package edu.fiuba.algo3.tp2N10.Controlador.Alertas;

import javafx.scene.control.Alert;

public class AlertaNombreFaltante extends Alert {

    public AlertaNombreFaltante() {
        super(AlertType.WARNING);
        this.setTitle("AlgoKahoot Error");
        this.setHeaderText("¡Faltan nombres!");
        this.setContentText("Los nombres de los jugadores son obligatorios");

    }

    public void mostrar() {
        //Aca iria el sonido
        this.showAndWait();
    }

}