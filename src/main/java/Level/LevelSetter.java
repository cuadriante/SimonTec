package Level;

import GameWindow.GameWindow;
import Pattern.CircularList;
import Pattern.PatternStorage;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;

public class LevelSetter {

    private static final CircularList<String> patternStorageColor = GameWindow.patternStorage.getPatternStorageColor();
    private static final CircularList<String> userPatternStorageColor = GameWindow.userPatternStorage.getUserPatternStorageColor();

    private static Text levelLabel = new Text();
    private static int level = GameWindow.patternStorage.getLevel();

    private static boolean state = true;
    private static int index;

    public static void setLevel(){

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

        GameWindow.gameWindow.getChildren().add(levelLabel);
    }

    public static void checkPatternRepetition(int index){
        System.out.println("index" + index);
        String currentColor = patternStorageColor.getElement(index);
        String currentUserColor = userPatternStorageColor.getElement(index);
        state = currentColor.equals(currentUserColor);
        System.out.println(state);
        if(!state){
            GameWindow.gameStage.close();
        }
        if (index == patternStorageColor.listSize() - 1){
            nextLevel();
            System.out.println("advancing");
        }

    }

    public static void nextLevel(){
        GameWindow.patternStorage.addColor();
        GameWindow.patternStorage.setIndex(0);
        GameWindow.patternStorage.patternStorageAnimation();
        GameWindow.userPatternStorage.setIndex(-1);
        GameWindow.userPatternStorage.deleteUserPatternStorage();
        String nivelString = Integer.toString(GameWindow.patternStorage.getLevel());
        levelLabel.setText(nivelString);
    }
}
