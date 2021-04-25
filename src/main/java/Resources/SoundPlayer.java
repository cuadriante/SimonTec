package Resources;

import GameWindow.GameWindow;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.util.Duration;

import java.net.URISyntaxException;
import java.util.Objects;

public class SoundPlayer {
    private final MediaPlayer soundPlayer;
    private final String redSound = "/Music/redSound.mp3";
    private final String blueSound = "/Music/blueSound.mp3";
    private final String greenSound = "/Music/greenSound.mp3";
    private final String yellowSound = "/Music/yellowSound.mp3";
    private final String nextLevelSound = "/Music/nextLevel.mp3";


    public SoundPlayer(String color) throws URISyntaxException {
        String colorSound = getColorSound(color);
        Media media = new Media((Objects.requireNonNull(getClass().getResource(colorSound))).toURI().toString());
        soundPlayer = new MediaPlayer(media);
        System.out.println("playing sound");

    }

    public void play(){
        soundPlayer.setVolume(500.0);
        soundPlayer.setAutoPlay(true);
    }

    public void stop(){
        soundPlayer.setVolume(0);
    }

    public String getColorSound(String color){
        String colorSound;
        switch (color) {
            case "red" -> colorSound = redSound;
            case "blue" -> colorSound = blueSound;
            case "green" -> colorSound = greenSound;
            default -> colorSound = yellowSound;
        }
        return colorSound;

    }

}
