package service;

import model.Book;

import java.util.ArrayList;
import java.util.List;

public class BookService {

    Repository repository = new Repository();

    // If the book has not been added before, it will be added.
    // Checked only by ISBN
    public boolean canAdded(String bookName, String authorName, int ISBN) {

        List<Book> books = repository.listAllBooks();
        for (Book book : books) {
            if (book.getISBN() == ISBN) {
                return false;
            }
        }
        Book book = new Book(bookName, authorName, ISBN);
        book.setAvailable(true);
        repository.addBook(book);
        return true;
    }


    // List retrieved from repository class
    public List<Book> getList() {

        return repository.listAllBooks();

    }

    // Searched for books with the same name
    // returned by being assigned to a list
    public List<Book> exists(String bookName) {
        List<Book> books = repository.listAllBooks();
        List<Book> availableBooks = new ArrayList<>();
        for (Book book : books) {
            if (book.getBookName().equals(bookName)) {
                availableBooks.add(book);
            }
        }
        return availableBooks;
    }


    // Checked the book was available
    public boolean isAvailableBook(int ISBN) {
        List<Book> books = repository.listAllBooks();

        for (Book book : books) {
            if (book.getISBN() == ISBN && book.isAvailable()) {
                book.setAvailable(false);
                return true;
            }
        }
        return false;
    }

    // Is the returned book registered in the system
    public boolean isCorrectISBN(int ISBN) {
        List<Book> books = repository.listAllBooks();

        for (Book book : books) {
            if (book.getISBN() == ISBN && !book.isAvailable()) {
                book.setAvailable(true);
                return true;
            }
        }
        return false;
    }
}

