package MenuWindow;

import ImageLoader.ImageLoader;
import javafx.animation.FadeTransition;
import javafx.concurrent.Task;
import javafx.scene.Scene;
import javafx.scene.Group;
import javafx.scene.control.Button;
import javafx.scene.effect.ImageInput;
import javafx.scene.image.ImageView;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;
import javafx.util.Duration;

import java.io.FileNotFoundException;

public class Menu {
    Stage lobby;
    Group root;
    public Menu(Stage Lobby){
        lobby = Lobby;
        lobby.setTitle( "SIMONTEC" );
        root = new Group();
        Scene scene = new Scene( root,700,700,Color.valueOf("#222222"));
        lobby.setScene(scene);

        Task<Void> menu = new Task<Void>() {
            @Override
            protected Void call() throws Exception {
                Thread.sleep(7000);
                return null;
            }
        };

        lobby.show();

        createComponents();

//        menu.setOnSucceeded(event -> {
//            try {
//               createComponents();
//            } catch (Exception e){
//                System.out.println(e.getMessage());
//            }
//
//        });
    }
    public void createComponents(){
        Button startButton =new Button();
        startButton.setLayoutX(0);
        startButton.setLayoutY(0);
        ImageView startButtonImage = new ImageView(ImageLoader.getInstance().getStartButton());
        startButton.setGraphic(startButtonImage);
        startButton.setWrapText(true);
        root.getChildren().add(startButton);
//        juegoInicia.setOnAction(e -> {
//            lobby.hide(); //se esconde la ventana principal
//            try {
//                //VentanaDeJuego.iniciarVentanaDeJuego(lobby); //se abre la ventana de juego
//            } catch (FileNotFoundException fileNotFoundException) {
//                fileNotFoundException.printStackTrace();
//            }
//        });
    }
}
