package com.hluther.javacompiler.modelos.instruccion.inc_dec;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.hluther.javacompiler.modelos.instruccion.Instruccion;
import com.hluther.javacompiler.modelos.instruccion.complemento.ResultadoInstruccion;

public class IncDec implements Instruccion {

    @JsonProperty("id")
    private String id;

    @JsonProperty("opr")
    private String opr;

    @Override
    public void generarCodigo(ResultadoInstruccion res) {
        res.getCodigo3d().agregarCodigo(id+" = "+id+" "+opr+" 1");
    }
}
