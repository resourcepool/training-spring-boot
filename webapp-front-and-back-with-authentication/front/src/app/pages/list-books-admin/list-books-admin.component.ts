import {Component, OnDestroy, OnInit} from '@angular/core';
import {User} from '../../models/user.model';
import {UserService} from '../../services/user.service';
import {BookService} from '../../services/book.service';
import {Book} from '../../models/book.model';
import {AuthService} from '../../auth/service/auth.service';
import {Subscription} from 'rxjs';
import {Router} from '@angular/router';

@Component({
  selector: 'app-list-books-admin',
  templateUrl: './list-books-admin.component.html',
  styleUrls: ['./list-books-admin.component.css']
})
export class ListBooksAdminComponent implements OnInit, OnDestroy {

  books: Book[];
  private currentUser: User;
  private subscription: Subscription;

  constructor(private bookService: BookService, private authService: AuthService, private router: Router) {
    this.subscription = this.authService.currentUserObservable().subscribe(u => this.currentUser = u);
  }

  ngOnInit() {
    this.bookService.listBooks().subscribe(books => this.books = books);
  }

  ngOnDestroy(): void {
    if (this.subscription) {
      this.subscription.unsubscribe();
    }
  }

  borrowBook(id: number) {
    this.bookService.borrowBook(id).subscribe(success => {
      window.location.reload();
    });
  }

  giveBookBack(id: number) {
    this.bookService.giveBookBack(id).subscribe(success => {
      window.location.reload();
    });
  }

}
