package edu.fiuba.algo3.tp2N10.Vista;


import edu.fiuba.algo3.tp2N10.Controlador.BotonListoProvisorio;
import edu.fiuba.algo3.tp2N10.Modelo.AlgoKahoot.Mostrable;
import edu.fiuba.algo3.tp2N10.Modelo.Pregunta.PreguntaMultipleChoice;
import edu.fiuba.algo3.tp2N10.Modelo.Pregunta.PreguntaVerdaderoFalso;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.Border;
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
        this.escenario.setScene(this.escenaRegistroJugadores());
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
        Label lblRegistroJugadores = new Label("Registro de Jugadores");
        lblRegistroJugadores.setStyle("-fx-font-size: 200%");
        BorderPane bpHeader = new BorderPane();
        bpHeader.setCenter(lblRegistroJugadores);
        bpHeader.setStyle("-fx-background-color: cornflowerblue");

        BorderPane bpHeaderIngresoDatosBoton = new BorderPane();
        bpHeaderIngresoDatosBoton.setTop(bpHeader);

        BorderPane bpRegistro = new BorderPane();
        bpRegistro.setPadding(new Insets(100, 100, 100, 100));
        VBox vboxJugadores = new VBox(10);
        HBox hboxNombre1 = new HBox(10);
        hboxNombre1.getChildren().addAll(
                new Label("Nombre Jugador 1: "),
                new TextField());
        HBox hboxNombre2 = new HBox(10);
        hboxNombre2.getChildren().addAll(
                new Label("Nombre Jugador 2: "),
                new TextField());
        vboxJugadores.getChildren().addAll(hboxNombre1, hboxNombre2);
        bpRegistro.setCenter(vboxJugadores);

        bpHeaderIngresoDatosBoton.setCenter(bpRegistro);

        // botonera Empezar a Jugar
        Button btnJugar = new Button("Empezar a Jugar");
        btnJugar.setOnAction(new BotonListoProvisorio(this));
        BorderPane bpBotoneraJugar = new BorderPane();
        bpBotoneraJugar.setStyle("-fx-background-color: cornflowerblue");
        bpBotoneraJugar.setRight(btnJugar);
        bpHeaderIngresoDatosBoton.setBottom(bpBotoneraJugar);

        return new Scene(bpHeaderIngresoDatosBoton, 640, 480);
    }

    public Scene escenaPreguntaVF() {
        Label lblJugador = new Label("Jugador 1");
        lblJugador.setStyle("-fx-font-size: 200%");
        Label lblEnunciado = new Label(this.preguntaVF.getPregunta());

        ToggleGroup grupoOpciones = new ToggleGroup();
        ToggleButton btnVerdadero = new ToggleButton("Verdadero");
        ToggleButton btnFalso = new ToggleButton("Falso");

        Button btnPowerUpX2 = new Button("x2");
        Button btnPowerUpX3 = new Button("x3");
        Button btnPowerUpEx1 = new Button("Exclusividad");
        Button btnPowerUpEx2 = new Button("Exclusividad");
        Button btnListo = new Button("Listo");


        btnListo.setOnAction(new BotonListoProvisorio(this));

        btnVerdadero.setToggleGroup(grupoOpciones);
        //btnVerdadero.setStyle("-fx-base: lightgreen;");
        btnFalso.setToggleGroup(grupoOpciones);
        //btnFalso.setStyle("-fx-base: red;");

        BorderPane bpPreguntaPowerUps = new BorderPane();

        VBox vboxEnunciadoOpciones = new VBox(100);
        vboxEnunciadoOpciones.getChildren().add(lblEnunciado);
        HBox hboxOpciones = new HBox(25);
        hboxOpciones.getChildren().addAll(btnVerdadero, btnFalso);
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
        Label lblJugador = new Label("Jugador 1");
        lblJugador.setStyle("-fx-font-size: 200%");
        Label lblEnunciado = new Label("Enunciado de pregunta Group Choice, uso opciones de MC por el momento");
        String grupoA = "Grupo A";
        String grupoB = "Grupo B";

        Button btnPowerUpX2 = new Button("x2");
        Button btnPowerUpX3 = new Button("x3");
        Button btnPowerUpEx1 = new Button("Exclusividad");
        Button btnPowerUpEx2 = new Button("Exclusividad");
        Button btnListo = new Button("Listo");
        ////////////////////////////////////////////
        btnListo.setOnAction(new BotonListoProvisorio(this));

        BorderPane bpPreguntaPowerUps = new BorderPane();

        VBox vboxEnunciadoOpciones = new VBox(100);
        vboxEnunciadoOpciones.getChildren().add(lblEnunciado);
        VBox vboxOpciones = new VBox(25);

        for (String op : this.preguntaMC.getOpciones()) {
            // Generar los radio buttons sengun las opciones.
            RadioButton rdoGrupoA = new RadioButton(grupoA);
            RadioButton rdoGrupoB = new RadioButton(grupoB);
            rdoGrupoA.setSelected(true);
            ToggleGroup agrupamiento = new ToggleGroup();
            agrupamiento.getToggles().addAll(rdoGrupoA, rdoGrupoB);
            HBox hboxRadioButtons = new HBox(20);
            hboxRadioButtons.getChildren().addAll(rdoGrupoA, rdoGrupoB);
            BorderPane bpOpcionMasRadio = new BorderPane();
            bpOpcionMasRadio.setLeft(new Label(op));
            bpOpcionMasRadio.setRight(hboxRadioButtons);
            vboxOpciones.getChildren().add(bpOpcionMasRadio);
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