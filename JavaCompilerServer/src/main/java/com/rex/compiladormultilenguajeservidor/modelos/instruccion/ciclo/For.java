package com.rex.compiladormultilenguajeservidor.modelos.instruccion.ciclo;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.rex.compiladormultilenguajeservidor.modelos.instruccion.Instruccion;
import com.rex.compiladormultilenguajeservidor.modelos.instruccion.complemento.ResultadoInstruccion;

import java.util.LinkedList;

public class For implements Instruccion {

    @JsonProperty("accionInicial")
    private Instruccion accionInicial;

    @JsonProperty("condicion")
    private Instruccion condicion;

    @JsonProperty("accionPosterior")
    private Instruccion accionPosterior;

    @JsonProperty("instrucciones")
    private LinkedList<Instruccion> instrucciones;

    @Override
    public void generarCodigo(ResultadoInstruccion res) {
        if(this.accionInicial!=null){
            this.accionInicial.generarCodigo(res);
        }
        int idEF = res.getIdE();
        int idIF = res.incIdE();
        res.incIdE();
        res.getCodigo3d().agregarCodigo("et"+idEF+":");
        this.condicion.generarCodigo(res);
        res.getCodigo3d().agregarCodigo("if "+res.getValor()+" goto et"+idIF);
        res.getCodigo3d().agregarCodigo("goto etf"+idIF);
        res.getCodigo3d().agregarCodigo("et"+idIF+":");
        for (Instruccion instruccion:this.instrucciones){
            instruccion.generarCodigo(res);
        }
        if(this.accionPosterior!=null){
            this.accionPosterior.generarCodigo(res);
        }
        res.getCodigo3d().agregarCodigo("goto et"+idEF);
        res.getCodigo3d().agregarCodigo("etf"+idIF+":");
    }
}
