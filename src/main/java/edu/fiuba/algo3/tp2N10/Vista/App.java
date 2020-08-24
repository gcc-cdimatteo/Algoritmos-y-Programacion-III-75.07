package edu.fiuba.algo3.tp2N10.Vista;

import edu.fiuba.algo3.tp2N10.Controlador.Alertas.AlertaErrorArchivoJson;
import edu.fiuba.algo3.tp2N10.Modelo.AlgoKahoot.AlgoKahoot;
import edu.fiuba.algo3.tp2N10.Modelo.Excepciones.PreguntaDesconocidaException;
import javafx.application.Application;
import javafx.application.Platform;
import javafx.scene.Scene;
import javafx.scene.media.MediaException;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.NoSuchFileException;

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

        try {
            reproductor = new MediaPlayer(new Media(new File("./resources/audio/intro.mp3").toURI().toString()));
            reproductor.setCycleCount(MediaPlayer.INDEFINITE);
            reproductor.setVolume(0.3);
            reproductor.play();
        } catch (MediaException ignored) {}

        ContenedorJugadores contenedorJugadores = new ContenedorJugadores(this);

        try {
            contenedorJugadores.setBackground(new FactoryBackgrounds().crearBackground("./resources/images/fondo.png", 1280, 720));
        } catch (FileNotFoundException ignored) {}
        Scene escenaJugadores = new Scene(contenedorJugadores, 1280, 720);

        ContenedorBienvenidos contenedorBienvenidos = new ContenedorBienvenidos(escenario, escenaJugadores, reproductor);
        try {
            contenedorBienvenidos.setBackground(new FactoryBackgrounds().crearBackground("./resources/images/bienvenida.png", 1280, 720));
        } catch (FileNotFoundException ignored) {}



        Scene escenaBienvenida = new Scene(contenedorBienvenidos, 1280, 720);

        escenario.setScene(escenaBienvenida);
        escenario.show();
    }

    public void jugar(String nombreUno, String nombreDos) throws IOException {
        if(reproductor != null) { this.reproductor.stop(); }
        AlgoKahoot algoKahoot;
        try{ algoKahoot = new AlgoKahoot("preguntas_variadas.json", nombreUno, nombreDos);
        } catch (NoSuchFileException | org.json.JSONException | PreguntaDesconocidaException ignored) {
            FileChooser fileChooser = new FileChooser();
            AlertaErrorArchivoJson alertaErrorArchivoJson = new AlertaErrorArchivoJson();
            alertaErrorArchivoJson.mostrar();
            algoKahoot = new AlgoKahoot(fileChooser.showOpenDialog(this.escenario).getAbsolutePath(), nombreUno, nombreDos);
        }
        AlgoKahootView algoKahootView = new AlgoKahootView(algoKahoot, escenario);
        algoKahootView.mostrar();
    }
}