package edu.fiuba.algo3.tp2N10.Vista;

import edu.fiuba.algo3.tp2N10.Controlador.EventHandlers.BotonResponderMC;
import edu.fiuba.algo3.tp2N10.Modelo.AlgoKahoot.AlgoKahoot;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.layout.VBox;

import java.util.ArrayList;
import java.util.Timer;

public class ContenedorPreguntaMC extends VBox {

    public ContenedorPreguntaMC(Button btnListo, AlgoKahoot algoKahoot, Timer temporizador) {
        super();

        ArrayList<CheckBox> arrayChkOpciones = new ArrayList<>();
        for (String op : algoKahoot.preguntaOpciones()) {
            arrayChkOpciones.add(new CheckBox(op));
        }
        btnListo.setOnAction(new BotonResponderMC(algoKahoot, arrayChkOpciones, temporizador));

        this.setSpacing(25);
        for (CheckBox chkOp : arrayChkOpciones) {
            this.getChildren().addAll(chkOp);
        }
    }
}
