package edu.fiuba.algo3.tp2N10.Controlador.EventHandlers;

import edu.fiuba.algo3.tp2N10.Controlador.Alertas.AlertaNombreFaltante;
import edu.fiuba.algo3.tp2N10.Controlador.Alertas.AlertaNombreLargo;
import edu.fiuba.algo3.tp2N10.Vista.App;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.TextField;
import javafx.scene.media.Media;
import javafx.scene.media.MediaException;
import javafx.scene.media.MediaPlayer;

import java.io.File;
import java.io.IOException;

public class BotonComenzarJuego implements EventHandler<ActionEvent> {
    private final TextField nombreUno;
    private final TextField nombreDos;
    private final App app;
    private final Integer largoMaximo = 30;


    public BotonComenzarJuego(TextField nombreUno, TextField nombreDos, App app) {
        this.nombreUno = nombreUno;
        this.nombreDos = nombreDos;
        this.app = app;
    }

    @Override
    public void handle(ActionEvent event) {
        if (this.nombreUno.getText().isEmpty() || this.nombreDos.getText().isEmpty()) {
            AlertaNombreFaltante alertaNombreFaltante = new AlertaNombreFaltante();
            alertaNombreFaltante.mostrar();
        } else if (this.nombreUno.getLength() > largoMaximo || this.nombreDos.getLength() > largoMaximo) {
            AlertaNombreLargo alertaNombreLargo = new AlertaNombreLargo(largoMaximo);
            alertaNombreLargo.mostrar();
        } else {
            try {
                MediaPlayer reproductor = new MediaPlayer(new Media(new File("./resources/audio/click.mp3").toURI().toString()));
                reproductor.setVolume(0.6);
                reproductor.play();
            } catch (MediaException ignored) {}
            try {
                this.app.jugar(this.nombreUno.getText(), this.nombreDos.getText());
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
