package view;

import model.Database;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

/**
 * Created by roberto on 22/11/16.
 */
public class LoginSwingPanel extends JPanel {
    JButton loginButton = new JButton("Login");
    JButton registerButton = new JButton("Register");

    private Database database;
    JTextField usernameTextField = new JTextField(20);
    JTextField passwordTextField = new JTextField(20);

    public LoginSwingPanel(Database database){
        this.database = database;
        this.setLayout(new FlowLayout(FlowLayout.CENTER, 50, 50));
        this.add(new JLabel("Username"));

        this.add(usernameTextField);
        this.add(new JLabel("Password"));

        this.add(passwordTextField);
        this.add(loginButton);
        this.add(registerButton);
    }

    public void addRegisterActionListener(ActionListener actionListener){
        registerButton.addActionListener(actionListener);
    }

    public void addLoginActionListener(ActionListener actionListener){
        loginButton.addActionListener(actionListener);
    }

    public String getUsername(){
        return usernameTextField.getText();
    }

    public String getPassword(){
        return passwordTextField.getText();
    }
}
