package io.takima.demo.exceptions;

public class BookAlreadyAvailableException extends IllegalStateException {
    public BookAlreadyAvailableException() {
        super("Cannot give back a book that hasn't been borrowed.");
    }
}
