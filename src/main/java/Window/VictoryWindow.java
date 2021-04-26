package Window;

import Resources.ImageLoader;
import Resources.MusicPlayer;
import Resources.SoundPlayer;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.image.ImageView;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class VictoryWindow {
    private Stage lobby;
    private Group victoryWindow;


    public VictoryWindow(Stage Lobby, MusicPlayer musicPlayer, SoundPlayer soundPlayer){

        musicPlayer.play();
        soundPlayer.stop();

        victoryWindow = new Group();
        Scene scene = new Scene(victoryWindow,700,700, Color.valueOf("#222222"));

        ImageView victoryBackground = new ImageView(ImageLoader.getInstance().getVictoryBackground());
        victoryBackground.setLayoutX(0);
        victoryBackground.setLayoutY(0);

        lobby = Lobby;
        lobby.setTitle( "SIMONTEC" );
        lobby.setResizable(false);
        lobby.setScene(scene);

        lobby.show();
        Text gameOverLabel = new Text();
        gameOverLabel.setText("YOU WON !");
        gameOverLabel.setX(170);
        gameOverLabel.setY(350);
        gameOverLabel.setFill(Color.valueOf("#ffffff"));

        double fontSize = 60;
        FontWeight fontWeight = FontWeight.BOLD;
        Font font = Font.font("Arial", fontWeight,fontSize);
        gameOverLabel.setFont(font);

        victoryWindow.getChildren().add(victoryBackground);
        victoryWindow.getChildren().add(gameOverLabel);

    }

}
