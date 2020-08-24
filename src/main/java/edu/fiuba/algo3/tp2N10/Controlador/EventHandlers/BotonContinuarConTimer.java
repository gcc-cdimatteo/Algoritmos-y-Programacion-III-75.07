package edu.fiuba.algo3.tp2N10.Controlador.EventHandlers;

import edu.fiuba.algo3.tp2N10.Modelo.AlgoKahoot.AlgoKahoot;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;

import java.util.Timer;

public class BotonContinuarConTimer implements EventHandler<ActionEvent> {

        private final AlgoKahoot algoKahoot;
        private final Timer temporizador;

        public BotonContinuarConTimer(AlgoKahoot algoKahoot, Timer temporizador) {
            this.algoKahoot = algoKahoot;
            this.temporizador = temporizador;
        }

        @Override
        public void handle(ActionEvent actionEvent) {
            this.temporizador.cancel();
            this.algoKahoot.notifyObservers();
        }
    }
