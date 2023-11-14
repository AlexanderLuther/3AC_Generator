package com.hluther.javacompiler.utilidades.proyecto;

import com.hluther.javacompiler.controladores.ControladorServicioProyecto;
import com.hluther.javacompiler.modelos.proyecto.Project;
import com.hluther.javacompiler.utilidades.proyecto.Archivo;
import com.hluther.javacompiler.utilidades.proyecto.analisis.Lexer;
import com.hluther.javacompiler.utilidades.proyecto.analisis.Parser;

import java.io.File;
import java.io.StringReader;

public class RecuperadorProyecto {

    public Project recuperar(String proyecto){
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
                return new Project();
            }
        }else{
            return new Project();
        }
    }

}
