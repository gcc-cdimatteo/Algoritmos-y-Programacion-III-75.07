package edu.fiuba.algo3.tp2N10.Controlador.Alertas;

import javafx.scene.control.Alert;

public class AlertaPowerUpNoDisponible extends Alert {

    public AlertaPowerUpNoDisponible(String powerUp) {
        super(AlertType.WARNING);
        this.setTitle("AlgoKahoot Error");
        this.setHeaderText("¡PowerUp no disponible!");
        this.setContentText("PowerUp " + powerUp + " se utilizo el maximo de veces");

    }

    public void mostrar() {
        //Aca iria el sonido
        this.showAndWait();
    }
}
