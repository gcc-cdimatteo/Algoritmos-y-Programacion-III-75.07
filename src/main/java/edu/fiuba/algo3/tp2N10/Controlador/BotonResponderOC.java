package edu.fiuba.algo3.tp2N10.Controlador;

import edu.fiuba.algo3.tp2N10.Controlador.Alertas.AlertaOrdenarTodasLasOpcionesOC;
import edu.fiuba.algo3.tp2N10.Controlador.Alertas.AlertaSeleccionarUnaOpcion;
import edu.fiuba.algo3.tp2N10.Modelo.AlgoKahoot.Ronda;
import edu.fiuba.algo3.tp2N10.Modelo.Respuesta.RespuestaOrderedChoice;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;

import java.util.List;

public class BotonResponderOC implements EventHandler<ActionEvent> {
    private Ronda ronda;
    private List<Integer> respuestaUsuario;
    private RespuestaOrderedChoice respuesta;
    private Integer tamRespuesta;

    public BotonResponderOC(Ronda ronda, List<Integer> respuestaUsuario, Integer tamRespuesta){
        this.ronda = ronda;
        this.respuestaUsuario = respuestaUsuario;
        this.tamRespuesta = tamRespuesta; // Refactorizar para evitar este atributo
    }

    @Override
    public void handle(ActionEvent actionEvent) {
        if(this.tamRespuesta != this.respuestaUsuario.size()){
            AlertaOrdenarTodasLasOpcionesOC alertaOrdenarTodasLasOpcionesOC = new AlertaOrdenarTodasLasOpcionesOC();
            alertaOrdenarTodasLasOpcionesOC.mostrar();
        }
        else{
            this.respuesta = new RespuestaOrderedChoice(this.respuestaUsuario);
            this.ronda.cargarRespuesta(this.respuesta);
            this.ronda.asignarPuntos();
        }
    }
}
