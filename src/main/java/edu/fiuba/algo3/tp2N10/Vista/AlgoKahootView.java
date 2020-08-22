package edu.fiuba.algo3.tp2N10.Vista;

import edu.fiuba.algo3.tp2N10.Modelo.AlgoKahoot.AlgoKahoot;
import edu.fiuba.algo3.tp2N10.Modelo.AlgoKahoot.Observer;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.scene.media.Media;
import javafx.scene.media.MediaException;
import javafx.scene.media.MediaPlayer;
import javafx.stage.Stage;

import java.io.File;

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
        String mediaPath;
        this.numeroTurno++;

        if (algoKahoot.finalizado()) {
            contenedor = new ContenedorPodio(this.algoKahoot);
            mediaPath = "./resources/audio/final.mp3";
        } else if (numeroTurno == 5) {
            contenedor = new ContenedorEntreRondas(this.algoKahoot);
            mediaPath = "./resources/audio/intermedio.mp3";
            this.numeroTurno = 0;
        } else if (numeroTurno % 2 != 0) {
            contenedor = new ContenedorPregunta(this.algoKahoot);
            mediaPath = "./resources/audio/pregunta.mp3";
        } else{
            contenedor = new ContenedorPrincipal(this.algoKahoot);
            mediaPath = "./resources/audio/jugar.mp3";
        }
        try {
            if(this.reproductor != null) { this.reproductor.stop();}
            this.reproductor = crearReproductor(mediaPath);
            this.reproductor.play();
        } catch (MediaException mediaException) {}

        double ancho = this.escenario.getWidth();
        double alto = this.escenario.getHeight();

        this.escenario.setScene(new Scene(contenedor, 640, 480));

        this.escenario.setWidth(ancho);
        this.escenario.setHeight(alto);
    }

    private MediaPlayer crearReproductor(String mediaPath){
        MediaPlayer reproductor = new MediaPlayer(new Media(new File(mediaPath).toURI().toString()));
        reproductor.setCycleCount(MediaPlayer.INDEFINITE);
        return reproductor;
    }


    @Override
    public void change() {
        this.mostrar();
    }
}
