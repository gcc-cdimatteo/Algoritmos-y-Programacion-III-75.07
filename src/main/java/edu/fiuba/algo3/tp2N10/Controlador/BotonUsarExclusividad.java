package edu.fiuba.algo3.tp2N10.Controlador;

import edu.fiuba.algo3.tp2N10.Controlador.Alertas.AlertaPowerUpNoDisponible;
import edu.fiuba.algo3.tp2N10.Modelo.AlgoKahoot.AlgoKahoot;
import edu.fiuba.algo3.tp2N10.Modelo.Excepciones.PowerUpNoDisponibleException;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;

public class BotonUsarExclusividad implements EventHandler<ActionEvent> {

    private AlgoKahoot algoKahoot;

    public BotonUsarExclusividad(AlgoKahoot algoKahoot){
        this.algoKahoot = algoKahoot;
    }

    @Override
    public void handle(ActionEvent actionEvent) {
        try {
            this.algoKahoot.jugadorUsaExclusividad();
        }catch (PowerUpNoDisponibleException e) {
            AlertaPowerUpNoDisponible alerta = new AlertaPowerUpNoDisponible("Exclusividad");
            alerta.mostrar();
        }
    }
}
