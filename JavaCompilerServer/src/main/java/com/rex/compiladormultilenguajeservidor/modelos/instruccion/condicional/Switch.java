package com.rex.compiladormultilenguajeservidor.modelos.instruccion.condicional;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.rex.compiladormultilenguajeservidor.modelos.instruccion.Instruccion;
import com.rex.compiladormultilenguajeservidor.modelos.instruccion.complemento.ResultadoInstruccion;

import java.util.LinkedList;

public class Switch implements Instruccion {

    @JsonProperty("variable")
    private Instruccion variable;

    @JsonProperty("casos")
    private LinkedList<Case> casos;

    @JsonProperty("casoDefault")
    private Default casoDefault;

    @Override
    public void generarCodigo(ResultadoInstruccion res) {
        int iES = res.getIdE();
        res.incIdE();
        res.getCodigo3d().agregarCodigo("goto et"+iES);
        for (Case aCase:this.casos){
            aCase.setIdES(iES);
            aCase.generarCodigo(res);
        }
        if(this.casoDefault!=null){
            this.casoDefault.setIdES(iES);
            this.casoDefault.generarCodigo(res);
        }
        res.getCodigo3d().agregarCodigo("goto etf"+iES);
        res.getCodigo3d().agregarCodigo("et"+iES+":");
        this.variable.generarCodigo(res);
        String var = res.getValor();
        for (Case aCase:this.casos){
            aCase.getVariable().generarCodigo(res);
            res.getCodigo3d().agregarCodigo("if "+var+" == "+res.getValor()+" goto et"+aCase.getIdE());
        }
        if(this.casoDefault!=null){
            res.getCodigo3d().agregarCodigo("goto et"+casoDefault.getIdE());
        }
        res.getCodigo3d().agregarCodigo("etf"+iES+":");
    }
}
