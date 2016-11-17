package view;

import com.googlecode.lanterna.TerminalSize;
import com.googlecode.lanterna.TextColor;
import com.googlecode.lanterna.gui2.*;
import com.googlecode.lanterna.gui2.dialogs.MessageDialog;
import com.googlecode.lanterna.screen.Screen;

import java.io.*;

/**
 * Created by roberto on 2/11/16.
 */
public class LoginPanel extends Panel {

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
                if(logInUser(username.getText(), password.getText())) new MainPanel(screen);
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
                if(registerUser(username.getText(), password.getText())){
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

    public boolean logInUser(String username, String password){
        BufferedReader br = null;
        try {
            String currentLine;
            String databaseUsername;
            String databaseUserPassword;
            br = new BufferedReader(new FileReader("/home/roberto/IdeaProjects/Library/src/persistence/users.txt"));
            while ((currentLine = br.readLine()) != null) {
                databaseUsername = currentLine.split(",")[0];
                databaseUserPassword = currentLine.split(",")[1];
                if(databaseUsername.equals(username) && databaseUserPassword.equals(password)) return true;
            }
        } catch (IOException e) {
            //e.printStackTrace();
            System.out.println("El fichero no existe" + e);
        }
        return false;
    }

    public boolean registerUser(String username, String password){
        if(username.length()<1 || password.length()<1) return false;
        try(FileWriter fw = new FileWriter("/home/roberto/IdeaProjects/Library/src/persistence/users.txt", true);
            BufferedWriter bw = new BufferedWriter(fw);
            PrintWriter out = new PrintWriter(bw))
        {
            out.println(username+","+password);
            System.out.println("User registered");
            return true;
            //more code
        } catch (IOException e) {
            //exception handling left as an exercise for the reader
        }
        return false;
    }
}
