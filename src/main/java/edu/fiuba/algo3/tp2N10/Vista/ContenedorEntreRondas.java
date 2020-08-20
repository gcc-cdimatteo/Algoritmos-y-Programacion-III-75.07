package edu.fiuba.algo3.tp2N10.Vista;

import edu.fiuba.algo3.tp2N10.Controlador.EventHandlers.BotonContinuar;
import edu.fiuba.algo3.tp2N10.Modelo.AlgoKahoot.AlgoKahoot;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;

public class ContenedorEntreRondas extends BorderPane {

    public ContenedorEntreRondas(AlgoKahoot algoKahoot) {
        super();


        this.setPadding(new Insets(25));

        Label etiqueta = new Label();
        etiqueta.setFont(Font.font("Tahoma", FontWeight.BOLD, 18));

        etiqueta.setText("Contendor intermedio");
        etiqueta.setTextFill(Color.web("#66A7C5"));



        Button botonContinuar = new Button();
        botonContinuar.setText("Continuar");
        botonContinuar.setOnAction( new BotonContinuar(algoKahoot));

        this.getChildren().addAll(etiqueta, botonContinuar);
}


//    public ContenedorEntreRondas(AlgoKahoot algoKahoot) {
//        super();
//        //this.algoKahoot = algoKahoot;
//
//        Label lblPuntajes = new Label("Puntajes");
//        lblPuntajes.setStyle("-fx-font-size: 200%");
//
//        BorderPane bpHeader = new BorderPane();
//        bpHeader.setCenter(lblPuntajes);
//        bpHeader.setStyle("-fx-background-color: cornflowerblue");
//
//        this.setTop(bpHeader);
//
//        Label lblJugador1 = new Label(algoKahoot.jugadorNombre());
//        int puntaje1 = algoKahoot.jugadorPuntaje();
//        Label lblPuntajeJugador1 = new Label(Integer.toString(puntaje1));
//        lblJugador1.setStyle("-fx-font-size: 100%");
//        lblPuntajeJugador1.setStyle("-fx-font-size: 75%");
//
//        BorderPane bpLeft = new BorderPane();
//        bpLeft.setTop(lblJugador1);
//        bpLeft.setCenter(lblPuntajeJugador1);
//
//        this.setLeft(bpHeader);
//
//        algoKahoot.cambiarJugador();
//
//        Label lblJugador2 = new Label(algoKahoot.jugadorNombre());
//        int puntaje2 = algoKahoot.jugadorPuntaje();
//        Label lblPuntajeJugador2 = new Label(Integer.toString(puntaje2));
//        lblJugador2.setStyle("-fx-font-size: 100%");
//        lblPuntajeJugador2.setStyle("-fx-font-size: 75%");
//
//        BorderPane bpRight = new BorderPane();
//        bpRight.setTop(lblJugador1);
//        bpRight.setCenter(lblPuntajeJugador1);
//
//        this.setRight(bpRight);
//
//        algoKahoot.cambiarJugador();
//
//    }

}
