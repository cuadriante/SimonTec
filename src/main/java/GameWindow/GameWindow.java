package GameWindow;

import Resources.ImageLoader;
import Level.LevelSetter;
import Pattern.PatternStorage;
import Pattern.UserPatternStorage;
import Resources.MusicPlayer;
import Resources.SoundPlayer;
import javafx.animation.FadeTransition;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.Group;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import javafx.util.Duration;

import java.net.URISyntaxException;

public class GameWindow {

    public static Stage gameStage;
    public static Group gameWindow = new Group();
    private static Scene gameScene = new Scene(gameWindow,700,700,Color.valueOf("#222222"));

    public static ImageView redTileClicked = new ImageView(ImageLoader.getInstance().getRedButtonClicked());
    public static ImageView blueTileClicked = new ImageView(ImageLoader.getInstance().getBlueButtonClicked());
    public static ImageView greenTileClicked = new ImageView(ImageLoader.getInstance().getGreenButtonClicked());
    public static ImageView yellowTileClicked = new ImageView(ImageLoader.getInstance().getYellowButtonClicked());


    public static UserPatternStorage userPatternStorage = new UserPatternStorage();
    public static PatternStorage patternStorage = new PatternStorage();

    private static SoundPlayer soundPlayer;

    public GameWindow(Stage lobby, MusicPlayer musicPlayer) {

        musicPlayer.play();

        gameStage = lobby;
        gameStage.setTitle( "SIMONTEC" );
        gameStage.setResizable(false);
        gameStage.setScene(gameScene);
        gameStage.show();

        ImageView menuBackground = new ImageView(ImageLoader.getInstance().getMenuBackground());
        menuBackground.setLayoutX(0);
        menuBackground.setLayoutY(0);

        redTileClicked.setLayoutX(103);
        redTileClicked.setLayoutY(105);
        redTileClicked.setOpacity(0.0);

        blueTileClicked.setLayoutX(335);
        blueTileClicked.setLayoutY(331);
        blueTileClicked.setOpacity(0.0);

        greenTileClicked.setLayoutX(333);
        greenTileClicked.setLayoutY(107);
        greenTileClicked.setOpacity(0.0);

        yellowTileClicked.setLayoutX(101);
        yellowTileClicked.setLayoutY(330);
        yellowTileClicked.setOpacity(0.0);

        lightUpTileWhenClicked(redTileClicked, "red");
        lightUpTileWhenClicked(blueTileClicked, "blue");
        lightUpTileWhenClicked(greenTileClicked, "green");
        lightUpTileWhenClicked(yellowTileClicked, "yellow");

        gameWindow.getChildren().add(menuBackground);
        gameWindow.getChildren().add(redTileClicked);
        gameWindow.getChildren().add(blueTileClicked);
        gameWindow.getChildren().add(greenTileClicked);
        gameWindow.getChildren().add(yellowTileClicked);

        LevelSetter.setLevelLabel();
        LevelSetter.setLevel();
        patternStorage.patternStorageAnimation();

    }


    public static void lightUpTileWhenClicked(ImageView tileColor, String color){

        tileColor.addEventHandler(MouseEvent.MOUSE_CLICKED, new EventHandler<MouseEvent>() {

            @Override
            public void handle(MouseEvent event) {
                lightUpTileAnimation(tileColor, color);
                event.consume();
                userPatternStorage.addColor(color);
                LevelSetter.checkPatternRepetition(userPatternStorage.getIndex());
            }
        });

    }

    public static void lightUpTileAnimation(ImageView tileColor, String color) {
        FadeTransition fadeTransition = new FadeTransition(Duration.millis(1000), tileColor);
        fadeTransition.setFromValue(1.0);
        fadeTransition.setToValue(0.0);
        fadeTransition.play();
        playNote(color);
    }

    public static void playNote(String color){
        try {
            soundPlayer = new SoundPlayer(color);
        } catch (URISyntaxException e) {
            e.printStackTrace();
        }

        soundPlayer.play();
    }

}
