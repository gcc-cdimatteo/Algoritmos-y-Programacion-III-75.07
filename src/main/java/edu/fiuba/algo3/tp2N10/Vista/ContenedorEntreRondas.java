package edu.fiuba.algo3.tp2N10.Vista;

import edu.fiuba.algo3.tp2N10.Controlador.EventHandlers.BotonContinuar;
import edu.fiuba.algo3.tp2N10.Controlador.EventHandlers.BotonSalir;
import edu.fiuba.algo3.tp2N10.Modelo.AlgoKahoot.AlgoKahoot;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;

import java.util.List;

public class ContenedorEntreRondas extends BorderPane {

    public ContenedorEntreRondas(AlgoKahoot algoKahoot) {
        super();

        List<String> nombres = algoKahoot.nombres();
        List<Integer> puntajes = algoKahoot.puntajes();

        Label lblPodio = new Label("Puntajes intermedios");
        lblPodio.setStyle("-fx-font-size: 200%");

        BorderPane bpHeader = new BorderPane();
        bpHeader.setCenter(lblPodio);
        bpHeader.setStyle("-fx-background-color: cornflowerblue");

        BorderPane bpPodio = new BorderPane();
        bpPodio.setPadding(new Insets(50, 150, 50, 150));
        BorderPane bpJugadorUno = new BorderPane();
        BorderPane bpJugadorDos = new BorderPane();

        String styLabel = "-fx-font-weight: bold; -fx-font-size: 130%";

        int puntosJugadorUno = puntajes.get(0);
        String nombreJugadorUno = nombres.get(0);
        Label lblJugadorUno = new Label(String.valueOf(nombreJugadorUno));
        lblJugadorUno.setStyle(styLabel);
        Label lblPuntajeUno = new Label(String.valueOf(puntosJugadorUno));
        lblPuntajeUno.setStyle(styLabel);

        int puntosJugadorDos = puntajes.get(1);
        String nombreJugadorDos = nombres.get(1);
        Label lblJugadorDos = new Label(nombreJugadorDos);
        lblJugadorDos.setStyle(styLabel);
        Label lblPuntajeDos = new Label(String.valueOf(puntosJugadorDos));
        lblPuntajeDos.setStyle(styLabel);

        int alturaPrimerPodio = 30*puntosJugadorUno;
        int alturaSegundoPodio = 30*puntosJugadorDos;

        Rectangle recJugadorUno = new Rectangle(0, 0, 100, alturaPrimerPodio);
        Rectangle recJugadorDos = new Rectangle(0, 0, 100, alturaSegundoPodio);
        VBox vboxJugadorPuntajeUno = new VBox(10);
        vboxJugadorPuntajeUno.setAlignment(Pos.CENTER);
        vboxJugadorPuntajeUno.getChildren().addAll(lblJugadorUno, lblPuntajeUno);
        bpJugadorUno.setTop(vboxJugadorPuntajeUno);
        bpJugadorUno.setBottom(recJugadorUno);

        VBox vboxJugadorPuntajeDos = new VBox(10);
        vboxJugadorPuntajeDos.setAlignment(Pos.CENTER);
        vboxJugadorPuntajeDos.getChildren().addAll(lblJugadorDos, lblPuntajeDos);
        bpJugadorDos.setTop(vboxJugadorPuntajeDos);
        bpJugadorDos.setBottom(recJugadorDos);

        bpPodio.setLeft(bpJugadorUno);
        bpPodio.setRight(bpJugadorDos);

        BorderPane bpBotoneraListo = new BorderPane();
        bpBotoneraListo.setStyle("-fx-background-color: cornflowerblue");

        Button botonContinuar = new Button();
        botonContinuar.setText("Continuar");
        botonContinuar.setOnAction(new BotonContinuar(algoKahoot));
        bpBotoneraListo.setRight(botonContinuar);

        this.setPadding(new Insets(10, 10, 10, 10));
        this.setTop(bpHeader);
        this.setCenter(bpPodio);
        this.setBottom(bpBotoneraListo);



    }
}


