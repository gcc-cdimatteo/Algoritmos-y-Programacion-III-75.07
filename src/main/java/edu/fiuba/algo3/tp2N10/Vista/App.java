package edu.fiuba.algo3.tp2N10.Vista;


//import edu.fiuba.algo3.tp2N10.Controlador.BotonSeleccionarOpcion;

import edu.fiuba.algo3.tp2N10.Controlador.*;
import edu.fiuba.algo3.tp2N10.Modelo.AlgoKahoot.AlgoKahoot;
import edu.fiuba.algo3.tp2N10.Modelo.AlgoKahoot.Jugador;
import edu.fiuba.algo3.tp2N10.Modelo.AlgoKahoot.Ronda;
import edu.fiuba.algo3.tp2N10.Modelo.BolsaDePreguntas;
import edu.fiuba.algo3.tp2N10.Modelo.Pregunta.*;
import javafx.application.Application;
import javafx.application.Platform;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.*;


public class App extends Application {

    Stage escenario;

    public static void main(String[] args) {
        launch(args);
    }

    public void start(Stage stage) throws Exception {
        this.escenario = stage;

        this.escenario.setTitle("AlgoKahoot");

        ContenedorJugadores contenedorJugadores = new ContenedorJugadores(this);
        Scene escenaJugadores = new Scene(contenedorJugadores, 640, 480);

        ContenedorBienvenidos contenedorBienvenidos = new ContenedorBienvenidos(this.escenario, escenaJugadores);
        Scene escenaBienvenida = new Scene(contenedorBienvenidos, 640, 480);

        this.escenario.setScene(escenaBienvenida);
        this.escenario.show();
    }

    /////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    public List<Pregunta> setupPreguntasProvisorio() {

        PreguntaVerdaderoFalso preguntaVFUno = PreguntaVerdaderoFalso.Clasico("La manzana es azul", false);
        PreguntaVerdaderoFalso preguntaVFDos = PreguntaVerdaderoFalso.Clasico("La manzana es azul", false);
        PreguntaVerdaderoFalso preguntaVFTres = PreguntaVerdaderoFalso.Clasico("La manzana es azul", false);

        List<Pregunta> preguntas = new ArrayList<>();

        preguntas.add(preguntaVFUno);
        preguntas.add(preguntaVFDos);
        preguntas.add(preguntaVFTres);

        return preguntas;
    }
    ///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

    public void jugar(String nombreUno, String nombreDos) {

        //La creacion de la lista de preguntas deberia estar dentro del modelo. Por ahora uso una funcion provisoria para debuggear la UI
        //AlgoKahoot algoKahoot = new AlgoKahoot(setupPreguntasProvisorio(), nombreUno, nombreDos);
        //DEBUGGING

        // Nota:
        // Para prueba de los contenedores paseo por los tipos de pregunta. Algo similar a Bienvenida seguido
        // del nombre de los jugadores. Esto posiblemente lo maneje Ronda a pedido de AlgoKahoot.
        // Se pasa la pregunta y el jugador.
        try {
            BolsaDePreguntas bolsaDePreguntas = new BolsaDePreguntas("preguntas.json");
            ArrayList<Pregunta> preguntas = bolsaDePreguntas.getLista();
            Pregunta pregunta = preguntas.get(0); // 0,1: VF, 2,3,4: MC, 5:OC, 6:GC

            // Se crean jugador y ronda porque son necesarias segun el contexto luego.
            Jugador jugador = new Jugador(nombreUno);
            Ronda ronda = new Ronda(pregunta, jugador);

            ContenedorPregunta contenedorPregunta = new ContenedorPregunta(this, pregunta, jugador, ronda);
            Scene escenaPregunta = new Scene(contenedorPregunta, 640, 480);

            this.escenario.setScene(escenaPregunta);
            this.escenario.show();

        } catch (IOException e) {
            e.printStackTrace();
            System.exit(1); // Boom!
        }


//      AlgoKahootView algoKahootView = new AlgoKahootView(algoKahoot);



    }
}


//    public Scene escenaPreguntaVF(Ronda ronda) {
//
//        Label lblJugador = new Label("Jugador 1");
//        lblJugador.setStyle("-fx-font-size: 200%");
//        Label lblEnunciado = new Label(this.pregunta.getEnunciado());
//
//        ToggleGroup grupoOpciones = new ToggleGroup();
//        ToggleButton btnVerdadero = new ToggleButton("Verdadero");
//        ToggleButton btnFalso = new ToggleButton("Falso");
//
//        Button btnPowerUpX2 = new Button("x2");
//        Button btnPowerUpX3 = new Button("x3");
//        Button btnPowerUpEx1 = new Button("Exclusividad");
//        Button btnPowerUpEx2 = new Button("Exclusividad");
//        Button btnListo = new Button("Listo");
//
//        btnListo.setOnAction(new BotonResponderVF(btnVerdadero, btnFalso, ronda));
//
//        btnVerdadero.setToggleGroup(grupoOpciones);
//        //btnVerdadero.setStyle("-fx-base: lightgreen;");
//        btnFalso.setToggleGroup(grupoOpciones);
//        //btnFalso.setStyle("-fx-base: red;");
//
//        BorderPane bpPreguntaPowerUps = new BorderPane();
//
//        VBox vboxEnunciadoOpciones = new VBox(100);
//        vboxEnunciadoOpciones.getChildren().add(lblEnunciado);
//        HBox hboxOpciones = new HBox(25);
//        hboxOpciones.getChildren().addAll(btnVerdadero, btnFalso);
//        vboxEnunciadoOpciones.getChildren().add(hboxOpciones);
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
//        bpBotoneraListo.setStyle("-fx-background-color: #6495ed");
//        bpBotoneraListo.setRight(btnListo);
//        bpJugadorPreguntaLista.setBottom(bpBotoneraListo);
//
//        return new Scene(bpJugadorPreguntaLista, 640, 480);
//    }
//
////
//    public Scene escenaPreguntaMC(Ronda ronda) {
//        Label lblJugador = new Label("Jugador 1");
//        lblJugador.setStyle("-fx-font-size: 200%");
//        Label lblEnunciado = new Label(this.pregunta.getEnunciado());
//
//        Button btnPowerUpX2 = new Button("x2");
//        Button btnPowerUpX3 = new Button("x3");
//        Button btnPowerUpEx1 = new Button("Exclusividad");
//        Button btnPowerUpEx2 = new Button("Exclusividad");
//        Button btnListo = new Button("Listo");
//        ////////////////////////////////////////////
//
//        ArrayList<CheckBox> arrayChkOpciones = new ArrayList<>();
//        for (String op : this.pregunta.getOpciones()) {
//            arrayChkOpciones.add(new CheckBox(op));
//        }
//        btnListo.setOnAction(new BotonResponderMC(arrayChkOpciones, ronda));
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
//
//    public Scene escenaPreguntaOC(Ronda ronda) {
//        List<Integer> respuestaUsuario = new ArrayList<>();
//        Label lblJugador = new Label("Jugador 1");
//        lblJugador.setStyle("-fx-font-size: 200%");
//        Label lblEnunciado = new Label(this.pregunta.getEnunciado());
//
//        Button btnPowerUpX2 = new Button("x2");
//        Button btnPowerUpX3 = new Button("x3");
//        Button btnPowerUpEx1 = new Button("Exclusividad");
//        Button btnPowerUpEx2 = new Button("Exclusividad");
//        Button btnListo = new Button("Listo");
//
//        Label respuestaOrdenada = new Label("");
//        respuestaOrdenada.setStyle("-fx-font-size: 300%");
//        VBox opcionesRespuesta = new VBox(5);
//        opcionesRespuesta.getChildren().add(respuestaOrdenada);
//        opcionesRespuesta.setMaxHeight(300);
//        opcionesRespuesta.setMaxWidth(400);
//
//        ////////////////////////////////////////////
//        btnListo.setOnAction(new BotonResponderOC(ronda, respuestaUsuario, this.pregunta.getOpciones().size()));
//
//        ArrayList<Button> arrayChkOpciones = new ArrayList<>();
//        for (int i = 0; i < this.pregunta.getOpciones().size(); i++) {
//            Button boton = new Button(this.pregunta.getOpciones().get(i));
//            boton.setOnAction(new BotonSeleccionarOpcionOC(respuestaOrdenada, boton, i, respuestaUsuario));
//            arrayChkOpciones.add(boton);
//        }
//
//        BorderPane bpPreguntaPowerUps = new BorderPane();
//
//        VBox vboxEnunciadoOpciones = new VBox(100);
//        vboxEnunciadoOpciones.getChildren().add(lblEnunciado);
//        HBox hboxOpciones = new HBox(25);
//        for (Button chkOp : arrayChkOpciones) {
//            hboxOpciones.getChildren().addAll(chkOp);
//        }
//        vboxEnunciadoOpciones.getChildren().add(hboxOpciones);
//        VBox vboxPowerUps = new VBox(5);
//        vboxPowerUps.getChildren().addAll(btnPowerUpX2, btnPowerUpX3, btnPowerUpEx1, btnPowerUpEx2);
//        bpPreguntaPowerUps.setLeft(vboxEnunciadoOpciones);
//        bpPreguntaPowerUps.setRight(vboxPowerUps);
//        bpPreguntaPowerUps.setCenter(opcionesRespuesta);
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
//}
////
////    public Scene escenaPreguntaGC(Ronda ronda) {
////        Label lblJugador = new Label("Jugador 1");
////        lblJugador.setStyle("-fx-font-size: 200%");
////        Label lblEnunciado = new Label(this.pregunta.getEnunciado());
////        String grupoA = "Grupo A";
////        String grupoB = "Grupo B";
////
////        Button btnPowerUpX2 = new Button("x2");
////        Button btnPowerUpX3 = new Button("x3");
////        Button btnPowerUpEx1 = new Button("Exclusividad");
////        Button btnPowerUpEx2 = new Button("Exclusividad");
////        Button btnListo = new Button("Listo");
////        ////////////////////////////////////////////
////        btnListo.setOnAction(new BotonSalir());
////
////        BorderPane bpPreguntaPowerUps = new BorderPane();
////
////        VBox vboxEnunciadoOpciones = new VBox(100);
////        vboxEnunciadoOpciones.getChildren().add(lblEnunciado);
////        VBox vboxOpciones = new VBox(25);
////
////        for (String op : this.pregunta.getOpciones()) {
////            // Generar los radio buttons sengun las opciones.
////            RadioButton rdoGrupoA = new RadioButton(grupoA);
////            RadioButton rdoGrupoB = new RadioButton(grupoB);
////            rdoGrupoA.setSelected(true);
////            ToggleGroup agrupamiento = new ToggleGroup();
////            agrupamiento.getToggles().addAll(rdoGrupoA, rdoGrupoB);
////            HBox hboxRadioButtons = new HBox(20);
////            hboxRadioButtons.getChildren().addAll(rdoGrupoA, rdoGrupoB);
////            BorderPane bpOpcionMasRadio = new BorderPane();
////            bpOpcionMasRadio.setLeft(new Label(op));
////            bpOpcionMasRadio.setRight(hboxRadioButtons);
////            vboxOpciones.getChildren().add(bpOpcionMasRadio);
////        }
////
////        vboxEnunciadoOpciones.getChildren().add(vboxOpciones);
////        VBox vboxPowerUps = new VBox(5);
////        vboxPowerUps.getChildren().addAll(btnPowerUpX2, btnPowerUpX3, btnPowerUpEx1, btnPowerUpEx2);
////        bpPreguntaPowerUps.setLeft(vboxEnunciadoOpciones);
////        bpPreguntaPowerUps.setRight(vboxPowerUps);
////
////        BorderPane bpJugadorPreguntaLista = new BorderPane();
////        bpJugadorPreguntaLista.setPadding(new Insets(10, 10, 10, 10));
////        BorderPane bpJugador = new BorderPane();
////        bpJugador.setCenter(lblJugador);
////        bpJugador.setStyle("-fx-background-color: cornflowerblue");
////        bpJugadorPreguntaLista.setTop(bpJugador);
////        bpJugadorPreguntaLista.setCenter(bpPreguntaPowerUps);
////        BorderPane bpBotoneraListo = new BorderPane();
////        bpBotoneraListo.setStyle("-fx-background-color: cornflowerblue");
////        bpBotoneraListo.setRight(btnListo);
////        bpJugadorPreguntaLista.setBottom(bpBotoneraListo);
////
////        return new Scene(bpJugadorPreguntaLista, 640, 480);
////    }
////
////    public Scene escenaFinal() {
////        return null;
////    }
//
//
////    ///////////////// CODIGO DE EJEMPLO
////    public Scene escenaEjemplo() {
////        Label lblJugador = new Label("ESCENA EJEMPLO");
////        lblJugador.setStyle("-fx-font-size: 200%");
////        Label lblEnunciado = new Label(this.preguntaMC.getPregunta());
////
////        Button btnPowerUpX2 = new Button("x2");
////        Button btnPowerUpX3 = new Button("x3");
////        Button btnPowerUpEx1 = new Button("Exclusividad");
////        Button btnPowerUpEx2 = new Button("Exclusividad");
////        Button btnListo = new Button("Listo");
////        ////////////////////////////////////////////
////        btnListo.setOnAction(new BotonListoProvisorio(this));
////
////        ArrayList<CheckBox> arrayChkOpciones = new ArrayList<>();
////        for (String op : this.preguntaMC.getOpciones()) {
////            arrayChkOpciones.add(new CheckBox(op));
////        }
////
////        BorderPane bpPreguntaPowerUps = new BorderPane();
////
////        VBox vboxEnunciadoOpciones = new VBox(100);
////        vboxEnunciadoOpciones.getChildren().add(lblEnunciado);
////        VBox vboxOpciones = new VBox(25);
////        for (CheckBox chkOp : arrayChkOpciones) {
////            vboxOpciones.getChildren().addAll(chkOp);
////        }
////        vboxEnunciadoOpciones.getChildren().add(vboxOpciones);
////        VBox vboxPowerUps = new VBox(5);
////        vboxPowerUps.getChildren().addAll(btnPowerUpX2, btnPowerUpX3, btnPowerUpEx1, btnPowerUpEx2);
////        bpPreguntaPowerUps.setLeft(vboxEnunciadoOpciones);
////        bpPreguntaPowerUps.setRight(vboxPowerUps);
////
////        BorderPane bpJugadorPreguntaLista = new BorderPane();
////        bpJugadorPreguntaLista.setPadding(new Insets(10, 10, 10, 10));
////        BorderPane bpJugador = new BorderPane();
////        bpJugador.setCenter(lblJugador);
////        bpJugador.setStyle("-fx-background-color: cornflowerblue");
////        bpJugadorPreguntaLista.setTop(bpJugador);
////        bpJugadorPreguntaLista.setCenter(bpPreguntaPowerUps);
////        BorderPane bpBotoneraListo = new BorderPane();
////        bpBotoneraListo.setStyle("-fx-background-color: cornflowerblue");
////        bpBotoneraListo.setRight(btnListo);
////        bpJugadorPreguntaLista.setBottom(bpBotoneraListo);
////
////        return new Scene(bpJugadorPreguntaLista, 640, 480);
////    }
//}