package edu.fiuba.algo3.tp2N10.Controlador;

import edu.fiuba.algo3.tp2N10.Modelo.AlgoKahoot.Ronda;
import edu.fiuba.algo3.tp2N10.Modelo.Respuesta.RespuestaGroupChoice;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Toggle;
import javafx.scene.control.ToggleGroup;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class BotonResponderGC implements EventHandler<ActionEvent> {

    private Ronda ronda;
    private ArrayList<ToggleGroup> opcionesUsuario;
    private RespuestaGroupChoice respuesta;

    public BotonResponderGC(Ronda ronda, ArrayList<ToggleGroup> opcionesUsuario){
        this.opcionesUsuario = opcionesUsuario;
        this.ronda = ronda;
    }

    @Override
    public void handle(ActionEvent actionEvent) {
        Set<Integer> grupoA = new HashSet<>();
        Set<Integer> grupoB = new HashSet<>();
        for(int i = 0; i < opcionesUsuario.size(); i++){
            ObservableList<Toggle> botones = opcionesUsuario.get(i).getToggles();
            if ((botones.get(0).isSelected())) {
                grupoA.add(i);
            } else {
                grupoB.add(i);
            }
        }
        this.respuesta = new RespuestaGroupChoice(grupoA, grupoB);
        this.ronda.cargarRespuesta(this.respuesta);
        this.ronda.asignarPuntos();
    }
}