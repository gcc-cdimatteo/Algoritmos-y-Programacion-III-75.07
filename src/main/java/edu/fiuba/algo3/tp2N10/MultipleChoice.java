//package edu.fiuba.algo3.tp2N10;
//
//import java.util.ArrayList;
//
//public abstract class MultipleChoice implements Pregunta {
//
//
//    private final String enunciado;
//    protected ArrayList<Respuesta> opciones;
//
//    public MultipleChoice(String unEnunciado, ArrayList<Respuesta> opciones) {
//        this.enunciado = unEnunciado;
//        this.opciones = opciones;
//    }
//
//    public abstract int valuar(ArrayList<Respuesta> respuestas);
//
//    public ArrayList<Integer> responder(ArrayList<ArrayList<Respuesta>> respuestas) {
//        ArrayList<Integer> puntos = new ArrayList();
//        for (ArrayList<Respuesta> respuestasUsuario : respuestas) {
//            puntos.add(valuar(respuestasUsuario));
//        }
//        return puntos;
//    }
//}
