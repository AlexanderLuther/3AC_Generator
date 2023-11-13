package com.rex.compiladormultilenguajeservidor.modelos.instruccion;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.rex.compiladormultilenguajeservidor.modelos.Codigo3d;
import com.rex.compiladormultilenguajeservidor.modelos.instruccion.complemento.ResultadoInstruccion;

public class Asignacion implements Instruccion{

    @JsonProperty("opr1")
    private String opr1;
    @JsonProperty("opr2")
    private Instruccion opr2;

    @Override
    public void generarCodigo(ResultadoInstruccion res) {
        this.opr2.generarCodigo(res);
        res.getCodigo3d().agregarCodigo(opr1+" = "+res.getValor());
    }
}
