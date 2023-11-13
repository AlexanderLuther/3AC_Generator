package com.rex.compiladormultilenguajeservidor.modelos.instruccion.condicional;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.rex.compiladormultilenguajeservidor.modelos.Codigo3d;
import com.rex.compiladormultilenguajeservidor.modelos.instruccion.Instruccion;
import com.rex.compiladormultilenguajeservidor.modelos.instruccion.complemento.ResultadoInstruccion;

import java.util.LinkedList;

public class If implements Instruccion {

    @JsonProperty("condicion")
    private Instruccion condicion;

    @JsonProperty("instrucciones")
    private LinkedList<Instruccion> instrucciones;

    @JsonProperty("instruccionesElseIf")
    private LinkedList<ElseIf> instruccionesElseIf;

    @JsonProperty("instruccionElse")
    private Else instruccionElse;


    @Override
    public void generarCodigo(ResultadoInstruccion res) {
        this.condicion.generarCodigo(res);
        int numEtIf = res.getIdE();
        int numEtN = res.incIdE();
        res.getCodigo3d().agregarCodigo("if "+res.getValor()+" goto et"+numEtIf);
        if(this.instruccionesElseIf.size()==0 && this.instruccionElse==null){
            res.getCodigo3d().agregarCodigo("goto etf"+numEtIf);
        }else{
            res.getCodigo3d().agregarCodigo("goto et"+numEtN);
        }
        res.getCodigo3d().agregarCodigo("et"+numEtIf+":");
        res.incIdE();
        for (Instruccion instruccion:this.instrucciones){
            instruccion.generarCodigo(res);
        }
        res.getCodigo3d().agregarCodigo("goto etf"+numEtIf);

        if(this.instruccionesElseIf.size()==0 && this.instruccionElse==null){
            res.getCodigo3d().agregarCodigo("etf"+numEtIf+":");
        }else{
            res.getCodigo3d().agregarCodigo("et"+numEtN+":");
            for(ElseIf elseIf:this.instruccionesElseIf){
                elseIf.setIdEF(numEtIf);
                elseIf.generarCodigo(res);
            }
            if(this.instruccionElse==null){
                res.getCodigo3d().agregarCodigo("goto etf"+numEtIf);
            }else{
                this.instruccionElse.setIdEF(numEtIf);
                this.instruccionElse.generarCodigo(res);
            }
            res.getCodigo3d().agregarCodigo("etf"+numEtIf+":");
        }

    }

    private void generarCodigoEstructuraIf(ResultadoInstruccion res,Instruccion condicion){
        /*condicion.generarCodigo(res);
        int numEtIf = res.getIdE();
        int numEtF = res.incIdE();
        res.getCodigo3d().agregarCodigo("if "+res.getValor()+" goto et"+numEtIf);
        res.getCodigo3d().agregarCodigo("goto et"+numEtF);
        res.getCodigo3d().agregarCodigo("et"+numEtIf+":");
        for (Instruccion instruccion:this.instrucciones){
            instruccion.generarCodigo(res);
        }
        res.getCodigo3d().agregarCodigo("goto etf"+numEtIf);
        res.getCodigo3d().agregarCodigo("et"+numEtF+":");
        res.incIdE();*/
    }
}
