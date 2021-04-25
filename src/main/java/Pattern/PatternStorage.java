package Pattern;

import GameWindow.GameWindow;
import javafx.scene.Group;

public class PatternStorage {
    CircularList<Color> patternStorage = new CircularList<>();

    public PatternStorage() {
        Color newColor = new Color();
        newColor.chooseColor();
        patternStorage.addLast(new Color());
    }
    public void addColor(){
        Color newColor = new Color();
        newColor.chooseColor();
        patternStorage.addLast(new Color());
    }

    public void patternStorageAnimation(Group gameWindow) {
        patternStorage.listSize();
        //GameWindow.lightUpTileAnimation();
    }

    public int getLevel(){
        return patternStorage.listSize();
    }
}
