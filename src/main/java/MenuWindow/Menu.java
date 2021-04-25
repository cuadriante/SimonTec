package MenuWindow;

import GameWindow.GameWindow;
import Resources.ImageLoader;
import Resources.MusicPlayer;
import javafx.scene.Scene;
import javafx.scene.Group;
import javafx.scene.control.Button;
import javafx.scene.image.ImageView;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

import java.net.URISyntaxException;

public class Menu {
    private final Stage lobby;
    private final Group menuWindow;
    private MusicPlayer musicPlayer;


    public Menu(Stage Lobby){

        menuWindow = new Group();
        Scene scene = new Scene(menuWindow,700,700,Color.valueOf("#222222"));

        lobby = Lobby;
        lobby.setTitle( "SIMONTEC" );
        lobby.setResizable(false);
        lobby.setScene(scene);

        lobby.show();

        createComponents();
    }

    public void createComponents(){

        try {
            musicPlayer = new MusicPlayer();
        } catch (URISyntaxException e) {
            e.printStackTrace();
        }
        musicPlayer.play();

        ImageView menuBackground = new ImageView(ImageLoader.getInstance().getMenuBackground());
        menuBackground.setLayoutX(0);
        menuBackground.setLayoutY(0);

        Button startButton =new Button();
        startButton.setLayoutX(266);
        startButton.setLayoutY(270);
        ImageView startButtonImage = new ImageView(ImageLoader.getInstance().getStartButtonCropped());
        startButton.setGraphic(startButtonImage);
        startButton.setWrapText(true);

        menuWindow.getChildren().add(menuBackground);
        menuWindow.getChildren().add(startButton);

        startButton.setOnAction(e ->{
            try{
                lobby.hide();
                GameWindow gameWindow = new GameWindow(lobby, musicPlayer);
            } catch (Exception e2){
                e2.getMessage();
            }
                });
    }
}
