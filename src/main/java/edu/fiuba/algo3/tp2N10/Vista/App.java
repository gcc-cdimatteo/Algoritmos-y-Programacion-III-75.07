package edu.fiuba.algo3.tp2N10.Vista;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;


public class App extends Application {

    private Stage escenario;

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
   }

    //Escenas
    public Scene escenaPregunta() {
        Label label = new Label("Hola mundo JavaFX!");
        return new Scene(new StackPane(label), 640, 480);
    }
}