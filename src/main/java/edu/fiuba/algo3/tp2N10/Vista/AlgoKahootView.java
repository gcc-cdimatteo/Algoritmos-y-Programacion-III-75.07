package edu.fiuba.algo3.tp2N10.Vista;

import edu.fiuba.algo3.tp2N10.Modelo.AlgoKahoot.AlgoKahoot;
import edu.fiuba.algo3.tp2N10.Modelo.Observer;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class AlgoKahootView implements Observer {
    private Stage escenario;
    private AlgoKahoot algoKahoot;

    public AlgoKahootView(AlgoKahoot algoKahoot, Stage stage) {
        this.algoKahoot = algoKahoot;
        this.escenario = stage;
        algoKahoot.addObserver(this);
    }

    public void mostrar() {
        ContenedorPrincipal contenedorPrincipal = new ContenedorPrincipal(this.algoKahoot);
        Scene escenaPrincipal = new Scene(contenedorPrincipal, 640, 480);
        this.escenario.setScene(escenaPrincipal);
    }

    @Override
    public void change() {
        this.mostrar();
    }
}
