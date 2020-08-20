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

        this.setTop(bpHeader);

        BorderPane bpRegistro = new BorderPane();
        bpRegistro.setPadding(new Insets(100, 100, 100, 100));
        VBox vboxJugadores = new VBox(10);


        TextField nombreUno = new TextField();
        HBox hboxNombre1 = new HBox(10);
        hboxNombre1.getChildren().addAll(new Label("Jugador 1: "), nombreUno);

        TextField nombreDos = new TextField();
        HBox hboxNombre2 = new HBox(10);
        hboxNombre1.getChildren().addAll(new Label("Jugador 2: "), nombreDos);


        vboxJugadores.getChildren().addAll(hboxNombre1, hboxNombre2);
        bpRegistro.setCenter(vboxJugadores);

        this.setCenter(bpRegistro);

        // botonera Empezar a Jugar
        Button btnJugar = new Button("Empezar a Jugar");
        btnJugar.setOnAction(new BotonComenzarJuego(nombreUno, nombreDos, app));
        BorderPane bpBotoneraJugar = new BorderPane();
        bpBotoneraJugar.setStyle("-fx-background-color: cornflowerblue");
        bpBotoneraJugar.setRight(btnJugar);
        this.setBottom(bpBotoneraJugar);
    }
}