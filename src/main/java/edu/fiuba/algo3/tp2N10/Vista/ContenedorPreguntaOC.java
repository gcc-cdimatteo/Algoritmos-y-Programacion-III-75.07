package edu.fiuba.algo3.tp2N10.Vista;

import edu.fiuba.algo3.tp2N10.Controlador.Botones.BotonResponderOC;
import edu.fiuba.algo3.tp2N10.Controlador.Botones.BotonSeleccionarOpcionOC;
import edu.fiuba.algo3.tp2N10.Modelo.AlgoKahoot.AlgoKahoot;
import javafx.scene.control.Button;
import javafx.scene.layout.HBox;

import java.util.ArrayList;
import java.util.List;

public class ContenedorPreguntaOC extends HBox {

    public ContenedorPreguntaOC(Button btnListo, AlgoKahoot algoKahoot) {
        super();

        List<Integer> respuestaUsuario = new ArrayList<>();

        ArrayList<Button> arrayBtnOpciones = new ArrayList<>();
        btnListo.setOnAction(new BotonResponderOC(algoKahoot, respuestaUsuario, arrayBtnOpciones));

        for (int i = 0; i < algoKahoot.preguntaOpciones().size(); i++) {
            Button boton = new Button(algoKahoot.preguntaOpciones().get(i));
            boton.setOnAction(new BotonSeleccionarOpcionOC(boton, i, respuestaUsuario));
            arrayBtnOpciones.add(boton);
        }

        this.setSpacing(25);
        for (Button btn : arrayBtnOpciones) {
            this.getChildren().add(btn);
        }
    }
}
