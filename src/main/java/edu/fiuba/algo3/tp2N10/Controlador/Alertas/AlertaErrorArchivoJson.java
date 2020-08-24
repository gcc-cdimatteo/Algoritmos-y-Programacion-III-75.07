package edu.fiuba.algo3.tp2N10.Controlador.Alertas;

import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.layout.Border;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.media.Media;
import javafx.scene.media.MediaException;
import javafx.scene.media.MediaPlayer;
import javafx.stage.DirectoryChooser;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import javafx.stage.Window;

import java.io.File;

public class AlertaErrorArchivoJson extends Alert {
    private MediaPlayer reproductor;

    public AlertaErrorArchivoJson() {
        super(Alert.AlertType.WARNING);
        this.setTitle("AlgoKahoot Error");
        this.setHeaderText("¡Error en cargar archivo de preguntas!");
        this.setContentText("Seleccione el archivo de preguntas correcto");
        try{ this.reproductor = new MediaPlayer(new Media(new File("./resources/audio/alerta.mp3").toURI().toString())); }
        catch (MediaException ignored) {}
    }

    public void mostrar() {
        if (reproductor != null) this.reproductor.play();
        showAndWait();
    }
}
