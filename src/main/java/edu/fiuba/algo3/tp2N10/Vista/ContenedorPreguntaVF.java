package edu.fiuba.algo3.tp2N10.Vista;

import edu.fiuba.algo3.tp2N10.Controlador.BotonResponderVF;
import edu.fiuba.algo3.tp2N10.Modelo.AlgoKahoot.AlgoKahoot;
import javafx.scene.control.Button;
import javafx.scene.control.ToggleButton;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.VBox;

public class ContenedorPreguntaVF extends VBox {

    public ContenedorPreguntaVF(Button btnListo, AlgoKahoot algoKahoot) {
        super();

        ToggleGroup grupoOpciones = new ToggleGroup();
        ToggleButton btnVerdadero = new ToggleButton("Verdadero");
        ToggleButton btnFalso = new ToggleButton("Falso");
        btnVerdadero.setToggleGroup(grupoOpciones);
        btnFalso.setToggleGroup(grupoOpciones);
        btnListo.setOnAction(new BotonResponderVF(algoKahoot, btnVerdadero, btnFalso));
        this.setSpacing(25);
        this.getChildren().addAll(btnVerdadero, btnFalso);
    }
}
