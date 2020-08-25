package edu.fiuba.algo3.tp2N10.Vista;

import edu.fiuba.algo3.tp2N10.Controlador.EventHandlers.BotonResponderVF;
import edu.fiuba.algo3.tp2N10.Modelo.AlgoKahoot.AlgoKahoot;
import javafx.scene.control.Button;
import javafx.scene.control.ToggleButton;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.VBox;

import java.util.Timer;
import java.util.concurrent.atomic.AtomicBoolean;

public class ContenedorPreguntaVF extends VBox {

    public ContenedorPreguntaVF(Button btnListo, AlgoKahoot algoKahoot, Timer temporizador, AtomicBoolean sinTiempo) {
        super();

        ToggleGroup grupoOpciones = new ToggleGroup();
        ToggleButton btnVerdadero = new ToggleButton("Verdadero");
        ToggleButton btnFalso = new ToggleButton("Falso");
        btnVerdadero.setToggleGroup(grupoOpciones);
        btnFalso.setToggleGroup(grupoOpciones);
        btnListo.setOnAction(new BotonResponderVF(algoKahoot, btnVerdadero, btnFalso, temporizador, sinTiempo));
        setSpacing(25);
        getChildren().addAll(btnVerdadero, btnFalso);
    }
}
