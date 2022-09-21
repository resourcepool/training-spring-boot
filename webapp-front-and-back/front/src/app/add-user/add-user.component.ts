import { Component, OnInit } from '@angular/core';
import {NgForm} from "@angular/forms";
import {User} from "../../models/user.model";
import {HttpClient} from "@angular/common/http";
import {Router} from "@angular/router";
import {UserService} from "../services/user.service";

@Component({
  selector: 'app-add-user',
  templateUrl: './add-user.component.html',
  styleUrls: ['./add-user.component.scss']
})
export class AddUserComponent implements OnInit {

  constructor(private httpClient: HttpClient, private router: Router, private userService: UserService) {
  }

  ngOnInit() {
  }

  onSubmit(ngForm: NgForm) {
    console.log(ngForm);
    const user = new User(
      null,
      ngForm.form.value.firstName,
      ngForm.form.value.lastName,
      ngForm.form.value.age,
    )

    this.userService.addUser(user).subscribe();
    setTimeout(()=>this.router.navigateByUrl('/'), 1000)
  }


}
