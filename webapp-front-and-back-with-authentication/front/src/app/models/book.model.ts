import { defaultsDeep } from 'lodash';

export class Book {
  id: number;
  borrowerId: string;
  title: string;
  author: string;

  constructor(book?: Partial<Book>) {
    defaultsDeep(this, book);
  }
}
