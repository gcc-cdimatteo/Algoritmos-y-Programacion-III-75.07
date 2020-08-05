package edu.fiuba.algo3.tp2N10;

import java.util.ArrayList;
import java.util.Arrays;

public class VerdaderoFalso implements Pregunta {

    private String enunciado;
    private boolean correcto;
    private TipoPuntaje tipoPuntaje;


    public VerdaderoFalso(String enunciado, boolean correcto){
        this.tipoPuntaje = new TipoPuntajeClasico();
        this.enunciado = enunciado;
        this.correcto = correcto;
    }

    public void conPenalidad(){
        this.tipoPuntaje = new TipoPuntajePenalidad();
    }

    private ArrayList<Integer> evaluar(boolean respuesta){
        Integer acierto = 0;
        Integer error = 0;
        if ((this.correcto == respuesta)) { acierto++; }
        else { error++; }
        return new ArrayList<>(Arrays.asList(acierto, error));
    }

    @Override
    public Integer responder(boolean valor){
        return this.tipoPuntaje.puntuar(this.evaluar(valor));
    }


}
