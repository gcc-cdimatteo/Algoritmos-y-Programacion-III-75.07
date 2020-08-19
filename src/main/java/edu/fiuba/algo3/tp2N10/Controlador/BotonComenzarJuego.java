package edu.fiuba.algo3.tp2N10.Controlador;

import edu.fiuba.algo3.tp2N10.Controlador.Alertas.AlertaNombreFaltante;
import edu.fiuba.algo3.tp2N10.Vista.App;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.TextField;

import java.io.IOException;

public class BotonComenzarJuego implements EventHandler<ActionEvent> {
    private TextField nombreUno;
    private TextField nombreDos;
    private App app;


    public BotonComenzarJuego(TextField nombreUno, TextField nombreDos, App app) {
        this.nombreUno = nombreUno;
        this.nombreDos = nombreDos;
        this.app = app;
    }

    @Override
    public void handle(ActionEvent event) {
        if (this.nombreUno.getText().isEmpty() || this.nombreDos.getText().isEmpty()) {
            AlertaNombreFaltante alertaNombreFaltante = new AlertaNombreFaltante();
            alertaNombreFaltante.mostrar();
        } else {
            try {
                this.app.jugar(this.nombreUno.getText(), this.nombreDos.getText());
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
