import {Component, OnDestroy} from '@angular/core';
import {User} from './models/user.model';
import {Subscription} from 'rxjs';
import {BookService} from './services/book.service';
import {AuthService} from './auth/service/auth.service';
import {Router} from '@angular/router';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent implements OnDestroy {
    authenticated: boolean;

    private subscription: Subscription;

    constructor(private bookService: BookService, private authService: AuthService, private router: Router) {
        this.subscription = this.authService.currentUserObservable().subscribe(u => this.authenticated = u?.authenticated);
    }

    ngOnDestroy(): void {
        if (this.subscription) {
            this.subscription.unsubscribe();
        }
    }


    logout() {
        this.authService.signOut()
            .then(() => {
                this.router.navigate(['/']);
            })
    }
}
