package edu.fiuba.algo3.tp2N10.Vista;

import edu.fiuba.algo3.tp2N10.Controlador.BotonComenzarJuego;
import edu.fiuba.algo3.tp2N10.Controlador.BotonUsarExclusividad;
import edu.fiuba.algo3.tp2N10.Controlador.BotonUsarMultiplicador;
import edu.fiuba.algo3.tp2N10.Modelo.AlgoKahoot.AlgoKahoot;
import edu.fiuba.algo3.tp2N10.Modelo.AlgoKahoot.Jugador;
import edu.fiuba.algo3.tp2N10.Modelo.AlgoKahoot.Ronda;
import edu.fiuba.algo3.tp2N10.Modelo.Pregunta.*;
import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ToggleButton;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;

public class ContenedorPrincipal extends BorderPane {

    public ContenedorPrincipal(AlgoKahoot algoKahoot) {
        super();

        Label lblJugador = new Label("  Jugador: " + algoKahoot.jugadorActualNombre());
        lblJugador.setStyle("-fx-font-size: 200%");
        Label lblPuntaje = new Label("Puntaje: " + algoKahoot.jugadorActualPuntaje() + "  ");
        lblPuntaje.setStyle("-fx-font-size: 200%");
        Label lblEnunciado = new Label(algoKahoot.preguntaActualEnunciado());

        BorderPane bpPreguntaPowerUps = new BorderPane();
        bpPreguntaPowerUps.setPadding(new Insets(10, 10, 10, 10));
        VBox vboxEnunciadoOpciones = new VBox(100);
        vboxEnunciadoOpciones.getChildren().add(lblEnunciado);

        VBox vboxPowerUps = new VBox(5);
        if (algoKahoot.preguntaActualPermiteMultiplicadores()) {
            ToggleButton btnPowerUpX2 = new ToggleButton("x2");
            btnPowerUpX2.setOnAction(new BotonUsarMultiplicador(algoKahoot, 2));
            ToggleButton btnPowerUpX3 = new ToggleButton("x3");
            btnPowerUpX3.setOnAction(new BotonUsarMultiplicador(algoKahoot, 3));
            ToggleGroup grupoMultiplicadores = new ToggleGroup();
            grupoMultiplicadores.getToggles().addAll(btnPowerUpX2, btnPowerUpX3);
            vboxPowerUps.getChildren().addAll(btnPowerUpX2, btnPowerUpX3);
        } else if (algoKahoot.preguntaActualPermiteExclusividad()) {
            Button btnPowerUpEx1 = new Button("Exclusividad");
            btnPowerUpEx1.setOnAction(new BotonUsarExclusividad(algoKahoot));
            vboxPowerUps.getChildren().addAll(btnPowerUpEx1);
        }

        Button btnListo = new Button("Listo");
        BorderPane bpHeader = new BorderPane();
        bpHeader.setLeft(lblJugador);
        bpHeader.setRight(lblPuntaje);
        bpHeader.setStyle("-fx-background-color: cornflowerblue");

        Object miPregunta = algoKahoot.preguntaActual().getClass();
        if (PreguntaVerdaderoFalso.class.equals(miPregunta)) {
            vboxEnunciadoOpciones.getChildren().add(new ContenedorPreguntaVF(btnListo, algoKahoot));
        } else if (PreguntaMultipleChoice.class.equals(miPregunta)) {
            vboxEnunciadoOpciones.getChildren().add(new ContenedorPreguntaMC(btnListo, algoKahoot));
        } else if (PreguntaOrderedChoice.class.equals(miPregunta)) {
            vboxEnunciadoOpciones.getChildren().add(new ContenedorPreguntaOC(btnListo, algoKahoot));
        } else if (PreguntaGroupChoice.class.equals(miPregunta)) {
            vboxEnunciadoOpciones.getChildren().add(new ContenedorPreguntaGC(btnListo, algoKahoot));
        }

        bpPreguntaPowerUps.setLeft(vboxEnunciadoOpciones);
        bpPreguntaPowerUps.setRight(vboxPowerUps);

        this.setPadding(new Insets(10, 10, 10, 10));
        this.setTop(bpHeader);
        this.setCenter(bpPreguntaPowerUps);
        BorderPane bpBotoneraListo = new BorderPane();
        bpBotoneraListo.setStyle("-fx-background-color: cornflowerblue");
        bpBotoneraListo.setRight(btnListo);
        this.setBottom(bpBotoneraListo);
    }
}