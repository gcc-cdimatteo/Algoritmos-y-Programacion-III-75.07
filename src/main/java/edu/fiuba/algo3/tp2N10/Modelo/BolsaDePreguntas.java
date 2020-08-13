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

    private ArrayList<Mostrable> lista = new ArrayList<>();

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

    private ArrayList<String> getOpcionesFromJson(JSONObject pregunta) {
        JSONArray opciones = pregunta.getJSONArray("opciones");

        ArrayList<String> arrayOpciones = new ArrayList<>();
        for (int i = 0; i < opciones.length(); i++) {
            arrayOpciones.add(opciones.getString(i));
        }
        return arrayOpciones;
    }

    private PreguntaGroupChoice generarPreguntaGroupChoice(JSONObject pregunta) {
        String enunciado = pregunta.getString("enunciado");
        ArrayList<String> arrayOpciones = getOpcionesFromJson(pregunta);

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
        return new PreguntaGroupChoice(enunciado, arrayOpciones, setUno, setDos);
    }



    private PreguntaOrderedChoice generarPreguntaOrderedChoice(JSONObject pregunta) {
        String enunciado = pregunta.getString("enunciado");
        ArrayList<String> arrayOpciones = getOpcionesFromJson(pregunta);

        JSONArray respuestas = pregunta.getJSONArray("respuestas");
        ArrayList<Integer> arrayRespuestas = new ArrayList<>();
        for (int i = 0; i < respuestas.length(); i++) {
            arrayRespuestas.add(respuestas.getInt(i));
        }

        return new PreguntaOrderedChoice(enunciado, arrayOpciones, arrayRespuestas);
    }

    private PreguntaMultipleChoice generarPreguntaMultipleChoice(JSONObject pregunta) {
        String enunciado = pregunta.getString("enunciado");
        ArrayList<String> arrayOpciones = getOpcionesFromJson(pregunta);

        JSONArray respuestas = pregunta.getJSONArray("respuestas");
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

    public ArrayList<Mostrable> getLista() {
        return this.lista;
    }
}
