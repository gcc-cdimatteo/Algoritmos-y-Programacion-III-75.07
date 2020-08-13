package edu.fiuba.algo3.tp2N10.Modelo.Respuesta;

import java.util.Set;

public class RespuestaGroupChoice implements Respuesta {

    private final Set<Integer> grupoA;
    private final Set<Integer> grupoB;

    public RespuestaGroupChoice(Set<Integer> grupoA, Set<Integer> grupoB){
        this.grupoA = grupoA;
        this.grupoB = grupoB;
    }

    public boolean equals(RespuestaGroupChoice otraRespuesta) {
        return otraRespuesta.equals(grupoA, grupoB);
    }

    private boolean equals(Set<Integer> grupoA, Set<Integer> grupoB) {
        return (this.grupoA.equals(grupoA) && this.grupoB.equals(grupoB));
    }

    @Override
    public Integer evaluar(Respuesta respuestaUsuario){
        return this.equals((RespuestaGroupChoice) respuestaUsuario) ? 1 : 0;
    }
}
