package view;

import model.Book;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

/**
 * Created by roberto on 22/11/16.
 */
public class BookSwingPanel extends JPanel{
    Book book;
    JTextField bookname = new JTextField(20);
    JTextField numberOfPages = new JTextField(10);
    JTextField author = new JTextField(20);
    JTextField availability = new JTextField(10);
    JButton backButton = new JButton("Back");

    public BookSwingPanel(){
        this.setLayout(new FlowLayout(FlowLayout.LEFT, 80, 80));
        this.book = book;
        this.add(new JLabel("Book"));
        this.add(bookname);
        this.add(new JLabel("Number of Pages"));
        this.add(numberOfPages);
        this.add(new JLabel("Author"));
        this.add(author);
        this.add(new JLabel("Availability"));
        this.add(availability);
        this.add(backButton);

    }

    public void setBook(Book book){
        bookname.setText(book.getBookName());
        numberOfPages.setText(""+book.getNumberOfPages());
        author.setText(book.getAuthor());
        availability.setText(book.getAvailability());
    }

    public void addBackButtonListener(ActionListener actionListener){
        backButton.addActionListener(actionListener);
    }
}
