package edu.fiuba.algo3.tp2N10.Controlador;

import edu.fiuba.algo3.tp2N10.Controlador.Alertas.AlertaPowerUpNoDisponible;
import edu.fiuba.algo3.tp2N10.Modelo.AlgoKahoot.AlgoKahoot;
import edu.fiuba.algo3.tp2N10.Modelo.Excepciones.PowerUpNoDisponibleException;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;

public class BotonUsarMultiplicador implements EventHandler<ActionEvent> {

    private AlgoKahoot algoKahoot;
    private Integer valorMultiplicador;

    public BotonUsarMultiplicador(AlgoKahoot algoKahoot, Integer valorMultiplicador){
        this.algoKahoot = algoKahoot;
        this.valorMultiplicador = valorMultiplicador;
    }

    @Override
    public void handle(ActionEvent actionEvent) {
        try {
            this.algoKahoot.jugadorUsaMultiplicador(this.valorMultiplicador);
        }catch (PowerUpNoDisponibleException e) {
            AlertaPowerUpNoDisponible alerta = new AlertaPowerUpNoDisponible("X"+this.valorMultiplicador.toString());
            alerta.mostrar();
        }
    }
}
