package com.rex.compiladormultilenguajeservidor.utilidades;

import com.rex.compiladormultilenguajeservidor.controladores.ControladorServicioProyecto;
import com.rex.compiladormultilenguajeservidor.modelos.proyecto.Proyecto;
import com.rex.compiladormultilenguajeservidor.utilidades.proyecto.analisis.Lexer;
import com.rex.compiladormultilenguajeservidor.utilidades.proyecto.analisis.Parser;

import java.io.File;
import java.io.StringReader;

public class RecuperadorProyecto {

    public Proyecto recuperar(String proyecto){
        File file = new File(ControladorServicioProyecto.PATH_DATA_PROYECTO+proyecto+".xml");
        if(file.exists()){
            Lexer lexer = new Lexer(new StringReader(Archivo.recuperarArchivo(file)));
            Parser parser = new Parser(lexer);
            try {
                parser.parse();
                System.out.println("ANALISIS CON 0 ERRORES");
                return parser.getProyecto();
            }catch (Exception e){
                e.printStackTrace();
                return new Proyecto();
            }
        }else{
            return new Proyecto();
        }
    }

}
