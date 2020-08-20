package edu.fiuba.algo3.tp2N10.Controlador.EventHandlers;

import edu.fiuba.algo3.tp2N10.Modelo.AlgoKahoot.AlgoKahoot;
import edu.fiuba.algo3.tp2N10.Modelo.Respuesta.RespuestaGroupChoice;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Toggle;
import javafx.scene.control.ToggleGroup;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

public class BotonResponderGC implements EventHandler<ActionEvent> {

    private final ArrayList<ToggleGroup> opcionesUsuario;
    private final AlgoKahoot algoKahoot;

    public BotonResponderGC(AlgoKahoot algoKahoot, ArrayList<ToggleGroup> opcionesUsuario) {
        this.algoKahoot = algoKahoot;
        this.opcionesUsuario = opcionesUsuario;
    }

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
        this.algoKahoot.cargarRespuesta(new RespuestaGroupChoice(grupoA, grupoB));
    }
}