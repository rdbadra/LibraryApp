package model;

import model.Book;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by roberto on 24/10/16.
 */
public class Database {
    private List<Book> bookDatabase = new ArrayList<Book>();

    public Database(){
        createDatabase();
    }

    private void createDatabase() {
        BufferedReader br = null;
        try {
            String currentLine;
            br = new BufferedReader(new FileReader("/home/roberto/IdeaProjects/Library/src/persistence/database.txt"));
            while ((currentLine = br.readLine()) != null) {
                this.add(new Book(currentLine.split(",")[0],Integer.parseInt(currentLine.split(",")[1]),currentLine.split(",")[2],currentLine.split(",")[3]));
                System.out.println(currentLine);
            }
        } catch (IOException e) {
            //e.printStackTrace();
            System.out.println("El fichero no existe" + e);
        }
    }

    public List<Book> showAll(){
        return bookDatabase;
    }

    public void add(Book newBook){
        //Escribir tambien en el archivo database.txt
        bookDatabase.add(newBook);
        System.out.println("model.Book added");
        System.out.println(bookDatabase.size());
    }

    public void addToDatabase(Book book){
        try(FileWriter fw = new FileWriter("/home/roberto/IdeaProjects/Library/src/persistence/database.txt", true);
            BufferedWriter bw = new BufferedWriter(fw);
            PrintWriter out = new PrintWriter(bw))
        {
            //out.println("");
            out.println(book.getBookName() + "," + book.getNumberOfPages()+ "," + book.getAuthor()  + "," + book.getAvailability());
            this.add(book);
            //more code
            //more code
        } catch (IOException e) {
            //exception handling left as an exercise for the reader
        }

    }

    public void remove(String bookName){
        Book bookToRemove = this.search(bookName);
        bookDatabase.remove(bookToRemove);
        System.out.println("model.Book removed");
    }

    public Book search(String bookName){
        int databaseSize = bookDatabase.size();
        Book result = null;
        for(Book book : bookDatabase){
            System.out.println("model.Book name:" + bookName);
            System.out.println(book.getBookName());
            result = (book.search(bookName)? book : null);
            if (result != null) return result;
        }
        //System.out.println(result.getBookName());
        return result;
    }
}
