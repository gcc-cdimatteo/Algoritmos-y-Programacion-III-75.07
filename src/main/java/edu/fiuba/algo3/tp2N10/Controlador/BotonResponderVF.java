package edu.fiuba.algo3.tp2N10.Controlador;


import edu.fiuba.algo3.tp2N10.Controlador.Alertas.AlertaSeleccionarUnaOpcion;
import edu.fiuba.algo3.tp2N10.Modelo.AlgoKahoot.AlgoKahoot;
import edu.fiuba.algo3.tp2N10.Modelo.Respuesta.RespuestaVerdaderoFalso;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.ToggleButton;

public class BotonResponderVF implements EventHandler<ActionEvent>{
    private AlgoKahoot algoKahoot;
    private ToggleButton botonVerdadero;
    private ToggleButton botonFalso;
    private RespuestaVerdaderoFalso respuesta;

    public BotonResponderVF(ToggleButton botonVerdadero, ToggleButton botonFalso, AlgoKahoot algoKahoot){
        this.botonVerdadero = botonVerdadero;
        this.botonFalso = botonFalso;
        this.algoKahoot = algoKahoot;
    }

    @Override
    public void handle(ActionEvent actionEvent) {
        if ( !this.botonVerdadero.isSelected() && !this.botonFalso.isSelected() ){
            AlertaSeleccionarUnaOpcion alertaSeleccionarUnaOpcion = new AlertaSeleccionarUnaOpcion();
            alertaSeleccionarUnaOpcion.mostrar();
        }
        else if (this.botonVerdadero.isSelected()){
            this.respuesta = new RespuestaVerdaderoFalso(true);
            this.algoKahoot.cargarRespuesta(this.respuesta);

        }
        else{
            this.respuesta = new RespuestaVerdaderoFalso(false);
            this.algoKahoot.cargarRespuesta(this.respuesta);
        }
    }
}
