package edu.fiuba.algo3.tp2N10.Vista;

import edu.fiuba.algo3.tp2N10.Controlador.EventHandlers.BotonComenzarJuego;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;

public class ContenedorJugadores extends BorderPane {

    public ContenedorJugadores(App app) {
        super();
        //Barra superior
        BorderPane bpHeader = new BorderPane();
        bpHeader.setStyle("-fx-background-color: cornflowerblue");
        bpHeader.setMinHeight(50);

        //Contenido
        Label labelRegistroJugadores = new Label("Ingresen sus nombres");
        labelRegistroJugadores.setFont(Font.font("Tahoma", FontWeight.BOLD, 30));

        Label labelJugadorUno = new Label("Jugador 1: ");
        labelJugadorUno.setFont(Font.font("Tahoma", 30));

        Label labelJugadorDos = new Label("Jugador 2: ");
        labelJugadorDos.setFont(Font.font("Tahoma", 30));

        TextField nombreUno = new TextField();
        TextField nombreDos = new TextField();

        HBox hbJugadorUno = new HBox(labelJugadorUno,nombreUno);
        hbJugadorUno.setAlignment(Pos.CENTER);
        hbJugadorUno.setSpacing(50);

        HBox hbJugadorDos = new HBox(labelJugadorDos,nombreDos);
        hbJugadorDos.setAlignment(Pos.CENTER);
        hbJugadorDos.setSpacing(50);

        // Boton
        Button botonJugar = new Button("Empezar a Jugar");
        botonJugar.setOnAction(new BotonComenzarJuego(nombreUno, nombreDos, app));
        botonJugar.setAlignment(Pos.CENTER);

        VBox vbJugadores = new VBox(labelRegistroJugadores,hbJugadorUno,hbJugadorDos,botonJugar);
        vbJugadores.setAlignment(Pos.CENTER);
        vbJugadores.setSpacing(50);

        //Barra inferior
        BorderPane bpFooter = new BorderPane();
        bpFooter.setStyle("-fx-background-color: cornflowerblue");
        bpFooter.setMinHeight(50);

        //Posiciones
        setTop(bpHeader);
        setCenter(vbJugadores);
        setBottom(bpFooter);
    }
}