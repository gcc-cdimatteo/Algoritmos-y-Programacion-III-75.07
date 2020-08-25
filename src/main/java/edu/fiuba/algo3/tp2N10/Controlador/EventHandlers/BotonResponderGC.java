package edu.fiuba.algo3.tp2N10.Controlador.EventHandlers;

import edu.fiuba.algo3.tp2N10.Modelo.AlgoKahoot.AlgoKahoot;
import edu.fiuba.algo3.tp2N10.Modelo.Respuesta.RespuestaGroupChoice;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Toggle;
import javafx.scene.control.ToggleGroup;
import javafx.scene.media.Media;
import javafx.scene.media.MediaException;
import javafx.scene.media.MediaPlayer;

import java.io.File;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;
import java.util.Timer;
import java.util.concurrent.atomic.AtomicBoolean;

public class BotonResponderGC implements EventHandler<ActionEvent> {

    private final ArrayList<ToggleGroup> opcionesUsuario;
    private final AlgoKahoot algoKahoot;
    private final Timer temporizador;
    private AtomicBoolean sinTiempo;

    public BotonResponderGC(AlgoKahoot algoKahoot, ArrayList<ToggleGroup> opcionesUsuario, Timer temporizador, AtomicBoolean sinTiempo) {
        this.algoKahoot = algoKahoot;
        this.opcionesUsuario = opcionesUsuario;
        this.temporizador = temporizador;
        this.sinTiempo = sinTiempo;
    }

    public void handle(ActionEvent actionEvent) {
        Set<Integer> grupoA = new HashSet<>();
        Set<Integer> grupoB = new HashSet<>();
        for(int i = 0; i < opcionesUsuario.size(); i++){
            ObservableList<Toggle> botones = opcionesUsuario.get(i).getToggles();
            if ((botones.get(0).isSelected())) {
                grupoA.add(i);
            } else {
                grupoB.add(i);
            }
        }
        this.temporizador.cancel();
        try {
            MediaPlayer reproductor = new MediaPlayer(new Media(new File("./resources/audio/click.mp3").toURI().toString()));
            reproductor.setVolume(0.6);
            reproductor.play();
        } catch (MediaException ignored) {}
        this.algoKahoot.cargarRespuesta(new RespuestaGroupChoice(grupoA, grupoB));
    }
}