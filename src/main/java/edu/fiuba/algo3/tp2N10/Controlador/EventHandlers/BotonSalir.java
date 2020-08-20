package edu.fiuba.algo3.tp2N10.Controlador.EventHandlers;

import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;


public class BotonSalir implements EventHandler<ActionEvent> {

    @Override
    public void handle(ActionEvent actionEvent) {
        Platform.exit();
    }

}
