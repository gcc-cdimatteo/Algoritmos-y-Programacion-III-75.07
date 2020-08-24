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
import java.io.FileNotFoundException;
import java.io.IOException;

public class App extends Application {

    Stage escenario;
    MediaPlayer reproductor;

    public static void main(String[] args) {
        launch(args);
    }

    public void start(Stage stage) {

        escenario = stage;
        escenario.setMaximized(true);
        escenario.setTitle("AlgoKahoot");
        escenario.setOnCloseRequest(event -> {
            if (reproductor != null) reproductor.stop();
            Platform.exit();
        });

        ContenedorJugadores contenedorJugadores = new ContenedorJugadores(this);

        try {
            contenedorJugadores.setBackground(new FactoryBackgrounds().crearBackground("./resources/images/fondo.png", 1280, 720));
        } catch (FileNotFoundException ignored) {}
        Scene escenaJugadores = new Scene(contenedorJugadores, 1280, 720);

        ContenedorBienvenidos contenedorBienvenidos = new ContenedorBienvenidos(escenario, escenaJugadores);
        try {
            contenedorBienvenidos.setBackground(new FactoryBackgrounds().crearBackground("./resources/images/bienvenida.png", 1280, 720));
        } catch (FileNotFoundException ignored) {}

        try {
            reproductor = new MediaPlayer(new Media(new File("./resources/audio/intro.mp3").toURI().toString()));
            reproductor.setCycleCount(MediaPlayer.INDEFINITE);
            reproductor.setVolume(0.3);
            reproductor.play();
        } catch (MediaException ignored) {}

        Scene escenaBienvenida = new Scene(contenedorBienvenidos, 1280, 720);

        escenario.setScene(escenaBienvenida);
        escenario.show();
    }

    public void jugar(String nombreUno, String nombreDos) throws IOException {
        if(reproductor != null) { this.reproductor.stop(); }
        AlgoKahoot algoKahoot = new AlgoKahoot("preguntas_single_test.json", nombreUno, nombreDos);
        AlgoKahootView algoKahootView = new AlgoKahootView(algoKahoot, escenario);
        algoKahootView.mostrar();
    }
}