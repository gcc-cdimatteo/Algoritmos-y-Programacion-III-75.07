package edu.fiuba.algo3.tp2N10.Modelo;

import edu.fiuba.algo3.tp2N10.Modelo.Pregunta.*;
import edu.fiuba.algo3.tp2N10.Modelo.Respuesta.RespuestaMultipleChoice;
import edu.fiuba.algo3.tp2N10.Modelo.Respuesta.RespuestaOrderedChoice;
import edu.fiuba.algo3.tp2N10.Modelo.Respuesta.RespuestaVerdaderoFalso;
import org.json.JSONArray;
import org.json.JSONObject;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;


public class BolsaDePreguntas {

    private ArrayList<Pregunta> lista = new ArrayList<>();

    public BolsaDePreguntas(String archivo) throws IOException {

        String contenido = new String(Files.readAllBytes(Paths.get(archivo)));

        JSONObject json = new JSONObject(contenido);
        JSONArray preguntas = json.getJSONArray("preguntas");

        for (int i = 0; i < preguntas.length(); i++) {
            JSONObject pregunta = preguntas.getJSONObject(i);
            switch (pregunta.getString("tipo")) {
                case "verdaderoFalso":
                    lista.add(generarPreguntaVerdaderoFalso(pregunta));
                    break;
                case "multipleChoice":
                    lista.add(generarPreguntaMultipleChoice(pregunta));
                    break;
                case "orderedChoice":
                    lista.add(generarPreguntaOrderedChoice(pregunta));
                    break;
                case "groupChoice":
                    lista.add(generarPreguntaGroupChoice(pregunta));
                    break;
                default:
                    System.out.println("Tipo de pregunta desconocida");
            }
        }
    }

    private PreguntaGroupChoice generarPreguntaGroupChoice(JSONObject pregunta) {
        // ToDo: Todavía no esta definida
        return null;
    }

    private PreguntaOrderedChoice generarPreguntaOrderedChoice(JSONObject pregunta) {
        String enunciado = pregunta.getString("enunciado");
        JSONArray opciones = pregunta.getJSONArray("opciones");
        JSONArray respuestas = pregunta.getJSONArray("respuestas");

        ArrayList<String> arrayOpciones = new ArrayList<>();
        for (int i = 0; i < opciones.length(); i++) {
            arrayOpciones.add(opciones.getString(i));
        }

        ArrayList<Integer> arrayRespuestas = new ArrayList<>();
        for (int i = 0; i < respuestas.length(); i++) {
            arrayRespuestas.add(respuestas.getInt(i));
        }

        return new PreguntaOrderedChoice(enunciado, arrayOpciones, arrayRespuestas);
    }

    private PreguntaMultipleChoice generarPreguntaMultipleChoice(JSONObject pregunta) {
        String enunciado = pregunta.getString("enunciado");
        JSONArray opciones = pregunta.getJSONArray("opciones");
        JSONArray respuestas = pregunta.getJSONArray("respuestas");

        ArrayList<String> arrayOpciones = new ArrayList<>();
        for (int i = 0; i < opciones.length(); i++) {
            arrayOpciones.add(opciones.getString(i));
        }

        HashSet<Integer> setRespuestas = new HashSet<>();
        for (int i = 0; i < respuestas.length(); i++) {
            setRespuestas.add(respuestas.getInt(i));
        }

        PreguntaMultipleChoice preguntaMC = null;
        switch (pregunta.getString("tipoPuntaje")) {
            case "clasico":
                preguntaMC = PreguntaMultipleChoice.Clasico(enunciado, arrayOpciones, setRespuestas);
                break;
            case "parcial":
                preguntaMC = PreguntaMultipleChoice.Parcial(enunciado, arrayOpciones, setRespuestas);
                break;
            case "conPenalidad":
                preguntaMC = PreguntaMultipleChoice.Penalidad(enunciado, arrayOpciones, setRespuestas);
        }
        return preguntaMC;
    }

    private PreguntaVerdaderoFalso generarPreguntaVerdaderoFalso(JSONObject pregunta) {
        String enunciado = pregunta.getString("enunciado");
        boolean respuesta = pregunta.getBoolean("respuesta");

        PreguntaVerdaderoFalso preguntaVF = null;
        if (pregunta.getBoolean("conPenalidad")) {
            preguntaVF = PreguntaVerdaderoFalso.Penalidad(enunciado, respuesta);
        } else {
            preguntaVF = PreguntaVerdaderoFalso.Clasico(enunciado, respuesta);
        }
        return preguntaVF;
    }

    public ArrayList<Pregunta> getLista() {
        return this.lista;
    }
}
