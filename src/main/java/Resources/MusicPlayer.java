package Resources;

import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.util.Duration;

import java.net.URISyntaxException;
import java.util.Objects;

public class MusicPlayer {
    private final MediaPlayer mediaPlayer;

    public MusicPlayer() throws URISyntaxException {
        Media media = new Media((Objects.requireNonNull(getClass().getResource("/Music/kirbyrr.mp3"))).toURI().toString());
        mediaPlayer = new MediaPlayer(media);
        System.out.println("playing");

    }

    public void reproducir(){
        mediaPlayer.setOnEndOfMedia(new Runnable() {
            public void run() {
                mediaPlayer.seek(Duration.ZERO);
            }
        });
        mediaPlayer.setVolume(10.0);
        mediaPlayer.setAutoPlay(true);
    }


    public void detener(){
        mediaPlayer.setVolume(0);
    }

}
