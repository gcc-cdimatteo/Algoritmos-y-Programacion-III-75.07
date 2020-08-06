package edu.fiuba.algo3.tp2N10;

import java.util.Arrays;
import java.util.List;
import java.util.Set;
import com.google.common.collect.Sets;

public class RespuestaMultipleChoice {

    private final Set<String> opciones;

    public RespuestaMultipleChoice(Set<String> opciones) {
        this.opciones = opciones;
    }

    public Set<String> intersection(RespuestaMultipleChoice respuesta) {
        return respuesta.intersection(this.opciones);
    }

    private Set<String> intersection(Set<String> opciones) {
        return Sets.intersection(this.opciones, opciones);
    }

    public Integer size() {
        return this.opciones.size();
    }

    public List<Integer> evaluar(RespuestaMultipleChoice respuestaUsuario) {
        Integer aciertos = this.intersection(respuestaUsuario).size();
        Integer errores = respuestaUsuario.size() - aciertos;
        return Arrays.asList(aciertos, errores);
    }
}
