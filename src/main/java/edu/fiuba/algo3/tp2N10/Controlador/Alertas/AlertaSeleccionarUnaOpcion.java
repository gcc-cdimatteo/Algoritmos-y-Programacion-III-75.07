package edu.fiuba.algo3.tp2N10.Controlador.Alertas;

import javafx.scene.control.Alert;

public class AlertaSeleccionarUnaOpcion extends Alert{

    public AlertaSeleccionarUnaOpcion() {
        super(AlertType.WARNING);
        this.setTitle("AlgoKahoot Error");
        this.setHeaderText("¡Debe seleccionar al menos una opcion!");
    }

    public void mostrar() {
        //Aca iria el sonido
        this.showAndWait();
    }
}
