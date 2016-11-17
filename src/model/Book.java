package model;

/**
 * Created by roberto on 24/10/16.
 */
public class Book {
    private String bookName;
    private int numberOfPages;
    private String author;
    private String available;

    public Book(String bookName, int numberOfPages, String author, String available){
        this.bookName = bookName;
        this.numberOfPages = numberOfPages;
        this.author = author;
        this.available = available;
    }

    public String getBookName(){
        return bookName;
    }

    public int getNumberOfPages(){
        return numberOfPages;
    }

    public String getAuthor(){
        return author;
    }

    public String getAvailability(){
        return available;
    }

    public boolean search(String bookName){
        boolean result = this.bookName.equals(bookName) ? true : false;
        return result;
    }
}
