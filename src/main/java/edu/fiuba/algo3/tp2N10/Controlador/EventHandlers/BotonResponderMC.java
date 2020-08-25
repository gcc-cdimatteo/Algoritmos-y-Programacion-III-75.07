package edu.fiuba.algo3.tp2N10.Controlador.EventHandlers;

import edu.fiuba.algo3.tp2N10.Controlador.Alertas.AlertaSeleccionarUnaOpcion;
import edu.fiuba.algo3.tp2N10.Modelo.AlgoKahoot.AlgoKahoot;
import edu.fiuba.algo3.tp2N10.Modelo.Respuesta.RespuestaMultipleChoice;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.CheckBox;
import javafx.scene.media.Media;
import javafx.scene.media.MediaException;
import javafx.scene.media.MediaPlayer;

import java.io.File;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;
import java.util.Timer;
import java.util.concurrent.atomic.AtomicBoolean;

public class BotonResponderMC implements EventHandler<ActionEvent> {

    private final ArrayList<CheckBox> opcionesUsuario;
    private final AlgoKahoot algoKahoot;
    private final Timer temporizador;
    private AtomicBoolean sinTiempo;

    public BotonResponderMC(AlgoKahoot algoKahoot, ArrayList<CheckBox> opcionesUsuario, Timer temporizador, AtomicBoolean sinTiempo){
        this.algoKahoot = algoKahoot;
        this.opcionesUsuario = opcionesUsuario;
        this.temporizador = temporizador;
        this.sinTiempo = sinTiempo;
    }

    public void handle(ActionEvent actionEvent) {
        Set<Integer> respuestas = new HashSet<>();
        for (int i = 0; i < this.opcionesUsuario.size(); i++){
            if(this.opcionesUsuario.get(i).isSelected()){
                respuestas.add(i);
            }
        }
        if(sinTiempo.get() && respuestas.size() == 0){
            temporizador.cancel();
            try {
                MediaPlayer reproductor = new MediaPlayer(new Media(new File("./resources/audio/sinrespuesta.mp3").toURI().toString()));
                reproductor.setVolume(0.6);
                reproductor.play();
            } catch (MediaException ignored) {}
            this.algoKahoot.jugadorNoResponde();
        }
        else if(respuestas.size() == 0){
            AlertaSeleccionarUnaOpcion alertaSeleccionarUnaOpcion = new AlertaSeleccionarUnaOpcion();
            alertaSeleccionarUnaOpcion.mostrar();
        }
        else {
            temporizador.cancel();
            try {
                MediaPlayer reproductor = new MediaPlayer(new Media(new File("./resources/audio/click.mp3").toURI().toString()));
                reproductor.setVolume(0.6);
                reproductor.play();
            } catch (MediaException ignored) {}
            this.algoKahoot.cargarRespuesta(new RespuestaMultipleChoice(respuestas));
        }
    }
}
