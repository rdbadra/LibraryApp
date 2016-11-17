package controller;

import com.googlecode.lanterna.gui2.*;
import com.googlecode.lanterna.screen.Screen;
import com.googlecode.lanterna.screen.TerminalScreen;
import com.googlecode.lanterna.terminal.DefaultTerminalFactory;
import com.googlecode.lanterna.terminal.Terminal;
import model.Database;
import view.LoginPanel;

import java.io.IOException;

/**
 * Created by roberto on 24/10/16.
 */
public class LibraryApp{
    Database database = new Database();
    public LibraryApp() throws IOException {
        Terminal terminal = new DefaultTerminalFactory().createTerminal();
        Screen screen = new TerminalScreen(terminal);
        screen.startScreen();
        // Create panel to hold components
        Panel panel= new LoginPanel(screen);
        // Create window to hold the panel
    }
}
