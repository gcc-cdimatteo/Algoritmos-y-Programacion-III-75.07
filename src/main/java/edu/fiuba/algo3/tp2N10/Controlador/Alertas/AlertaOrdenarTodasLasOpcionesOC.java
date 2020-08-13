package edu.fiuba.algo3.tp2N10.Controlador.Alertas;

import javafx.scene.control.Alert;

public class AlertaOrdenarTodasLasOpcionesOC extends Alert{

    public AlertaOrdenarTodasLasOpcionesOC() {
        super(Alert.AlertType.WARNING);
        this.setTitle("AlgoKahoot Error");
        this.setHeaderText("¡Debe ordenar todas las opciones!");
    }

    public void mostrar() {
        //Aca iria el sonido
        this.showAndWait();
    }
}
