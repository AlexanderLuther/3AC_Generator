package com.rex.compiladormultilenguajeservidor.modelos.instruccion.condicional;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.rex.compiladormultilenguajeservidor.modelos.instruccion.Instruccion;
import com.rex.compiladormultilenguajeservidor.modelos.instruccion.complemento.ResultadoInstruccion;

import java.util.LinkedList;

public class Default implements Instruccion {

    @JsonProperty("instrucciones")
    private LinkedList<Instruccion> instrucciones;

    @JsonProperty("contieneBreak")
    private boolean contieneBreak;

    private int idES;
    private int idE;

    @Override
    public void generarCodigo(ResultadoInstruccion res) {
        this.idE = res.getIdE();
        res.incIdE();
        res.getCodigo3d().agregarCodigo("et"+idE+":");
        for (Instruccion instruccion:this.instrucciones){
            instruccion.generarCodigo(res);
        }
        if(contieneBreak){
            res.getCodigo3d().agregarCodigo("goto etf"+idES);
        }
    }

    public void setIdES(int idES) {
        this.idES = idES;
    }

    public int getIdE() {
        return idE;
    }
}
