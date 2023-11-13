package com.rex.compiladormultilenguajeservidor.modelos.instruccion.ciclo;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.rex.compiladormultilenguajeservidor.modelos.instruccion.Instruccion;
import com.rex.compiladormultilenguajeservidor.modelos.instruccion.complemento.ResultadoInstruccion;

import java.util.LinkedList;

public class DoWhile implements Instruccion {

    @JsonProperty("condicion")
    private Instruccion condicion;

    @JsonProperty("instrucciones")
    private LinkedList<Instruccion> instrucciones;

    @Override
    public void generarCodigo(ResultadoInstruccion res) {
        int etIDW = res.getIdE();
        res.incIdE();
        res.getCodigo3d().agregarCodigo("et"+etIDW+":");
        for(Instruccion instruccion:this.instrucciones){
            instruccion.generarCodigo(res);
        }
        this.condicion.generarCodigo(res);
        res.getCodigo3d().agregarCodigo("if "+res.getValor()+" goto et"+etIDW);
    }
}
