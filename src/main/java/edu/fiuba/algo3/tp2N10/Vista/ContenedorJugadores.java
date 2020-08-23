package edu.fiuba.algo3.tp2N10.Vista;

import edu.fiuba.algo3.tp2N10.Controlador.EventHandlers.BotonComenzarJuego;
import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

public class ContenedorJugadores extends BorderPane {

    public ContenedorJugadores(App app) {
        super();

        Label lblRegistroJugadores = new Label("Registro de Jugadores");
        lblRegistroJugadores.setStyle("-fx-font-size: 200%");

        BorderPane bpHeader = new BorderPane();
        bpHeader.setCenter(lblRegistroJugadores);
        bpHeader.setStyle("-fx-background-color: cornflowerblue");

        setTop(bpHeader);

        BorderPane bpRegistro = new BorderPane();
        bpRegistro.setPadding(new Insets(200, 200, 200, 200));

        TextField nombreUno = new TextField();
        TextField nombreDos = new TextField();
        HBox hboxNombres = new HBox(100);
        Label lblJugador1 = new Label("Jugador 1: ");
        lblJugador1.setStyle("-fx-font-size: 200%");
        Label lblJugador2 = new Label("Jugador 2: ");
        lblJugador2.setStyle("-fx-font-size: 200%");
        hboxNombres.getChildren().addAll(lblJugador1, nombreUno,
                lblJugador2, nombreDos);
        bpRegistro.setCenter(hboxNombres);
        setCenter(bpRegistro);

        // botonera Empezar a Jugar
        Button btnJugar = new Button("Empezar a Jugar");
        btnJugar.setOnAction(new BotonComenzarJuego(nombreUno, nombreDos, app));
        BorderPane bpBotoneraJugar = new BorderPane();
        bpBotoneraJugar.setStyle("-fx-background-color: cornflowerblue");
        bpBotoneraJugar.setRight(btnJugar);
        this.setBottom(bpBotoneraJugar);
    }
}