package edu.fiuba.algo3.tp2N10.Modelo;

import edu.fiuba.algo3.tp2N10.Modelo.Excepciones.PreguntaDesconocidaException;
import edu.fiuba.algo3.tp2N10.Modelo.Pregunta.*;
import org.json.JSONArray;
import org.json.JSONObject;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;


public class FactoryPreguntas {

    private Queue<Pregunta> preguntas = new LinkedList<>();

    ////////////////////////////////////////////////////////////////////////////////////////////////////////
    // PUBLIC
    ////////////////////////////////////////////////////////////////////////////////////////////////////////
    public Queue<Pregunta> preguntas() {
        return this.preguntas;
    }

    public FactoryPreguntas(String archivo) throws IOException {

        String contenido = new String(Files.readAllBytes(Paths.get(archivo)));

        JSONObject json = new JSONObject(contenido);
        JSONArray preguntas = json.getJSONArray("preguntas");

        for (int i = 0; i < preguntas.length(); i++) {
            JSONObject pregunta = preguntas.getJSONObject(i);
            switch (pregunta.getString("tipo")) {
                case "verdaderoFalsoClasico":
                    this.preguntas.add(generarPreguntaVerdaderoFalsoClasico(pregunta));
                    break;
                case "verdaderoFalsoPenalidad":
                    this.preguntas.add(generarPreguntaVerdaderoFalsoPenalidad(pregunta));
                    break;
                case "multipleChoiceClasico":
                    this.preguntas.add(generarPreguntaMultipleChoiceClasico(pregunta));
                    break;
                case "multipleChoiceParcial":
                    this.preguntas.add(generarPreguntaMultipleChoiceParcial(pregunta));
                    break;
                case "multipleChoicePenalidad":
                    this.preguntas.add(generarPreguntaMultipleChoicePenalidad(pregunta));
                    break;
                case "orderedChoice":
                    this.preguntas.add(generarPreguntaOrderedChoice(pregunta));
                    break;
                case "groupChoice":
                    this.preguntas.add(generarPreguntaGroupChoice(pregunta));
                    break;
                default:
                    throw new PreguntaDesconocidaException();
            }
        }
    }

    ////////////////////////////////////////////////////////////////////////////////////////////////////////
    // PRIVATE
    ////////////////////////////////////////////////////////////////////////////////////////////////////////
    private List<String> obtenerOpciones(JSONObject pregunta) {
        JSONArray opciones = pregunta.getJSONArray("opciones");

        ArrayList<String> arrayOpciones = new ArrayList<>();
        for (int i = 0; i < opciones.length(); i++) {
            arrayOpciones.add(opciones.getString(i));
        }
        return arrayOpciones;
    }

    private String obtenerEnunciado(JSONObject pregunta) {
        return pregunta.getString("enunciado");
    }

    ///////////////////////////////////////////////////////////
    // Verdadero Falso
    ///////////////////////////////////////////////////////////
    private boolean obtenerRespuestaVF(JSONObject pregunta) {
        return pregunta.getBoolean("respuesta");
    }

    private Pregunta generarPreguntaVerdaderoFalsoClasico(JSONObject pregunta) {
        return PreguntaVerdaderoFalso.Clasico(obtenerEnunciado(pregunta), obtenerRespuestaVF(pregunta));
    }

    private Pregunta generarPreguntaVerdaderoFalsoPenalidad(JSONObject pregunta) {
        return PreguntaVerdaderoFalso.Penalidad(obtenerEnunciado(pregunta), obtenerRespuestaVF(pregunta));
    }

    ///////////////////////////////////////////////////////////
    // MultipleChoice
    ///////////////////////////////////////////////////////////
    private Set<Integer> obtenerRespuestasMC(JSONObject pregunta) {
        JSONArray respuestas = pregunta.getJSONArray("respuestas");
        HashSet<Integer> setRespuestas = new HashSet<>();
        for (int i = 0; i < respuestas.length(); i++) {
            setRespuestas.add(respuestas.getInt(i));
        }
        return setRespuestas;
    }

    private Pregunta generarPreguntaMultipleChoicePenalidad(JSONObject pregunta) {
        return PreguntaMultipleChoice.Penalidad(obtenerEnunciado(pregunta), obtenerOpciones(pregunta), obtenerRespuestasMC(pregunta));
    }

    private Pregunta generarPreguntaMultipleChoiceParcial(JSONObject pregunta) {
        return PreguntaMultipleChoice.Parcial(obtenerEnunciado(pregunta), obtenerOpciones(pregunta), obtenerRespuestasMC(pregunta));
    }

    private Pregunta generarPreguntaMultipleChoiceClasico(JSONObject pregunta) {
        return PreguntaMultipleChoice.Clasico(obtenerEnunciado(pregunta), obtenerOpciones(pregunta), obtenerRespuestasMC(pregunta));
    }

    ///////////////////////////////////////////////////////////
    // GroupChoice
    ///////////////////////////////////////////////////////////
    private PreguntaGroupChoice generarPreguntaGroupChoice(JSONObject pregunta) {
        JSONObject respuestas = pregunta.getJSONObject("respuestas");
        JSONArray grupoUno = respuestas.getJSONArray("grupoUno");
        HashSet<Integer> setUno = new HashSet<>();
        for (int i = 0; i < grupoUno.length(); i++) {
            setUno.add(grupoUno.getInt(i));
        }
        JSONArray grupoDos = respuestas.getJSONArray("grupoDos");
        HashSet<Integer> setDos = new HashSet<>();
        for (int i = 0; i < grupoDos.length(); i++) {
            setDos.add(grupoDos.getInt(i));
        }
        return new PreguntaGroupChoice(obtenerEnunciado(pregunta), obtenerOpciones(pregunta), setUno, setDos);
    }

    ///////////////////////////////////////////////////////////
    // OrderedChoice
    ///////////////////////////////////////////////////////////
    private PreguntaOrderedChoice generarPreguntaOrderedChoice(JSONObject pregunta) {
        JSONArray respuestas = pregunta.getJSONArray("respuestas");
        ArrayList<Integer> arrayRespuestas = new ArrayList<>();
        for (int i = 0; i < respuestas.length(); i++) {
            arrayRespuestas.add(respuestas.getInt(i));
        }
        return new PreguntaOrderedChoice(obtenerEnunciado(pregunta), obtenerOpciones(pregunta), arrayRespuestas);
    }

}
