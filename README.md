[![Build Status](https://travis-ci.org/fiuba/algo3_proyecto_base_tp2.svg?branch=master)](https://travis-ci.org/fiuba/algo3_proyecto_base_tp2) [![codecov](https://codecov.io/gh/fiuba/algo3_proyecto_base_tp2/branch/master/graph/badge.svg)](https://codecov.io/gh/fiuba/algo3_proyecto_base_tp2)



# TP2 Algoritmos 3: AlgoKahoot

Trabajo Práctico número 2 de la materia Algoritmos y Programación III de FIUBA

## Grupo 10

* **Carolina Di Matteo** - [gcc-cdimatteo](https://github.com/gcc-cdimatteo)
* **Juan Ignacio Díaz** - [Nacho-Dz](https://github.com/Nacho-Dz)
* **Agustin Vallcorba** - [agustinvallcorba](https://github.com/agustinvallcorba)
* **Leonardo De La Cruz** - [electromakumba](https://github.com/electromakumba)
* **Mariano Abbate** - [mabbate](https://github.com/mabbate)

Corrector: **Tomás Bustamante**

### Pre-requisitos

Listado de software/herramientas necesarias para el proyecto

```
java 11
maven 3.6.0
...
```

## Ejecutando las pruebas

```bash
    mvn test
```

Este comando crea el reporte de cobertura para CI y el reporte HTML que pueden abrir de la siguiente manera:

```bash
    <browser> ./target/site/jacoco/index.html
```

## Ejecutando la aplicación

Ejecutar el siguiente comando desde el directorio que contiene el archivo pom.xml 

```bash
    mvn clean javafx:run
```

## Formato del archivo JSON de preguntas
El archivo JSON consiste un array de preguntas llamado "pregutnas" 
 y según el tipo de pregunta tiene un
formato particular. Describimos los objetos JSON para cada tipo de pregunta:

### Pregunta VF
    {
      "tipo": "verdaderoFalsoPenalidad" ,
      "enunciado": "La manzana es una fruta" ,
      "respuesta": true
    }
    
El tipo pude ser verdaderoFalsoClasico o verdaderoFalsoPenalidad. La respuesta true o false.

### Pregunta Multiple Choice
    {
      "tipo": "multipleChoiceClasico" ,
      "enunciado": "La naranja es..." ,
      "opciones": [ "Una verdura" , "Una fruta" , "Un cítrico" , "Como la banana" ] ,
      "respuestas": [ 1 , 2 ] 
    }
El tipo puede ser:
* multipleChoiceClasico
* multipleChoiceParcial
* multipleChoicePenalidad

En respuesta se va el index (basado en 0) de las repuestas correctas seleccionadas desde las opciones.

### Pregunta Ordered Choice
    {
      "tipo": "orderedChoice" ,
      "enunciado": "Ordene según el abecedario las siguientes letras" ,
      "opciones": [ "D" , "B" , "C" , "A" ] ,
      "respuestas": [ 3 , 1 , 2 , 0 ]
    }

En respuestas se indica el array de índices que indican el orden de la secuencia correcta.    
    
### Pregunta Group Choice 
    {
      "tipo": "groupChoice" ,
      "enunciado": "Agrupe según frutas (A) y verduras (B)",
      "opciones": [ "Lechuga" , "Naranja" , "Banana" , "Zanahoria" , "Tomate" ] ,
      "respuestas": { "grupoUno": [ 1 , 2 , 4 ] , "grupoDos": [ 0 , 3 ] }
    }
    
En el enunciado por claridad es conveniente indicar claramente el tipo de grupo. Puede ser como
en el ejemplo (A) o (B).
En las repuestas se dan los índice de las opciones que entran en cada grupo.

### Ejemplo de archivo completo conteniendo dos preguntas

    {
      "preguntas": [
        {
          "tipo": "verdaderoFalsoPenalidad" ,
          "enunciado": "La manzana es una fruta" ,
          "respuesta": true
        } ,
        {
          "tipo": "multipleChoiceClasico" ,
          "enunciado": "La naranja es..." ,
          "opciones": [ "Una verdura" , "Una fruta" , "Un cítrico" , "Como la banana" ] ,
          "respuestas": [ 1 , 2 ] 
        }
      ]
    }


## Licencia

Este repositorio está bajo la Licencia MIT
