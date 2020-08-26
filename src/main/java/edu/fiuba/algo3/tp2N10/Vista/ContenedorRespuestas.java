package edu.fiuba.algo3.tp2N10.Vista;

import edu.fiuba.algo3.tp2N10.Controlador.EventHandlers.BotonSiguientePregunta;
import edu.fiuba.algo3.tp2N10.Modelo.AlgoKahoot.AlgoKahoot;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.TextAlignment;

public class ContenedorRespuestas extends BorderPane {

    public ContenedorRespuestas(AlgoKahoot algoKahoot){
        //Barra superior
        BorderPane bpHeader = new BorderPane();
        bpHeader.setStyle("-fx-background-color: cornflowerblue");
        bpHeader.setMinHeight(50);

        //Contenido
        Label labelEnunciadoPregunta = new Label(algoKahoot.preguntaEnunciado());
        labelEnunciadoPregunta.setWrapText(true);
        labelEnunciadoPregunta.setTextAlignment(TextAlignment.CENTER);
        labelEnunciadoPregunta.setFont(Font.font("Tahoma", FontWeight.BOLD, 40));

        Label labelRespuesta = new Label("Respuesta correcta");
        labelRespuesta.setFont(Font.font("Tahoma", 30));

        Label labelCorrecta = new Label(algoKahoot.respuestaCorrecta());
        labelCorrecta.setTextAlignment(TextAlignment.CENTER);
        labelCorrecta.setFont(Font.font("Tahoma", 30));

        VBox vbRespuesta = new VBox(labelEnunciadoPregunta, labelRespuesta, labelCorrecta);
        vbRespuesta.setAlignment(Pos.CENTER);
        vbRespuesta.setSpacing(100);

        //Barra Inferior
        Button botonContinuar = new Button();
        botonContinuar.setText("Continuar");
        botonContinuar.setOnAction(new BotonSiguientePregunta(algoKahoot));

        BorderPane bpContinuar = new BorderPane();
        bpContinuar.setStyle("-fx-background-color: cornflowerblue");
        bpContinuar.setMinHeight(50);
        bpContinuar.setCenter(botonContinuar);

        //Posiciones
        setTop(bpHeader);
        setCenter(vbRespuesta);
        setBottom(bpContinuar);
    }
}
