package edu.fiuba.algo3.tp2N10.Controlador.EventHandlers;

import edu.fiuba.algo3.tp2N10.Modelo.AlgoKahoot.AlgoKahoot;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;

public class BotonContinuar implements EventHandler<ActionEvent> {

    private final AlgoKahoot algoKahoot;

    public BotonContinuar(AlgoKahoot algoKahoot) {
        this.algoKahoot = algoKahoot;
    }

    @Override
    public void handle(ActionEvent actionEvent) {
        this.algoKahoot.notifyObservers();
    }
}