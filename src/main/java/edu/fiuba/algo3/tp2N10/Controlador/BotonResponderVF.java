package edu.fiuba.algo3.tp2N10.Controlador;


import edu.fiuba.algo3.tp2N10.Controlador.Alertas.AlertaSeleccionarUnaOpcion;
import edu.fiuba.algo3.tp2N10.Modelo.AlgoKahoot.Ronda;
import edu.fiuba.algo3.tp2N10.Modelo.Respuesta.RespuestaVerdaderoFalso;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.ToggleButton;

public class BotonResponderVF implements EventHandler<ActionEvent>{
    private Ronda ronda;
    private ToggleButton botonVerdadero;
    private ToggleButton botonFalso;
    private RespuestaVerdaderoFalso respuesta;

    public BotonResponderVF(ToggleButton botonVerdadero, ToggleButton botonFalso, Ronda ronda){
        this.botonVerdadero = botonVerdadero;
        this.botonFalso = botonFalso;
        this.ronda = ronda;
    }

    @Override
    public void handle(ActionEvent actionEvent) {
        if ( !this.botonVerdadero.isSelected() && !this.botonFalso.isSelected() ){
            AlertaSeleccionarUnaOpcion alertaSeleccionarUnaOpcion = new AlertaSeleccionarUnaOpcion();
            alertaSeleccionarUnaOpcion.mostrar();
        }
        else if (this.botonVerdadero.isSelected()){
            this.respuesta = new RespuestaVerdaderoFalso(true);
            this.ronda.cargarRespuesta(this.respuesta);

            //////////////PARA DEBUGEAR
            this.ronda.cargarRespuesta(new RespuestaVerdaderoFalso(false));
            this.ronda.asignarPuntos();
        }

        else{
            this.respuesta = new RespuestaVerdaderoFalso(false);
            this.ronda.cargarRespuesta(this.respuesta);

            //////////////PARA DEBUGEAR
            this.ronda.cargarRespuesta(new RespuestaVerdaderoFalso(true));
            this.ronda.asignarPuntos();
        }
    }
}
