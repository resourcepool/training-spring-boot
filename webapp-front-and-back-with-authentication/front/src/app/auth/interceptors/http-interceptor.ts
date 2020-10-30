import {Injectable} from '@angular/core';
import {HttpEvent, HttpHandler, HttpHeaders, HttpInterceptor, HttpRequest} from '@angular/common/http';
import {environment} from '../../../environments/environment';
import {Observable} from 'rxjs';
import {AuthService} from '../service/auth.service';

@Injectable()
export class AuthHeaderInterceptor implements HttpInterceptor {

  private _idToken: string;
  private _backendBaseUrl: string;

  constructor(private _authService: AuthService) {
    _authService.currentIdToken().subscribe(idToken => {
      this._idToken = idToken;
    });
    this._backendBaseUrl = this._sanitizePrefix(environment.url)
  }

  _sanitizePrefix(prefix: string): string {
    if (prefix.endsWith('/')) {
      return prefix.substr(0, prefix.length - 1);
    }
    return prefix;
  }

  _sanitizeSuffix(suffix: string): string {
    if (!suffix.startsWith('/')) {
      return '/' + suffix;
    }
    return suffix;
  }

  /**
   * Url can be of two things:
   * - Call to third-party API (http://xxx https://yyy)
   * - Call to internal backend API (/endpoint or endpoint)
   * @param url
   * @private
   */
  _computeUrl(url: string) :string {
    if (url.startsWith('http')) {
      return url;
    }
    return this._backendBaseUrl + this._sanitizeSuffix(url);
  }

  intercept(req: HttpRequest<any>, next: HttpHandler): Observable<HttpEvent<any>> {
    let headers: HttpHeaders = req.headers;
    if (this._idToken) {
      headers = req.headers.set('Authorization', 'Bearer ' + this._idToken);
    }
    return next.handle(req.clone({
      headers,
      url: this._computeUrl(req.url)
    }));
  }
}
