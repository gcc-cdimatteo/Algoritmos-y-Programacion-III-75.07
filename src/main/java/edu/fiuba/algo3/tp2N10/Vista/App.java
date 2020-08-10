package edu.fiuba.algo3.tp2N10.Vista;


import edu.fiuba.algo3.tp2N10.Controlador.BotonListoProvisorio;
import edu.fiuba.algo3.tp2N10.Modelo.AlgoKahoot.Mostrable;
import edu.fiuba.algo3.tp2N10.Modelo.Pregunta.PreguntaMultipleChoice;
import edu.fiuba.algo3.tp2N10.Modelo.Pregunta.PreguntaVerdaderoFalso;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;


public class App extends Application {

    private Stage escenario;
    private Mostrable preguntaMC;
    private Mostrable preguntaVF;

    public void start(Stage stage) throws Exception {
        this.escenario = stage;
        this.setup();
        this.escenario.setScene(this.escenaPreguntaVF());
        this.escenario.show();
    }

    public static void main(String[] args) {
        launch(args);
    }

    public void setup() {
        this.escenario.setTitle("AlgoKahoot");

        Set<Integer> respuestasCorrectasMC = new HashSet<>(Arrays.asList(0, 2, 3));

        this.preguntaVF = PreguntaVerdaderoFalso.Clasico("La manzana es roja", true);
        this.preguntaMC = PreguntaMultipleChoice.Clasico("La manzana es...", Arrays.asList("Una Fruta", "Un Citrico", "Roja", "Azul"), respuestasCorrectasMC);
    }

    public void cambiarEscenaA(Scene nuevaEscena) {
        this.escenario.setScene(nuevaEscena);
    }

    //Escenas


    public Scene escenaBienvenida() {
        return null;
    }

    public Scene escenaRegistroJugadores() {
        return null;
    }

    public Scene escenaPreguntaVF() {
        Label lblJugador = new Label("Jugador 1");
        lblJugador.setStyle("-fx-font-size: 200%");
        Label lblEnunciado = new Label(this.preguntaVF.getPregunta());

        Button btnPowerUpX2 = new Button("x2");
        Button btnPowerUpX3 = new Button("x3");
        Button btnPowerUpEx1 = new Button("Exclusividad");
        Button btnPowerUpEx2 = new Button("Exclusividad");
        Button btnListo = new Button("Listo");
        ////////////////////////////////////////////
        btnListo.setOnAction(new BotonListoProvisorio(this));

        ArrayList<CheckBox> arrayChkOpciones = new ArrayList<>();
        for (String op : this.preguntaVF.getOpciones()) {
            arrayChkOpciones.add(new CheckBox(op));
        }

        BorderPane bpPreguntaPowerUps = new BorderPane();

        VBox vboxEnunciadoOpciones = new VBox(100);
        vboxEnunciadoOpciones.getChildren().add(lblEnunciado);
        HBox hboxOpciones = new HBox(25);
        for (CheckBox chkOp : arrayChkOpciones) {
            hboxOpciones.getChildren().addAll(chkOp);
        }
        vboxEnunciadoOpciones.getChildren().add(hboxOpciones);
        VBox vboxPowerUps = new VBox(5);
        vboxPowerUps.getChildren().addAll(btnPowerUpX2, btnPowerUpX3, btnPowerUpEx1, btnPowerUpEx2);
        bpPreguntaPowerUps.setLeft(vboxEnunciadoOpciones);
        bpPreguntaPowerUps.setRight(vboxPowerUps);

        BorderPane bpJugadorPreguntaLista = new BorderPane();
        bpJugadorPreguntaLista.setPadding(new Insets(10, 10, 10, 10));
        BorderPane bpJugador = new BorderPane();
        bpJugador.setCenter(lblJugador);
        bpJugador.setStyle("-fx-background-color: cornflowerblue");
        bpJugadorPreguntaLista.setTop(bpJugador);
        bpJugadorPreguntaLista.setCenter(bpPreguntaPowerUps);
        BorderPane bpBotoneraListo = new BorderPane();
        bpBotoneraListo.setStyle("-fx-background-color: cornflowerblue");
        bpBotoneraListo.setRight(btnListo);
        bpJugadorPreguntaLista.setBottom(bpBotoneraListo);

        return new Scene(bpJugadorPreguntaLista, 640, 480);
    }

    public Scene escenaPreguntaMC() {
        Label lblJugador = new Label("Jugador 1");
        lblJugador.setStyle("-fx-font-size: 200%");
        Label lblEnunciado = new Label(this.preguntaMC.getPregunta());

        Button btnPowerUpX2 = new Button("x2");
        Button btnPowerUpX3 = new Button("x3");
        Button btnPowerUpEx1 = new Button("Exclusividad");
        Button btnPowerUpEx2 = new Button("Exclusividad");
        Button btnListo = new Button("Listo");
        ////////////////////////////////////////////
        btnListo.setOnAction(new BotonListoProvisorio(this));

        ArrayList<CheckBox> arrayChkOpciones = new ArrayList<>();
        for (String op : this.preguntaMC.getOpciones()) {
            arrayChkOpciones.add(new CheckBox(op));
        }

        BorderPane bpPreguntaPowerUps = new BorderPane();

        VBox vboxEnunciadoOpciones = new VBox(100);
        vboxEnunciadoOpciones.getChildren().add(lblEnunciado);
        VBox vboxOpciones = new VBox(25);
        for (CheckBox chkOp : arrayChkOpciones) {
            vboxOpciones.getChildren().addAll(chkOp);
        }
        vboxEnunciadoOpciones.getChildren().add(vboxOpciones);
        VBox vboxPowerUps = new VBox(5);
        vboxPowerUps.getChildren().addAll(btnPowerUpX2, btnPowerUpX3, btnPowerUpEx1, btnPowerUpEx2);
        bpPreguntaPowerUps.setLeft(vboxEnunciadoOpciones);
        bpPreguntaPowerUps.setRight(vboxPowerUps);

        BorderPane bpJugadorPreguntaLista = new BorderPane();
        bpJugadorPreguntaLista.setPadding(new Insets(10, 10, 10, 10));
        BorderPane bpJugador = new BorderPane();
        bpJugador.setCenter(lblJugador);
        bpJugador.setStyle("-fx-background-color: cornflowerblue");
        bpJugadorPreguntaLista.setTop(bpJugador);
        bpJugadorPreguntaLista.setCenter(bpPreguntaPowerUps);
        BorderPane bpBotoneraListo = new BorderPane();
        bpBotoneraListo.setStyle("-fx-background-color: cornflowerblue");
        bpBotoneraListo.setRight(btnListo);
        bpJugadorPreguntaLista.setBottom(bpBotoneraListo);

        return new Scene(bpJugadorPreguntaLista, 640, 480);
    }

    public Scene escenaPreguntaOC() {
        return null;
    }

    public Scene escenaPreguntaGC() {
        return null;
    }

    public Scene escenaFinal() {
        return null;
    }


    ///////////////// CODIGO DE EJEMPLO
    public Scene escenaEjemplo() {
        Label lblJugador = new Label("ESCENA EJEMPLO");
        lblJugador.setStyle("-fx-font-size: 200%");
        Label lblEnunciado = new Label(this.preguntaMC.getPregunta());

        Button btnPowerUpX2 = new Button("x2");
        Button btnPowerUpX3 = new Button("x3");
        Button btnPowerUpEx1 = new Button("Exclusividad");
        Button btnPowerUpEx2 = new Button("Exclusividad");
        Button btnListo = new Button("Listo");
        ////////////////////////////////////////////
        btnListo.setOnAction(new BotonListoProvisorio(this));

        ArrayList<CheckBox> arrayChkOpciones = new ArrayList<>();
        for (String op : this.preguntaMC.getOpciones()) {
            arrayChkOpciones.add(new CheckBox(op));
        }

        BorderPane bpPreguntaPowerUps = new BorderPane();

        VBox vboxEnunciadoOpciones = new VBox(100);
        vboxEnunciadoOpciones.getChildren().add(lblEnunciado);
        VBox vboxOpciones = new VBox(25);
        for (CheckBox chkOp : arrayChkOpciones) {
            vboxOpciones.getChildren().addAll(chkOp);
        }
        vboxEnunciadoOpciones.getChildren().add(vboxOpciones);
        VBox vboxPowerUps = new VBox(5);
        vboxPowerUps.getChildren().addAll(btnPowerUpX2, btnPowerUpX3, btnPowerUpEx1, btnPowerUpEx2);
        bpPreguntaPowerUps.setLeft(vboxEnunciadoOpciones);
        bpPreguntaPowerUps.setRight(vboxPowerUps);

        BorderPane bpJugadorPreguntaLista = new BorderPane();
        bpJugadorPreguntaLista.setPadding(new Insets(10, 10, 10, 10));
        BorderPane bpJugador = new BorderPane();
        bpJugador.setCenter(lblJugador);
        bpJugador.setStyle("-fx-background-color: cornflowerblue");
        bpJugadorPreguntaLista.setTop(bpJugador);
        bpJugadorPreguntaLista.setCenter(bpPreguntaPowerUps);
        BorderPane bpBotoneraListo = new BorderPane();
        bpBotoneraListo.setStyle("-fx-background-color: cornflowerblue");
        bpBotoneraListo.setRight(btnListo);
        bpJugadorPreguntaLista.setBottom(bpBotoneraListo);

        return new Scene(bpJugadorPreguntaLista, 640, 480);
    }
}