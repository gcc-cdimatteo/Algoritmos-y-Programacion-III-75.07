package edu.fiuba.algo3.tp2N10.Vista;

import edu.fiuba.algo3.tp2N10.Controlador.EventHandlers.BotonContinuar;
import edu.fiuba.algo3.tp2N10.Modelo.AlgoKahoot.AlgoKahoot;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
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
        Label labelJugadorUno = armarLabel(nombres.get(0), 300, Pos.CENTER_LEFT);
        Label labelPuntajeUno = armarLabel(String.valueOf(puntajes.get(0)), 40, Pos.CENTER_RIGHT);

        HBox hBoxJugadorUno = new HBox(labelJugadorUno,labelPuntajeUno);
        hBoxJugadorUno.setAlignment(Pos.CENTER);
        hBoxJugadorUno.setSpacing(50);

        //Jugador Dos
        Label labelJugadorDos = armarLabel(nombres.get(1), 300, Pos.CENTER_LEFT);
        Label labelPuntajeDos = armarLabel(String.valueOf(puntajes.get(1)), 40, Pos.CENTER_RIGHT);

        HBox hBoxJugadorDos = new HBox(labelJugadorDos,labelPuntajeDos);
        hBoxJugadorDos.setAlignment(Pos.CENTER);
        hBoxJugadorDos.setSpacing(50);

        VBox vBoxJugadores;
        if (puntajes.get(1) > puntajes.get(0)) vBoxJugadores = new VBox(hBoxJugadorDos, hBoxJugadorUno);
        else vBoxJugadores = new VBox(hBoxJugadorUno, hBoxJugadorDos);
        vBoxJugadores.setAlignment(Pos.CENTER);
        vBoxJugadores.setSpacing(30);

        Node panePuestos;
        if (puntajes.get(1).equals(puntajes.get(0))) {
            panePuestos = armarLabel("Empate:", 250, Pos.CENTER_LEFT);
        } else {
            Label labelPrimero = armarLabel("Primer puesto:", 300, Pos.CENTER_RIGHT);
            Label labelSegundo = armarLabel("Segundo puesto:", 300, Pos.CENTER_RIGHT);

            VBox vBoxPuestos = new VBox(labelPrimero, labelSegundo);
            vBoxPuestos.setAlignment(Pos.CENTER);
            vBoxPuestos.setSpacing(30);
            panePuestos = vBoxPuestos;
        }

        HBox hBoxPosiciones = new HBox(panePuestos, vBoxJugadores);
        hBoxPosiciones.setAlignment(Pos.CENTER);

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
        setCenter(hBoxPosiciones);
        setBottom(bpBotoneraListo);
    }

    private Label armarLabel(String s, int prefWidth, Pos alignment) {
        Label label = new Label(s);
        label.setFont(Font.font("Tahoma", 30));
        label.setPrefWidth(prefWidth);
        label.setAlignment(alignment);
        return label;
    }
}


