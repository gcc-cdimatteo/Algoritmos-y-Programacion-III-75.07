package edu.fiuba.algo3.tp2N10.Vista;

import edu.fiuba.algo3.tp2N10.Controlador.EventHandlers.BotonEntrar;
import edu.fiuba.algo3.tp2N10.Controlador.EventHandlers.BotonSalir;

import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;

public class ContenedorBienvenidos extends BorderPane {

    public ContenedorBienvenidos(Stage stage, Scene proximaEscena) {

        super();

        Label labelEtiqueta = new Label();
        labelEtiqueta.setFont(Font.font("Tahoma", FontWeight.BOLD, 20));
        labelEtiqueta.setText("¡Bienvenidos a AlgoKahoot, la app de preguntas de Algoritmos III!");
        labelEtiqueta.setTextFill(Color.web("#6495ED"));

        Button botonEntrar = new Button();
        botonEntrar.setText("Entrar");
        botonEntrar.setOnAction( new BotonEntrar(stage, proximaEscena));

        Button botonSalir = new Button();
        botonSalir.setText("Salir");
        //botonSalir.setOnAction( new BotonSalir());

        HBox hbBotones = new HBox(botonEntrar,botonSalir);
        hbBotones.setAlignment(Pos.CENTER);
        hbBotones.setSpacing(100);

        VBox vbContenido = new VBox(labelEtiqueta,hbBotones);
        vbContenido.setAlignment(Pos.CENTER);
        vbContenido.setSpacing(50);

        setCenter(vbContenido);
    }
}
