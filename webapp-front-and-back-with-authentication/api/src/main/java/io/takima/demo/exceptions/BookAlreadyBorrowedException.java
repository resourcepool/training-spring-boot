package io.takima.demo.exceptions;

public class BookAlreadyBorrowedException extends IllegalStateException {
    public BookAlreadyBorrowedException() {
        super("Cannot borrow a book that has already been borrowed by someone else.");
    }
}
