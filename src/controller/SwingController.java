package controller;

import model.Book;
import model.Database;
import model.UserDatabase;
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
                Book book = (new Database()).search(bookName);
                if(book != null){
                    view.getSearchSwingPanel().setVisible(false);
                    view.setContentPane(new BookSwingPanel(book));
                }else {
                    JOptionPane.showMessageDialog(null, "Book not found");

                };

            }

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


}


