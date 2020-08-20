package edu.fiuba.algo3.tp2N10.Controlador.EventHandlers;

import edu.fiuba.algo3.tp2N10.Modelo.AlgoKahoot.AlgoKahoot;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;

public class BotonUsarExclusividad implements EventHandler<ActionEvent> {

    private final Button boton;
    private final AlgoKahoot algoKahoot;

    public BotonUsarExclusividad(AlgoKahoot algoKahoot, Button boton){
        this.algoKahoot = algoKahoot;
        this.boton = boton;
    }

    @Override
    public void handle(ActionEvent actionEvent) {
        algoKahoot.jugadorUsaExclusividad();
        boton.setVisible(false);

    }
}
