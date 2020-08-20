package edu.fiuba.algo3.tp2N10.Controlador.EventHandlers;

import edu.fiuba.algo3.tp2N10.Modelo.AlgoKahoot.AlgoKahoot;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class BotonUsarMultiplicador implements EventHandler<ActionEvent> {

    private final Button boton;
    private final AlgoKahoot algoKahoot;
    private final List<Integer> valores = new ArrayList<>(Collections.singletonList(1));
    private Integer valorActual = 0;

    public BotonUsarMultiplicador(AlgoKahoot algoKahoot, Button boton) {
        this.algoKahoot = algoKahoot;
        this.boton = boton;
    }

    public void add(int valor) {
        this.valores.add(valor);
    }

    @Override
    public void handle(ActionEvent actionEvent) {
        valorActual = (valorActual + 1) % valores.size();
        Integer multiplicadorActual = valores.get(valorActual);
        boton.setText("x" + multiplicadorActual.toString());
        this.algoKahoot.jugadorUsaMultiplicador(multiplicadorActual);
    }
}
