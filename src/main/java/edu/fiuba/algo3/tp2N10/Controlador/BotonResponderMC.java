package edu.fiuba.algo3.tp2N10.Controlador;

import edu.fiuba.algo3.tp2N10.Controlador.Alertas.AlertaSeleccionarUnaOpcion;
import edu.fiuba.algo3.tp2N10.Modelo.AlgoKahoot.AlgoKahoot;
import edu.fiuba.algo3.tp2N10.Modelo.AlgoKahoot.Ronda;
import edu.fiuba.algo3.tp2N10.Modelo.Respuesta.RespuestaMultipleChoice;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.CheckBox;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

public class BotonResponderMC implements EventHandler<ActionEvent> {

    private final AlgoKahoot algoKahoot;
    ArrayList<CheckBox> opcionesUsuario;
    RespuestaMultipleChoice respuesta;

    public BotonResponderMC(ArrayList<CheckBox> opcionesUsuario, AlgoKahoot algoKahoot){
        this.opcionesUsuario = opcionesUsuario;
        this.algoKahoot = algoKahoot;
    }

    @Override
    public void handle(ActionEvent actionEvent){
        Set<Integer> respuestas = new HashSet<>();
        for (int i = 0; i < this.opcionesUsuario.size(); i++){
            if(this.opcionesUsuario.get(i).isSelected()){
                respuestas.add(i);
            }
        }
        if(respuestas.size() == 0){
            AlertaSeleccionarUnaOpcion alertaSeleccionarUnaOpcion = new AlertaSeleccionarUnaOpcion();
            alertaSeleccionarUnaOpcion.mostrar();
        }
        else {
            this.respuesta = new RespuestaMultipleChoice(respuestas);
            this.algoKahoot.cargarRespuesta(this.respuesta);
        }
    }
}
