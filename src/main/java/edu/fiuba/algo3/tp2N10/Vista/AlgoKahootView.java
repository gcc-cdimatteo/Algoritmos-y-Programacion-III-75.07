package edu.fiuba.algo3.tp2N10.Vista;

import edu.fiuba.algo3.tp2N10.Modelo.AlgoKahoot.AlgoKahoot;
import edu.fiuba.algo3.tp2N10.Modelo.Observer;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class AlgoKahootView implements Observer {
    private final Stage escenario;
    private final AlgoKahoot algoKahoot;

    public AlgoKahootView(AlgoKahoot algoKahoot, Stage stage) {
        this.algoKahoot = algoKahoot;
        this.escenario = stage;
        algoKahoot.addObserver(this);
    }

    public void mostrar() {
        if(this.algoKahoot.finalizado()) {
            ContenedorPodio contenedorPodio = new ContenedorPodio(this.algoKahoot);
            Scene escenaPodio = new Scene(contenedorPodio, 640, 480);
            this.escenario.setScene(escenaPodio);
        }
        else {
            ContenedorPrincipal contenedorPrincipal = new ContenedorPrincipal(this.algoKahoot);
            Scene escenaPrincipal = new Scene(contenedorPrincipal, 640, 480);
            this.escenario.setScene(escenaPrincipal);
        }
    }

    @Override
    public void change() {
        this.mostrar();
    }
}
