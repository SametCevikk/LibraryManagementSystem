package model;

public class Book {


    public Book(String bookName, String authorName, int ISBN) {
        this.bookName = bookName;
        this.authorName = authorName;
        this.ISBN = ISBN;
    }

    private String bookName;
    private String authorName;
    private int ISBN;

    private boolean isAvailable;

    public String getBookName() {
        return bookName;
    }

    public void setBookName(String bookName) {
        this.bookName = bookName;
    }

    public String getAuthorName() {
        return authorName;
    }

    public void setAuthorName(String authorName) {
        this.authorName = authorName;
    }

    public int getISBN() {
        return ISBN;
    }

    public void setISBN(int ISBN) {
        this.ISBN = ISBN;
    }

    public boolean isAvailable() {
        return isAvailable;
    }

    public void setAvailable(boolean available) {
        isAvailable = available;
    }

}
