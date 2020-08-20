package edu.fiuba.algo3.tp2N10.Vista;

import edu.fiuba.algo3.tp2N10.Controlador.EventHandlers.BotonContinuar;
import edu.fiuba.algo3.tp2N10.Modelo.AlgoKahoot.AlgoKahoot;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;

public class ContenedorPregunta extends BorderPane {


    public ContenedorPregunta(AlgoKahoot algoKahoot){

        BorderPane bpHeader = new BorderPane();
        bpHeader.setStyle("-fx-background-color: cornflowerblue");

        BorderPane bpPregunta = new BorderPane();
        Label tipoPregunta = new Label(algoKahoot.preguntaActual());
        tipoPregunta.setStyle("-fx-font-size: 200%");
        Label enunciadoPregunta = new Label(algoKahoot.preguntaEnunciado());
        enunciadoPregunta.setStyle("-fx-font-size: 250%");
        bpHeader.setCenter(tipoPregunta);
        bpPregunta.setCenter(enunciadoPregunta);

        BorderPane bpBotoneraListo = new BorderPane();
        bpBotoneraListo.setStyle("-fx-background-color: cornflowerblue");
        Button botonContinuar = new Button();
        botonContinuar.setText("Continuar");
        botonContinuar.setOnAction(new BotonContinuar(algoKahoot));
        bpBotoneraListo.setRight(botonContinuar);


        this.setTop(bpHeader);
        this.setCenter(bpPregunta);
        this.setBottom(bpBotoneraListo);
    }
}
