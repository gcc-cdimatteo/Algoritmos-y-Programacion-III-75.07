package edu.fiuba.algo3.tp2N10.Vista;

import edu.fiuba.algo3.tp2N10.Controlador.BotonComenzarJuego;
import edu.fiuba.algo3.tp2N10.Controlador.BotonResponderMC;
import edu.fiuba.algo3.tp2N10.Modelo.AlgoKahoot.Jugador;
import edu.fiuba.algo3.tp2N10.Modelo.AlgoKahoot.Ronda;
import edu.fiuba.algo3.tp2N10.Modelo.Pregunta.Pregunta;
import edu.fiuba.algo3.tp2N10.Modelo.Pregunta.PreguntaVerdaderoFalso;
import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

import java.util.ArrayList;

public class ContenedorPreguntaMC extends VBox {

    public ContenedorPreguntaMC(Pregunta pregunta, Button btnListo, Ronda ronda) {
        super();

        ArrayList<CheckBox> arrayChkOpciones = new ArrayList<>();
        for (String op : pregunta.getOpciones()) {
            arrayChkOpciones.add(new CheckBox(op));
        }
        btnListo.setOnAction(new BotonResponderMC(arrayChkOpciones, ronda));

        this.setSpacing(25);
        for (CheckBox chkOp : arrayChkOpciones) {
            this.getChildren().addAll(chkOp);
        }
    }
}
