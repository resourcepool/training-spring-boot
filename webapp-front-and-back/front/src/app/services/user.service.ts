import { Injectable } from '@angular/core';
import {User} from '../models/user.model';
import {Observable} from 'rxjs';
import {HttpClient} from '@angular/common/http';
import {environment} from '../../environments/environment';
import {timeout} from 'rxjs/operators';
import { defaultsDeep } from 'lodash';

@Injectable({
  providedIn: 'root'
})
export class UserService {

  private url: string;

  constructor(private http: HttpClient) {
    this.url = environment.url;
  }

  getUsers(): Observable<User[]> {
    return this.http.get<User[]>(`${this.url}/users`).pipe(timeout(10000));
  }

  addUser(user: User): Observable<User> {
    return this.http.post<any>(`${this.url}/users`, user).pipe(timeout(10000));
  }

  deleteUser(id: number): Observable<any> {
    return this.http.delete(`${this.url}/users/${id}`).pipe(timeout(10000));
  }

}
