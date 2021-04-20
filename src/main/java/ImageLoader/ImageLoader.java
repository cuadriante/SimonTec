package ImageLoader;

import javafx.scene.image.Image;
import java.io.InputStream;

/*
usar singleton para cargar cada imagen que se usa solo una vez
 */

/**
 * La clase Imagenes, un Singleton para cargar las imagenes utilizadas solo una vez.
 */
public class ImageLoader {
    private static ImageLoader INSTANCE = null;

    // imagenes disponibles
    private Image yellowButton = null;
    private Image blueButton = null;
    private Image redButton = null;
    private Image greenButton = null;
    private Image yellowButtonClicked = null;
    private Image blueButtonClicked = null;
    private Image redButtonClicked = null;
    private Image greenButtonClicked = null;
    private Image startButton = null;

    // constructor privado para que solo exista una instancia
    private ImageLoader() {
        loadImages();
    }

    // metodo sincronizado para evitar problemas con hilos
    public static synchronized ImageLoader getInstance() {
        if (INSTANCE == null) {
            INSTANCE = new ImageLoader();
        }
        return INSTANCE;
    }

    //llama a todos los cargar imagenes de todas las imagenes
    private void loadImages() {
        yellowButton = loadImage("/Images/amarillo.png");
        blueButton = loadImage("/Images/azul.png");
        redButton = loadImage("/Images/rojo.png");
        greenButton = loadImage("/Images/verde.png");
        startButton = loadImage("/Images/start.png");
    }

    private Image loadImage(String imageName) {
        Image resultado = null;
        try {
            InputStream inputStream = this.getClass().getResourceAsStream(imageName);
            resultado = new Image(inputStream);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return resultado;
    }

    public Image getYellowButton() {
        return yellowButton;
    }

    public Image getBlueButton() {
        return blueButton;
    }

    public Image getRedButton() {
        return redButton;
    }

    public Image getGreenButton() {
        return greenButton;
    }

    public Image getYellowButtonClicked() {
        return yellowButtonClicked;
    }

    public Image getBlueButtonClicked() {
        return blueButtonClicked;
    }

    public Image getRedButtonClicked() {
        return redButtonClicked;
    }

    public Image getGreenButtonClicked() {
        return greenButtonClicked;
    }

    public Image getStartButton() {
        return startButton;
    }
}
