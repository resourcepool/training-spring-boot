
//user.service.ts
import {Injectable} from "@angular/core";
import {HttpClient} from "@angular/common/http";
import {environment} from "../../environments/environment";
import {Observable} from "rxjs";
import {User} from "../../models/user.model";

@Injectable({
  providedIn: 'root'
})
export class UserService {

  private url: string;

  constructor(private http: HttpClient) {
    this.url = environment.url;
  }

  getUsers(): Observable<User[]> {
    return this.http.get<User[]>(`${this.url}/users`);
  }

  addUser(user: User): Observable<User> {
    return this.http.post<any>(`${this.url}/users`, user);
  }

  deleteUser(id: bigint | null): Observable<any> {
    return this.http.delete(`${this.url}/users/${id}`);
  }

}
