package edu.fiuba.algo3.tp2N10.Controlador.EventHandlers;

import edu.fiuba.algo3.tp2N10.Modelo.AlgoKahoot.AlgoKahoot;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.media.Media;
import javafx.scene.media.MediaException;
import javafx.scene.media.MediaPlayer;

import java.io.File;

public class BotonContinuar implements EventHandler<ActionEvent> {

    private final AlgoKahoot algoKahoot;

    public BotonContinuar(AlgoKahoot algoKahoot) {
        this.algoKahoot = algoKahoot;
    }

    @Override
    public void handle(ActionEvent actionEvent) {
        try {
            MediaPlayer reproductor = new MediaPlayer(new Media(new File("./resources/audio/click.mp3").toURI().toString()));
            reproductor.setVolume(0.6);
            reproductor.play();
        } catch (MediaException ignored) {}
        this.algoKahoot.notifyObservers();
    }
}