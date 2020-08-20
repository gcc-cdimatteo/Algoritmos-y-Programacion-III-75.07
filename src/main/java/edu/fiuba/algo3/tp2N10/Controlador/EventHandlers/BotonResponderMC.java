package edu.fiuba.algo3.tp2N10.Controlador.EventHandlers;

import edu.fiuba.algo3.tp2N10.Controlador.Alertas.AlertaSeleccionarUnaOpcion;
import edu.fiuba.algo3.tp2N10.Modelo.AlgoKahoot.AlgoKahoot;
import edu.fiuba.algo3.tp2N10.Modelo.Respuesta.RespuestaMultipleChoice;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.CheckBox;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;
import java.util.Timer;

public class BotonResponderMC implements EventHandler<ActionEvent> {

    private final ArrayList<CheckBox> opcionesUsuario;
    private final AlgoKahoot algoKahoot;
    private final Timer temporizador;

    public BotonResponderMC(AlgoKahoot algoKahoot, ArrayList<CheckBox> opcionesUsuario, Timer temporizador){
        this.algoKahoot = algoKahoot;
        this.opcionesUsuario = opcionesUsuario;
        this.temporizador = temporizador;
    }

    public void handle(ActionEvent actionEvent) {
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
            this.algoKahoot.cargarRespuesta(new RespuestaMultipleChoice(respuestas));
            temporizador.cancel();
        }
    }
}
