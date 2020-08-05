package edu.fiuba.algo3.tp2N10;

import java.util.ArrayList;

//ACTUALIZAR(Utiliza clase respuesta obsoleta)

public class OrderedChoice implements Pregunta {

    private final String enunciado;
    protected ArrayList<Respuesta> opciones; //Crear nueva clase "opciones" o refactorizar "Respuesta"
    private ArrayList<Respuesta> respuestaOrdenada;

    public OrderedChoice(String unEnunciado, ArrayList<Respuesta> opciones, ArrayList<Respuesta> respuestaOrdenada) {
        this.enunciado = unEnunciado;
        this.opciones = opciones;
        this.respuestaOrdenada = respuestaOrdenada;
    }

    public int valuar(ArrayList<Respuesta> respuesta) { //REFACTOR
        for (int i = 0; i < respuesta.size(); i++) {
            String nombreRespuestaUsuario = respuesta.get(i).getRespuesta();
            String nombreRespuestaOrdenada = respuestaOrdenada.get(i).getRespuesta();
            if (!nombreRespuestaUsuario.equals(nombreRespuestaOrdenada)) {
                return 0;
            }
        }
        return 1;
    }

    @Override
    public ArrayList<Integer> responder(ArrayList<ArrayList<Respuesta>> respuestas) {
        ArrayList<Integer> puntos = new ArrayList();
        for (ArrayList<Respuesta> respuestasUsuario : respuestas) {
            puntos.add(valuar(respuestasUsuario));
        }
        return puntos;
    }
}
