package com.rex.compiladormultilenguajeservidor.modelos.instruccion;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.rex.compiladormultilenguajeservidor.modelos.Codigo3d;
import com.rex.compiladormultilenguajeservidor.modelos.instruccion.complemento.ResultadoInstruccion;

import java.util.LinkedList;

public class Metodo implements Instruccion{

    @JsonProperty("nombre")
    private String nombre;
    @JsonProperty("instrucciones")
    private LinkedList<Instruccion> instrucciones;

    public Metodo(String nombre, LinkedList<Instruccion> instrucciones) {
        this.nombre = nombre;
        this.instrucciones = instrucciones;
    }

    @Override
    public void generarCodigo(ResultadoInstruccion res) {
        res.getCodigo3d().agregarCodigo(this.nombre+" {");
        for (Instruccion instruccion:this.instrucciones){
            instruccion.generarCodigo(res);
        }
        res.getCodigo3d().agregarCodigo("}");
    }

    public void setNombreOficial(String nombreClase){
        this.nombre = nombreClase+"_"+this.nombre;
    }
}
