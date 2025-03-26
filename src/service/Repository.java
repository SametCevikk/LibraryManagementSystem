package service;

import model.Book;

import java.util.ArrayList;
import java.util.List;

public class Repository {


    private final List<Book> books = new ArrayList<>();

    public List<Book> listAllBooks() {
        return books;
    }

    //book added to the list
    public void addBook(Book book) {
        books.add(book);
    }

}
