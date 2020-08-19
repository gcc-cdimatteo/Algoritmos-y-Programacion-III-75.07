package edu.fiuba.algo3.tp2N10.Controlador;

import edu.fiuba.algo3.tp2N10.Controlador.Alertas.AlertaSeleccionarUnaOpcion;
import edu.fiuba.algo3.tp2N10.Modelo.AlgoKahoot.AlgoKahoot;
import edu.fiuba.algo3.tp2N10.Modelo.Respuesta.RespuestaMultipleChoice;
import javafx.event.ActionEvent;
import javafx.scene.control.CheckBox;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

public class BotonResponderMC extends BotonResponder {

    private final ArrayList<CheckBox> opcionesUsuario;

    public BotonResponderMC(AlgoKahoot algoKahoot, ArrayList<CheckBox> opcionesUsuario){
        super(algoKahoot);
        this.opcionesUsuario = opcionesUsuario;
    }

    @Override
    public void handle(ActionEvent actionEvent) {
        usarPowerUp();
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
        }
    }
}
