package edu.fiuba.algo3.tp2N10.Controlador.EventHandlers;

import edu.fiuba.algo3.tp2N10.Modelo.AlgoKahoot.AlgoKahoot;
import edu.fiuba.algo3.tp2N10.Modelo.Excepciones.FaltanRespuestasException;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;

public class BotonSiguientePregunta implements EventHandler<ActionEvent> {

        private final AlgoKahoot algoKahoot;

        public BotonSiguientePregunta(AlgoKahoot algoKahoot) {
            this.algoKahoot = algoKahoot;
        }

        @Override
        public void handle(ActionEvent actionEvent) {
            try { this.algoKahoot.siguientePregunta(); }
            catch (FaltanRespuestasException ignored) {}
        }
}

