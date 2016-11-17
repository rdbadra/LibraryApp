package view;

import com.googlecode.lanterna.TextColor;
import com.googlecode.lanterna.gui2.*;
import com.googlecode.lanterna.gui2.dialogs.MessageDialog;
import com.googlecode.lanterna.screen.Screen;
import model.Book;
import model.Database;

/**
 * Created by roberto on 1/11/16.
 */
public class BookAdditionPanel extends Panel{
    Database database = new Database();
    public BookAdditionPanel(Screen screen){
        this.setLayoutManager(new GridLayout(4));
        this.addComponent(new Label("Book Name"));
        TextBox bookName = new TextBox();
        this.addComponent(bookName);
        this.addComponent(new Label("Number of Pages"));
        TextBox numberOfPages = new TextBox();
        this.addComponent(numberOfPages);
        this.addComponent(new Label("Author"));
        TextBox author = new TextBox();
        this.addComponent(author);
        this.addComponent(new Label("Available"));
        TextBox available = new TextBox();
        this.addComponent(available);
        this.addComponent(new Button("Back", new Runnable() {
            @Override
            public void run() {
                new MainPanel(screen);

            }
        }));

        BasicWindow window = new BasicWindow();
        MultiWindowTextGUI gui = new MultiWindowTextGUI(screen, new DefaultWindowManager(), new EmptySpace(TextColor.ANSI.GREEN));


        this.addComponent(new Button("Save", new Runnable() {
            @Override
            public void run() {
                if(bookName.getText().length()>0 && numberOfPages.getText().length()>0 && author.getText().length()>0 && available.getText().length()>0){
                    database.addToDatabase(new Book(bookName.getText(),Integer.parseInt(numberOfPages.getText()),author.getText(),available.getText()));
                    MessageDialog.showMessageDialog(gui, "Information", "Book saved");
                    new MainPanel(screen);
                } else {
                    MessageDialog.showMessageDialog(gui, "Information", "Nothing has been saved saved");
                }
            }
        }));
        window.setComponent(this);
        gui.addWindowAndWait(window);
    }

}
