package com.rex.compiladormultilenguajeservidor.test;

import com.rex.compiladormultilenguajeservidor.utilidades.Archivo;
import com.rex.compiladormultilenguajeservidor.utilidades.proyecto.analisis.Lexer;
import com.rex.compiladormultilenguajeservidor.utilidades.proyecto.analisis.Parser;

import java.io.File;
import java.io.StringReader;

public class Test {

    public static void main(String[] args) {
        levantarProyecto();
    }

    private static void levantarProyecto(){
        File file = new File("data/proyecto1.xml");
        if(file.exists()){
            Lexer lexer = new Lexer(new StringReader(Archivo.recuperarArchivo(file)));
            Parser parser = new Parser(lexer);
            try {
                parser.parse();
                System.out.println("ANALISIS CON 0 ERRORES");
            }catch (Exception e){
                e.printStackTrace();
            }
        }else{
            System.out.println("NO EXISTE EL PROYECTO");
        }
    }

}
