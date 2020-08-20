package edu.fiuba.algo3.tp2N10.Controlador.EventHandlers;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.control.Label;

import java.util.LinkedList;
import java.util.List;

public class BotonSeleccionarOpcionOC implements EventHandler<ActionEvent>{
    Label labelRespuesta;
    Button boton;
    Integer numeroOpcion;
    LinkedList<String> respuestaOrdenada;
    List<Integer> respuestaUsuario;

    public BotonSeleccionarOpcionOC(Button boton, Integer numeroOpcion, List<Integer> respuestaUsuario, Label labelRespuesta, LinkedList<String> respuestaOrdenada){
        this.boton = boton;
        this.labelRespuesta = labelRespuesta;
        this.numeroOpcion = numeroOpcion;
        this.respuestaUsuario = respuestaUsuario;
        this.respuestaOrdenada = respuestaOrdenada;
    }

    public Boolean esUltimaRespuesta(){
        if (this.respuestaUsuario.size() == 0) return false;
        return this.respuestaUsuario.get(this.respuestaUsuario.size() - 1).equals(this.numeroOpcion);
    }

    public void removerRespuesta(){
        this.respuestaOrdenada.remove(boton.getText());
        this.respuestaUsuario.remove(this.numeroOpcion);
        this.actualizarLabel();
        this.boton.setVisible(true);
    }

    private void actualizarLabel(){
        this.labelRespuesta.setText("".join("-", this.respuestaOrdenada));
    }

    @Override
    public void handle(ActionEvent actionEvent) {
        this.boton.setVisible(false);
        this.respuestaOrdenada.add(this.boton.getText());
        this.respuestaUsuario.add(this.numeroOpcion);
        this.actualizarLabel();
    }
}