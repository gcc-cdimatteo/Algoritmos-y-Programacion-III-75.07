package edu.fiuba.algo3.tp2N10.Vista;

import edu.fiuba.algo3.tp2N10.Controlador.BotonComenzarJuego;
import edu.fiuba.algo3.tp2N10.Modelo.AlgoKahoot.Jugador;
import edu.fiuba.algo3.tp2N10.Modelo.AlgoKahoot.Ronda;
import edu.fiuba.algo3.tp2N10.Modelo.Pregunta.Pregunta;
import edu.fiuba.algo3.tp2N10.Modelo.Pregunta.PreguntaMultipleChoice;
import edu.fiuba.algo3.tp2N10.Modelo.Pregunta.PreguntaVerdaderoFalso;
import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;

public class ContenedorPregunta extends BorderPane {

    public ContenedorPregunta(App app, Pregunta pregunta, Jugador jugador, Ronda ronda) {
        super();

        Label lblJugador = new Label("  Jugador: " + jugador.nombre());
        lblJugador.setStyle("-fx-font-size: 200%");
        Label lblPuntaje = new Label("Puntaje: " + jugador.puntaje() + "  ");
        lblPuntaje.setStyle("-fx-font-size: 200%");
        Label lblEnunciado = new Label(pregunta.getEnunciado());

        BorderPane bpPreguntaPowerUps = new BorderPane();
        bpPreguntaPowerUps.setPadding(new Insets(10, 10, 10, 10));
        VBox vboxEnunciadoOpciones = new VBox(100);
        vboxEnunciadoOpciones.getChildren().add(lblEnunciado);

        Button btnPowerUpX2 = new Button("x2");
        Button btnPowerUpX3 = new Button("x3");
        Button btnPowerUpEx1 = new Button("Exclusividad");
        Button btnPowerUpEx2 = new Button("Exclusividad");
        Button btnListo = new Button("Listo");

        BorderPane bpHeader = new BorderPane();
        bpHeader.setLeft(lblJugador);
        bpHeader.setRight(lblPuntaje);
        bpHeader.setStyle("-fx-background-color: cornflowerblue");

        if (pregunta.getClass() == PreguntaMultipleChoice.class) {
            vboxEnunciadoOpciones.getChildren().add(new ContenedorPreguntaMC(pregunta, btnListo, ronda));
        } else if (pregunta.getClass() == PreguntaVerdaderoFalso.class) {
            vboxEnunciadoOpciones.getChildren().add(new ContenedorPreguntaVF(btnListo, ronda));
        }

        VBox vboxPowerUps = new VBox(5);
        vboxPowerUps.getChildren().addAll(btnPowerUpX2, btnPowerUpX3, btnPowerUpEx1, btnPowerUpEx2);
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