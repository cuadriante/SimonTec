package GameWindow;

import Resources.ImageLoader;
import Resources.MusicPlayer;
import Resources.SoundPlayer;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.image.ImageView;
import javafx.scene.media.MediaPlayer;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class GameOverWindow {
    private Stage lobby;
    private Group gameOverWindow;


    public GameOverWindow(Stage Lobby, MusicPlayer musicPlayer, SoundPlayer soundPlayer){

        musicPlayer.stop();
        soundPlayer.stop();

        gameOverWindow = new Group();
        Scene scene = new Scene(gameOverWindow,700,700, Color.valueOf("#222222"));

        ImageView gameOverBackground = new ImageView(ImageLoader.getInstance().getGameOverBackground());
        gameOverBackground.setLayoutX(0);
        gameOverBackground.setLayoutY(0);

        lobby = Lobby;
        lobby.setTitle( "SIMONTEC" );
        lobby.setResizable(false);
        lobby.setScene(scene);

        lobby.show();
        Text gameOverLabel = new Text();
        gameOverLabel.setText("GAME OVER");
        gameOverLabel.setX(170);
        gameOverLabel.setY(350);
        gameOverLabel.setFill(Color.valueOf("#ffffff"));

        double fontSize = 60;
        FontWeight fontWeight = FontWeight.BOLD;
        Font font = Font.font("Arial", fontWeight,fontSize);
        gameOverLabel.setFont(font);

        gameOverWindow.getChildren().add(gameOverBackground);
        gameOverWindow.getChildren().add(gameOverLabel);

    }

}
