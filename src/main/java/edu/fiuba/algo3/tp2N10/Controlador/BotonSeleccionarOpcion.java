//package edu.fiuba.algo3.tp2N10.Controlador;
//
//import edu.fiuba.algo3.tp2N10.Vista.App;
//import javafx.collections.ObservableList;
//import javafx.event.ActionEvent;
//import javafx.event.EventHandler;
//import javafx.scene.control.Button;
//import javafx.scene.control.ListView;
//import javafx.scene.layout.VBox;
//
//public class BotonSeleccionarOpcion implements EventHandler<ActionEvent>{
//    ListView<String> listaOrdenada;
//    Button boton;
//
//    public BotonSeleccionarOpcion(ListView<String> lista, Button boton){
//        this.boton = boton;
//        this.listaOrdenada = lista;
//
//    }
//
//    @Override
//    public void handle(ActionEvent actionEvent) {
//        String opcion = this.boton.getText();
//        this.boton.setVisible(false);
//        ObservableList<String> items = this.listaOrdenada.getItems();
//        items.add(opcion);
//        this.listaOrdenada.setItems(items);
//    }
//}