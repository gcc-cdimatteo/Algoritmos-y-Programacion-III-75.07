package edu.fiuba.algo3.tp2N10.Controlador.EventHandlers;


import edu.fiuba.algo3.tp2N10.Controlador.Alertas.AlertaSeleccionarUnaOpcion;
import edu.fiuba.algo3.tp2N10.Modelo.AlgoKahoot.AlgoKahoot;
import edu.fiuba.algo3.tp2N10.Modelo.Respuesta.RespuestaVerdaderoFalso;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.ToggleButton;

public class BotonResponderVF implements EventHandler<ActionEvent> {
    private final ToggleButton botonVerdadero;
    private final ToggleButton botonFalso;
    private final AlgoKahoot algoKahoot;

    public BotonResponderVF(AlgoKahoot algoKahoot, ToggleButton botonVerdadero, ToggleButton botonFalso){
        this.algoKahoot = algoKahoot;
        this.botonVerdadero = botonVerdadero;
        this.botonFalso = botonFalso;
    }

    public void handle(ActionEvent actionEvent) {
        if (botonVerdadero.isSelected()) {
            algoKahoot.cargarRespuesta(new RespuestaVerdaderoFalso(true));
        } else if (botonFalso.isSelected()) {
            algoKahoot.cargarRespuesta(new RespuestaVerdaderoFalso(false));
        } else {
            AlertaSeleccionarUnaOpcion alertaSeleccionarUnaOpcion = new AlertaSeleccionarUnaOpcion();
            alertaSeleccionarUnaOpcion.mostrar();
        }
    }
}
