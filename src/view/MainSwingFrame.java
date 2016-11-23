package view;

import model.Database;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

/**
 * Created by roberto on 22/11/16.
 */
public class MainSwingFrame extends JFrame{
    private Database database;
    LoginSwingPanel loginSwingPanel = new LoginSwingPanel(database);
    SearchSwingPanel searchSwingPanel = new SearchSwingPanel();

    public MainSwingFrame(Database database){
        this.database = database;
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(new Dimension(500, 500));
        this.setPreferredSize(new Dimension(500, 500));
        this.setLocationRelativeTo(null);

        this.setContentPane(loginSwingPanel);
        this.setResizable(false);
    }

    public LoginSwingPanel getLoginSwingPanel(){
        return loginSwingPanel;
    }

    public SearchSwingPanel getSearchSwingPanel(){
        return searchSwingPanel;
    }
}
