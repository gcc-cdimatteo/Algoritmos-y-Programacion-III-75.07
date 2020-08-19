package edu.fiuba.algo3.tp2N10.Vista;

import edu.fiuba.algo3.tp2N10.Modelo.AlgoKahoot.AlgoKahoot;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;

public class ContenedorEntreRondas extends BorderPane {


    public ContenedorEntreRondas(AlgoKahoot algoKahoot) {
        super();
        //this.algoKahoot = algoKahoot;

        Label lblPuntajes = new Label("Puntajes");
        lblPuntajes.setStyle("-fx-font-size: 200%");

        BorderPane bpHeader = new BorderPane();
        bpHeader.setCenter(lblPuntajes);
        bpHeader.setStyle("-fx-background-color: cornflowerblue");

        this.setTop(bpHeader);

        Label lblJugador1 = new Label(algoKahoot.jugadorNombre());
        Integer puntaje1 = algoKahoot.jugadorPuntaje();
        Label lblPuntajeJugador1 = new Label(puntaje1.toString());
        lblJugador1.setStyle("-fx-font-size: 100%");
        lblPuntajeJugador1.setStyle("-fx-font-size: 75%");

        BorderPane bpLeft = new BorderPane();
        bpLeft.setTop(lblJugador1);
        bpLeft.setCenter(lblPuntajeJugador1);

        this.setLeft(bpHeader);

        algoKahoot.cambiarJugador();

        Label lblJugador2 = new Label(algoKahoot.jugadorNombre());
        Integer puntaje2 = algoKahoot.jugadorPuntaje();
        Label lblPuntajeJugador2 = new Label(puntaje2.toString());
        lblJugador2.setStyle("-fx-font-size: 100%");
        lblPuntajeJugador2.setStyle("-fx-font-size: 75%");

        BorderPane bpRight = new BorderPane();
        bpRight.setTop(lblJugador1);
        bpRight.setCenter(lblPuntajeJugador1);

        this.setRight(bpRight);

        algoKahoot.cambiarJugador();

    }

}
