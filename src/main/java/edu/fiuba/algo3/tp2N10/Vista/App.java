package edu.fiuba.algo3.tp2N10.Vista;

import edu.fiuba.algo3.tp2N10.Modelo.AlgoKahoot.AlgoKahoot;
import edu.fiuba.algo3.tp2N10.FactoryPreguntas;
import javafx.application.Application;
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

        this.escenario = stage;

        this.escenario.setTitle("AlgoKahoot");

        ContenedorJugadores contenedorJugadores = new ContenedorJugadores(this);
        Scene escenaJugadores = new Scene(contenedorJugadores, 640, 480);

        ContenedorBienvenidos contenedorBienvenidos = new ContenedorBienvenidos(this.escenario, escenaJugadores);
        Scene escenaBienvenida = new Scene(contenedorBienvenidos, 640, 480);

        try {
            this.reproductor = new MediaPlayer(new Media(new File("./resources/audio/intro.mp3").toURI().toString()));
            this.reproductor.setCycleCount(MediaPlayer.INDEFINITE);
            this.reproductor.play();
        } catch (MediaException mediaException) {}

        this.escenario.setScene(escenaBienvenida);
        this.escenario.show();
    }

    public void jugar(String nombreUno, String nombreDos) throws IOException {
        this.reproductor.stop();
        AlgoKahoot algoKahoot = new AlgoKahoot(new FactoryPreguntas("preguntas_test.json").preguntas(), nombreUno, nombreDos);
        AlgoKahootView algoKahootView = new AlgoKahootView(algoKahoot, escenario);
        algoKahootView.mostrar();
    }
}

//Música por https://patrickdearteaga.com