//package edu.fiuba.algo3.tp2N10.Controlador;
//
//import javafx.event.ActionEvent;
//import javafx.event.EventHandler;
//import javafx.scene.control.Button;
//import javafx.scene.control.Label;
//
//public class BotonSeleccionarOpcionOC implements EventHandler<ActionEvent>{
//    Label respuestaOrdenada;
//    Button boton;
//
//    public BotonSeleccionarOpcionOC(Label respuestaOrdenada, Button boton){
//        this.boton = boton;
//        this.respuestaOrdenada = respuestaOrdenada;
//
//    }
//
//    @Override
//    public void handle(ActionEvent actionEvent) {
//        String opcion = this.boton.getText();
//        this.boton.setVisible(false);
//            this.respuestaOrdenada.setText(this.respuestaOrdenada.getText() + opcion);
//    }
//}