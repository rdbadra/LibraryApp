package view; /**
 * Created by roberto on 24/10/16.
 */
import com.googlecode.lanterna.gui2.*;
import com.googlecode.lanterna.screen.Screen;
import model.Book;
import model.Database;

public class SearchPanel extends Panel{
    Database database = null;

    public SearchPanel(Database database, BookPanel bookPanel, MainPanel mainpanel, Screen screen){
        this.database = database;
        this.setLayoutManager(new GridLayout(5));
        this.addComponent(new Label("model.Book"));
        TextBox bookName = new TextBox();
        this.addComponent(bookName);
        Button search = new Button("Search", new Runnable() {
            @Override
            public void run() {
                if(bookName.getText().length() > 0){
                    Book book = database.search(bookName.getText());
                    if(book != null){
                        bookPanel.addRegister(book);
                    }else {
                        bookPanel.showNoResults();
                    };

                }
            }
        });
        this.addComponent(search);
        this.addComponent(new Button("ADD", new Runnable() {
            @Override
            public void run() {
                BookAdditionPanel bookAdditionPanel = new BookAdditionPanel(screen);

            }
        }));

        this.addComponent(new Button("Logout", new Runnable() {
            @Override
            public void run() {
                new LoginPanel(screen);
            }
        }));
    }
}
