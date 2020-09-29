import { Component, OnInit } from '@angular/core';
import {NgForm} from '@angular/forms';
import {UserService} from '../../services/user.service';
import { defaultsDeep } from 'lodash';
import {Router} from '@angular/router';

@Component({
  selector: 'app-add-user',
  templateUrl: './add-user.component.html',
  styleUrls: ['./add-user.component.css']
})
export class AddUserComponent implements OnInit {

  constructor(private userService: UserService, private router: Router) { }

  ngOnInit() {
  }

  onSubmit(ngForm: NgForm) {
    console.log(ngForm);
    const user = defaultsDeep({
      id: null,
      firstName: ngForm.form.value.firstName,
      lastName: ngForm.form.value.lastName,
      age: ngForm.form.value.age,
    });

    this.userService.addUser(user).subscribe(user => console.log(user));

    this.router.navigateByUrl('/');
  }
}
