package edu.fiuba.algo3.tp2N10.Controlador;

import edu.fiuba.algo3.tp2N10.Modelo.AlgoKahoot.AlgoKahoot;
import edu.fiuba.algo3.tp2N10.Modelo.AlgoKahoot.Ronda;
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

    private AlgoKahoot algoKahoot;
    private ArrayList<ToggleGroup> opcionesUsuario;
    private RespuestaGroupChoice respuesta;

    public BotonResponderGC(AlgoKahoot algoKahoot, ArrayList<ToggleGroup> opcionesUsuario){
        this.opcionesUsuario = opcionesUsuario;
        this.algoKahoot = algoKahoot;
    }

    @Override
    public void handle(ActionEvent actionEvent) {
        Set<Integer> grupoA = new HashSet<>();
        Set<Integer> grupoB = new HashSet<>();
        for(int i = 0; i < opcionesUsuario.size(); i++){
            ObservableList<Toggle> botones = opcionesUsuario.get(i).getToggles();
            if ((botones.get(0).isSelected())) {
                grupoA.add(i + 1);
            } else {
                grupoB.add(i + 1);
            }
        }
        this.respuesta = new RespuestaGroupChoice(grupoA, grupoB);
        this.algoKahoot.cargarRespuesta(this.respuesta);
    }
}