# Library Management System

## 📌 Project Description
This is a simple **Library Management System** built in **Java**. The system allows users to:
- Add new books
- Display all books
- Search for books by title
- Check out books
- Return books

## 🛠️ Technologies Used
- **Java** (Object-Oriented Programming)
- **Collections Framework** (`List`, `ArrayList`)
- **Scanner** (for user input)


   
## 📌 Features

✅ Add a New Book
Users can add a book by providing its title, author name, and ISBN. The system ensures that duplicate ISBNs are not allowed.

✅ Display All Books
Lists all the books available in the library along with their availability status.

✅ Search for a Book
Allows users to search for books by title.

✅ Check Out a Book
Users can check out a book using its ISBN. Once a book is checked out, it becomes unavailable.

✅ Return a Book
Users can return a previously checked-out book using its ISBN.

## 📂 Project Structure
- **LibraryManagementSystem/**  
  - **application/**  
    - `Application.java`  — Main application (user interface)
  - **model/**  
    - `Book.java`  — Book class with attributes and methods
  - **service/**  
    - `BookService.java`  — Business logic for book operations
    - `Repository.java`  — Stores book data
  - `README.md`  — Project documentation
