package com.rex.compiladormultilenguajeservidor.modelos.instruccion.condicional;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.rex.compiladormultilenguajeservidor.modelos.Codigo3d;
import com.rex.compiladormultilenguajeservidor.modelos.instruccion.Instruccion;
import com.rex.compiladormultilenguajeservidor.modelos.instruccion.complemento.ResultadoInstruccion;

import java.util.LinkedList;

public class Else implements Instruccion {

    @JsonProperty("instrucciones")
    private LinkedList<Instruccion> instrucciones;

    private int idEF;

    @Override
    public void generarCodigo(ResultadoInstruccion res) {
        for (Instruccion instruccion:this.instrucciones){
            instruccion.generarCodigo(res);
        }
        res.getCodigo3d().agregarCodigo("goto etf"+this.idEF);
    }

    public void setIdEF(int idEF) {
        this.idEF = idEF;
    }
}
