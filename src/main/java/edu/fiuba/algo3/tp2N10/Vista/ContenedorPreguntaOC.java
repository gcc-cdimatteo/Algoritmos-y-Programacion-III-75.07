package edu.fiuba.algo3.tp2N10.Vista;

import edu.fiuba.algo3.tp2N10.Controlador.BotonResponderOC;
import edu.fiuba.algo3.tp2N10.Controlador.BotonSeleccionarOpcionOC;
import edu.fiuba.algo3.tp2N10.Modelo.AlgoKahoot.Ronda;
import edu.fiuba.algo3.tp2N10.Modelo.Pregunta.Pregunta;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;

import java.util.ArrayList;
import java.util.List;

public class ContenedorPreguntaOC extends HBox {

    public ContenedorPreguntaOC(Label respuestaOrdenada, Pregunta pregunta, Button btnListo, Ronda ronda){
        super();

        List<Integer> respuestaUsuario = new ArrayList<>();

        btnListo.setOnAction(new BotonResponderOC(ronda, respuestaUsuario, pregunta.getOpciones().size()));
        ArrayList<Button> arrayBtnOpciones = new ArrayList<>();
        for (int i = 0; i < pregunta.getOpciones().size(); i++) {
            Button boton = new Button(pregunta.getOpciones().get(i));
            boton.setOnAction(new BotonSeleccionarOpcionOC(respuestaOrdenada, boton, i, respuestaUsuario));
            arrayBtnOpciones.add(boton);
        }

        this.setSpacing(25);
        for (Button btn : arrayBtnOpciones) {
            this.getChildren().addAll(btn);
        }
    }
}
