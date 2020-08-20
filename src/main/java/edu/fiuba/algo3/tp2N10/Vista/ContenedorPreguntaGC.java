package edu.fiuba.algo3.tp2N10.Vista;

import edu.fiuba.algo3.tp2N10.Controlador.EventHandlers.BotonResponderGC;
import edu.fiuba.algo3.tp2N10.Modelo.AlgoKahoot.AlgoKahoot;
import javafx.scene.control.*;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

import java.util.ArrayList;

public class ContenedorPreguntaGC extends VBox {

    public ContenedorPreguntaGC(Button btnListo, AlgoKahoot algoKahoot){
        String grupoA = "Grupo A";
        String grupoB = "Grupo B";
        ArrayList<ToggleGroup> gruposDeOpciones = new ArrayList<>();
        for (String op : algoKahoot.preguntaOpciones()) {
            RadioButton rdoGrupoA = new RadioButton(grupoA);
            RadioButton rdoGrupoB = new RadioButton(grupoB);
            rdoGrupoA.setSelected(true);
            ToggleGroup agrupamiento = new ToggleGroup();
            agrupamiento.getToggles().addAll(rdoGrupoA, rdoGrupoB);
            gruposDeOpciones.add(agrupamiento);
            HBox hboxRadioButtons = new HBox(20);
            hboxRadioButtons.getChildren().addAll(rdoGrupoA, rdoGrupoB);
            BorderPane bpOpcionMasRadio = new BorderPane();
            bpOpcionMasRadio.setLeft(new Label(op));
            bpOpcionMasRadio.setRight(hboxRadioButtons);

            this.getChildren().add(bpOpcionMasRadio);
        }
        btnListo.setOnAction(new BotonResponderGC(algoKahoot, gruposDeOpciones));
        this.setSpacing(25);
    }
}