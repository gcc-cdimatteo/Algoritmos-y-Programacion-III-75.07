package edu.fiuba.algo3.tp2N10.Controlador.EventHandlers;

import edu.fiuba.algo3.tp2N10.Controlador.Alertas.AlertaOrdenarTodasLasOpcionesOC;
import edu.fiuba.algo3.tp2N10.Modelo.AlgoKahoot.AlgoKahoot;
import edu.fiuba.algo3.tp2N10.Modelo.Respuesta.RespuestaOrderedChoice;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.media.Media;
import javafx.scene.media.MediaException;
import javafx.scene.media.MediaPlayer;

import java.io.File;
import java.util.List;
import java.util.Timer;
import java.util.concurrent.atomic.AtomicBoolean;

public class BotonResponderOC implements EventHandler<ActionEvent> {
    private final List<Integer> respuestaUsuario;
    private final List<Button> botones;
    private final AlgoKahoot algoKahoot;
    private final Timer temporizador;
    private AtomicBoolean sinTiempo;

    public BotonResponderOC(AlgoKahoot algoKahoot, List<Integer> respuestaUsuario, List<Button> botones, Timer temporizador, AtomicBoolean sinTiempo){
        this.algoKahoot = algoKahoot;
        this.respuestaUsuario = respuestaUsuario;
        this.botones = botones;
        this.temporizador = temporizador;
        this.sinTiempo = sinTiempo;
    }

    public void handle(ActionEvent actionEvent) {
        for (Button boton : botones) {

            if (boton.isVisible() && sinTiempo.get()){
                temporizador.cancel();
                try {
                    MediaPlayer reproductor = new MediaPlayer(new Media(new File("./resources/audio/sinrespuesta.mp3").toURI().toString()));
                    reproductor.setVolume(0.6);
                    reproductor.play();
                } catch (MediaException ignored) {}
                algoKahoot.jugadorNoResponde();
                return;
            }
            else if (boton.isVisible()) {
                AlertaOrdenarTodasLasOpcionesOC alertaOrdenarTodasLasOpcionesOC = new AlertaOrdenarTodasLasOpcionesOC();
                alertaOrdenarTodasLasOpcionesOC.mostrar();
                return;
            }
        }
        this.temporizador.cancel();
        try {
            MediaPlayer reproductor = new MediaPlayer(new Media(new File("./resources/audio/click.mp3").toURI().toString()));
            reproductor.setVolume(0.6);
            reproductor.play();
        } catch (MediaException ignored) {}
        this.algoKahoot.cargarRespuesta(new RespuestaOrderedChoice(this.respuestaUsuario));
    }
}
