//package edu.fiuba.algo3.tp2N10;
//
//import org.json.JSONArray;
//import org.json.JSONObject;
//
//import java.io.*;
//import java.nio.file.Files;
//import java.nio.file.Paths;
//import java.util.ArrayList;
//import java.util.Arrays;
//import java.util.Collections;
//import java.util.HashSet;
//
//
//public class BolsaDePreguntas {
//
//    private ArrayList<Mostrable> lista = new ArrayList<>();
//
//    public BolsaDePreguntas(String archivo) throws IOException {
//
//        String contenido = new String(Files.readAllBytes(Paths.get(archivo)));
//
//        JSONObject json = new JSONObject(contenido);
//        JSONArray preguntas = json.getJSONArray("preguntas");
//
//        for (int i = 0; i < preguntas.length(); i++) {
//            JSONObject pregunta = preguntas.getJSONObject(i);
//            switch (pregunta.getString("tipo")) {
//                case "verdaderoFalso":
//                    lista.add(generarPreguntaVerdaderoFalso(pregunta));
//                    break;
//                case "multipleChoice":
//                    lista.add(generarPreguntaMultipleChoice(pregunta));
//                    break;
//                case "orderedChoice":
//                    lista.add(generarPreguntaOrderedChoice(pregunta));
//                    break;
//                case "groupChoice":
//                    lista.add(generarPreguntaGroupChoice(pregunta));
//                    break;
//                default:
//                    System.out.println("Tipo de pregunta desconocida");
//            }
//        }
//    }
//
//    private Mostrable generarPreguntaGroupChoice(JSONObject pregunta) {
//        System.out.println("Leyendo una pregunta GroupChoice...");
//
//        // ToDo: Todavía no esta definida
//        return null;
//    }
//
//    private Mostrable generarPreguntaOrderedChoice(JSONObject pregunta) {
//        System.out.println("Leyendo una pregunta OrderedChoice...");
//
//        String enunciado = pregunta.getString("enunciado");
//        JSONArray respuestas = pregunta.getJSONArray("respuesta");
//
//        ArrayList<String> arrayRespuestas = new ArrayList<>();
//        for (int i = 0; i < respuestas.length(); i++) {
//            arrayRespuestas.add(respuestas.getString(i));
//        }
//
//        RespuestaOrderedChoice respuestaCorrecta = new RespuestaOrderedChoice(arrayRespuestas);
//        return new OrderedChoice(enunciado, respuestaCorrecta);
//    }
//
//    private Mostrable generarPreguntaMultipleChoice(JSONObject pregunta) {
//        System.out.println("Leyendo una pregunta Multiple Choice...");
//        String enunciado = pregunta.getString("enunciado");
//        JSONArray respuestas = pregunta.getJSONArray("respuesta");
//
//        ArrayList<String> arrayRespuestas = new ArrayList<>();
//        for (int i = 0; i < respuestas.length(); i++) {
//            arrayRespuestas.add(respuestas.getString(i));
//        }
//
//        RespuestaMultipleChoice respuestaCorrecta = new RespuestaMultipleChoice(new HashSet<>(arrayRespuestas));
//
//        MultipleChoice preguntaMC = null;
//        switch (pregunta.getString("tipoPuntaje")) {
//            case "clasico":
//                preguntaMC = new MultipleChoice(enunciado, respuestaCorrecta);
//                break;
//            case "parcial":
//                preguntaMC = MultipleChoice.MultipleChoiceParcial(enunciado, respuestaCorrecta);
//                break;
//            case "conPenalidad":
//                preguntaMC = MultipleChoice.MultipleChoicePenalidad(enunciado, respuestaCorrecta);
//        }
//        return preguntaMC;
//    }
//
//    private Mostrable generarPreguntaVerdaderoFalso(JSONObject pregunta) {
//        System.out.println("Leyendo una pregunta VerdaderoFalso...");
//        String enunciado = pregunta.getString("enunciado");
//        boolean respuesta = pregunta.getBoolean("respuesta");
//
//        RespuestaVerdaderoFalso respuestaCorrecta = new RespuestaVerdaderoFalso(respuesta);
//        VerdaderoFalso preguntaVF = null;
//        if (pregunta.getBoolean("conPenalidad")) {
//            preguntaVF = VerdaderoFalso.VerdaderoFalsoPenalidad(enunciado,respuestaCorrecta);
//        } else {
//            preguntaVF = new VerdaderoFalso(enunciado, respuestaCorrecta);
//        }
//        return preguntaVF;
//    }
//
//    public ArrayList<Mostrable> getLista() {
//        return this.lista;
//    }
//}
