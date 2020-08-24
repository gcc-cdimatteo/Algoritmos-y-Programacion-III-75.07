package edu.fiuba.algo3.tp2N10.Controlador.Alertas;

import javafx.scene.control.Alert;
import javafx.scene.media.Media;
import javafx.scene.media.MediaException;
import javafx.scene.media.MediaPlayer;

import java.io.File;

public class AlertaNombreLargo extends Alert {

    private MediaPlayer reproductor;

    public AlertaNombreLargo(Integer largoMaximo) {
        super(AlertType.WARNING);
        this.setTitle("AlgoKahoot Error");
        this.setHeaderText("¡Nombre muy largo!");
        this.setContentText("Los nombres no deben superar "+ largoMaximo.toString() +" los caracteres");
        try{ this.reproductor = new MediaPlayer(new Media(new File("./resources/audio/alerta.mp3").toURI().toString())); }
        catch (MediaException ignored) {}
    }
    public void mostrar() {
        if (reproductor != null) this.reproductor.play();
        this.showAndWait();
    }

}

