package edu.fiuba.algo3.tp2N10.Controlador.EventHandlers;

import edu.fiuba.algo3.tp2N10.Controlador.Alertas.AlertaOrdenarTodasLasOpcionesOC;
import edu.fiuba.algo3.tp2N10.Modelo.AlgoKahoot.AlgoKahoot;
import edu.fiuba.algo3.tp2N10.Modelo.Respuesta.RespuestaOrderedChoice;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;

import java.util.List;
import java.util.Timer;

public class BotonResponderOC implements EventHandler<ActionEvent> {
    private final List<Integer> respuestaUsuario;
    private final List<Button> botones;
    private final AlgoKahoot algoKahoot;
    private final Timer temporizador;

    public BotonResponderOC(AlgoKahoot algoKahoot, List<Integer> respuestaUsuario, List<Button> botones, Timer temporizador){
        this.algoKahoot = algoKahoot;
        this.respuestaUsuario = respuestaUsuario;
        this.botones = botones;
        this.temporizador = temporizador;
    }

    public void handle(ActionEvent actionEvent) {
        for (Button boton : botones) {
            if (boton.isVisible()) {
                AlertaOrdenarTodasLasOpcionesOC alertaOrdenarTodasLasOpcionesOC = new AlertaOrdenarTodasLasOpcionesOC();
                alertaOrdenarTodasLasOpcionesOC.mostrar();
                return;
            }
        }
        this.algoKahoot.cargarRespuesta(new RespuestaOrderedChoice(this.respuestaUsuario));
        this.temporizador.cancel();
    }
}
