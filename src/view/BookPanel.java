package view;

import com.googlecode.lanterna.gui2.GridLayout;
import com.googlecode.lanterna.gui2.Label;
import com.googlecode.lanterna.gui2.Panel;
import model.Book;

/**
 * Created by roberto on 24/10/16.
 */
public class BookPanel extends Panel{
    Label bookName = new Label("");
    Label numberOfPages = new Label("");
    Label author = new Label("");
    Label available = new Label("");

    public BookPanel(){
        this.setLayoutManager(new GridLayout(4));
        this.addComponent(new Label("Book Name |"));
        this.addComponent(new Label("Number of Pages |"));
        this.addComponent(new Label("Author |"));
        this.addComponent(new Label("Available"));
        this.addComponent(bookName);
        this.addComponent(numberOfPages);
        this.addComponent(author);
        this.addComponent(available);
    }

    public void addRegister(Book book){
        bookName.setText(book.getBookName());
        numberOfPages.setText(book.getNumberOfPages() + "");
        author.setText(book.getAuthor());
        available.setText(book.getAvailability());
    }

    public void showNoResults(){
        bookName.setText("No results");
        numberOfPages.setText("");
        author.setText("");
        available.setText("");
    }
}
