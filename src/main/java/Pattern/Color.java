package Pattern;

import Window.GameWindow;
import javafx.scene.image.ImageView;

import java.util.Random;

public class Color {
    Random random = new Random();
    String color;
    ImageView colorImage;

    public Color(){
        //color = chooseColor();
    }

    public void chooseColor(){
        String chosenColor;
        int possibleColor = random.nextInt(4);
        switch (possibleColor) {
            case 1 -> chosenColor = "red";
            case 2 -> chosenColor = "blue";
            case 3 -> chosenColor = "green";
            default -> chosenColor = "yellow";
        }
        setColorImage(chosenColor);
        color = chosenColor;
    }

    public void setColor(String newColor){
        color = newColor;
    }

    public void setColorImage(String stringColor){
        switch (stringColor) {
            case "red" -> colorImage = GameWindow.redTileClicked;
            case "blue" -> colorImage = GameWindow.blueTileClicked;
            case "green" -> colorImage = GameWindow.greenTileClicked;
            default -> colorImage = GameWindow.yellowTileClicked;
        }
    }

    public ImageView getColorImage(){
        return colorImage;
    }
    public String getColorColor(){
        return color;
    }

}

