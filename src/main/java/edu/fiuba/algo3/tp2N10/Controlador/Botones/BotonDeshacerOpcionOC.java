package edu.fiuba.algo3.tp2N10.Controlador.Botones;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.control.Label;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

import static java.util.Arrays.asList;

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
