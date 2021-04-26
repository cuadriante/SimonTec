package Level;

import Window.GameWindow;
import Pattern.CircularList;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import Window.GameOverWindow;
import Window.VictoryWindow;

public class LevelSetter {

    private static final CircularList<String> patternStorageColor = GameWindow.patternStorage.getPatternStorageColor();
    private static final CircularList<String> userPatternStorageColor = GameWindow.userPatternStorage.getUserPatternStorageColor();

    private static Text levelLabel = new Text();
    private static int level = GameWindow.patternStorage.getLevel();

    public static Text waitLabel = new Text();
    public static Text repeatLabel = new Text();

    private static boolean state = true;
    private static int index;
    public static int timeBetweenColors = 1000;

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

        if (level >= 10) {
            levelLabel.setX(277);
        }

        GameWindow.gameWindow.getChildren().add(levelLabel);
    }

    public static void newLevelLabel(){
        String nivelString = Integer.toString(GameWindow.patternStorage.getLevel());
        levelLabel.setText(nivelString);
        if (level >= 10) {
            levelLabel.setX(277);
        }

    }

    public static void setWaitLabel(){
        waitLabel.setText("Wait . . .");
        waitLabel.setX(70);
        waitLabel.setY(70);
        waitLabel.setFill(Color.valueOf("#808080"));

        double fontSize = 40;
        FontWeight fontWeight = FontWeight.BOLD;
        Font font = Font.font("Arial", fontWeight,fontSize);
        waitLabel.setFont(font);

        GameWindow.gameWindow.getChildren().add(waitLabel);
    }

    public static void setRepeatLabel(){
        repeatLabel.setText("Repeat!");
        repeatLabel.setX(400);
        repeatLabel.setY(71);
        repeatLabel.setFill(Color.valueOf("808080"));

        double fontSize = 40;
        FontWeight fontWeight = FontWeight.BOLD;
        Font font = Font.font("Arial", fontWeight,fontSize);
        repeatLabel.setFont(font);

        GameWindow.gameWindow.getChildren().add(repeatLabel);
    }

    public static void checkPatternRepetition(int index) {

        waitLabel.setFill(Color.valueOf("#808080"));
        repeatLabel.setFill(Color.valueOf("#ffffff"));
        System.out.println("index" + index);
        String currentColor = patternStorageColor.getElement(index);
        String currentUserColor = userPatternStorageColor.getElement(index);
        state = currentColor.equals(currentUserColor);
        System.out.println(state);
        if(!state){
            GameWindow.gameStage.close();
            GameWindow.patternStorage.setPararAnimacion(true);
            GameOverWindow gameOverWindow = new GameOverWindow(GameWindow.gameStage, GameWindow.musicPlayer, GameWindow.soundPlayer);

        }
        if (index == patternStorageColor.listSize() - 1){
            nextLevel();
            System.out.println("advancing");
        }

    }

    public static void nextLevel() {
        level = GameWindow.patternStorage.getLevel();
        if (level == 10){
            VictoryWindow victoryWindow = new VictoryWindow(GameWindow.gameStage, GameWindow.musicPlayer, GameWindow.soundPlayer);
        } else {
            System.out.println(level);
            GameWindow.patternStorage.addColor();
            GameWindow.patternStorage.setIndex(0);
            GameWindow.patternStorage.patternStorageAnimation();
            GameWindow.userPatternStorage.setIndex(-1);
            GameWindow.userPatternStorage.deleteUserPatternStorage();

            newLevelLabel();
            repeatLabel.setFill(Color.valueOf("#808080"));
            waitLabel.setFill(Color.valueOf("#ffffff"));

            timeBetweenColors = timeBetweenColors - 100;
        }
    }
}
