package edu.fiuba.algo3.tp2N10.Vista;

import edu.fiuba.algo3.tp2N10.Controlador.EventHandlers.BotonDeshacerOpcionOC;
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

public class ContenedorPreguntaOC extends BorderPane {

    public ContenedorPreguntaOC(Button btnListo, AlgoKahoot algoKahoot) {
        super();

        List<Integer> respuestaUsuario = new ArrayList<>();

        Label respuestaOrdenadaLabel = new Label("");
        respuestaOrdenadaLabel.setStyle("-fx-font-size: 150%");

        ArrayList<Button> arrayBtnOpciones = new ArrayList<>();
        HBox hboxOpciones = new HBox(25);
        btnListo.setOnAction(new BotonResponderOC(algoKahoot, respuestaUsuario, arrayBtnOpciones));

        ArrayList<BotonSeleccionarOpcionOC> handlersSeleccionarOpcion = new ArrayList<>();

        LinkedList<String> respuestaOrdenada = new LinkedList<>();

        for (int i = 0; i < algoKahoot.preguntaOpciones().size(); i++) {
            Button boton = new Button(algoKahoot.preguntaOpciones().get(i));
            BotonSeleccionarOpcionOC handler = new BotonSeleccionarOpcionOC(boton, i, respuestaUsuario, respuestaOrdenadaLabel, respuestaOrdenada);
            boton.setOnAction(handler);
            arrayBtnOpciones.add(boton);
            handlersSeleccionarOpcion.add(handler);
            hboxOpciones.getChildren().add(boton);
        }

        Button botonDeshacer = new Button("Deshacer");
        botonDeshacer.setOnAction(new BotonDeshacerOpcionOC(handlersSeleccionarOpcion));

        this.setLeft(hboxOpciones);
        this.setRight(botonDeshacer);
        this.setBottom(respuestaOrdenadaLabel);
    }
}
