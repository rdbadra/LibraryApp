package view;

import com.googlecode.lanterna.TerminalSize;
import com.googlecode.lanterna.TextColor;
import com.googlecode.lanterna.gui2.*;
import com.googlecode.lanterna.gui2.dialogs.MessageDialog;
import com.googlecode.lanterna.screen.Screen;
import model.UserDatabase;

import java.io.*;

/**
 * Created by roberto on 2/11/16.
 */
public class LoginPanel extends Panel{

    public LoginPanel(Screen screen){
        this.setLayoutManager(new GridLayout(6));
        this.addComponent(new EmptySpace(new TerminalSize(0, 1)));
        this.addComponent(new EmptySpace(new TerminalSize(0, 1)));

        this.addComponent(new Label("Username"));
        TextBox username = new TextBox("");
        this.addComponent(username);
        this.addComponent(new EmptySpace(new TerminalSize(2, 2)));
        this.addComponent(new EmptySpace(new TerminalSize(2, 2)));
        this.addComponent(new EmptySpace(new TerminalSize(4, 1)));
        this.addComponent(new EmptySpace(new TerminalSize(4, 1)));
        this.addComponent(new Label("Password"));
        TextBox password = new TextBox("");
        this.addComponent(password);
        BasicWindow window = new BasicWindow();
        MultiWindowTextGUI gui = new MultiWindowTextGUI(screen, new DefaultWindowManager(), new EmptySpace(TextColor.ANSI.MAGENTA));

        this.addComponent(new EmptySpace(new TerminalSize(2, 2)));
        this.addComponent(new EmptySpace(new TerminalSize(2, 2)));
        this.addComponent(new EmptySpace(new TerminalSize(4, 1)));
        this.addComponent(new EmptySpace(new TerminalSize(4, 1)));

        this.addComponent(new Button("Log in", new Runnable() {
            @Override
            public void run() {
                if((new UserDatabase()).logInUser(username.getText(), password.getText())) new MainPanel(screen);
                MessageDialog.showMessageDialog(gui, "Error", "Log in error");
            }
        }));
//        this.addComponent(new EmptySpace(new TerminalSize(0, 1)));
//        this.addComponent(new EmptySpace(new TerminalSize(0, 1)));
//        this.addComponent(new EmptySpace(new TerminalSize(0, 1)));
        this.addComponent(new EmptySpace(new TerminalSize(2, 2)));
        this.addComponent(new EmptySpace(new TerminalSize(2, 2)));
        this.addComponent(new EmptySpace(new TerminalSize(4, 1)));
        this.addComponent(new EmptySpace(new TerminalSize(4, 1)));
        this.addComponent(new EmptySpace(new TerminalSize(4, 1)));
        this.addComponent(new Button("Register", new Runnable() {
            @Override
            public void run() {
                if((new UserDatabase()).registerUser(username.getText(), password.getText())){
                    MessageDialog.showMessageDialog(gui, "", "Registration successfull");
                    new LoginPanel(screen);
                } else {
                    MessageDialog.showMessageDialog(gui, "Error", "Registration error");
                };

            }
        }));
        window.setComponent(this);
        gui.addWindowAndWait(window);
    }


}
