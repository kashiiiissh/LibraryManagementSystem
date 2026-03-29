package library;

import java.util.List;
import java.util.Scanner;

public class Main {
  public static void main(String[] args) {
    
    Scanner sc=new Scanner(System.in);
    Library library=new Library();

    while (true) {
       System.out.println("\n=== LIBRARY MANAGEMENT SYSTEM ===");
       System.out.println("1. Add New Book");
       System.out.println("2. View All Books");
       System.out.println("3. Search Books");
       System.out.println("4. Register Member");
       System.out.println("5. Borrow Book");
       System.out.println("6. Return Book");
       System.out.println("7. View Library");
       System.out.println("8. Exit");
       System.out.println("Enter your choice: ");

       int choice=sc.nextInt();
       sc.nextLine();

       switch (choice) {
        case 1:
            System.out.println("Enter ISBN: ");
            String isbn=sc.nextLine();
            System.out.println("Enter Title: ");
            String title=sc.nextLine();
            System.out.println("Enter Author: ");
            String author=sc.nextLine();
            System.out.println("Enter Year: ");
            int year=sc.nextInt();
            sc.nextLine();
           library.addBook(new Book(isbn, title, author, year));
       break;
        

       case 2:
           library.displayAllBooks();
       break;
       

       case 3:
           System.out.println("Enter keyword: ");
           String keyword=sc.nextLine();
           List<Book> results=library.searchBooks(keyword);

       if(results.isEmpty()){
        System.out.println("No books found!");
       }else{
        for(Book b: results){
            System.out.println(b);
        }
       }
       break;
       
       
       case 4:
            System.out.println("Enter Member ID: ");
       String id=sc.nextLine();
       System.out.println("Enter Name: ");
       String name=sc.nextLine();
       library.registerMember(new Member(id, name));
       break;
       

       case 5:
       System.out.println("Enter ISBN: ");
       String borrowIsbn=sc.nextLine();
       System.out.println("Enter Member ID: ");
       String memberId=sc.nextLine();
       library.borrowBook(borrowIsbn,memberId);
       break;


       case 6:
        System.out.println("Enter ISBN: ");
        String returnIsbn=sc.nextLine();
        System.out.println("Enter Member ID: ");
        String returnMememberId=sc.nextLine();
        library.returnBook(returnIsbn,returnMememberId);
        break;

         
        case 7:
        library.displayStatistics();
        break;


        case 8:
            System.out.println("Exiting...Thank you!");
            sc.close();
            System.exit(0);


            default:
                System.out.println("Invalid choice! Try again.");
    }
  }
 }  
}
