package com.rex.compiladormultilenguajeservidor.modelos.instruccion;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.rex.compiladormultilenguajeservidor.modelos.Codigo3d;
import com.rex.compiladormultilenguajeservidor.modelos.instruccion.complemento.ResultadoInstruccion;
import com.rex.compiladormultilenguajeservidor.modelos.instruccion.complemento.TipoInstruccion;

public class Operacion implements Instruccion{

    @JsonProperty("opr1")
    private Instruccion opr1;
    @JsonProperty("opr2")
    private Instruccion opr2;
    @JsonProperty("opr")
    private String opr;
    @JsonProperty("resultado")
    private Object resultado;

    @Override
    public void generarCodigo(ResultadoInstruccion res) {
        if(this.opr.equals(TipoInstruccion.INT)|this.opr.equals(TipoInstruccion.DOUBLE)|this.opr.equals(TipoInstruccion.BOOLEAN)|this.opr.equals(TipoInstruccion.STRING)|this.opr.equals(TipoInstruccion.ID)|this.opr.equals(TipoInstruccion.CHAR)|this.opr.equals(TipoInstruccion.FLOAT)){
            res.setValor(this.resultado.toString());
        }else{
            this.opr1.generarCodigo(res);
            String res1 = res.getValor();
            this.opr2.generarCodigo(res);
            String res2 = res.getValor();
            String resultado = "t"+res.getIdT();
            res.setValor(resultado);
            res.getCodigo3d().agregarCodigo(resultado+" = "+res1+" "+this.opr+" "+res2);
            res.incIdT();
        }
    }
}
