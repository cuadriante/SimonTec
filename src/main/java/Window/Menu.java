package Window;

import Level.LevelSetter;
import Window.GameWindow;
import Resources.ImageLoader;
import Resources.MusicPlayer;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.Group;
import javafx.scene.control.Button;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
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

        ImageView startButton = new ImageView(ImageLoader.getInstance().getStartButtonCropped());
        startButton.setLayoutX(272);
        startButton.setLayoutY(274);

//        Button startButton =new Button();
//        startButton.setLayoutX(266);
//        startButton.setLayoutY(270);
//        ImageView startButtonImage = new ImageView(ImageLoader.getInstance().getStartButtonCropped());
//        startButton.setGraphic(startButtonImage);
//        startButton.setWrapText(true);

        openGameWhenClicked(startButton);

        menuWindow.getChildren().add(menuBackground);
        menuWindow.getChildren().add(startButton);

//        startButton.setOnAction(e ->{
//            try{
//                lobby.hide();
//                GameWindow gameWindow = new GameWindow(lobby, musicPlayer);
//            } catch (Exception e2){
//                e2.getMessage();
//            }
//                });
    }

    public void openGameWhenClicked(ImageView startButton){
        startButton.addEventHandler(MouseEvent.MOUSE_CLICKED, new EventHandler<MouseEvent>() {

            @Override
            public void handle(MouseEvent event) {
                try{
                lobby.hide();
                GameWindow gameWindow = new GameWindow(lobby, musicPlayer);
                } catch (Exception e2){
                e2.getMessage();
                }
                event.consume();
            }
        });


    }
}
