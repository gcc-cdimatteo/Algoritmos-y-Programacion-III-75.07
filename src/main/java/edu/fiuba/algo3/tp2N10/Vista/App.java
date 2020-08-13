package edu.fiuba.algo3.tp2N10.Vista;


//import edu.fiuba.algo3.tp2N10.Controlador.BotonSeleccionarOpcion;

import edu.fiuba.algo3.tp2N10.Controlador.BotonComenzarJuego;
import edu.fiuba.algo3.tp2N10.Controlador.BotonResponderMC;
import edu.fiuba.algo3.tp2N10.Controlador.BotonResponderVF;
import edu.fiuba.algo3.tp2N10.Controlador.BotonSalir;
import edu.fiuba.algo3.tp2N10.Modelo.AlgoKahoot.Jugador;
import edu.fiuba.algo3.tp2N10.Modelo.Pregunta.Mostrable;
import edu.fiuba.algo3.tp2N10.Modelo.Pregunta.PreguntaMultipleChoice;
import edu.fiuba.algo3.tp2N10.Modelo.Pregunta.PreguntaOrderedChoice;
import edu.fiuba.algo3.tp2N10.Modelo.Pregunta.PreguntaVerdaderoFalso;
import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.stage.Stage;

import java.util.*;


public class App extends Application {
    private List<Jugador> jugadores;
    private Stage escenario;

    private Mostrable pregunta;



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

        Jugador jugadorUno = new Jugador("Jugador Uno");
        Jugador jugadorDos = new Jugador("Jugador Dos");
        this.jugadores = Arrays.asList(jugadorUno, jugadorDos);

        Set<Integer> respuestasCorrectasMC = new HashSet<>(Arrays.asList(0, 2, 3));
//        this.preguntaMC = PreguntaMultipleChoice.Clasico("La manzana es...", Arrays.asList("Una Fruta", "Un Citrico", "Roja", "Azul"), respuestasCorrectasMC);
//        this.preguntaOC = new PreguntaOrderedChoice("El orden de las letras del abecedario es...", Arrays.asList("B", "C", "A"), Arrays.asList(1, 2, 3));
    }

    public void nombrarJugadores(String nombreUno, String nombreDos) {
        this.jugadores.get(0).nombrar(nombreUno);
        this.jugadores.get(1).nombrar(nombreDos);
    }

    public void jugar() {

        //llamo a bolsa de preguntas
        this.pregunta = PreguntaVerdaderoFalso.Clasico("La manzana es una fruta",true);
   //     ronda = new Ronda(this.jugadores);

        this.cambiarEscenaA(this.escenaPreguntaVF());


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


        TextField nombreUno = new TextField();
        HBox hboxNombre1 = new HBox(10);
        hboxNombre1.getChildren().addAll(new Label("Nombre Jugador 1: "), nombreUno);

        TextField nombreDos = new TextField();
        HBox hboxNombre2 = new HBox(10);
        hboxNombre1.getChildren().addAll(new Label("Nombre Jugador 2: "), nombreDos);


        vboxJugadores.getChildren().addAll(hboxNombre1, hboxNombre2);
        bpRegistro.setCenter(vboxJugadores);

        bpHeaderIngresoDatosBoton.setCenter(bpRegistro);

        // botonera Empezar a Jugar
        Button btnJugar = new Button("Empezar a Jugar");
        btnJugar.setOnAction(new BotonComenzarJuego(nombreUno, nombreDos, this));
        BorderPane bpBotoneraJugar = new BorderPane();
        bpBotoneraJugar.setStyle("-fx-background-color: cornflowerblue");
        bpBotoneraJugar.setRight(btnJugar);
        bpHeaderIngresoDatosBoton.setBottom(bpBotoneraJugar);

        return new Scene(bpHeaderIngresoDatosBoton, 640, 480);
    }

    public Scene escenaPreguntaVF() {

        Label lblJugador = new Label("Jugador 1");
        lblJugador.setStyle("-fx-font-size: 200%");
        Label lblEnunciado = new Label(this.pregunta.getEnunciado());

        ToggleGroup grupoOpciones = new ToggleGroup();
        ToggleButton btnVerdadero = new ToggleButton("Verdadero");
        ToggleButton btnFalso = new ToggleButton("Falso");

        Button btnPowerUpX2 = new Button("x2");
        Button btnPowerUpX3 = new Button("x3");
        Button btnPowerUpEx1 = new Button("Exclusividad");
        Button btnPowerUpEx2 = new Button("Exclusividad");
        Button btnListo = new Button("Listo");

        btnListo.setOnAction(new BotonResponderVF(btnVerdadero, btnFalso));

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
        bpBotoneraListo.setStyle("-fx-background-color: #6495ed");
        bpBotoneraListo.setRight(btnListo);
        bpJugadorPreguntaLista.setBottom(bpBotoneraListo);

        return new Scene(bpJugadorPreguntaLista, 640, 480);
    }

//
//    public Scene escenaPreguntaMC() {
//        Label lblJugador = new Label("Jugador 1");
//        lblJugador.setStyle("-fx-font-size: 200%");
//        Label lblEnunciado = new Label(this.preguntaMC.getPregunta());
//
//        Button btnPowerUpX2 = new Button("x2");
//        Button btnPowerUpX3 = new Button("x3");
//        Button btnPowerUpEx1 = new Button("Exclusividad");
//        Button btnPowerUpEx2 = new Button("Exclusividad");
//        Button btnListo = new Button("Listo");
//        ////////////////////////////////////////////
//
//        ArrayList<CheckBox> arrayChkOpciones = new ArrayList<>();
//        for (String op : this.preguntaMC.getOpciones()) {
//            arrayChkOpciones.add(new CheckBox(op));
//        }
//        btnListo.setOnAction(new BotonResponderMC(arrayChkOpciones));
//
//        BorderPane bpPreguntaPowerUps = new BorderPane();
//
//        VBox vboxEnunciadoOpciones = new VBox(100);
//        vboxEnunciadoOpciones.getChildren().add(lblEnunciado);
//        VBox vboxOpciones = new VBox(25);
//        for (CheckBox chkOp : arrayChkOpciones) {
//            vboxOpciones.getChildren().addAll(chkOp);
//        }
//        vboxEnunciadoOpciones.getChildren().add(vboxOpciones);
//        VBox vboxPowerUps = new VBox(5);
//        vboxPowerUps.getChildren().addAll(btnPowerUpX2, btnPowerUpX3, btnPowerUpEx1, btnPowerUpEx2);
//        bpPreguntaPowerUps.setLeft(vboxEnunciadoOpciones);
//        bpPreguntaPowerUps.setRight(vboxPowerUps);
//
//        BorderPane bpJugadorPreguntaLista = new BorderPane();
//        bpJugadorPreguntaLista.setPadding(new Insets(10, 10, 10, 10));
//        BorderPane bpJugador = new BorderPane();
//        bpJugador.setCenter(lblJugador);
//        bpJugador.setStyle("-fx-background-color: cornflowerblue");
//        bpJugadorPreguntaLista.setTop(bpJugador);
//        bpJugadorPreguntaLista.setCenter(bpPreguntaPowerUps);
//        BorderPane bpBotoneraListo = new BorderPane();
//        bpBotoneraListo.setStyle("-fx-background-color: cornflowerblue");
//        bpBotoneraListo.setRight(btnListo);
//        bpJugadorPreguntaLista.setBottom(bpBotoneraListo);
//
//        return new Scene(bpJugadorPreguntaLista, 640, 480);
//    }

    public Scene escenaPreguntaOC() {
        Label lblJugador = new Label("Jugador 1");
        lblJugador.setStyle("-fx-font-size: 200%");
        Label lblEnunciado = new Label(this.preguntaOC.getPregunta());

        Button btnPowerUpX2 = new Button("x2");
        Button btnPowerUpX3 = new Button("x3");
        Button btnPowerUpEx1 = new Button("Exclusividad");
        Button btnPowerUpEx2 = new Button("Exclusividad");
        Button btnListo = new Button("Listo");

        ListView<String> listaOrdenada = new ListView<String>();
        ObservableList<String> items = FXCollections.observableArrayList ();
        listaOrdenada.setItems(items);
        listaOrdenada.setPrefWidth(100);
        VBox opcionesRespuesta = new VBox(200);
        opcionesRespuesta.getChildren().add(listaOrdenada);
        BorderPane bpOpcionesOrdenadas = new BorderPane();
        bpOpcionesOrdenadas.setMaxHeight(100);
        bpOpcionesOrdenadas.setCenter(opcionesRespuesta);
        ////////////////////////////////////////////
        btnListo.setOnAction(new BotonListoProvisorio(this));

        ArrayList<Button> arrayChkOpciones = new ArrayList<>();
        for (String op : this.preguntaOC.getOpciones()) {
            Button boton = new Button(op);
            boton.setOnAction(new BotonSeleccionarOpcion(listaOrdenada, boton));
            arrayChkOpciones.add(boton);
        }

        BorderPane bpPreguntaPowerUps = new BorderPane();

        VBox vboxEnunciadoOpciones = new VBox(100);
        vboxEnunciadoOpciones.getChildren().add(lblEnunciado);
        HBox hboxOpciones = new HBox(25);
        for (Button chkOp : arrayChkOpciones) {
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
        bpJugadorPreguntaLista.setLeft(bpOpcionesOrdenadas);
        BorderPane bpBotoneraListo = new BorderPane();
        bpBotoneraListo.setStyle("-fx-background-color: cornflowerblue");
        bpBotoneraListo.setRight(btnListo);
        bpJugadorPreguntaLista.setBottom(bpBotoneraListo);

        return new Scene(bpJugadorPreguntaLista, 640, 480);
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

//    public Scene escenaFinal() {
//        return null;
//    }


//    ///////////////// CODIGO DE EJEMPLO
//    public Scene escenaEjemplo() {
//        Label lblJugador = new Label("ESCENA EJEMPLO");
//        lblJugador.setStyle("-fx-font-size: 200%");
//        Label lblEnunciado = new Label(this.preguntaMC.getPregunta());
//
//        Button btnPowerUpX2 = new Button("x2");
//        Button btnPowerUpX3 = new Button("x3");
//        Button btnPowerUpEx1 = new Button("Exclusividad");
//        Button btnPowerUpEx2 = new Button("Exclusividad");
//        Button btnListo = new Button("Listo");
//        ////////////////////////////////////////////
//        btnListo.setOnAction(new BotonListoProvisorio(this));
//
//        ArrayList<CheckBox> arrayChkOpciones = new ArrayList<>();
//        for (String op : this.preguntaMC.getOpciones()) {
//            arrayChkOpciones.add(new CheckBox(op));
//        }
//
//        BorderPane bpPreguntaPowerUps = new BorderPane();
//
//        VBox vboxEnunciadoOpciones = new VBox(100);
//        vboxEnunciadoOpciones.getChildren().add(lblEnunciado);
//        VBox vboxOpciones = new VBox(25);
//        for (CheckBox chkOp : arrayChkOpciones) {
//            vboxOpciones.getChildren().addAll(chkOp);
//        }
//        vboxEnunciadoOpciones.getChildren().add(vboxOpciones);
//        VBox vboxPowerUps = new VBox(5);
//        vboxPowerUps.getChildren().addAll(btnPowerUpX2, btnPowerUpX3, btnPowerUpEx1, btnPowerUpEx2);
//        bpPreguntaPowerUps.setLeft(vboxEnunciadoOpciones);
//        bpPreguntaPowerUps.setRight(vboxPowerUps);
//
//        BorderPane bpJugadorPreguntaLista = new BorderPane();
//        bpJugadorPreguntaLista.setPadding(new Insets(10, 10, 10, 10));
//        BorderPane bpJugador = new BorderPane();
//        bpJugador.setCenter(lblJugador);
//        bpJugador.setStyle("-fx-background-color: cornflowerblue");
//        bpJugadorPreguntaLista.setTop(bpJugador);
//        bpJugadorPreguntaLista.setCenter(bpPreguntaPowerUps);
//        BorderPane bpBotoneraListo = new BorderPane();
//        bpBotoneraListo.setStyle("-fx-background-color: cornflowerblue");
//        bpBotoneraListo.setRight(btnListo);
//        bpJugadorPreguntaLista.setBottom(bpBotoneraListo);
//
//        return new Scene(bpJugadorPreguntaLista, 640, 480);
//    }
}