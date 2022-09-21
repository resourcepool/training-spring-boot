import { Component, OnInit } from '@angular/core';
import {User} from "../../models/user.model";
import {HttpClient} from "@angular/common/http";
import {UserService} from "../services/user.service";

@Component({
  selector: 'app-list-users',
  templateUrl: './list-users.component.html',
  styleUrls: ['./list-users.component.scss']
})
export class ListUsersComponent implements OnInit {

  estCeQuilEstLa= false;
  users: User[];
  constructor(private http: HttpClient, private userService: UserService) {
    this.users=[];
  }

  ngOnInit() {
    this.userService.getUsers().subscribe(users => this.users = users)
  }

  showMe() {
    this.estCeQuilEstLa=!this.estCeQuilEstLa;
  }

  deleteUser(id: bigint | null){
    this.userService.deleteUser(id).subscribe(() => this.users = this.users.filter(user => user.id !== id));
  }
}
