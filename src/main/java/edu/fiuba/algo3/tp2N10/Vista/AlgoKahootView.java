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

        if (numeroTurno == 5){
            this.temporizador = new Timer();
            contenedor = new ContenedorRespuestas(algoKahoot);
            backgroundPath = "./resources/images/fondo.png";
            mediaPath = "./resources/audio/intermedio.mp3";
        } else if (algoKahoot.finalizado()) {
            contenedor = new ContenedorPodio(algoKahoot);
            backgroundPath = "./resources/images/final.png";
            mediaPath = "./resources/audio/final.mp3";
        } else if (numeroTurno == 1 || numeroTurno == 3) {
            this.temporizador = new Timer();
            contenedor = new ContenedorEnunciado(algoKahoot, this.temporizador);
            backgroundPath = "./resources/images/fondo.png";
            mediaPath = "./resources/audio/pregunta.mp3";
        } else if (numeroTurno == 6) {
            contenedor = new ContenedorEntreRondas(algoKahoot);
            backgroundPath = "./resources/images/fondo.png";
            mediaPath = "./resources/audio/intermedio.mp3";
            numeroTurno = 0;
        } else {
            this.temporizador = new Timer();
            contenedor = new ContenedorPrincipal(algoKahoot, this.temporizador);
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
            if(reproductor != null) {
                reproductor.stop();}
            if(temporizador != null){
                temporizador.cancel();
            }
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
