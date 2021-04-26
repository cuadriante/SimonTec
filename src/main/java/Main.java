import Window.GameWindow;
import Window.Menu;
import javafx.application.Application;
import javafx.stage.Stage;

public class Main extends Application {
    @Override
    public void start(Stage Lobby) throws Exception {
        Menu menu = new Menu(Lobby);
        //GameWindow gameWindow = new GameWindow(Lobby);
    }

    public static void main(String[] args) {
        launch(args);
    }
}