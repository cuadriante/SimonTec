package Pattern;

import javafx.scene.image.ImageView;

import java.util.Random;

public class Color {
    Random random = new Random();
    String color;
    ImageView colorImage;

    public Color(){
        //color = chooseColor();
    }

    public String chooseColor(){
        String chosenColor;
        int possibleColor = random.nextInt(4);
        switch (possibleColor) {
            case 1 -> chosenColor = "red";
            case 2 -> chosenColor = "blue";
            case 3 -> chosenColor = "green";
            default -> chosenColor = "yellow";
        }
        return chosenColor;
    }

    public void setColor(String newColor){
        color = newColor;
    }

    public void setColorImage(String stringColor){
//        if (stringColor == "red"){
//            colorImage = ImageLoader.
//        }
    }

}

