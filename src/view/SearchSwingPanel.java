package view;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

/**
 * Created by roberto on 22/11/16.
 */
public class SearchSwingPanel extends JPanel {
    JTextField bookTextField = new JTextField(20);
    JButton searchButton = new JButton("Search");
    JButton addBookButton = new JButton("ADD");
    JButton logoutButton = new JButton("Logout");

    public SearchSwingPanel(){
        this.setLayout(new FlowLayout(FlowLayout.CENTER, 50, 50));
        this.add(new JLabel("Book:"));
        this.add(bookTextField);
        this.add(searchButton);
        this.add(addBookButton);
        this.add(logoutButton);
    }

    public void cleanSearch(){
        bookTextField.setText("");
    }

    public String getBookTextField(){
        return bookTextField.getText();
    }

    public void addSearchListener(ActionListener actionListener){
        searchButton.addActionListener(actionListener);
    }

    public void addBookAdditionListener(ActionListener actionListener){
        addBookButton.addActionListener(actionListener);
    }

    public void addLogoutListener(ActionListener actionListener){
        logoutButton.addActionListener(actionListener);
    }
}
