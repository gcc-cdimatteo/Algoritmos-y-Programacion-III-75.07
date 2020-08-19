package edu.fiuba.algo3.tp2N10.Controlador.Botones;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class BotonEntrar implements EventHandler<ActionEvent> {

    private final Stage stage;
    private final Scene proximaEscena;

    public BotonEntrar(Stage stage, Scene proximaEscena) {
        this.stage = stage;
        this.proximaEscena = proximaEscena;
    }

    @Override
    public void handle(ActionEvent actionEvent) {
        stage.setScene(proximaEscena);
        //stage.setFullScreenExitHint("");
        //stage.setFullScreen(true);
    }
}
