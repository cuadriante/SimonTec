package GameWindow;

import ImageLoader.ImageLoader;
import Pattern.PatternStorage;
import Pattern.UserPatternStorage;
import javafx.animation.FadeTransition;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.Group;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.util.Duration;

public class GameWindow {
    private static Stage gameStage;
    private static Group gameWindow = new Group();
    private static Scene gameScene = new Scene(gameWindow,700,700,Color.valueOf("#222222"));;
    private static Text levelLabel = new Text();
    private static UserPatternStorage userPatternStorage = new UserPatternStorage();
    private static PatternStorage patternStorage = new PatternStorage();
    private static int level = patternStorage.getLevel();

    public GameWindow(Stage lobby){

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

        lightUpTileWhenClicked(redTileClicked, "red");
        lightUpTileWhenClicked(blueTileClicked, "blue");
        lightUpTileWhenClicked(greenTileClicked, "green");
        lightUpTileWhenClicked(yellowTileClicked, "yellow");

        gameWindow.getChildren().add(menuBackground);
        gameWindow.getChildren().add(redTileClicked);
        gameWindow.getChildren().add(blueTileClicked);
        gameWindow.getChildren().add(greenTileClicked);
        gameWindow.getChildren().add(yellowTileClicked);

        setLevelLabel();

        patternStorage.patternStorageAnimation(gameWindow);

    }


    public static void lightUpTileWhenClicked(ImageView tileColor, String color){

        tileColor.addEventHandler(MouseEvent.MOUSE_CLICKED, new EventHandler<MouseEvent>() {

            @Override
            public void handle(MouseEvent event) {
                System.out.println("Tile pressed ");
                lightUpTileAnimation(tileColor);
                event.consume();
                userPatternStorage.addColor(color);
            }
        });

    }

    public static void lightUpTileAnimation(ImageView tileColor) {
        FadeTransition fadeTransition = new FadeTransition(Duration.millis(1000), tileColor);
        fadeTransition.setFromValue(1.0);
        fadeTransition.setToValue(0.0);
        fadeTransition.play();
    }

    public static void setLevelLabel(){
        String levelString = Integer.toString(level);

        levelLabel.setText(levelString);
        levelLabel.setX(312);
        levelLabel.setY(389);
        levelLabel.setFill(Color.valueOf("#ffffff"));

        double fontSize = 120;
        FontWeight fontWeight = FontWeight.BOLD;
        Font font = Font.font("Arial", fontWeight,fontSize);
        levelLabel.setFont(font);

        gameWindow.getChildren().add(levelLabel);
    }

}
