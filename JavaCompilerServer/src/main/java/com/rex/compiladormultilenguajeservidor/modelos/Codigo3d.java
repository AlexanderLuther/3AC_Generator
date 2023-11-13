package com.rex.compiladormultilenguajeservidor.modelos;

public class Codigo3d {

    private String codigo;

    public Codigo3d() {
        this.codigo = "";
    }

    public void agregarCodigo(String codigo){
        this.codigo += codigo+"\n";
    }

    public String getCodigo() {
        return codigo;
    }
}
