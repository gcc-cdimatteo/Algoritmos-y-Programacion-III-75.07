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
import javafx.scene.media.MediaPlayer;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.List;

public class ContenedorPodio extends BorderPane {

    public ContenedorPodio(AlgoKahoot algoKahoot, MediaPlayer reproductor) {
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

        hbPrimero = armarHBoxJugador(labelJugadorUno, labelPuntajeUno);
        hbSegundo = armarHBoxJugador(labelJugadorDos,labelPuntajeDos);
        ImageView imagePrimero = armarImagenPuesto(pathImagePrimero);
        ImageView imageSegundo = armarImagenPuesto(pathImageSegundo);
        HBox hbPodio;

        if (!puntajes.get(0).equals(puntajes.get(1))) {
            if (puntajes.get(0) < puntajes.get(1)) {
                HBox aux = hbSegundo;
                hbSegundo = hbPrimero;
                hbPrimero = aux;
            }

            VBox vbPrimero = armarVBox(hbPrimero, imagePrimero);
            VBox vbSegundo = armarVBox(hbSegundo, imageSegundo);

            hbPodio = new HBox(vbPrimero, vbSegundo);

        } else {
            pathImagePrimero = "./resources/images/empateuno.png";
            pathImageSegundo = "./resources/images/empatedos.png";
            imagePrimero = armarImagenPuesto(pathImagePrimero);
            imageSegundo = armarImagenPuesto(pathImageSegundo);

            VBox vbPrimero = armarVBox(hbPrimero, imagePrimero);
            VBox vbSegundo = armarVBox(hbSegundo, imageSegundo);

            HBox hbJugadores = new HBox(vbPrimero, vbSegundo);
            hbJugadores.setAlignment(Pos.CENTER);
            hbJugadores.setSpacing(200);

            VBox vbEmpate = new VBox(empatePodioLabels(), hbJugadores);
            vbEmpate.setAlignment(Pos.CENTER);
            vbEmpate.setSpacing(30);
            hbPodio = new HBox(vbEmpate);

        }

        hbPodio.setAlignment(Pos.CENTER);
        hbPodio.setSpacing(200);

        //Barra Inferior
        Button botonSalir = new Button("Salir");
        botonSalir.setOnAction( new BotonSalir(reproductor));
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

    private VBox armarVBox(HBox hb, ImageView image) {
        VBox miVB = new VBox(hb, image);
        miVB.setAlignment(Pos.CENTER);
        miVB.setSpacing(20);
        return miVB;
    }

    private HBox armarHBoxJugador(Label jugador, Label puntaje) {
        HBox miHB = new HBox(jugador,puntaje);
        miHB.setAlignment(Pos.CENTER);
        miHB.setSpacing(20);
        miHB.setStyle("-fx-background-color: #ffffff");
        return miHB;
    }

    private ImageView armarImagenPuesto(String pathImage) {
        ImageView miImagen = new ImageView();
        try { miImagen.setImage(new Image(new FileInputStream(pathImage)));
        } catch (FileNotFoundException ignored) {}
        miImagen.setScaleX(1);
        miImagen.setScaleY(1);
        miImagen.setFitWidth(175);
        miImagen.setFitHeight(250);
        return miImagen;
    }

    private Label empatePodioLabels() {
        Label miLabel = new Label("Empate");
        miLabel.setFont(Font.font("Tahoma", FontWeight.BOLD, 50));
        miLabel.setAlignment(Pos.CENTER);
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