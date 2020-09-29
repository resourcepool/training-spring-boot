import { Component, OnInit } from '@angular/core';
import {User} from '../../models/user.model';
import {UserService} from '../../services/user.service';

@Component({
  selector: 'app-list-users',
  templateUrl: './list-users.component.html',
  styleUrls: ['./list-users.component.css']
})
export class ListUsersComponent implements OnInit {

  users: User[];

  constructor(private userService: UserService) { }

  ngOnInit() {
    this.userService.getUsers().subscribe(users => this.users = users);
  }

  deleteUser(id: number) {
    this.userService.deleteUser(id).subscribe(succes => {
      this.users = this.users.filter(user => user.id !== id)
    });
  }

}
