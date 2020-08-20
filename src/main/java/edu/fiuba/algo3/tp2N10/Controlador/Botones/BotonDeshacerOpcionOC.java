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

    private List<Integer> respuestaUsuario;
    private ArrayList<Button> botones;
    private Label respuestaOrdenada;

    public BotonDeshacerOpcionOC(List<Integer> respuestaUsuario, ArrayList<Button> botones, Label respuestaOrdenada){
        this.respuestaOrdenada = respuestaOrdenada;
        this.respuestaUsuario = respuestaUsuario;
        this.botones = botones;
    }

    @Override
    public void handle(ActionEvent actionEvent) {
        if(this.respuestaOrdenada.getText() == "") return;
        LinkedList<String> respuestaParceada = new LinkedList(Arrays.asList((respuestaOrdenada.getText().split("-"))));
        String respuesta = respuestaParceada.removeLast();
        for(Button boton: this.botones ){
            if(boton.getText().equals(respuesta)){
                boton.setVisible(true);
                this.respuestaUsuario.remove(this.respuestaUsuario.size() - 1);
            }
        }
        this.respuestaOrdenada.setText("".join("-", respuestaParceada));
    }
}
