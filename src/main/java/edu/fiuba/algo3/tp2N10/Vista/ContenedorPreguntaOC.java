package edu.fiuba.algo3.tp2N10.Vista;

import edu.fiuba.algo3.tp2N10.Controlador.EventHandlers.HandlerOpcionesOC;
import edu.fiuba.algo3.tp2N10.Controlador.EventHandlers.BotonResponderOC;
import edu.fiuba.algo3.tp2N10.Controlador.EventHandlers.BotonSeleccionarOpcionOC;
import edu.fiuba.algo3.tp2N10.Modelo.AlgoKahoot.AlgoKahoot;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Timer;

public class ContenedorPreguntaOC extends BorderPane {

    public ContenedorPreguntaOC(Button btnListo, AlgoKahoot algoKahoot, Timer temporizador) {
        super();

        LinkedList<Integer> respuestaUsuario = new LinkedList<>();

        Label respuestaOrdenadaLabel = new Label("");
        respuestaOrdenadaLabel.setStyle("-fx-font-size: 150%");

        List<Button> arrayBtnOpciones = new ArrayList<>();
        HBox hboxOpciones = new HBox(25);
        btnListo.setOnAction(new BotonResponderOC(algoKahoot, respuestaUsuario, arrayBtnOpciones, temporizador));

        HandlerOpcionesOC handlerOpciones = new HandlerOpcionesOC(respuestaOrdenadaLabel, respuestaUsuario);

        for (int i = 0; i < algoKahoot.preguntaOpciones().size(); i++) {
            Button boton = new Button(algoKahoot.preguntaOpciones().get(i));
            BotonSeleccionarOpcionOC handler = new BotonSeleccionarOpcionOC(boton, i, handlerOpciones);
            boton.setOnAction(handler);
            arrayBtnOpciones.add(boton);
            hboxOpciones.getChildren().add(boton);
        }

        Button botonDeshacer = new Button("Deshacer");
        botonDeshacer.setOnAction(handlerOpciones);

        setLeft(hboxOpciones);
        setRight(botonDeshacer);
        setBottom(respuestaOrdenadaLabel);
    }
}
