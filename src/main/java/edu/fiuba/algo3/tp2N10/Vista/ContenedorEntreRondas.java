package edu.fiuba.algo3.tp2N10.Vista;

import edu.fiuba.algo3.tp2N10.Controlador.EventHandlers.BotonContinuar;
import edu.fiuba.algo3.tp2N10.Modelo.AlgoKahoot.AlgoKahoot;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;

import java.util.List;

public class ContenedorEntreRondas extends BorderPane {

    public ContenedorEntreRondas(AlgoKahoot algoKahoot) {
        super();

        //Barra superior
        Label labelPodio = new Label("Posiciones");
        labelPodio.setFont(Font.font("Tahoma", FontWeight.BOLD, 30));
        labelPodio.setTextFill(Color.rgb(255, 255, 255));

        BorderPane bpHeader = new BorderPane();
        bpHeader.setCenter(labelPodio);
        bpHeader.setStyle("-fx-background-color: cornflowerblue");
        bpHeader.setMinHeight(50);

        //Contenido
        List<String> nombres = algoKahoot.nombres();
        List<Integer> puntajes = algoKahoot.puntajes();

        //Jugador Uno
        Label labelJugadorUno = new Label(String.valueOf(nombres.get(0)));
        labelJugadorUno.setFont(Font.font("Tahoma", 30));
        labelJugadorUno.setMinWidth(300);
        Label labelPuntajeUno = new Label(String.valueOf(puntajes.get(0)));
        labelPuntajeUno.setFont(Font.font("Tahoma", 30));
        labelPuntajeUno.setMinWidth(50);
        labelPuntajeUno.setAlignment(Pos.CENTER_RIGHT);

        //Jugador Dos
        Label labelJugadorDos = new Label(nombres.get(1));
        labelJugadorDos.setFont(Font.font("Tahoma", 30));
        labelJugadorDos.setMinWidth(300);
        Label labelPuntajeDos = new Label(String.valueOf(puntajes.get(1)));
        labelPuntajeDos.setFont(Font.font("Tahoma", 30));
        labelPuntajeDos.setMinWidth(50);
        labelPuntajeDos.setAlignment(Pos.CENTER_RIGHT);

        //Tabla posiciones
        HBox hbPrimero;
        Label labelPrimero = new Label("Primer puesto:");
        labelPrimero.setFont(Font.font("Tahoma", 30));
        labelPrimero.setMinWidth(250);
        labelPrimero.setAlignment(Pos.CENTER_LEFT);

        HBox hbSegundo;
        Label labelSegundo = new Label("Segundo puesto:");
        labelSegundo.setFont(Font.font("Tahoma", 30));
        labelSegundo.setMinWidth(250);
        labelSegundo.setAlignment(Pos.CENTER_LEFT);

        Label labelEmpate = new Label("");
        labelEmpate.setFont(Font.font("Tahoma", 30));
        labelEmpate.setMinWidth(250);
        labelEmpate.setAlignment(Pos.CENTER_LEFT);

        if(puntajes.get(0) > puntajes.get(1)){
            hbPrimero = new HBox(labelPrimero,labelJugadorUno,labelPuntajeUno);
            hbSegundo = new HBox(labelSegundo,labelJugadorDos,labelPuntajeDos);
        }
        else if (puntajes.get(0) < puntajes.get(1)){
            hbPrimero = new HBox(labelPrimero,labelJugadorDos,labelPuntajeDos);
            hbSegundo = new HBox(labelSegundo,labelJugadorUno,labelPuntajeUno);
        }
        else {
            hbPrimero = new HBox(labelPrimero,labelJugadorUno,labelPuntajeUno);
            hbSegundo = new HBox(labelEmpate,labelJugadorDos,labelPuntajeDos);
        }

        hbPrimero.setAlignment(Pos.CENTER);
        hbPrimero.setSpacing(50);
        hbSegundo.setAlignment(Pos.CENTER);
        hbSegundo.setSpacing(50);

        VBox vbPosiciones = new VBox(hbPrimero,hbSegundo);
        vbPosiciones.setAlignment(Pos.CENTER);
        vbPosiciones.setSpacing(30);

        //Barra Inferior
        Button botonContinuar = new Button();
        botonContinuar.setText("Continuar");
        botonContinuar.setOnAction(new BotonContinuar(algoKahoot));

        BorderPane bpBotoneraListo = new BorderPane();
        bpBotoneraListo.setStyle("-fx-background-color: cornflowerblue");
        bpBotoneraListo.setMinHeight(50);
        bpBotoneraListo.setCenter(botonContinuar);

        //Posiciones
        setTop(bpHeader);
        setCenter(vbPosiciones);
        setBottom(bpBotoneraListo);

    }
}


