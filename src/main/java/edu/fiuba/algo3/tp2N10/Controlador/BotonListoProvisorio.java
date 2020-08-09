package edu.fiuba.algo3.tp2N10.Controlador;

import edu.fiuba.algo3.tp2N10.Vista.App;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;



///////////////// CODIGO DE EJEMPLO
public class BotonListoProvisorio implements EventHandler<ActionEvent> {
    App app;

    public BotonListoProvisorio(App app){
        this.app = app;
    }

    @Override
    public void handle(ActionEvent actionEvent) {
        this.app.cambiarEscenaA(app.escenaEjemplo());
    }

}
