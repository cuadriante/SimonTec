package GameWindow;

import ImageLoader.ImageLoader;
import javafx.animation.FadeTransition;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.Group;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import javafx.util.Duration;

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

        ImageView redTileClicked = new ImageView(ImageLoader.getInstance().getRedButtonClicked());
        redTileClicked.setLayoutX(103);
        redTileClicked.setLayoutY(105);
        redTileClicked.setOpacity(0.0);

        ImageView blueTileClicked = new ImageView(ImageLoader.getInstance().getBlueButtonClicked());
        blueTileClicked.setLayoutX(335);
        blueTileClicked.setLayoutY(331);
        blueTileClicked.setOpacity(0.0);

        ImageView greenTileClicked = new ImageView(ImageLoader.getInstance().getGreenButtonClicked());
        greenTileClicked.setLayoutX(333);
        greenTileClicked.setLayoutY(107);
        greenTileClicked.setOpacity(0.0);

        ImageView yellowTileClicked = new ImageView(ImageLoader.getInstance().getYellowButtonClicked());
        yellowTileClicked.setLayoutX(101);
        yellowTileClicked.setLayoutY(330);
        yellowTileClicked.setOpacity(0.0);

        lightUpTile(redTileClicked);
        lightUpTile(blueTileClicked);
        lightUpTile(greenTileClicked);
        lightUpTile(yellowTileClicked);


        gameWindow.getChildren().add(menuBackground);
        gameWindow.getChildren().add(redTileClicked);
        gameWindow.getChildren().add(blueTileClicked);
        gameWindow.getChildren().add(greenTileClicked);
        gameWindow.getChildren().add(yellowTileClicked);
    }


    public void lightUpTile(ImageView tileColor){

        tileColor.addEventHandler(MouseEvent.MOUSE_CLICKED, new EventHandler<MouseEvent>() {

            @Override
            public void handle(MouseEvent event) {
                System.out.println("Tile pressed ");
                FadeTransition fadeTransition = new FadeTransition(Duration.millis(1000), tileColor);
                fadeTransition.setFromValue(1.0);
                fadeTransition.setToValue(0.0);
                fadeTransition.play();
                event.consume();
            }
        });

    }
}
