package edu.fiuba.algo3.tp2N10.Vista;


import edu.fiuba.algo3.tp2N10.RespuestaVerdaderoFalso;
import edu.fiuba.algo3.tp2N10.VerdaderoFalso;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;


public class App extends Application {

    private Stage escenario;
    private VerdaderoFalso pregunta;

    public void start(Stage stage) throws Exception {
        this.escenario = stage;
        this.setup();
        this.escenario.setScene(this.escenaPregunta());
        this.escenario.show();
    }

    public static void main(String[] args) {
        launch(args);
    }

    public void setup(){
        this.escenario.setTitle("AlgoKahoot");
        this.pregunta = new VerdaderoFalso("Verde es un color",new RespuestaVerdaderoFalso(true));
    }

    //Escenas
    public Scene escenaPregunta(){
//        Label label = new Label(this.pregunta.getEnunciado());
        Label label = new Label("Prueba");
        Scene escenario = new Scene(new StackPane(label), 640, 480);
        return escenario;
    }


}