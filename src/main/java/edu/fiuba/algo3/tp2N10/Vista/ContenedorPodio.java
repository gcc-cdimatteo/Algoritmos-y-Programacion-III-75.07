package edu.fiuba.algo3.tp2N10.Vista;

import edu.fiuba.algo3.tp2N10.Controlador.BotonSalir;
import edu.fiuba.algo3.tp2N10.Modelo.AlgoKahoot.AlgoKahoot;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import javafx.scene.shape.Rectangle;

public class ContenedorPodio extends BorderPane {

    public ContenedorPodio(AlgoKahoot algoKahoot) {
        super();
        Label lblPodio = new Label("Podio"); // + algoKahoot.jugadorActualNombre());
        lblPodio.setStyle("-fx-font-size: 200%");

        BorderPane bpHeader = new BorderPane();
        bpHeader.setCenter(lblPodio);
        bpHeader.setStyle("-fx-background-color: cornflowerblue");

        //BorderPane bpPreguntaPowerUps = new BorderPane();
        BorderPane bpPodio = new BorderPane();
        bpPodio.setPadding(new Insets(50, 150, 50, 150));
        BorderPane bpJugadorUno = new BorderPane();
        BorderPane bpJugadorDos = new BorderPane();

        String styLabel = "-fx-font-weight: bold; -fx-font-size: 130%";
        int puntosJugadorUno = algoKahoot.jugadorPuntaje();
        Label lblJugadorUno = new Label(algoKahoot.jugadorNombre());
        lblJugadorUno.setStyle(styLabel);
        Label lblPuntajeUno = new Label(String.valueOf(puntosJugadorUno));
        lblPuntajeUno.setStyle(styLabel);

        algoKahoot.cambiarJugador();
        int puntosJugadorDos = algoKahoot.jugadorPuntaje();
        Label lblJugadorDos = new Label(algoKahoot.jugadorNombre());
        lblJugadorDos.setStyle(styLabel);
        Label lblPuntajeDos = new Label(String.valueOf(puntosJugadorDos));
        lblPuntajeDos.setStyle(styLabel);

        // Según quien gane varía la altura del podio
        // Caso default: empate misma altura.
        int alturaPrimerPodio = 200;
        int alturaSegundoPodio = 200;
        if (puntosJugadorDos > puntosJugadorUno)
            alturaPrimerPodio = 100;
        if (puntosJugadorDos < puntosJugadorUno)
            alturaSegundoPodio = 100;

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
        Button btnListo = new Button("Salir");
        btnListo.setOnAction( new BotonSalir());
        bpBotoneraListo.setRight(btnListo);

        this.setPadding(new Insets(10, 10, 10, 10));
        this.setTop(bpHeader);
        this.setCenter(bpPodio);
        this.setBottom(bpBotoneraListo);
    }
}