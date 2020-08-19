package edu.fiuba.algo3.tp2N10.Controlador;

import edu.fiuba.algo3.tp2N10.Modelo.AlgoKahoot.AlgoKahoot;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.ToggleGroup;

import java.util.ArrayList;

public abstract class BotonResponder implements EventHandler<ActionEvent> {

    protected final AlgoKahoot algoKahoot;

    public BotonResponder(AlgoKahoot algoKahoot){
        this.algoKahoot = algoKahoot;
    }

    protected void usarPowerUp() {

    }

    @Override
    public abstract void handle(ActionEvent actionEvent);
}
