package library;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

public class FileHandler {
   private static final String BOOK_FILE="data/books.txt";
   private static final String MEMBER_FILE="data/members.txt";


   public void saveBooks(List<Book> books){
    try(PrintWriter writer=new PrintWriter(new FileWriter(BOOK_FILE))){

        for(Book book:books){
            writer.println(
                book.getIsbn()+","+
                book.getTitle()+","+
                book.getAuthor()+","+
                book.getYear()+","+
                book.isAvailable()+","+
                book.getBorrowedBy()+","+

                book.getDueDate()
            );
        }
    }catch(Exception e){
        System.out.println("Error saving books!");
    }
   }
   public List<Book> loadBooks(){
    List<Book> books=new ArrayList<>();

    try(BufferedReader reader=new BufferedReader(new FileReader(BOOK_FILE))){

        String line;
        while ((line=reader.readLine()) != null) {
            String[] data=line.split(",");

            Book book=new Book(
                data[0],
                data[1],
                data[2],
                Integer.parseInt(data[3])
            );

            book.setAvailable(Boolean.parseBoolean(data[4]));
            if(!data[5].equals("null")){
                book.setBorrowedBy(data[5]);
            }
            if(!data[5].equals("null")){
                book.setDueDate(java.time.LocalDate.parse(data[6]));
        }
        books.add(book);
    }
   }catch(Exception e){
    System.out.println("No previous book data found.");
   }
   return books;
}
    public void saveMembers(List<Member> members){
        try(PrintWriter writer=new PrintWriter(new FileWriter(MEMBER_FILE))){
            for(Member m:members){
                writer.println(m.getId()+","+m.getName());
             }
        }catch(Exception e){
             System.out.println("Error saving members!");
        }
    }
    public List<Member> loadMembers(){
        List<Member> members=new ArrayList<>();

        try(BufferedReader reader=new BufferedReader(new FileReader(MEMBER_FILE))){
            String line;
            while ((line=reader.readLine()) != null){
            String[] data=line.split(",");
            Member m=new Member(data[0],data[1]);
            members.add(m);
            }
        
        } catch (Exception e) {
            System.out.println("No previous member data found.");        
        }
        return members;
    }
}
