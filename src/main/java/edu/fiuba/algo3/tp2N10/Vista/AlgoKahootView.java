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
import java.util.Timer;

public class AlgoKahootView implements Observer {

    private final Stage escenario;
    private final AlgoKahoot algoKahoot;
    private int numeroTurno = 0;
    private MediaPlayer reproductor;
    private Timer temporizador;

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
            mediaPath = "./resources/audio/final.mp3";
            backgroundPath = "./resources/images/final.png";
            contenedor = new ContenedorPodio(algoKahoot,reproductor);
        } else {
            backgroundPath = "./resources/images/fondo.png";
            switch (numeroTurno % 6) {
                case 1:
                case 3:
                    mediaPath = "./resources/audio/pregunta.mp3";
                    temporizador = new Timer();
                    contenedor = new ContenedorEnunciado(algoKahoot, temporizador);
                    break;
                case 2:
                case 4:
                    mediaPath = "./resources/audio/jugar.mp3";
                    temporizador = new Timer();
                    contenedor = new ContenedorPrincipal(algoKahoot, temporizador);
                    break;
                case 5:
                    mediaPath = "./resources/audio/intermedio.mp3";
                    contenedor = new ContenedorRespuestas(algoKahoot);
                    break;
                default:
                    mediaPath = "./resources/audio/intermedio.mp3";
                    contenedor = new ContenedorEntreRondas(algoKahoot);
            }
        }

        try {
            contenedor.setBackground(new FactoryBackgrounds().crearBackground(backgroundPath, 1280, 720));
        } catch (FileNotFoundException ignored) {}

        try {
            reproductor = crearReproductor(mediaPath);
            reproductor.play();
        } catch (MediaException ignored) {}

        double ancho = escenario.getWidth();
        double alto = escenario.getHeight();

        escenario.setScene(new Scene(contenedor, 1280, 720));

        escenario.setOnCloseRequest(event -> {
            if (reproductor != null) reproductor.stop();
            if (temporizador != null) temporizador.cancel();
            Platform.exit();
        });

        escenario.setWidth(ancho);
        escenario.setHeight(alto);
    }

    private MediaPlayer crearReproductor(String mediaPath) {
        if (reproductor != null) reproductor.stop();
        MediaPlayer reproductor = new MediaPlayer(new Media(new File(mediaPath).toURI().toString()));
        reproductor.setCycleCount(MediaPlayer.INDEFINITE);
        reproductor.setVolume(0.3);
        return reproductor;
    }

    @Override
    public void change() {
        this.mostrar();
    }
}
