package edu.fiuba.algo3.tp2N10.Vista;

import edu.fiuba.algo3.tp2N10.Controlador.BotonUsarExclusividad;
import edu.fiuba.algo3.tp2N10.Controlador.BotonUsarMultiplicador;
import edu.fiuba.algo3.tp2N10.Modelo.AlgoKahoot.AlgoKahoot;
import edu.fiuba.algo3.tp2N10.Modelo.Pregunta.*;
import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ToggleButton;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;

public class ContenedorPrincipal extends BorderPane {

    private final AlgoKahoot algoKahoot;

    public ContenedorPrincipal(AlgoKahoot algoKahoot) {
        super();
        this.algoKahoot = algoKahoot;

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
            ToggleGroup grupoMultiplicadores = new ToggleGroup();
            if (algoKahoot.multiplicadorDisponible(2)) {
                agregarBotonMultiplicador(vboxPowerUps, grupoMultiplicadores, 2);
            }
            if (algoKahoot.multiplicadorDisponible(3)) {
                agregarBotonMultiplicador(vboxPowerUps, grupoMultiplicadores, 3);
            }
        } else if (algoKahoot.permiteExclusividad()) {
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

    private void agregarBotonMultiplicador(VBox vBox, ToggleGroup toggles, Integer valor) {
        ToggleButton btnMultiplicador = new ToggleButton("x" + valor.toString());
        btnMultiplicador.setOnAction(new BotonUsarMultiplicador(algoKahoot, valor));
        toggles.getToggles().add(btnMultiplicador);
        vBox.getChildren().add(btnMultiplicador);

    }
}