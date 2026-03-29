# LibraryManagementSystem
 

# Project Description

A console-based Java application designed to manage library operations such as book tracking, member management, and borrowing/returning books. This system uses Object-Oriented Programming (OOP) principles and file handling for data persistence.

---

# Features

-  Add new books
-  Search books by title or author
-  Register library members
-  Borrow books with due date
-  Return books
-  View library statistics
-  File-based data storage (no database required)

---

🛠️ Technologies Used

- Java (Core Java)
- OOP Concepts (Encapsulation, Classes, Objects)
- Collections (ArrayList)
- File Handling (FileReader, FileWriter)
- Java Time API (LocalDate)

---

# Project Structure

week3-library-system/
│── src/
│   ├── main/
│   │   ├── java/
│   │   │   ├── library/
│   │   │   │   ├── Main.java
│   │   │   │   ├── Book.java
│   │   │   │   ├── Member.java
│   │   │   │   ├── Library.java
│   │   │   │   └── FileHandler.java
│
│── data/
│   ├── books.txt
│   └── members.txt
│
│── README.md

---

# How to Run

Step 1: Compile the project

javac -d bin src/main/java/library/*.java

Step 2: Run the application

java -cp bin library.Main

---

# Sample Menu

=== LIBRARY MANAGEMENT SYSTEM ===
1. Add New Book
2. View All Books
3. Search Books
4. Register Member
5. Borrow Book
6. Return Book
7. View Library Statistics
8. Exit

---

# Sample Output

=== BOOK LIST ===
1. ISBN: 101 | Title: Java Programming | Author: James | Year: 2020 | Status: Available

---





