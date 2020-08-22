package edu.fiuba.algo3.tp2N10.Vista;

import edu.fiuba.algo3.tp2N10.Controlador.EventHandlers.BotonUsarExclusividad;
import edu.fiuba.algo3.tp2N10.Controlador.EventHandlers.BotonUsarMultiplicador;
import edu.fiuba.algo3.tp2N10.Modelo.AlgoKahoot.AlgoKahoot;
import javafx.application.Platform;
import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import javafx.scene.media.Media;
import javafx.scene.media.MediaException;
import javafx.scene.media.MediaPlayer;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

import java.io.File;
import java.util.Timer;
import java.util.TimerTask;

public class ContenedorPrincipal extends BorderPane {

    public ContenedorPrincipal(AlgoKahoot algoKahoot) {
        super();

        Timer temporizador = new Timer();

        Label lblJugador = new Label("  Jugador: " + algoKahoot.jugadorNombre());
        lblJugador.setStyle("-fx-font-size: 200%");
        Label lblPuntaje = new Label("Puntaje: " + algoKahoot.jugadorPuntaje() + "  ");
        lblPuntaje.setStyle("-fx-font-size: 200%");
        Label lblEnunciado = new Label(algoKahoot.preguntaEnunciado());

        BorderPane bpPreguntaPowerUps = new BorderPane();
        bpPreguntaPowerUps.setPadding(new Insets(10, 10, 10, 10));
        VBox vboxEnunciadoOpciones = new VBox(100);
        vboxEnunciadoOpciones.getChildren().add(lblEnunciado);

        VBox vboxPowerUps = new VBox(5);
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
        BorderPane bpHeader = new BorderPane();
        bpHeader.setLeft(lblJugador);
        bpHeader.setRight(lblPuntaje);
        bpHeader.setStyle("-fx-background-color: cornflowerblue");

        switch (algoKahoot.preguntaActual()) {
            case ("VerdaderoFalsoClasico") :
            case ("VerdaderoFalsoPenalidad") :
                vboxEnunciadoOpciones.getChildren().add(new ContenedorPreguntaVF(btnListo, algoKahoot, temporizador));
                break;
            case ("MultipleChoiceClasico") :
            case ("MultipleChoiceParcial") :
            case ("MultipleChoicePenalidad") :
                vboxEnunciadoOpciones.getChildren().add(new ContenedorPreguntaMC(btnListo, algoKahoot, temporizador));
                break;
            case ("OrderedChoice") :
                vboxEnunciadoOpciones.getChildren().add(new ContenedorPreguntaOC(btnListo, algoKahoot, temporizador));
                break;
            case ("GroupChoice") :
                vboxEnunciadoOpciones.getChildren().add(new ContenedorPreguntaGC(btnListo, algoKahoot, temporizador));
                break;
        }

        bpPreguntaPowerUps.setLeft(vboxEnunciadoOpciones);
        bpPreguntaPowerUps.setRight(vboxPowerUps);

        setPadding(new Insets(10, 10, 10, 10));
        setTop(bpHeader);
        setCenter(bpPreguntaPowerUps);
        BorderPane bpBotoneraListo = new BorderPane();
        bpBotoneraListo.setStyle("-fx-background-color: cornflowerblue");
        bpBotoneraListo.setRight(btnListo);
        setBottom(bpBotoneraListo);

        Label labelTemporizador = new Label("16");
        labelTemporizador.setStyle("-fx-font-size: 200%");
        bpHeader.setCenter(labelTemporizador);

        TimerTask task = new TimerTask(){
            @Override
            public void run() {
            Platform.runLater(() -> {
                int contador = Integer.parseInt(labelTemporizador.getText()) - 1;
                labelTemporizador.setText(Integer.toString(contador));
                if(contador <= 5 && contador > 0){
                    labelTemporizador.setTextFill(Color.web("#ff0000"));
                }else if(contador == 0) {
                    try {
                        MediaPlayer reproductor = new MediaPlayer(new Media(new File("./resources/audio/sinrespuesta.mp3").toURI().toString()));
                        if (reproductor != null ) reproductor.play();
                        } catch ( MediaException ignored) {}
                    algoKahoot.jugadorNoResponde();
                    temporizador.cancel();
                }
            });
         }
        };
        temporizador.schedule(task, 0, 1000L);
    }
}