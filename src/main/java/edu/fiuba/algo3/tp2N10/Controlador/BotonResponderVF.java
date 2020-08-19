package edu.fiuba.algo3.tp2N10.Controlador;


import edu.fiuba.algo3.tp2N10.Controlador.Alertas.AlertaSeleccionarUnaOpcion;
import edu.fiuba.algo3.tp2N10.Modelo.AlgoKahoot.AlgoKahoot;
import edu.fiuba.algo3.tp2N10.Modelo.Respuesta.RespuestaVerdaderoFalso;
import javafx.event.ActionEvent;
import javafx.scene.control.ToggleButton;

public class BotonResponderVF extends BotonResponder {
    private final ToggleButton botonVerdadero;
    private final ToggleButton botonFalso;

    public BotonResponderVF(AlgoKahoot algoKahoot, ToggleButton botonVerdadero, ToggleButton botonFalso){
        super(algoKahoot);
        this.botonVerdadero = botonVerdadero;
        this.botonFalso = botonFalso;
    }

    @Override
    public void handle(ActionEvent actionEvent) {
        usarPowerUp();
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
