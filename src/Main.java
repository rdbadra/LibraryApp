import controller.LibraryApp;
import controller.SwingController;
import model.Database;
import view.MainSwingFrame;

import java.io.IOException;

/**
 * Created by roberto on 24/10/16.
 */
public class Main {
    public static void main(String[] args) throws IOException {
        //new LibraryApp();
        Database model = new Database();
        MainSwingFrame view = new MainSwingFrame(model);
        SwingController controller = new SwingController(model, view);
        view.setVisible(true);
    }
}
