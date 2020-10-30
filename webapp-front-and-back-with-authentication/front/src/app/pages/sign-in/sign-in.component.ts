import {Component, OnDestroy, OnInit} from '@angular/core';
import {Subscription} from 'rxjs';
import {Router} from '@angular/router';
import {AuthService} from '../../auth/service/auth.service';

@Component({
  selector: 'app-sign-in',
  templateUrl: './sign-in.component.html',
  styleUrls: ['./sign-in.component.scss']
})
export class SignInComponent implements OnInit, OnDestroy {

  error: any;
  private authenticated: boolean;
  private currentUserSubscription: Subscription;

  constructor(private authService: AuthService,
              private router: Router) {
  }

  get isLogged(): boolean {
    return this.authenticated;
  }

  ngOnInit() {
    this.currentUserSubscription = this.authService.currentUserObservable()
        .subscribe(user => {
          this.authenticated = user && !user.anonymous;
          if (this.authenticated) {
            this.router.navigate([`/`]);
          }
        });
  }

  ngOnDestroy() {
    if (this.currentUserSubscription) {
      this.currentUserSubscription.unsubscribe();
    }
  }

  signinGoogle() {
    this.authService.googleSignIn()
        .then(success => {
          console.log('Sign-In successful!')
        })
        .catch(err => {
          this.error = err;
        });
  }

}
