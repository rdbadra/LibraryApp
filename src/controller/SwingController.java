package controller;

import model.Book;
import model.Database;
import model.UserDatabase;
import view.BookAdditionSwingPanel;
import view.BookSwingPanel;
import view.LoginSwingPanel;
import view.MainSwingFrame;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by roberto on 22/11/16.
 */
public class SwingController {
    private Database model;
    private MainSwingFrame view;

    public SwingController(Database model, MainSwingFrame view){
        this.model = model;
        this.view = view;
        //I need to add the action listeners
        addApplicationListeners();
    }

    private void addApplicationListeners() {
        view.getLoginSwingPanel().addLoginActionListener(new LoginListener());
        view.getLoginSwingPanel().addRegisterActionListener(new RegisterListener());
        view.getSearchSwingPanel().addSearchListener(new SearchListener());
        view.getSearchSwingPanel().addLogoutListener(new LogoutListener());
        view.getSearchSwingPanel().addBookAdditionListener(new BookAdditionListener());
        view.getBookSwingPanel().addBackButtonListener(new BackBookSwingPanelListener());
        view.getBookAdditionSwingPanel().addBackButtonListener(new BackBookAdditionSwingPanelListener());
        view.getBookAdditionSwingPanel().addSaveBookListener(new SaveBookAdditionSwingPanelListener());
    }

    class LoginListener implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
            LoginSwingPanel loginSwingPanel = view.getLoginSwingPanel();
            String username = loginSwingPanel.getUsername();
            String password = loginSwingPanel.getPassword();
            if((new UserDatabase()).logInUser(username, password)){
                loginSwingPanel.setVisible(false);
                loginSwingPanel.deleteInputFields();
                view.setContentPane(view.getSearchSwingPanel());
            }
        }
    }

    class RegisterListener implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
            LoginSwingPanel loginSwingPanel = view.getLoginSwingPanel();
            String username = loginSwingPanel.getUsername();
            String password = loginSwingPanel.getPassword();
            if((new UserDatabase()).registerUser(username, password)){
                JOptionPane.showMessageDialog(null, "Registered successfully");
                loginSwingPanel.setVisible(false);
                view.setContentPane(view.getSearchSwingPanel());
            } else {
                JOptionPane.showMessageDialog(null, "Couldn't register");
            }

        }

    }

    class SearchListener implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
            String bookName = view.getSearchSwingPanel().getBookTextField();
            if(bookName.length() > 0){
                Book book = model.search(bookName);
                if(book != null){
                    view.getSearchSwingPanel().setVisible(false);
                    view.getSearchSwingPanel().cleanSearch();
                    view.getBookSwingPanel().setVisible(true);
                    view.getBookSwingPanel().setBook(book);
                    view.setContentPane(view.getBookSwingPanel());

                }else {
                    JOptionPane.showMessageDialog(null, "Book not found");

                };

            } else {
                JOptionPane.showMessageDialog(null, "You have to enter a book");
            }

        }


    }

    class BookAdditionListener implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
            view.getSearchSwingPanel().setVisible(false);
            view.getBookAdditionSwingPanel().setVisible(true);
            view.setContentPane(view.getBookAdditionSwingPanel());
        }
    }

    class LogoutListener implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
            view.getSearchSwingPanel().setVisible(false);
            LoginSwingPanel swingPanel = view.getLoginSwingPanel();
            swingPanel.setVisible(true);
            view.setContentPane(view.getLoginSwingPanel());
        }
    }

    class BackBookSwingPanelListener implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
            view.getBookSwingPanel().setVisible(false);
            view.getSearchSwingPanel().setVisible(true);
            view.setContentPane(view.getSearchSwingPanel());
        }
    }

    class BackBookAdditionSwingPanelListener implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
            view.getBookAdditionSwingPanel().setVisible(false);
            view.getSearchSwingPanel().setVisible(true);
            view.setContentPane(view.getSearchSwingPanel());
        }
    }

    class SaveBookAdditionSwingPanelListener implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
            BookAdditionSwingPanel bookAdditionSwingPanel = view.getBookAdditionSwingPanel();
            if(bookAdditionSwingPanel.getBookName().length()>0 && bookAdditionSwingPanel.getNumberOfPages().length()>0 && bookAdditionSwingPanel.getAuthor().length()>0 && bookAdditionSwingPanel.getAvailabilityTextField().length()>0){
                model.addToDatabase(new Book(bookAdditionSwingPanel.getBookName(),Integer.parseInt(bookAdditionSwingPanel.getNumberOfPages()),bookAdditionSwingPanel.getAuthor(),bookAdditionSwingPanel.getAvailabilityTextField()));
                JOptionPane.showMessageDialog(null, "Book saved");
                bookAdditionSwingPanel.cleanInputs();
            } else {
                JOptionPane.showMessageDialog(null, "Nothing has been saved");
            }
        }
    }


}


