package view;

import javax.swing.*;
import java.awt.*;

/**
 * Created by roberto on 22/11/16.
 */
public class SearchSwingPanel extends JPanel {
    JTextField bookTextField = new JTextField(20);
    JButton searchButton = new JButton("Search");

    public SearchSwingPanel(){
        this.setLayout(new FlowLayout(FlowLayout.CENTER, 50, 50));
        this.add(new JLabel("Book:"));
        this.add(bookTextField);
        this.add(searchButton);
    }
}
