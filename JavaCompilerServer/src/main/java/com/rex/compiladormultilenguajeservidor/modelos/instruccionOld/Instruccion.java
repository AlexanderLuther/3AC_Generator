package com.rex.compiladormultilenguajeservidor.modelos.instruccionOld;

import com.rex.compiladormultilenguajeservidor.modelos.Codigo3d;
import com.rex.compiladormultilenguajeservidor.modelos.instruccion.complemento.ResultadoInstruccion;
import com.rex.compiladormultilenguajeservidor.modelos.instruccion.complemento.TipoInstruccion;

import java.util.LinkedList;

public class Instruccion {

    private Instruccion opr1;
    private Instruccion opr2;
    private Object resultado;
    private String opr;
    private LinkedList<Instruccion> instrucciones;

    /*
    public ResultadoInstruccion generarCodigo(int idT, Codigo3d codigo3d){
        if(this.opr.equals(TipoInstruccion.INT)|this.opr.equals(TipoInstruccion.ID)|this.opr.equals(TipoInstruccion.CHAR)|this.opr.equals(TipoInstruccion.FLOAT)){
            ResultadoInstruccion ri = new ResultadoInstruccion(this.resultado.toString(),idT);
            return ri;
        }else if(this.opr.equals(TipoInstruccion.ASIGNACION)){
            ResultadoInstruccion res1 = this.opr1.generarCodigo(idT,codigo3d);
            ResultadoInstruccion res2 = this.opr2.generarCodigo(res1.getIdT(),codigo3d);
            codigo3d.agregarCodigo(res1.getValor()+" = "+res2.getValor());
            return new ResultadoInstruccion("",res2.getIdT());
        }else{
            ResultadoInstruccion res1 = this.opr1.generarCodigo(idT,codigo3d);
            ResultadoInstruccion res2 = this.opr2.generarCodigo(res1.getIdT(),codigo3d);
            String res = "t"+res2.getIdT();
            codigo3d.agregarCodigo(res+" = "+res1.getValor()+" "+this.opr+" "+res2.getValor());
            return new ResultadoInstruccion(res,res2.getIdT()+1);
        }
    }
    */

    public Instruccion getOpr1() {
        return opr1;
    }

    public void setOpr1(Instruccion opr1) {
        this.opr1 = opr1;
    }

    public Instruccion getOpr2() {
        return opr2;
    }

    public void setOpr2(Instruccion opr2) {
        this.opr2 = opr2;
    }

    public Object getResultado() {
        return resultado;
    }

    public void setResultado(Object resultado) {
        this.resultado = resultado;
    }

    public String getOpr() {
        return opr;
    }

    public void setOpr(String opr) {
        this.opr = opr;
    }

    public LinkedList<Instruccion> getInstrucciones() {
        return instrucciones;
    }
}
