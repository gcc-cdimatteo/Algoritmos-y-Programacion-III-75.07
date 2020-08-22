package edu.fiuba.algo3.tp2N10.Controlador.Alertas;

import javafx.scene.control.Alert;
import javafx.scene.media.Media;
import javafx.scene.media.MediaException;
import javafx.scene.media.MediaPlayer;

import java.io.File;

public class AlertaSeleccionarUnaOpcion extends Alert{

    private MediaPlayer reproductor;

    public AlertaSeleccionarUnaOpcion() {
        super(AlertType.WARNING);
        this.setTitle("AlgoKahoot Error");
        this.setHeaderText("¡Debe seleccionar al menos una opcion!");
        this.reproductor = new MediaPlayer(new Media(new File("./resources/audio/alerta.mp3").toURI().toString()));
    }

    public void mostrar() {
        this.reproductor.play();
        this.showAndWait();
    }
}
