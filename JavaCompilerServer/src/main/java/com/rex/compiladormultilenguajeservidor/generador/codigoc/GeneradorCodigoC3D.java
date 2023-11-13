package com.rex.compiladormultilenguajeservidor.generador.codigoc;

import com.rex.compiladormultilenguajeservidor.modelos.instruccion.Instruccion;

import java.util.LinkedList;

public class GeneradorCodigoC3D {

    private String codigo;

    public GeneradorCodigoC3D() {
        this.codigo = "";
    }

    public void generarCodigo(LinkedList<Instruccion> instrucciones){
        codigo += "#include <stdio.h>\n" +
                "#include <stdlib.h>\n" +
                "#include <string.h>";
    }

}
