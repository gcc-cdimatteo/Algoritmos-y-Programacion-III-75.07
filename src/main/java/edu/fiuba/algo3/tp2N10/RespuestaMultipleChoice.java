package edu.fiuba.algo3.tp2N10;

import java.util.ArrayList;
import java.util.Arrays;

public class RespuestaMultipleChoice {

    private final ArrayList<String> unaCadenaDeRespuestas;

    public RespuestaMultipleChoice(ArrayList<String> unaCadenaDeRespuestas) {
        this.unaCadenaDeRespuestas = unaCadenaDeRespuestas;
    }

    public ArrayList<Integer> evaluar(RespuestaMultipleChoice respuestasCorrectas) {
        int aciertos = 0;
        int errores = 0;
        for (String unaRespuesta : this.unaCadenaDeRespuestas) {
            if (respuestasCorrectas.contiene(unaRespuesta)){
                aciertos++;
            } else {
                errores++;
            }
        }
        return new ArrayList<>(Arrays.asList(aciertos, errores));
    }

    private boolean contiene(String unaRespuesta) {
        return this.unaCadenaDeRespuestas.contains(unaRespuesta);
    }

}
