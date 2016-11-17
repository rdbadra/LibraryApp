package view;

import com.googlecode.lanterna.TextColor;
import com.googlecode.lanterna.gui2.*;
import com.googlecode.lanterna.screen.Screen;
import model.Database;
import view.BookPanel;
import view.SearchPanel;

/**
 * Created by roberto on 24/10/16.
 */
public class MainPanel extends Panel {
    //This panel must include view.BookPanel and view.SearchPanel
    Database database = new Database();
    public MainPanel(Screen screen){
        this.setLayoutManager(new LinearLayout(Direction.VERTICAL));
        BookPanel bookPanel = new BookPanel();
        Panel searchPanel = new SearchPanel(database, bookPanel, this, screen);
        this.addComponent(searchPanel);
        this.addComponent(bookPanel);
        BasicWindow window = new BasicWindow();
        window.setComponent(this);
        // Create gui and start gui
        WindowBasedTextGUI gui = new MultiWindowTextGUI(screen, new DefaultWindowManager(), new EmptySpace(TextColor.ANSI.BLUE));
        gui.addWindowAndWait(window);
    }
}
