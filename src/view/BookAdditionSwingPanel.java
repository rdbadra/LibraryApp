package view;

import javax.swing.*;
import java.awt.event.ActionListener;

/**
 * Created by roberto on 23/11/16.
 */
public class BookAdditionSwingPanel extends JPanel{
    private JTextField bookNameTextField;
    private JTextField numberOfPagesTextField;
    private JTextField authorTextField;

    private JTextField availabilityTextField;
    private JButton saveButton;
    private JButton backButton;
    private JPanel bookAdditionJPanel;
    private JLabel bookNameJLabel;
    private JLabel numberOfPagesJLabel;
    private JLabel authorJLabel;
    private JLabel availableJLabel;

    public BookAdditionSwingPanel(){
        this.add(bookAdditionJPanel);
    }

    public void addBackButtonListener(ActionListener actionListener){
        backButton.addActionListener(actionListener);
    }

    public void addSaveBookListener(ActionListener actionListener){
        saveButton.addActionListener(actionListener);
    }

    public String getBookName(){
        return bookNameTextField.getText();
    }

    public String getNumberOfPages(){
        return numberOfPagesTextField.getText();
    }

    public String getAuthor(){
        return authorTextField.getText();
    }

    public String getAvailabilityTextField() {
        return availabilityTextField.getText();
    }

    public void cleanInputs(){
        bookNameTextField.setText("");
        numberOfPagesTextField.setText("");
        authorTextField.setText("");
        availabilityTextField.setText("");
    }



}
