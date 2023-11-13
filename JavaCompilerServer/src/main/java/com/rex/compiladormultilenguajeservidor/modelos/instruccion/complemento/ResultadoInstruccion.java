package com.rex.compiladormultilenguajeservidor.modelos.instruccion.complemento;

import com.rex.compiladormultilenguajeservidor.modelos.Codigo3d;

public class ResultadoInstruccion {

    private String valor;
    private int idT;
    private int idE;
    private Codigo3d codigo3d;

    public ResultadoInstruccion(String valor, int idT, int idE) {
        this.valor = valor;
        this.idT = idT;
        this.idE = idE;
        codigo3d = new Codigo3d();
    }

    public String getValor() {
        return valor;
    }

    public int getIdT() {
        return idT;
    }

    public int getIdE() {
        return idE;
    }

    public void setValor(String valor) {
        this.valor = valor;
    }

    public int incIdT() {
        this.idT++;
        return this.idT;
    }

    public int incIdE() {
        this.idE++;
        return this.idE;
    }

    public Codigo3d getCodigo3d() {
        return codigo3d;
    }
}
