package edu.fiuba.algo3.tp2N10.Vista;

import edu.fiuba.algo3.tp2N10.Controlador.BotonEntrar;
import edu.fiuba.algo3.tp2N10.Controlador.BotonSalir;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;


public class ContenedorBienvenidos extends VBox {

    Stage stage;

    public ContenedorBienvenidos(Stage stage, Scene proximaEscena) {

        super();

        this.stage = stage;

        this.setAlignment(Pos.CENTER);
        this.setSpacing(20);
        this.setPadding(new Insets(25));

        Label etiqueta = new Label();
        etiqueta.setFont(Font.font("Tahoma", FontWeight.BOLD, 18));

        etiqueta.setText("Bienvenidos a AlgoKahoot. Haga click en entrar");
        etiqueta.setTextFill(Color.web("#66A7C5"));

        Button botonEntrar = new Button();
        botonEntrar.setText("Entrar");
        botonEntrar.setOnAction( new BotonEntrar(stage, proximaEscena));


        Button botonSalir = new Button();
        botonSalir.setText("Salir");
        botonSalir.setOnAction( new BotonSalir());

        this.getChildren().addAll(etiqueta, botonEntrar, botonSalir);
    }
}
