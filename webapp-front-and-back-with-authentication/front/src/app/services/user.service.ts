import { Injectable } from '@angular/core';
import {User} from '../models/user.model';
import {Observable} from 'rxjs';
import {HttpClient} from '@angular/common/http';
import {environment} from '../../environments/environment';
import {timeout} from 'rxjs/operators';
import { defaultsDeep } from 'lodash';
import {AuthService} from '../auth/service/auth.service';

@Injectable({
  providedIn: 'root'
})
export class UserService {

  private url: string;
  private currentUser: User;

  constructor(private http: HttpClient, private authService: AuthService) {
    this.url = environment.url;
    this.authService.currentUserObservable().subscribe(u => {
      this.currentUser = u;
    })
  }

  getUserDetails(): Observable<User> {
    return this.http.get<User>(`${this.url}/users/${this.currentUser?.uid}`).pipe(timeout(10000));
  }

}
