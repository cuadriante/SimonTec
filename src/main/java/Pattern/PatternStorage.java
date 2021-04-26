package Pattern;

import Window.GameWindow;
import Level.LevelSetter;
import javafx.concurrent.Task;
import javafx.scene.image.ImageView;

public class PatternStorage {
    CircularList<Color> patternStorage = new CircularList<>();
    CircularList<String> patternStorageColor = new CircularList<>();
    private Task<Void> animacion;
    private int index = 0;
    private int size = patternStorage.listSize();
    private boolean pararAnimacion = false;

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
                if (!pararAnimacion) {
                    do {
                        if (index == 0) {
                            Thread.sleep(1000);
                        }
                        if (index == size) {
                            System.out.println("brrrrrrr");
                        }
                        Color colorToLightUp = patternStorage.getElement(index);
                        ImageView colorImage = colorToLightUp.getColorImage();
                        GameWindow.lightUpTileAnimation(colorImage, colorToLightUp.getColorColor());
                        Thread.sleep(LevelSetter.timeBetweenColors);
                        index++;
                    } while (index <= size);
                }
                if (index == size - 1){
                    LevelSetter.repeatLabel.setFill(javafx.scene.paint.Color.valueOf("ffffff"));
                    LevelSetter.waitLabel.setFill(javafx.scene.paint.Color.valueOf("808080"));
                }

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

    public void setPararAnimacion(boolean state){
        pararAnimacion = state;
    }

}
















