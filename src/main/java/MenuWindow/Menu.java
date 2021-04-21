package MenuWindow;

import GameWindow.GameWindow;
import ImageLoader.ImageLoader;
import javafx.scene.Scene;
import javafx.scene.Group;
import javafx.scene.control.Button;
import javafx.scene.image.ImageView;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

public class Menu {
    Stage lobby;
    Group menuWindow;

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
                GameWindow gameWindow = new GameWindow(lobby);
            } catch (Exception e2){
                e2.getMessage();
            }
                });
    }
}
