package edu.fiuba.algo3.tp2N10.Controlador.EventHandlers;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class BotonEntrar implements EventHandler<ActionEvent> {

    private final Stage escenario;
    private final Scene proximaEscena;

    public BotonEntrar(Stage stage, Scene proximaEscena) {
        this.escenario = stage;
        this.proximaEscena = proximaEscena;
    }

    @Override
    public void handle(ActionEvent actionEvent) {
        double ancho = escenario.getWidth();
        double alto = escenario.getHeight();

        escenario.setScene(proximaEscena);

        escenario.setWidth(ancho);
        escenario.setHeight(alto);
    }
}
