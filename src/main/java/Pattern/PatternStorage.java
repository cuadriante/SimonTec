package Pattern;

import GameWindow.GameWindow;
import javafx.concurrent.Task;
import javafx.scene.Group;
import javafx.scene.image.ImageView;

import java.sql.Time;

public class PatternStorage {
    CircularList<Color> patternStorage = new CircularList<>();
    CircularList<String> patternStorageColor = new CircularList<>();
    private Task<Void> animacion;
    private int index = 0;
    private int size = patternStorage.listSize();

    public PatternStorage() {
        addColor();
    }

    public void addColor(){
        Color newColor = new Color();
        newColor.chooseColor();
        patternStorage.addLast(newColor);
        patternStorageColor.addLast(newColor.getColorColor());
    }

    public void patternStorageAnimation(){
        animacion = new Task<>() {
            @Override
            public Void call() throws InterruptedException {
                    do {
                        if (index == 0){
                            Thread.sleep(1000);
                        }
                        Color colorToLightUp = patternStorage.getElement(index);
                        ImageView colorImage = colorToLightUp.getColorImage();
                        GameWindow.lightUpTileAnimation(colorImage, colorToLightUp.getColorColor());
                        Thread.sleep(1000);
                        index++;
                    } while (index <= size);
                return null;
            }
        };
        animacion.setOnSucceeded(event -> {
            if (animacion.isDone()){
                patternStorageAnimation();
            }
        });
        new Thread(animacion).start();
    }

    public int getLevel(){
        return patternStorage.listSize();
    }

    public CircularList<String> getPatternStorageColor() {
        return patternStorageColor;
    }

    public void setIndex(int index){
        this.index = index;
    }

}
















