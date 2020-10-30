import {Component, OnDestroy, OnInit} from '@angular/core';
import {User} from '../../models/user.model';
import {BookService} from '../../services/book.service';
import {Book} from '../../models/book.model';
import {AuthService} from '../../auth/service/auth.service';
import {Subscription} from 'rxjs';
import {Router} from '@angular/router';

@Component({
  selector: 'app-list-books',
  templateUrl: './list-books.component.html',
  styleUrls: ['./list-books.component.css']
})
export class ListBooksComponent implements OnInit {

  books: Book[];

  constructor(private bookService: BookService) {

  }

  ngOnInit() {
    this.bookService.listBooks().subscribe(books => this.books = books);
  }

}
