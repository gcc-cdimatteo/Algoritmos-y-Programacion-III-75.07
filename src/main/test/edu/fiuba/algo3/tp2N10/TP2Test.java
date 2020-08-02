package edu.fiuba.algo3.tp2N10;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TP2Test {

    private VerdaderoFalsoClasico unaPreguntaDeVFClasico;
    private VerdaderoFalsoConPenalidad unaPreguntaDeVFConPenalidad;
    private Respuesta respuestaCorrectaVF;
    private Respuesta respuestaIncorrectaVF;

    private MultipleChoiceClasico unaPreguntaDeMCClasico;
    private MultipleChoiceParcial unaPreguntaDeMCParcial;

    private MultipleChoiceConPenalidad unaPreguntaDeMCConPenalidad;

    private Respuesta respuestaCorrectaMCUno;
    private Respuesta respuestaCorrectaMCDos;
    private Respuesta respuestaCorrectaMCTres;
    private Respuesta respuestaIncorrectaMCUno;

    public void setupRespuestasVF() {
        this.respuestaCorrectaVF = new RespuestaCorrecta("Verdadero|jaja|jasjdj|jjasdsj|jajsdjj|jajsdj");
        this.respuestaIncorrectaVF = new RespuestaIncorrecta("Falso");
    }

    public void creoUnaPreguntaDeVFClasico() {
        setupRespuestasVF();
        ArrayList<Respuesta> respuestas = new ArrayList<>(Arrays.asList(this.respuestaCorrectaVF, this.respuestaIncorrectaVF));
        this.unaPreguntaDeVFClasico = new VerdaderoFalsoClasico("Una manzana es una fruta", respuestas);
    }

    public void creoUnaPreguntaDeVFConPenalidad() {
        setupRespuestasVF();
        ArrayList<Respuesta> respuestas = new ArrayList<>(Arrays.asList(this.respuestaCorrectaVF, this.respuestaIncorrectaVF));
        this.unaPreguntaDeVFConPenalidad = new VerdaderoFalsoConPenalidad("Una manzana es una fruta", respuestas);
    }

    public void setupRespuestasMC() {
        this.respuestaCorrectaMCUno = new RespuestaCorrecta("Una fruta");
        this.respuestaCorrectaMCDos = new RespuestaCorrecta("De color rojo");
        this.respuestaCorrectaMCTres = new RespuestaCorrecta("Muy rica");
        this.respuestaIncorrectaMCUno = new RespuestaIncorrecta("Carne");
    }

    public void creoUnaPreguntaDeMCClasico() {
        setupRespuestasMC();
        ArrayList<Respuesta> respuestas = new ArrayList<>(Arrays.asList(this.respuestaCorrectaMCUno, this.respuestaCorrectaMCDos, this.respuestaCorrectaMCTres, this.respuestaIncorrectaMCUno));
        this.unaPreguntaDeMCClasico = new MultipleChoiceClasico("Una manzana es...", respuestas);
    }

    public void creoUnaPreguntaDeMCParcial() {
        setupRespuestasMC();
        ArrayList<Respuesta> respuestas = new ArrayList<>(Arrays.asList(this.respuestaCorrectaMCUno, this.respuestaCorrectaMCDos, this.respuestaCorrectaMCTres, this.respuestaIncorrectaMCUno));
        this.unaPreguntaDeMCParcial = new MultipleChoiceParcial("Una manzana es...", respuestas);
    }

    public void creoUnaPreguntaDeMCConPenalidad() {
        setupRespuestasMC();
        ArrayList<Respuesta> respuestas = new ArrayList<>(Arrays.asList(this.respuestaCorrectaMCUno, this.respuestaCorrectaMCDos, this.respuestaCorrectaMCTres, this.respuestaIncorrectaMCUno));
        this.unaPreguntaDeMCConPenalidad = new MultipleChoiceConPenalidad("Una manzana es...", respuestas);
    }

    ////////////////////////////////////////////////////////////////////////////////////////////////////////
    // Entrega0
    ////////////////////////////////////////////////////////////////////////////////////////////////////////
    @Test
    public void unaPreguntaDeVFClasicoPuedeCrearseSiSeIndicaLaRtaCorreta() { //Pto. 1
        creoUnaPreguntaDeVFClasico();
        assertEquals(1, this.unaPreguntaDeVFClasico.valuar(this.respuestaCorrectaVF));
    }

    @Test
    public void unaPreguntaDeVFClasicoPuntua0SiSeRespondeMal() {
        creoUnaPreguntaDeVFClasico();
        assertEquals(0, this.unaPreguntaDeVFClasico.valuar(this.respuestaIncorrectaVF));
    }

    @Test
    public void unaPreguntaDeVFClasicoRecibeRespuestasYAsignaPuntos() { //Pto. 2
        creoUnaPreguntaDeVFClasico();
        ArrayList<Respuesta> respuestaJugadorUno = new ArrayList<>(Collections.singletonList(this.respuestaCorrectaVF));
        ArrayList<Respuesta> respuestaJugadorDos = new ArrayList<>(Collections.singletonList(this.respuestaIncorrectaVF));
        ArrayList<ArrayList<Respuesta>> respuestas = new ArrayList<>(Arrays.asList(respuestaJugadorUno, respuestaJugadorDos));
        ArrayList<Integer> puntosObtenidos = this.unaPreguntaDeVFClasico.responder(respuestas);
        ArrayList<Integer> puntosEsperados = new ArrayList<>(Arrays.asList(1, 0));
        assertEquals(puntosEsperados, puntosObtenidos);
    }

    ////////////////////////////////////////////////////////////////////////////////////////////////////////
    // Entrega1
    ////////////////////////////////////////////////////////////////////////////////////////////////////////
    @Test
    public void unaPreguntaDeVFConPenalidadPuedeCrearseSiSeIndicaLaRtaCorreta() { //Pto. 1
        creoUnaPreguntaDeVFConPenalidad();
        assertEquals(1, this.unaPreguntaDeVFConPenalidad.valuar(this.respuestaCorrectaVF));
    }

    @Test
    public void unaPreguntaDeVFConPenalidadRestaPuntosSiSeRespondeMal() {
        creoUnaPreguntaDeVFConPenalidad();
        assertEquals(-1, unaPreguntaDeVFConPenalidad.valuar(this.respuestaIncorrectaVF));
    }

    @Test
    public void unaPreguntaDeMCClasicoPuedeCrearseSiSeIndicaLasRtasCorretas() { //Pto. 2
        creoUnaPreguntaDeMCClasico();
        assertEquals(1, this.unaPreguntaDeMCClasico.valuar(new ArrayList<>(Arrays.asList(this.respuestaCorrectaMCUno, this.respuestaCorrectaMCDos, this.respuestaCorrectaMCTres))));
    }

    @Test
    public void unaPreguntaDeMCClasicoPuntua0SiSeRespondeMal() {
        creoUnaPreguntaDeMCClasico();
        assertEquals(0, this.unaPreguntaDeMCClasico.valuar(new ArrayList<>(Arrays.asList(this.respuestaCorrectaMCUno, this.respuestaCorrectaMCDos, this.respuestaIncorrectaMCUno))));
    }

    @Test
    public void unaPreguntaDeMCClasicoPuntua0SiLaRespuestaEstaIncompleta() {
        creoUnaPreguntaDeMCClasico();
        assertEquals(0, this.unaPreguntaDeMCClasico.valuar(new ArrayList<>(Arrays.asList(this.respuestaCorrectaMCUno, this.respuestaCorrectaMCDos))));
    }

    @Test
    public void unaPreguntaDeMCParcialPuedeCrearseSiSeIndicaLasRtasCorretas() { //Pto. 3
        creoUnaPreguntaDeMCParcial();
        assertEquals(2, this.unaPreguntaDeMCParcial.valuar(new ArrayList<>(Arrays.asList(this.respuestaCorrectaMCUno, this.respuestaCorrectaMCDos))));
    }

    @Test
    public void unaPreguntaDeMCParcialPuntua0SiSeRespondeMal() {
        creoUnaPreguntaDeMCParcial();
        assertEquals(0, this.unaPreguntaDeMCParcial.valuar(new ArrayList<>(Arrays.asList(this.respuestaCorrectaMCUno, this.respuestaCorrectaMCDos, this.respuestaIncorrectaMCUno))));
    }

    @Test
    public void unaPreguntaDeVFConPenalidadRecibeRespuestasYAsignaPuntos() { //Pto. 4
        creoUnaPreguntaDeVFConPenalidad();
        ArrayList<Respuesta> respuestaJugadorUno = new ArrayList<>(Collections.singletonList(this.respuestaCorrectaVF));
        ArrayList<Respuesta> respuestaJugadorDos = new ArrayList<>(Collections.singletonList(this.respuestaIncorrectaVF));
        ArrayList<ArrayList<Respuesta>> respuestas = new ArrayList<>(Arrays.asList(respuestaJugadorUno, respuestaJugadorDos));
        ArrayList<Integer> puntosObtenidos = this.unaPreguntaDeVFConPenalidad.responder(respuestas);
        ArrayList<Integer> puntosEsperados = new ArrayList<>(Arrays.asList(1, -1));
        assertEquals(puntosEsperados, puntosObtenidos);
    }

    @Test
    public void unaPreguntaDeMCClasicoRecibeRespuestasYAsignaPuntos() { //Pto. 5
        creoUnaPreguntaDeMCClasico();
        ArrayList<Respuesta> respuestasJugadorUno = new ArrayList<>(Arrays.asList(this.respuestaCorrectaMCDos, this.respuestaCorrectaMCTres, this.respuestaCorrectaMCUno));
        ArrayList<Respuesta> respuestasJugadorDos = new ArrayList<>(Arrays.asList(this.respuestaCorrectaMCDos, this.respuestaIncorrectaMCUno, this.respuestaCorrectaMCUno));
        ArrayList<ArrayList<Respuesta>> respuestasUsuarios = new ArrayList<>(Arrays.asList(respuestasJugadorUno, respuestasJugadorDos));
        ArrayList<Integer> puntosObtenidos = this.unaPreguntaDeMCClasico.responder(respuestasUsuarios);
        ArrayList<Integer> puntosEsperados = new ArrayList<>(Arrays.asList(1, 0));
        assertEquals(puntosEsperados, puntosObtenidos);
    }

    @Test
    public void unaPreguntaDeMCParcialRecibeRespuestasYAsignaPuntos() { //Pto. 6
        creoUnaPreguntaDeMCParcial();
        ArrayList<Respuesta> respuestasUsuarioUno = new ArrayList<>(Arrays.asList(this.respuestaCorrectaMCDos, this.respuestaCorrectaMCTres, this.respuestaCorrectaMCUno));
        ArrayList<Respuesta> respuestasUsuarioDos = new ArrayList<>(Arrays.asList(this.respuestaCorrectaMCDos, this.respuestaIncorrectaMCUno, this.respuestaCorrectaMCUno));
        ArrayList<ArrayList<Respuesta>> respuestasUsuarios = new ArrayList<>(Arrays.asList(respuestasUsuarioUno, respuestasUsuarioDos));
        ArrayList<Integer> puntosObtenidos = this.unaPreguntaDeMCParcial.responder(respuestasUsuarios);
        ArrayList<Integer> puntosEsperados = new ArrayList<>(Arrays.asList(3, 0));
        assertEquals(puntosEsperados, puntosObtenidos);
    }

    ////////////////////////////////////////////////////////////////////////////////////////////////////////
    // Entrega 2
    ////////////////////////////////////////////////////////////////////////////////////////////////////////

    @Test
    public void unaPreguntaDeMCConPenalidadAsignaPuntajeParcialSiSeRespondeAlgunasBienyAlgunasMal() {
        creoUnaPreguntaDeMCConPenalidad();
        assertEquals(2, this.unaPreguntaDeMCConPenalidad.valuar(
                new ArrayList<>(Arrays.asList(
                        new RespuestaCorrecta("Una fruta"),
                        new RespuestaCorrecta("De color rojo"),
                        new RespuestaCorrecta("Muy rica"),
                        new RespuestaIncorrecta("Carne")))));
    }

    @Test
    public void unaPreguntaDeMCConPenalidadAsignaTotalDePuntosSiSeRespondeTodoBien() {
        creoUnaPreguntaDeMCConPenalidad();
        assertEquals(3, this.unaPreguntaDeMCConPenalidad.valuar(
                new ArrayList<>(Arrays.asList(
                        new RespuestaCorrecta("Una fruta"),
                        new RespuestaCorrecta("De color rojo"),
                        new RespuestaCorrecta("Muy rica")))));
    }

    @Test
    public void unaPreguntaDeMCConPenalidadAsignaTotalDePuntosEnContraSiSeRespondeTodoMal() {
        creoUnaPreguntaDeMCConPenalidad();
        assertEquals(-1, this.unaPreguntaDeMCConPenalidad.valuar(
                new ArrayList<>(Arrays.asList(new RespuestaIncorrecta("Carne")))));
    }

    @Test
    public void unaPreguntaDeMCConPenalidadRecibeRespuestasYAsignaPuntos() {
        creoUnaPreguntaDeMCConPenalidad();

        ArrayList<Respuesta> respuestasJugadorUno = new ArrayList<>(Arrays.asList(
                new RespuestaCorrecta("Una fruta"),
                new RespuestaCorrecta("De color rojo"),
                new RespuestaCorrecta("Muy rica"),
                new RespuestaIncorrecta("Carne")));
        ArrayList<Respuesta> respuestasJugadorDos = new ArrayList<>(Arrays.asList(
                new RespuestaIncorrecta("Carne")));

        ArrayList<ArrayList<Respuesta>> respuestasUsuarios = new ArrayList<>(
                Arrays.asList(respuestasJugadorUno, respuestasJugadorDos));
        ArrayList<Integer> puntosObtenidos = this.unaPreguntaDeMCConPenalidad.responder(respuestasUsuarios);
        ArrayList<Integer> puntosEsperados = new ArrayList<>(Arrays.asList(2, -1));
        assertEquals(puntosEsperados, puntosObtenidos);
    }

    // ToDo: Ordered choice


    // ToDo: Group Choice


}