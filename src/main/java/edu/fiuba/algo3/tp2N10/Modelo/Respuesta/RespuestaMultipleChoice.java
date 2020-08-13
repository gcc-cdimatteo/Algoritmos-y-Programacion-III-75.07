package edu.fiuba.algo3.tp2N10.Modelo.Respuesta;

import java.util.Arrays;
import java.util.List;
import java.util.Set;
import com.google.common.collect.Sets;

public class RespuestaMultipleChoice implements Respuesta {

    private final Set<Integer> opciones;

    public RespuestaMultipleChoice(Set<Integer> opciones) {
        this.opciones = opciones;
    }

    public Set<Integer> intersection(RespuestaMultipleChoice respuesta) {
        return respuesta.intersection(opciones);
    }

    private Set<Integer> intersection(Set<Integer> opciones) {
        return Sets.intersection(this.opciones, opciones);
    }

    public Integer size() {
        return opciones.size();
    }

    @Override
    public List<Integer> evaluar(Respuesta respuestaUsuario) {
        RespuestaMultipleChoice respuestaUsuarioCasteada = (RespuestaMultipleChoice) respuestaUsuario;
        Integer aciertos = this.intersection(respuestaUsuarioCasteada).size();
        Integer errores = respuestaUsuarioCasteada.size() - aciertos;
        return Arrays.asList(aciertos, errores);
    }
}
