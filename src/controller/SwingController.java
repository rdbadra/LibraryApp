package controller;

import model.Database;
import model.UserDatabase;
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
        addAplicationListeners();
    }

    private void addAplicationListeners() {
        view.getLoginSwingPanel().addLoginActionListener(new LoginListener());
        view.getLoginSwingPanel().addRegisterActionListener(new RegisterListener());
    }

    class LoginListener implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
            LoginSwingPanel loginSwingPanel = view.getLoginSwingPanel();
            String username = loginSwingPanel.getUsername();
            String password = loginSwingPanel.getPassword();
            if((new UserDatabase()).logInUser(username, password)){
                loginSwingPanel.setVisible(false);
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


}


