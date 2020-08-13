package edu.fiuba.algo3.tp2N10.Controlador;

import edu.fiuba.algo3.tp2N10.Controlador.Alertas.AlertaSeleccionarUnaOpcion;
import edu.fiuba.algo3.tp2N10.Modelo.Respuesta.RespuestaMultipleChoice;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.CheckBox;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

public class BotonResponderMC implements EventHandler<ActionEvent> {

    ArrayList<CheckBox> opcionesUsuario;
    RespuestaMultipleChoice respuestaUsuario;

    public BotonResponderMC(ArrayList<CheckBox> opcionesUsuario){
        this.opcionesUsuario = opcionesUsuario;
    }

    @Override
    public void handle(ActionEvent actionEvent){
        Set<Integer> respuestas = new HashSet<Integer>();
        for (int i = 0; i < this.opcionesUsuario.size(); i++){
            if(this.opcionesUsuario.get(i).isSelected()){
                respuestas.add(i);
            }
        }
        if(respuestas.size() == 0){
            AlertaSeleccionarUnaOpcion alertaSeleccionarUnaOpcion = new AlertaSeleccionarUnaOpcion();
            alertaSeleccionarUnaOpcion.mostrar();
        }
        else{this.respuestaUsuario = new RespuestaMultipleChoice(respuestas);}
    }
}
