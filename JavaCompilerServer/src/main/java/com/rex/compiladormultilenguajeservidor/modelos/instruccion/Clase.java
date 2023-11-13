package com.rex.compiladormultilenguajeservidor.modelos.instruccion;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.rex.compiladormultilenguajeservidor.modelos.instruccion.complemento.ResultadoInstruccion;

import java.util.LinkedList;

public class Clase implements Instruccion{

    @JsonProperty("nombre")
    private String nombre;

    @JsonProperty("instrucciones")
    private LinkedList<Instruccion> instrucciones;

    @Override
    public void generarCodigo(ResultadoInstruccion res) {
        LinkedList<Instruccion> instruccionesConstructor = new LinkedList<>();
        for(Instruccion instruccion:this.instrucciones){
            if (instruccion instanceof Metodo) {
                continue;
            }else{
                instruccionesConstructor.add(instruccion);
            }
        }
        Metodo constructor = new Metodo(this.nombre+"_"+this.nombre,instruccionesConstructor);
        constructor.generarCodigo(res);
        for (Instruccion instruccion:this.instrucciones){
            if(instruccion instanceof Metodo){
                ((Metodo)instruccion).setNombreOficial(this.nombre);
                instruccion.generarCodigo(res);
            }
        }
    }
}
