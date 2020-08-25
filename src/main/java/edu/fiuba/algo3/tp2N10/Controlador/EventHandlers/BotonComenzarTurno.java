package edu.fiuba.algo3.tp2N10.Controlador.EventHandlers;

import edu.fiuba.algo3.tp2N10.Modelo.AlgoKahoot.AlgoKahoot;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.media.Media;
import javafx.scene.media.MediaException;
import javafx.scene.media.MediaPlayer;

import java.io.File;
import java.util.Timer;

public class BotonComenzarTurno implements EventHandler<ActionEvent> {

        private final AlgoKahoot algoKahoot;
        private final Timer temporizador;

        public BotonComenzarTurno(AlgoKahoot algoKahoot, Timer temporizador) {
            this.algoKahoot = algoKahoot;
            this.temporizador = temporizador;
        }

        @Override
        public void handle(ActionEvent actionEvent) {
            try {
                MediaPlayer reproductor = new MediaPlayer(new Media(new File("./resources/audio/comienzaturno.mp3").toURI().toString()));
                reproductor.setVolume(0.3);
                reproductor.play();
            } catch (MediaException ignored) {}
            this.temporizador.cancel();
            this.algoKahoot.notifyObservers();
        }
    }
