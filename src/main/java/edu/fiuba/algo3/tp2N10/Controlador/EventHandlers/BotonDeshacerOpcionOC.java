package edu.fiuba.algo3.tp2N10.Controlador.EventHandlers;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;

import java.util.ArrayList;

public class BotonDeshacerOpcionOC implements EventHandler<ActionEvent> {

    ArrayList<BotonSeleccionarOpcionOC> handlers;

    public BotonDeshacerOpcionOC(ArrayList<BotonSeleccionarOpcionOC> handlers){
        this.handlers = handlers;
    }

    @Override
    public void handle(ActionEvent actionEvent) {
        for(BotonSeleccionarOpcionOC handler: this.handlers ){
            if(handler.esUltimaRespuesta()){
                handler.removerRespuesta();
                return;
            }
        }
    }
}
