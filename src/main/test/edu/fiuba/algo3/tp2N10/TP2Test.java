package edu.fiuba.algo3.tp2N10;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class TP2Test {

    private VerdaderoFalsoClasico unaPreguntaDeVFClasico;
    private VerdaderoFalsoConPenalidad unaPreguntaDeVFConPenalidad;
    private Respuesta respuestaCorrectaVF;
    private Respuesta respuestaIncorrectaVF;

    private MultipleChoiceClasico unaPreguntaDeMCClasico;
    private MultipleChoiceParcial unaPreguntaDeMCParcial;
    private Respuesta respuestaCorrectaMCUno;
    private Respuesta respuestaCorrectaMCDos;
    private Respuesta respuestaCorrectaMCTres;
    private Respuesta respuestaIncorrectaMCUno;

    public void setupRespuestasVF() {
        this.respuestaCorrectaVF = new Respuesta(true);
        this.respuestaIncorrectaVF = new Respuesta(false);
    }

    public void creoUnaPreguntaDeVFClasico() {
        setupRespuestasVF();
        this.unaPreguntaDeVFClasico = new VerdaderoFalsoClasico("Una manzana es una fruta", this.respuestaCorrectaVF);
    }

    public void creoUnaPreguntaDeVFConPenalidad() {
        setupRespuestasVF();
        this.unaPreguntaDeVFConPenalidad = new VerdaderoFalsoConPenalidad("Una manzana es una fruta", this.respuestaCorrectaVF);
    }

    public void setupRespuestasMC() {
        this.respuestaCorrectaMCUno = new Respuesta("Una fruta");
        this.respuestaCorrectaMCDos = new Respuesta("De color rojo");
        this.respuestaCorrectaMCTres = new Respuesta("Muy rica");
        this.respuestaIncorrectaMCUno = new Respuesta("Carne");
    }

    public void creoUnaPreguntaDeMCClasico() {
        setupRespuestasMC();
        this.unaPreguntaDeMCClasico = new MultipleChoiceClasico("Una manzana es una fruta", new ArrayList<Respuesta>(Arrays.asList(this.respuestaCorrectaMCUno, this.respuestaCorrectaMCDos, this.respuestaCorrectaMCTres)));
    }

    public void creoUnaPreguntaDeMCParcial() {
        setupRespuestasMC();
        this.unaPreguntaDeMCParcial = new MultipleChoiceParcial("Una manzana es una fruta", new ArrayList<Respuesta>(Arrays.asList(this.respuestaCorrectaMCUno, this.respuestaCorrectaMCDos, this.respuestaCorrectaMCTres)));
    }

    ////////////////////////////////////////////////////////////////////////////////////////////////////////
    // Entrega0
    ////////////////////////////////////////////////////////////////////////////////////////////////////////
    @Test
    public void unaPreguntaDeVFClasicoPuedeCrearseSiSeIndicaLaRtaCorreta(){ //Pto. 1
        creoUnaPreguntaDeVFClasico();
        assertEquals(1, this.unaPreguntaDeVFClasico.puntuar(this.respuestaCorrectaVF));
    }

    @Test
    public void unaPreguntaDeVFClasicoPuntua0SiSeRespondeMal(){
        creoUnaPreguntaDeVFClasico();
        assertEquals(0, this.unaPreguntaDeVFClasico.puntuar(this.respuestaIncorrectaVF));
    }

    @Test
    public void unaPreguntaDeVFClasicoRecibeRespuestasYAsignaPuntos(){ //Pto. 2
        creoUnaPreguntaDeVFClasico();
        ArrayList<Integer> puntosObtenidos = this.unaPreguntaDeVFClasico.responder(new ArrayList<>(Arrays.asList(this.respuestaCorrectaVF, this.respuestaIncorrectaVF)));
        ArrayList<Integer> puntosEsperados = new ArrayList(Arrays.asList(1, 0));
        assertTrue(puntosObtenidos.equals(puntosEsperados));
    }

    ////////////////////////////////////////////////////////////////////////////////////////////////////////
    // Entrega1
    ////////////////////////////////////////////////////////////////////////////////////////////////////////
    @Test
    public void unaPreguntaDeVFConPenalidadPuedeCrearseSiSeIndicaLaRtaCorreta(){ //Pto. 1
        creoUnaPreguntaDeVFConPenalidad();
        assertEquals(1, this.unaPreguntaDeVFConPenalidad.puntuar(this.respuestaCorrectaVF));
    }

    @Test
    public void unaPreguntaDeVFConPenalidadRestaPuntosSiSeRespondeMal(){
        creoUnaPreguntaDeVFConPenalidad();
        assertEquals(-1, unaPreguntaDeVFConPenalidad.puntuar(this.respuestaIncorrectaVF));
    }

    @Test
    public void unaPreguntaDeMCClasicoPuedeCrearseSiSeIndicaLasRtasCorretas(){ //Pto. 2
        creoUnaPreguntaDeMCClasico();
        assertEquals(1, this.unaPreguntaDeMCClasico.puntuar(new ArrayList<Respuesta>(Arrays.asList(this.respuestaCorrectaMCUno, this.respuestaCorrectaMCDos, this.respuestaCorrectaMCTres))));
    }

    @Test
    public void unaPreguntaDeMCClasicoPuntua0SiSeRespondeMal(){
        creoUnaPreguntaDeMCClasico();
        assertEquals(0, this.unaPreguntaDeMCClasico.puntuar(new ArrayList<Respuesta>(Arrays.asList(this.respuestaCorrectaMCUno, this.respuestaCorrectaMCDos, this.respuestaIncorrectaMCUno))));
    }

    @Test
    public void unaPreguntaDeMCParcialPuedeCrearseSiSeIndicaLasRtasCorretas(){ //Pto. 3
        creoUnaPreguntaDeMCParcial();
        assertEquals(2, this.unaPreguntaDeMCParcial.puntuar(new ArrayList<Respuesta>(Arrays.asList(this.respuestaCorrectaMCUno, this.respuestaCorrectaMCDos))));
    }

    @Test
    public void unaPreguntaDeMCParcialPuntua0SiSeRespondeMal(){
        creoUnaPreguntaDeMCParcial();
        assertEquals(0, this.unaPreguntaDeMCParcial.puntuar(new ArrayList<Respuesta>(Arrays.asList(this.respuestaCorrectaMCUno, this.respuestaCorrectaMCDos, this.respuestaIncorrectaMCUno))));
    }

    @Test
    public void unaPreguntaDeVFConPenalidadRecibeRespuestasYAsignaPuntos(){ //Pto. 4
        creoUnaPreguntaDeVFConPenalidad();
        ArrayList<Integer> puntosObtenidos = this.unaPreguntaDeVFConPenalidad.responder(new ArrayList<>(Arrays.asList(this.respuestaCorrectaVF, this.respuestaIncorrectaVF)));
        ArrayList<Integer> puntosEsperados = new ArrayList(Arrays.asList(1, -1));
        assertTrue(puntosObtenidos.equals(puntosEsperados));
    }

    @Test
    public void unaPreguntaDeMCClasicoRecibeRespuestasYAsignaPuntos(){ //Pto. 5
        creoUnaPreguntaDeMCClasico();
        ArrayList<Respuesta> respuestasUsuarioUno = new ArrayList<>(Arrays.asList(this.respuestaCorrectaMCDos, this.respuestaCorrectaMCTres, this.respuestaCorrectaMCUno));
        ArrayList<Respuesta> respuestasUsuarioDos = new ArrayList<>(Arrays.asList(this.respuestaCorrectaMCDos, this.respuestaIncorrectaMCUno, this.respuestaCorrectaMCUno));
        ArrayList<ArrayList<Respuesta>> respuestasUsuarios = new ArrayList<>(Arrays.asList(respuestasUsuarioUno, respuestasUsuarioDos));
        ArrayList<Integer> puntosObtenidos = this.unaPreguntaDeMCClasico.responder(respuestasUsuarios);
        ArrayList<Integer> puntosEsperados = new ArrayList(Arrays.asList(1, 0));
        assertTrue(puntosObtenidos.equals(puntosEsperados));
    }

    @Test
    public void unaPreguntaDeMCParcialRecibeRespuestasYAsignaPuntos(){ //Pto. 6
        creoUnaPreguntaDeMCParcial();
        ArrayList<Respuesta> respuestasUsuarioUno = new ArrayList<>(Arrays.asList(this.respuestaCorrectaMCDos, this.respuestaCorrectaMCTres, this.respuestaCorrectaMCUno));
        ArrayList<Respuesta> respuestasUsuarioDos = new ArrayList<>(Arrays.asList(this.respuestaCorrectaMCDos, this.respuestaIncorrectaMCUno, this.respuestaCorrectaMCUno));
        ArrayList<ArrayList<Respuesta>> respuestasUsuarios = new ArrayList<>(Arrays.asList(respuestasUsuarioUno, respuestasUsuarioDos));
        ArrayList<Integer> puntosObtenidos = this.unaPreguntaDeMCParcial.responder(respuestasUsuarios);
        ArrayList<Integer> puntosEsperados = new ArrayList(Arrays.asList(3, 0));
        assertTrue(puntosObtenidos.equals(puntosEsperados));
    }

}