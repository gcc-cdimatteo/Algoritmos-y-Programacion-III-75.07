package edu.fiuba.algo3.tp2N10.Vista;

import javafx.scene.image.Image;
import javafx.scene.layout.*;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

public class FactoryBackgrounds {

    private Image imagenDeFondo;

    public Background crearBackground(String direccion, int ancho, int alto) throws FileNotFoundException {
        imagenDeFondo = new Image(new FileInputStream(direccion));
        return new Background(new BackgroundImage(imagenDeFondo,
                BackgroundRepeat.REPEAT,
                BackgroundRepeat.REPEAT,
                BackgroundPosition.CENTER,
                new BackgroundSize(ancho, alto, false, false, false, false)));
    }
}
