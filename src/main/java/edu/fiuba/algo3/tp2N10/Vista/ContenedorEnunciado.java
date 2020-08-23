package edu.fiuba.algo3.tp2N10.Vista;

import edu.fiuba.algo3.tp2N10.Controlador.EventHandlers.BotonContinuar;
import edu.fiuba.algo3.tp2N10.Modelo.AlgoKahoot.AlgoKahoot;
import javafx.application.Platform;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.media.Media;
import javafx.scene.media.MediaException;
import javafx.scene.media.MediaPlayer;
import javafx.scene.paint.Color;

import java.io.File;
import java.util.Timer;
import java.util.TimerTask;

public class ContenedorEnunciado extends BorderPane {


    public ContenedorEnunciado(AlgoKahoot algoKahoot, Timer temporizador){

        BorderPane bpHeader = new BorderPane();
        bpHeader.setStyle("-fx-background-color: cornflowerblue");

        BorderPane bpPregunta = new BorderPane();

        Label tipoPregunta = new Label(algoKahoot.preguntaActual());
        tipoPregunta.setStyle("-fx-font-size: 200%");

        Label enunciadoPregunta = new Label(algoKahoot.preguntaEnunciado());
        enunciadoPregunta.setStyle("-fx-font-size: 250%");

        bpHeader.setCenter(tipoPregunta);
        bpPregunta.setCenter(enunciadoPregunta);

        Button botonContinuar = new Button();
        botonContinuar.setText("Continuar");
        botonContinuar.setOnAction(new BotonContinuar(algoKahoot));

        BorderPane bpContinuar = new BorderPane();
        bpContinuar.setStyle("-fx-background-color: cornflowerblue");
        bpContinuar.setRight(botonContinuar);

        setTop(bpHeader);
        setCenter(bpPregunta);
        setBottom(bpContinuar);

        //Timer
        Label labelTemporizador = new Label("16");
        labelTemporizador.setStyle("-fx-font-size: 200%");
        bpHeader.setCenter(labelTemporizador);

        TimerTask task = new TimerTask() {
            @Override
            public void run() {
                Platform.runLater(() -> {
                    int contador = Integer.parseInt(labelTemporizador.getText()) - 1;
                    labelTemporizador.setText(Integer.toString(contador));
                    if (contador == 0) {
                        try {
                            MediaPlayer reproductor = new MediaPlayer(new Media(new File("./resources/audio/comienzaturno.mp3").toURI().toString()));
                            if (reproductor != null) reproductor.play();
                        } catch (MediaException ignored) {
                        }
                        algoKahoot.notifyObservers();
                        temporizador.cancel();
                    }
                });
            }
        };
        temporizador.schedule(task, 0, 1000L);
    }
}
