package edu.fiuba.algo3.tp2N10.Controlador;

import edu.fiuba.algo3.tp2N10.Controlador.Alertas.AlertaNombreFaltante;
import edu.fiuba.algo3.tp2N10.Controlador.Alertas.AlertaSeleccionarUnaOpcion;
import edu.fiuba.algo3.tp2N10.Modelo.Respuesta.RespuestaVerdaderoFalso;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.control.ToggleButton;

public class BotonResponderVF implements EventHandler<ActionEvent>{

    ToggleButton botonVerdadero;
    ToggleButton botonFalso;
    RespuestaVerdaderoFalso respuesta;

    public BotonResponderVF(ToggleButton botonVerdadero, ToggleButton botonFalso){
        this.botonVerdadero = botonVerdadero;
        this.botonFalso = botonFalso;
    }

    @Override
    public void handle(ActionEvent actionEvent) {
        if (this.botonVerdadero.isSelected()){
            this.respuesta = new RespuestaVerdaderoFalso(true);
        }
        else if (this.botonFalso.isSelected()){
            this.respuesta = new RespuestaVerdaderoFalso(false);
        }
        else{
            AlertaSeleccionarUnaOpcion alertaSeleccionarUnaOpcion = new AlertaSeleccionarUnaOpcion();
            alertaSeleccionarUnaOpcion.mostrar();
        }
    }
}
