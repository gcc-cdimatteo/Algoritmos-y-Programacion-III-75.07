package edu.fiuba.algo3.tp2N10.Controlador.EventHandlers;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.media.Media;
import javafx.scene.media.MediaException;
import javafx.scene.media.MediaPlayer;
import javafx.stage.Stage;

import java.io.File;

public class BotonEntrar implements EventHandler<ActionEvent> {

    private final Stage escenario;
    private final Scene proximaEscena;

    public BotonEntrar(Stage stage, Scene proximaEscena) {
        this.escenario = stage;
        this.proximaEscena = proximaEscena;
    }

    @Override
    public void handle(ActionEvent actionEvent) {
        try {
            MediaPlayer reproductor = new MediaPlayer(new Media(new File("./resources/audio/click.mp3").toURI().toString()));
            reproductor.setVolume(0.6);
            reproductor.play();
        } catch (MediaException ignored) {}
        double ancho = escenario.getWidth();
        double alto = escenario.getHeight();
        boolean pantallaMaximizada = escenario.isMaximized();
        escenario.setScene(proximaEscena);
        escenario.setWidth(ancho);
        escenario.setHeight(alto);
        if (pantallaMaximizada) escenario.setMaximized(true);
    }
}
