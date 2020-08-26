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
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.TextAlignment;

import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.atomic.AtomicBoolean;

public class ContenedorPrincipal extends BorderPane {

    public ContenedorPrincipal(AlgoKahoot algoKahoot, Timer temporizador) {
        super();

        Label labelJugador = new Label("  Jugador: " + algoKahoot.jugadorNombre());
        labelJugador.setStyle("-fx-font-size: 200%");
        labelJugador.setTextFill(Color.rgb(255, 255, 255));
        Label labelPuntaje = new Label("Puntaje: " + algoKahoot.jugadorPuntaje() + "  ");
        labelPuntaje.setStyle("-fx-font-size: 200%");
        labelPuntaje.setTextFill(Color.rgb(255, 255, 255));
        Label labelEnunciado = new Label(algoKahoot.preguntaEnunciado());
        labelEnunciado.setWrapText(true);
        labelEnunciado.setStyle("-fx-font-size: 250%");
        labelEnunciado.setTextAlignment(TextAlignment.CENTER);

        BorderPane bpPreguntaPowerUps = new BorderPane();
        bpPreguntaPowerUps.setPadding(new Insets(10, 10, 10, 10));
        VBox vboxEnunciadoOpciones = new VBox(100);
        vboxEnunciadoOpciones.getChildren().add(labelEnunciado);

        VBox vboxPowerUps = new VBox(20);
        Label labelPowerUps = new Label("Power Ups");
        labelPowerUps.setStyle("-fx-font-size: 150%");
        vboxPowerUps.setPadding(new Insets(10,10,10,10));
        vboxPowerUps.setBorder(new Border(new BorderStroke(Color.CORNFLOWERBLUE,
                BorderStrokeStyle.SOLID, CornerRadii.EMPTY, BorderWidths.DEFAULT)));
        vboxPowerUps.getChildren().add(labelPowerUps);

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
        bpHeader.setLeft(labelJugador);
        bpHeader.setRight(labelPuntaje);
        bpHeader.setStyle("-fx-background-color: cornflowerblue");
        bpHeader.setMinHeight(50);

        AtomicBoolean sinTiempo = new AtomicBoolean(false);
        Pane contenedor;
        switch (algoKahoot.preguntaActual()) {
            case ("Verdadero Falso Clasico"):
            case ("Verdadero Falso Penalidad"):
                contenedor = new ContenedorPreguntaVF(btnListo, algoKahoot, temporizador, sinTiempo);
                break;
            case ("Multiple Choice Clasico"):
            case ("Multiple Choice Parcial"):
            case ("Multiple Choice Penalidad"):
                contenedor = new ContenedorPreguntaMC(btnListo, algoKahoot, temporizador, sinTiempo);
                break;
            case ("Ordered Choice"):
                contenedor = new ContenedorPreguntaOC(btnListo, algoKahoot, temporizador, sinTiempo);
                break;
            case ("Group Choice"):
                contenedor = new ContenedorPreguntaGC(btnListo, algoKahoot, temporizador, sinTiempo);
                break;
            default:
                throw new IllegalStateException("Unexpected value: " + algoKahoot.preguntaActual());
        }

        vboxEnunciadoOpciones.getChildren().add(contenedor);
        bpPreguntaPowerUps.setLeft(vboxEnunciadoOpciones);
        bpPreguntaPowerUps.setRight(vboxPowerUps);
        vboxEnunciadoOpciones.maxWidthProperty().bind(bpPreguntaPowerUps.widthProperty().subtract(200));
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