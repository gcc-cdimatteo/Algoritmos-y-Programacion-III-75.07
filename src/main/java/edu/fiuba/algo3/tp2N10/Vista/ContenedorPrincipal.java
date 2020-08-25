package edu.fiuba.algo3.tp2N10.Vista;

import edu.fiuba.algo3.tp2N10.Controlador.EventHandlers.BotonUsarExclusividad;
import edu.fiuba.algo3.tp2N10.Controlador.EventHandlers.BotonUsarMultiplicador;
import edu.fiuba.algo3.tp2N10.Modelo.AlgoKahoot.AlgoKahoot;
import javafx.application.Platform;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.*;
import javafx.scene.media.Media;
import javafx.scene.media.MediaException;
import javafx.scene.media.MediaPlayer;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;

import java.io.File;
import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.atomic.AtomicBoolean;

public class ContenedorPrincipal extends BorderPane {

    public ContenedorPrincipal(AlgoKahoot algoKahoot, Timer temporizador) {
        super();

        Label lblJugador = new Label("  Jugador: " + algoKahoot.jugadorNombre());
        lblJugador.setStyle("-fx-font-size: 200%");
        lblJugador.setTextFill(Color.rgb(255, 255, 255));
        Label lblPuntaje = new Label("Puntaje: " + algoKahoot.jugadorPuntaje() + "  ");
        lblPuntaje.setStyle("-fx-font-size: 200%");
        lblPuntaje.setTextFill(Color.rgb(255, 255, 255));
        Label lblEnunciado = new Label(algoKahoot.preguntaEnunciado());
        lblEnunciado.setStyle("-fx-font-size: 250%");

        BorderPane bpPreguntaPowerUps = new BorderPane();
        bpPreguntaPowerUps.setPadding(new Insets(10, 10, 10, 10));
        VBox vboxEnunciadoOpciones = new VBox(100);
        vboxEnunciadoOpciones.getChildren().add(lblEnunciado);

        VBox vboxPowerUps = new VBox(20);
        Label lblPowerUps = new Label("Power Ups");
        lblPowerUps.setStyle("-fx-font-size: 150%");
        vboxPowerUps.setPadding(new Insets(10,10,10,10));
        vboxPowerUps.setBorder(new Border(new BorderStroke(Color.CORNFLOWERBLUE,
                BorderStrokeStyle.SOLID, CornerRadii.EMPTY, BorderWidths.DEFAULT)));
        vboxPowerUps.getChildren().add(lblPowerUps);

        if (algoKahoot.permiteMultiplicadores()) {
            Button botonMultiplicador = new Button("x1");
            BotonUsarMultiplicador handler = new BotonUsarMultiplicador(algoKahoot, botonMultiplicador);
            if (algoKahoot.multiplicadorDisponible(2)) {
                handler.add(2);
            }
            if (algoKahoot.multiplicadorDisponible(3)) {
                handler.add(3);
            }
            botonMultiplicador.setOnAction(handler);
            vboxPowerUps.getChildren().add(botonMultiplicador);

        } else if (algoKahoot.permiteExclusividad()) {
            Button botonExclusividad = new Button("Exclusividad");
            botonExclusividad.setOnAction(new BotonUsarExclusividad(algoKahoot, botonExclusividad));
            vboxPowerUps.getChildren().add(botonExclusividad);
        }

        Button btnListo = new Button("Listo");
        btnListo.setAlignment(Pos.CENTER);
        BorderPane bpHeader = new BorderPane();
        bpHeader.setLeft(lblJugador);
        bpHeader.setRight(lblPuntaje);
        bpHeader.setStyle("-fx-background-color: cornflowerblue");
        bpHeader.setMinHeight(50);

        AtomicBoolean sinTiempo = new AtomicBoolean(false);
        switch (algoKahoot.preguntaActual()) {
            case ("Verdadero Falso Clasico"):
            case ("Verdadero Falso Penalidad"):
                vboxEnunciadoOpciones.getChildren().add(new ContenedorPreguntaVF(btnListo, algoKahoot, temporizador, sinTiempo));
                break;
            case ("Multiple Choice Clasico"):
            case ("Multiple Choice Parcial"):
            case ("Multiple Choice Penalidad"):
                vboxEnunciadoOpciones.getChildren().add(new ContenedorPreguntaMC(btnListo, algoKahoot, temporizador, sinTiempo));
                break;
            case ("Ordered Choice"):
                vboxEnunciadoOpciones.getChildren().add(new ContenedorPreguntaOC(btnListo, algoKahoot, temporizador, sinTiempo));
                break;
            case ("Group Choice"):
                vboxEnunciadoOpciones.getChildren().add(new ContenedorPreguntaGC(btnListo, algoKahoot, temporizador, sinTiempo));
                break;
        }

        bpPreguntaPowerUps.setLeft(vboxEnunciadoOpciones);
        bpPreguntaPowerUps.setRight(vboxPowerUps);

        setTop(bpHeader);
        setCenter(bpPreguntaPowerUps);
        BorderPane bpBotoneraListo = new BorderPane();
        bpBotoneraListo.setStyle("-fx-background-color: cornflowerblue");
        bpBotoneraListo.setCenter(btnListo);
        bpBotoneraListo.setMinHeight(50);
        setBottom(bpBotoneraListo);

        //Temporizador
        Label labelTemporizador = new Label("31");
        labelTemporizador.setFont(Font.font("Tahoma", FontWeight.BOLD, 30));
        labelTemporizador.setTextFill(Color.rgb(255, 255, 255));
        bpHeader.setCenter(labelTemporizador);

        TimerTask task = new TimerTask() {
            @Override
            public void run() {
                Platform.runLater(() -> {
                    int contador = Integer.parseInt(labelTemporizador.getText()) - 1;
                    labelTemporizador.setText(Integer.toString(contador));
                    if (contador <= 5 && contador > 0) {
                        labelTemporizador.setTextFill(Color.web("#ff0000"));
                    } else if (contador == 0) {
                        sinTiempo.set(true);
                        btnListo.fire();
                    }
                });
            }
        };
        temporizador.schedule(task, 0, 1000L);
    }
}