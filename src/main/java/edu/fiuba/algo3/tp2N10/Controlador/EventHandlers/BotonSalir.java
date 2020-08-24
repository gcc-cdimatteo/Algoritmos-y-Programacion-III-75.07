package edu.fiuba.algo3.tp2N10.Controlador.EventHandlers;

import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.media.MediaPlayer;


public class BotonSalir implements EventHandler<ActionEvent> {
    private MediaPlayer reproductor;

    public BotonSalir(MediaPlayer reproductor){
        this.reproductor = reproductor;
    }

    @Override
    public void handle(ActionEvent actionEvent) {
        if(reproductor != null) reproductor.stop();
        Platform.exit();
    }

}
