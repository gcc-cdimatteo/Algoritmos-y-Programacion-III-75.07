package edu.fiuba.algo3.tp2N10.Controlador.EventHandlers;


import edu.fiuba.algo3.tp2N10.Controlador.Alertas.AlertaSeleccionarUnaOpcion;
import edu.fiuba.algo3.tp2N10.Modelo.AlgoKahoot.AlgoKahoot;
import edu.fiuba.algo3.tp2N10.Modelo.Respuesta.RespuestaVerdaderoFalso;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.ToggleButton;

import java.util.Timer;

public class BotonResponderVF implements EventHandler<ActionEvent> {
    private final ToggleButton botonVerdadero;
    private final ToggleButton botonFalso;
    private final AlgoKahoot algoKahoot;
    private final Timer temporizador;

    public BotonResponderVF(AlgoKahoot algoKahoot, ToggleButton botonVerdadero, ToggleButton botonFalso, Timer temporizador){
        this.algoKahoot = algoKahoot;
        this.botonVerdadero = botonVerdadero;
        this.botonFalso = botonFalso;
        this.temporizador = temporizador;
    }

    public void handle(ActionEvent actionEvent) {
        if (botonVerdadero.isSelected()) algoKahoot.cargarRespuesta(new RespuestaVerdaderoFalso(true));
        else if (botonFalso.isSelected()) algoKahoot.cargarRespuesta(new RespuestaVerdaderoFalso(false));
        else {
            AlertaSeleccionarUnaOpcion alertaSeleccionarUnaOpcion = new AlertaSeleccionarUnaOpcion();
            alertaSeleccionarUnaOpcion.mostrar();
            return;
        }
        this.temporizador.cancel();
    }
}
