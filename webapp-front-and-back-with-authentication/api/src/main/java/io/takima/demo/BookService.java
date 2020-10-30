package io.takima.demo;

import io.takima.demo.exceptions.BookAlreadyAvailableException;
import io.takima.demo.exceptions.BookAlreadyBorrowedException;
import io.takima.demo.exceptions.BookBorrowerException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class BookService {

    private final BookDAO bookDAO;

    @Autowired
    public BookService(BookDAO bookDAO) {
        this.bookDAO = bookDAO;
    }

    public Iterable<Book> listBooks() {
        return bookDAO.findAll();
    }

    public Book borrow(Long id, String userId) {
        Book book = this.bookDAO.findById(id).get();
        if (book.getBorrowerId() != null) {
            throw new BookAlreadyBorrowedException();
        }
        book.setBorrowerId(userId);
        return this.bookDAO.save(book);
    }

    public Book giveBack(Long id, String userId) {
        Book book = this.bookDAO.findById(id).get();
        if (!book.getBorrowerId().equals(userId)) {
            throw new BookBorrowerException();
        }
        if (book.getBorrowerId() == null) {
            throw new BookAlreadyAvailableException();
        }
        book.setBorrowerId(null);
        return this.bookDAO.save(book);
    }
}
