package edu.fiuba.algo3.tp2N10;

import java.util.ArrayList;

public class TipoPuntajeParcial implements TipoPuntaje {

    private ArrayList<Respuesta> respuestasCorrectas;

    public TipoPuntajeParcial(ArrayList<Respuesta> respuestasCorrectas) {
        this.respuestasCorrectas = respuestasCorrectas;
    }

    @Override
    public int puntuar(Respuesta unaRespuesta) {
        return (this.respuestasCorrectas.contains(unaRespuesta)) ? 1 : -1;
    }

    @Override
    public int puntuar(ArrayList<Respuesta> respuestas) {
        int total = 0;
        for (Respuesta respuesta : respuestas) {
            int respuestaPuntaje = puntuar(respuesta);
            if (respuestaPuntaje == -1) { return 0; }
            total += respuestaPuntaje;
        }
        return total;
    }

}
