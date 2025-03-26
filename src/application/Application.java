package application;

import model.Book;
import service.BookService;

import java.util.List;
import java.util.Scanner;

public class Application {

    private final static BookService bookService = new BookService();
    private final static Scanner scanner = new Scanner(System.in);


    public static void main(String[] args) {


        System.out.println("Welcome to the Library Management System!\n");

        String choice;

        do {
            menu();
            choice = scanner.nextLine();

            switch (choice) {
                case "1" -> add();
                case "2" -> getAll();
                case "3" -> findBook();
                case "4" -> checkOut();
                case "5" -> returnBook();
                case "6" -> System.out.println("Thank you use the library Management System");
                default -> System.out.println("You made an invalid choice");
            }

        } while (!choice.equals("6"));

    }

    public static void menu() {
        System.out.println();
        System.out.println("Please select an option: ");
        System.out.println("1. Add a new book: ");
        System.out.println("2. Display all books:");
        System.out.println("3. Search a book by little:");
        System.out.println("4. Check out a book:");
        System.out.println("5. Return a book:");
        System.out.println("6. Exit");
        System.out.print("Enter your choice: ");
    }

    // A new book was added here
    public static void add() {
        System.out.print("Enter book title: ");
        String bookName = scanner.nextLine();

        System.out.print("Enter author name: ");
        String authorName = scanner.nextLine();

        System.out.print("Enter ISBN: ");
        int ISBN = scanner.nextInt();
        scanner.nextLine();
        // Checked if the book had been added before.
        if (bookService.canAdded(bookName, authorName, ISBN)) {
            System.out.println("Book added successfully");
        } else {
            System.out.println("Book already exists");
        }
    }

    // list printed
    public static void getAll() {

        List<Book> books = bookService.getList();
        System.out.println("All Books:\n");
        get(books);
    }

    // given list printed
    public static void get(List<Book> books) {
        for (Book book : books) {
            System.out.println("Title: " + book.getBookName());
            System.out.println("Author: " + book.getAuthorName());
            System.out.println("ISBN: " + book.getISBN());
            if (book.isAvailable()) {
                System.out.println("Status:  Available ");
            } else {
                System.out.println("Status: Not Available");
            }
            System.out.println("--------------------------------------------------------------");
        }
    }

    // Searched by book title
    public static void findBook() {
        System.out.print("Enter book title to search: ");
        String bookName = scanner.nextLine();
        List<Book> availableBooks = bookService.exists(bookName);
        if (availableBooks.isEmpty()) {
            System.out.println("There is no any book");
        } else {
            System.out.println("Found Book:");
            System.out.println("-----------------------------------------------");
            get(availableBooks);
        }
    }

    // Books are loaned by ISBN
    public static void checkOut() {
        System.out.print("Enter the ISBN of the book you want to check out: ");
        int ISBN = scanner.nextInt();
        scanner.nextLine();
        if (bookService.isAvailableBook(ISBN)) {
            System.out.println("Book checked out successfully");
        } else {
            System.out.println("Book is not found or already checked out");
        }

    }

    // The loaned book was returned
    public static void returnBook() {
        System.out.print("Enter the ISBN of the book you want to return: ");
        int ISBN = scanner.nextInt();
        scanner.nextLine();
        if (bookService.isCorrectISBN(ISBN)) {
            System.out.println("Book returned successfully");
        } else {
            System.out.println("Book is not found or already returned");
        }
    }

}
