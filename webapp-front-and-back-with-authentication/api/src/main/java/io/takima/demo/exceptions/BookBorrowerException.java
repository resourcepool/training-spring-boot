package io.takima.demo.exceptions;

public class BookBorrowerException extends IllegalStateException {
    public BookBorrowerException() {
        super("You are not the borrower of the book. You cannot do any actions linked to this book.");
    }
}
