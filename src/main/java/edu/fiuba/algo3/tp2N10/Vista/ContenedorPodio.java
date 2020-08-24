package edu.fiuba.algo3.tp2N10.Vista;

import edu.fiuba.algo3.tp2N10.Controlador.EventHandlers.BotonSalir;
import edu.fiuba.algo3.tp2N10.Modelo.AlgoKahoot.AlgoKahoot;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.List;

public class ContenedorPodio extends BorderPane {

    public ContenedorPodio(AlgoKahoot algoKahoot) {
        super();

        //Barra superior
        Label labelPodio = new Label("Podio");
        labelPodio.setFont(Font.font("Tahoma", FontWeight.BOLD, 30));
        labelPodio.setTextFill(Color.rgb(255, 255, 255));

        BorderPane bpHeader = new BorderPane();
        bpHeader.setCenter(labelPodio);
        bpHeader.setStyle("-fx-background-color: cornflowerblue");
        bpHeader.setMinHeight(50);

        //Contenido
        List<String> nombres = algoKahoot.nombres();
        List<Integer> puntajes = algoKahoot.puntajes();

        //Jugador Uno
        Label labelJugadorUno = armarJugadorLables(nombres.get(0), 200, Pos.CENTER_LEFT);
        Label labelPuntajeUno = armarJugadorLables(String.valueOf(puntajes.get(0)), 50, Pos.CENTER_RIGHT);

        //Jugador Uno
        Label labelJugadorDos = armarJugadorLables(nombres.get(1), 200, Pos.CENTER_LEFT);
        Label labelPuntajeDos = armarJugadorLables(String.valueOf(puntajes.get(1)), 50, Pos.CENTER_RIGHT);

        //Podio
        HBox hbPrimero;
        HBox hbSegundo;
        String pathImagePrimero = "./resources/images/primerpuesto.png";
        String pathImageSegundo = "./resources/images/segundopuesto.png";
        boolean empate = false;

        Label labelPrimero = armarPodioLabels("Primer puesto", Pos.CENTER);
        Label labelSegundo = armarPodioLabels("Segundo puesto", Pos.CENTER);
        Label labelEmpate = armarPodioLabels("Empate", Pos.CENTER);

        if (puntajes.get(0) > puntajes.get(1)) {
            hbPrimero = new HBox(labelJugadorUno,labelPuntajeUno);
            hbSegundo = new HBox(labelJugadorDos,labelPuntajeDos);
        } else if (puntajes.get(0) < puntajes.get(1)) {
            hbPrimero = new HBox(labelJugadorDos,labelPuntajeDos);
            hbSegundo = new HBox(labelJugadorUno,labelPuntajeUno);
        } else {
            hbPrimero = new HBox(labelJugadorUno,labelPuntajeUno);
            hbSegundo = new HBox(labelJugadorDos,labelPuntajeDos);
            pathImagePrimero = "./resources/images/empateuno.png";
            pathImageSegundo = "./resources/images/empatedos.png";
            empate = true;
        }

        ImageView imagePrimero = new ImageView();
        try { imagePrimero.setImage(new Image(new FileInputStream(pathImagePrimero)));
        } catch (FileNotFoundException ignored) {}
        imagePrimero.setScaleX(1);
        imagePrimero.setScaleY(1);
        imagePrimero.setFitWidth(175);
        imagePrimero.setFitHeight(250);

        ImageView imageSegundo = new ImageView();
        try { imageSegundo.setImage(new Image(new FileInputStream(pathImageSegundo)));
        } catch (FileNotFoundException ignored) {}
        imageSegundo.setScaleX(1);
        imageSegundo.setScaleY(1);
        imageSegundo.setFitWidth(175);
        imageSegundo.setFitHeight(250);

        HBox hbPodio;

        hbPrimero.setAlignment(Pos.CENTER);
        hbPrimero.setSpacing(20);
        hbPrimero.setStyle("-fx-background-color: #ffffff");

        hbSegundo.setAlignment(Pos.CENTER);
        hbSegundo.setSpacing(20);
        hbSegundo.setStyle("-fx-background-color: #ffffff");

        if (!empate) {

            VBox vbPrimero = new VBox(labelPrimero, hbPrimero, imagePrimero);
            vbPrimero.setAlignment(Pos.CENTER);
            vbPrimero.setSpacing(20);

            VBox vbSegundo = new VBox(labelSegundo, hbSegundo, imageSegundo);
            vbSegundo.setAlignment(Pos.CENTER);
            vbSegundo.setSpacing(20);

            hbPodio = new HBox(vbPrimero, vbSegundo);
        } else {
            VBox vbPrimero = new VBox(hbPrimero, imagePrimero);
            vbPrimero.setAlignment(Pos.CENTER);
            vbPrimero.setSpacing(20);

            VBox vbSegundo = new VBox(hbSegundo, imageSegundo);
            vbSegundo.setAlignment(Pos.CENTER);
            vbSegundo.setSpacing(20);

            HBox hbJugadores = new HBox(vbPrimero, vbSegundo);
            hbJugadores.setAlignment(Pos.CENTER);
            hbJugadores.setSpacing(200);

            VBox vbEmpate = new VBox(labelEmpate,hbJugadores);
            vbEmpate.setAlignment(Pos.CENTER);
            vbEmpate.setSpacing(30);
            hbPodio = new HBox(vbEmpate);
        }

        hbPodio.setAlignment(Pos.CENTER);
        hbPodio.setSpacing(200);

        //Barra Inferior
        Button botonSalir = new Button("Salir");
        botonSalir.setOnAction( new BotonSalir());
        botonSalir.setAlignment(Pos.CENTER);

        BorderPane bpBotoneraListo = new BorderPane();
        bpBotoneraListo.setStyle("-fx-background-color: cornflowerblue");
        bpBotoneraListo.setMinHeight(50);
        bpBotoneraListo.setCenter(botonSalir);

        //Posiciones
        setTop(bpHeader);
        setCenter(hbPodio);
        setBottom(bpBotoneraListo);
    }

    private Label armarPodioLabels(String nombre, Pos alignment) {
        Label miLabel = new Label(nombre);
        miLabel.setFont(Font.font("Tahoma", FontWeight.BOLD, 50));
        miLabel.setAlignment(alignment);
        return miLabel;
    }

    private Label armarJugadorLables(String nombre, int minWidth, Pos alignment){
        Label label = new Label(nombre);
        label.setFont(Font.font("Tahoma", FontWeight.BOLD, 35));
        label.setMinWidth(minWidth);
        label.setAlignment(alignment);
        return label;
    }

}