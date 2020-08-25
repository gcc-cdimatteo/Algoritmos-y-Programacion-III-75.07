package edu.fiuba.algo3.tp2N10.Controlador.EventHandlers;


import edu.fiuba.algo3.tp2N10.Controlador.Alertas.AlertaSeleccionarUnaOpcion;
import edu.fiuba.algo3.tp2N10.Modelo.AlgoKahoot.AlgoKahoot;
import edu.fiuba.algo3.tp2N10.Modelo.Respuesta.RespuestaVerdaderoFalso;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.ToggleButton;
import javafx.scene.media.Media;
import javafx.scene.media.MediaException;
import javafx.scene.media.MediaPlayer;

import java.io.File;
import java.util.Timer;
import java.util.concurrent.atomic.AtomicBoolean;

public class BotonResponderVF implements EventHandler<ActionEvent> {
    private final ToggleButton botonVerdadero;
    private final ToggleButton botonFalso;
    private final AlgoKahoot algoKahoot;
    private final Timer temporizador;
    private AtomicBoolean sinTiempo;

    public BotonResponderVF(AlgoKahoot algoKahoot, ToggleButton botonVerdadero, ToggleButton botonFalso, Timer temporizador, AtomicBoolean sinTiempo){
        this.algoKahoot = algoKahoot;
        this.botonVerdadero = botonVerdadero;
        this.botonFalso = botonFalso;
        this.temporizador = temporizador;
        this.sinTiempo = sinTiempo;
    }

    public void handle(ActionEvent actionEvent) {
        if(botonVerdadero.isSelected() || botonFalso.isSelected()){
            this.temporizador.cancel();
            try {
                MediaPlayer reproductor = new MediaPlayer(new Media(new File("./resources/audio/click.mp3").toURI().toString()));
                reproductor.setVolume(0.6);
                reproductor.play();
            } catch (MediaException ignored) {}
            algoKahoot.cargarRespuesta(new RespuestaVerdaderoFalso(botonVerdadero.isSelected()));
        }
        else if(sinTiempo.get()){
            this.temporizador.cancel();
            try {
                MediaPlayer reproductor = new MediaPlayer(new Media(new File("./resources/audio/sinrespuesta.mp3").toURI().toString()));
                reproductor.setVolume(0.6);
                reproductor.play();
            } catch (MediaException ignored) {}
            algoKahoot.jugadorNoResponde();
        }
        else{
            AlertaSeleccionarUnaOpcion alertaSeleccionarUnaOpcion = new AlertaSeleccionarUnaOpcion();
            alertaSeleccionarUnaOpcion.mostrar();
        }

    }
}
