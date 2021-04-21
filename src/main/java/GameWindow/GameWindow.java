package GameWindow;

import ImageLoader.ImageLoader;
import javafx.scene.Scene;
import javafx.scene.Group;
import javafx.scene.image.ImageView;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

public class GameWindow {
    private Stage gameStage;
    private Group gameWindow;
    private Scene gameScene;


    public GameWindow(Stage lobby){

        gameWindow = new Group();
        gameScene = new Scene(gameWindow,700,700,Color.valueOf("#222222"));

        gameStage = lobby;
        gameStage.setTitle( "SIMONTEC" );
        gameStage.setResizable(false);
        gameStage.setScene(gameScene);

        gameStage.show();

        ImageView menuBackground = new ImageView(ImageLoader.getInstance().getMenuBackground());
        menuBackground.setLayoutX(0);
        menuBackground.setLayoutY(0);

        gameWindow.getChildren().add(menuBackground);
    }

}
