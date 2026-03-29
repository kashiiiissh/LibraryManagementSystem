package library;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;

public class Library {
 private List<Book> books;
 private List<Member> members;
 private FileHandler fileHandler;
 

 public Library(){
    books=new ArrayList<>();
    members=new ArrayList<>();
    fileHandler=new FileHandler();

    loadData();
 }



 private void loadData(){
    books=fileHandler.loadBooks();
    members=fileHandler.loadMembers();

    System.out.println("Data loaded: "+books.size()+" books, "+members.size()+" members");
 }



 public void addBook(Book book){
    books.add(book);
    fileHandler.saveBooks(books);
    System.out.println("Books added successfully!");
 }



 public void removeBook(String isbn){
 Book book=findBookByIsbn(isbn);

 if(book !=null){
    books.remove(book);
    fileHandler.saveBooks(books);
    System.out.println("Books removed successfully!");
 }
 else{
    System.out.println("Books not found!");
 }
 }



 public Book findBookByIsbn(String isbn){
    return books.stream().filter(b ->
        b.getIsbn().equals(isbn))
        .findFirst()
        .orElse(null);
    }
    public List<Book>searchBooks(String keyword){
      
        return books.stream().filter(b ->
        b.getTitle().toLowerCase().contains(keyword.toLowerCase()) ||
        b.getAuthor().toLowerCase().contains(keyword.toLowerCase())
     )
       .collect(Collectors.toList());
   } 
   


 public void displayAllBooks(){
    if(books.isEmpty()){
        System.out.println("No books availabl.");
        return;
    }
    System.out.println("\n=== BOOK LIST===");
    for(int i=0;i<books.size();i++){
        System.out.println((i + 1) + ". "+ books.get(i));
    }
   }



   public void registerMember(Member member){
    members.add(member);
    fileHandler.saveMembers(members);
    System.out.println("Members registered successfully!");
   }



   public Member findMemberById(String id){
    return members.stream()
    .filter(m ->m.getId().equals(id))
    .findFirst()
    .orElse(null);
   }




   public void borrowBook(String isbn, String memberId){
    Book book=findBookByIsbn(isbn);
    Member member=findMemberById(memberId);
    
    if(book == null){
        System.out.println("Book not found!");
        return;
    }
    if(member == null){
        System.out.println("Member not found!");
        return;
    }
    if(!book.isAvailable()){
        System.out.println("Book already borrowed!");
        return;
    }
    book.setAvailable(false);
    book.setBorrowedBy(memberId);

    book.setDueDate(java.time.LocalDate.now().plusDays(7));

    member.borrowBook(isbn);

    fileHandler.saveBooks(books);
    fileHandler.saveMembers(members);

    System.out.println("Books borrowed successfully!");
    System.out.println("Due date:"+book.getDueDate());
    }



    public void returnBook(String isbn,String memberId){
        Book book=findBookByIsbn(isbn);
        Member member=findMemberById(memberId);

        if(book==null || member==null){
            System.out.println("Invalid Details!");
            return;
        }
        book.returnBook();
        member.returnBook(isbn);

        fileHandler.saveBooks(books);
        fileHandler.saveMembers(members);

        System.out.println("Books returned succesfully!");
    }


    
    public void displayStatistics(){

        long available=books.stream().filter(Book::isAvailable).count();
        long borrowed=books.size()-available;

        System.out.println("\n=== LIBRARY STATS ===");
        System.out.println("Total Books: "+books.size());
        System.out.println("Available: "+available);
        System.out.println("Borrowed: "+borrowed);
        System.out.println("Members:: "+members.size());

        long overdue=books.stream()
        .filter(b -> !b.isAvailable() && b.isOverDue())
        .count();

        System.out.println("Overdue: "+overdue);
    }
}
        
    
    

