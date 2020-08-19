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

public class BotonResponderGC extends BotonResponder {

    private final ArrayList<ToggleGroup> opcionesUsuario;

    public BotonResponderGC(AlgoKahoot algoKahoot, ArrayList<ToggleGroup> opcionesUsuario) {
        super(algoKahoot);
        this.opcionesUsuario = opcionesUsuario;
    }

    @Override
    public void handle(ActionEvent actionEvent) {
        usarPowerUp();
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
        this.algoKahoot.cargarRespuesta(new RespuestaGroupChoice(grupoA, grupoB));
    }
}