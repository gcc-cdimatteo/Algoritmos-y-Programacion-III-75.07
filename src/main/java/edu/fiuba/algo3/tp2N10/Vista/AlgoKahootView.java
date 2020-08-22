package edu.fiuba.algo3.tp2N10.Vista;

import edu.fiuba.algo3.tp2N10.Modelo.AlgoKahoot.AlgoKahoot;
import edu.fiuba.algo3.tp2N10.Modelo.AlgoKahoot.Observer;
import javafx.application.Platform;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.scene.media.Media;
import javafx.scene.media.MediaException;
import javafx.scene.media.MediaPlayer;
import javafx.stage.Stage;

import java.io.File;
import java.io.FileNotFoundException;

public class AlgoKahootView implements Observer {
    private final Stage escenario;
    private final AlgoKahoot algoKahoot;
    private int numeroTurno = 0;
    private MediaPlayer reproductor;

    public AlgoKahootView(AlgoKahoot algoKahoot, Stage stage) {
        this.algoKahoot = algoKahoot;
        this.escenario = stage;
        algoKahoot.addObserver(this);
    }

    public void mostrar() {
        BorderPane contenedor;
        String backgroundPath;
        String mediaPath;
        numeroTurno++;

        if (algoKahoot.finalizado()) {
            contenedor = new ContenedorPodio(algoKahoot);
            backgroundPath = "./resources/images/fondo.png";
            mediaPath = "./resources/audio/final.mp3";
        } else if (numeroTurno == 5) {
            contenedor = new ContenedorEntreRondas(algoKahoot);
            backgroundPath = "./resources/images/fondo.png";
            mediaPath = "./resources/audio/intermedio.mp3";
            numeroTurno = 0;
        } else if (numeroTurno % 2 != 0) {
            contenedor = new ContenedorPregunta(algoKahoot);
            backgroundPath = "./resources/images/fondo.png";
            mediaPath = "./resources/audio/pregunta.mp3";
        } else {
            contenedor = new ContenedorPrincipal(algoKahoot);
            backgroundPath = "./resources/images/fondo.png";
            mediaPath = "./resources/audio/jugar.mp3";
        }

        try { contenedor.setBackground(new FactoryBackgrounds().crearBackground(backgroundPath, 1280, 720));}
        catch (FileNotFoundException ignored) {}

        try {
            reproductor = crearReproductor(mediaPath);
            reproductor.play();
        } catch (MediaException ignored) {}


        double ancho = escenario.getWidth();
        double alto = escenario.getHeight();

        escenario.setScene(new Scene(contenedor, 1280, 720));

        escenario.setOnCloseRequest(event -> {
            System.out.println("Stage AlgoKahootView is closing");
            if(reproductor != null) {
                System.out.println("Reproductor AlgoKahootView is closing");
                reproductor.stop();}
            Platform.exit();
        });

        escenario.setWidth(ancho);
        escenario.setHeight(alto);
    }

    private MediaPlayer crearReproductor(String mediaPath) {
        if (reproductor != null) reproductor.stop();
        MediaPlayer reproductor = new MediaPlayer(new Media(new File(mediaPath).toURI().toString()));
        reproductor.setCycleCount(MediaPlayer.INDEFINITE);
        return reproductor;
    }


    @Override
    public void change() {
        this.mostrar();
    }
}
