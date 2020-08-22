package edu.fiuba.algo3.tp2N10.Vista;

import edu.fiuba.algo3.tp2N10.Modelo.AlgoKahoot.AlgoKahoot;
import javafx.application.Application;
import javafx.application.Platform;
import javafx.scene.Scene;
import javafx.scene.media.MediaException;
import javafx.stage.Stage;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;

import java.io.File;
import java.io.IOException;

public class App extends Application {

    Stage escenario;
    MediaPlayer reproductor;

    public static void main(String[] args) {
        launch(args);
    }

    public void start(Stage stage) {

        escenario = stage;
        //escenario.setMaximized(true);
        escenario.setTitle("AlgoKahoot");
        escenario.setOnCloseRequest(event -> {
            System.out.println("Stage is closing");
            if(reproductor != null) {reproductor.stop();}
            Platform.exit();
        });

        ContenedorJugadores contenedorJugadores = new ContenedorJugadores(this);
        Scene escenaJugadores = new Scene(contenedorJugadores, 1280, 720);

        ContenedorBienvenidos contenedorBienvenidos = new ContenedorBienvenidos(escenario, escenaJugadores);
        Scene escenaBienvenida = new Scene(contenedorBienvenidos, 1280, 720);

        try {
            reproductor = new MediaPlayer(new Media(new File("./resources/audio/intro.mp3").toURI().toString()));
            reproductor.setCycleCount(MediaPlayer.INDEFINITE);
            reproductor.play();
        } catch (MediaException ignored) {}

        escenario.setScene(escenaBienvenida);
        escenario.show();
    }

    public void jugar(String nombreUno, String nombreDos) throws IOException {
        if(reproductor != null) { this.reproductor.stop(); }
        AlgoKahoot algoKahoot = new AlgoKahoot("preguntas_test.json", nombreUno, nombreDos);
        AlgoKahootView algoKahootView = new AlgoKahootView(algoKahoot, escenario);
        algoKahootView.mostrar();
    }
}