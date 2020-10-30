import { Injectable } from '@angular/core';
import {User} from '../models/user.model';
import {Observable} from 'rxjs';
import {HttpClient} from '@angular/common/http';
import {environment} from '../../environments/environment';
import {timeout} from 'rxjs/operators';
import { defaultsDeep } from 'lodash';
import {Book} from '../models/book.model';

@Injectable({
  providedIn: 'root'
})
export class BookService {

  private url: string;

  constructor(private http: HttpClient) {
    this.url = environment.url;
  }

  listBooks(): Observable<Book[]> {
    return this.http.get<Book[]>(`${this.url}/books`).pipe(timeout(10000));
  }

  borrowBook(id: number): Observable<Book> {
    return this.http.post<any>(`${this.url}/books/borrow/${id}`, null).pipe(timeout(10000));
  }

  giveBookBack(id: number): Observable<any> {
    return this.http.post(`${this.url}/books/give-back/${id}`, null).pipe(timeout(10000));
  }

}
