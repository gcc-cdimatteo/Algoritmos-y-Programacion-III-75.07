package edu.fiuba.algo3.tp2N10.Controlador.Alertas;

import javafx.scene.control.Alert;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;

import java.io.File;

public class AlertaNombreFaltante extends Alert {

    private MediaPlayer reproductor;

    public AlertaNombreFaltante() {
        super(AlertType.WARNING);
        this.setTitle("AlgoKahoot Error");
        this.setHeaderText("¡Faltan nombres!");
        this.setContentText("Los nombres de los jugadores son obligatorios");
        this.reproductor = new MediaPlayer(new Media(new File("./resources/audio/alerta.mp3").toURI().toString()));
    }

    public void mostrar() {
        this.reproductor.play();
        this.showAndWait();
    }

}