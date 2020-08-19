package edu.fiuba.algo3.tp2N10.Controlador;

import edu.fiuba.algo3.tp2N10.Controlador.Alertas.AlertaOrdenarTodasLasOpcionesOC;
import edu.fiuba.algo3.tp2N10.Controlador.Alertas.AlertaSeleccionarUnaOpcion;
import edu.fiuba.algo3.tp2N10.Modelo.AlgoKahoot.AlgoKahoot;
import edu.fiuba.algo3.tp2N10.Modelo.AlgoKahoot.Ronda;
import edu.fiuba.algo3.tp2N10.Modelo.Respuesta.RespuestaOrderedChoice;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;

import java.util.List;

public class BotonResponderOC extends BotonResponder {
    private final List<Integer> respuestaUsuario;
    private final Integer tamRespuesta;

    public BotonResponderOC(AlgoKahoot algoKahoot, List<Integer> respuestaUsuario, Integer tamRespuesta){
        super(algoKahoot);
        this.respuestaUsuario = respuestaUsuario;
        this.tamRespuesta = tamRespuesta; // Refactorizar para evitar este atributo
    }

    @Override
    public void handle(ActionEvent actionEvent) {
        usarPowerUp();
        if(this.tamRespuesta != this.respuestaUsuario.size()) {
            AlertaOrdenarTodasLasOpcionesOC alertaOrdenarTodasLasOpcionesOC = new AlertaOrdenarTodasLasOpcionesOC();
            alertaOrdenarTodasLasOpcionesOC.mostrar();
        }
        else{
            this.algoKahoot.cargarRespuesta(new RespuestaOrderedChoice(this.respuestaUsuario));
        }
    }
}
