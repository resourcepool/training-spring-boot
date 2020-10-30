import {Injectable} from '@angular/core';
import {CanActivate, Router} from '@angular/router';

import {AuthService} from '../auth.service';
import {from, Observable, of} from 'rxjs';
import {flatMap, mergeMap} from 'rxjs/operators';

@Injectable({
  providedIn: 'root'
})
export class AuthGuard implements CanActivate {

  constructor(private _authService: AuthService, private _router: Router) {}

  canActivate(): Observable<boolean> {
    return this._authService.currentUserObservable().pipe(mergeMap(user => {
        console.log(user);
        if (!user || !user.authenticated) {
          console.error('Auth Guard Failed. Authenticating first.');
          this._router.navigate(['/sign-in']);
          return of(false);
        }
        console.log('Auth Guard Succeeded with user', user);
        return of(true);
      }));
  }
}
