package edu.fiuba.algo3.tp2N10;

import java.util.HashSet;

public class RespuestaGroupChoice {

    private final HashSet<String> grupoDeOpciones1;
    private final HashSet<String> grupoDeOpciones2;

    public RespuestaGroupChoice(HashSet<String> grupo1, HashSet<String> grupo2){
        this.grupoDeOpciones1 = grupo1;
        this.grupoDeOpciones2 = grupo2;
    }

    public boolean equals(RespuestaGroupChoice otraRespuesta) {

        return otraRespuesta.equals(this.grupoDeOpciones1, this.grupoDeOpciones2);
    }

    private boolean equals(HashSet<String> grupoDeOpciones1, HashSet<String> grupoDeOpciones2) {

        return (this.grupoDeOpciones1.equals(grupoDeOpciones1) && this.grupoDeOpciones2.equals(grupoDeOpciones2));
    }

    public Integer evaluar(RespuestaGroupChoice respuestaUsuario){
        return this.equals(respuestaUsuario) ? 1 : 0;
    }
}
