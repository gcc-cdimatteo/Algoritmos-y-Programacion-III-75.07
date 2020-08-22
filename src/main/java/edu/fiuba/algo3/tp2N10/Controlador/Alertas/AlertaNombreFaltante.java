package edu.fiuba.algo3.tp2N10.Controlador.Alertas;

import javafx.scene.control.Alert;
import javafx.scene.media.Media;
import javafx.scene.media.MediaException;
import javafx.scene.media.MediaPlayer;

import java.io.File;

public class AlertaNombreFaltante extends Alert {

    private MediaPlayer reproductor;

    public AlertaNombreFaltante() {
        super(AlertType.WARNING);
        this.setTitle("AlgoKahoot Error");
        this.setHeaderText("¡Faltan nombres!");
        this.setContentText("Los nombres de los jugadores son obligatorios");
        try{ this.reproductor = new MediaPlayer(new Media(new File("./resources/audio/alerta.mp3").toURI().toString())); }
        catch (MediaException ignored) {}
    }

    public void mostrar() {
        if (reproductor != null) this.reproductor.play();
        this.showAndWait();
    }

}