package com.hluther.javacompiler.utilidades.proyecto;

import com.hluther.javacompiler.modelos.proyecto.File;
import com.hluther.javacompiler.modelos.proyecto.Package;
import com.hluther.javacompiler.modelos.proyecto.Project;

public class ConstructorXML {

    public String construirXML(Project proyecto){
        String codigo = "<PROYECTO_W>";
        codigo += "     <NOMBRE_PROYECTO>"+proyecto.getName().trim()+"</NOMBRE_PROYECTO>";
        codigo += "     <PAQUETE_PRINCIPAL>";
        codigo += "     <PAQUETES_PAQUETE>";
        for (Package paqueteHijo:proyecto.getPrincipalPackage().getPackages()){
            codigo += construirPaquete(paqueteHijo);
        }
        codigo += "     </PAQUETES_PAQUETE>";
        codigo += "     <ARCHIVOS_PAQUETE>";
        for (File archivo:proyecto.getPrincipalPackage().getFiles()){
            codigo += construirArchivo(archivo);
        }
        codigo += "     </ARCHIVOS_PAQUETE>";
        codigo += "     </PAQUETE_PRINCIPAL>";
        codigo += "</PROYECTO_W>";
        return codigo;
    }

    private String construirArchivo(File archivo){
        String codigo = "<ARCHIVO>";
        codigo += "     <NOMBRE_ARCHIVO>"+archivo.getName().trim()+"</NOMBRE_ARCHIVO>";
        codigo += "     <ID_ARCHIVO>"+archivo.getId().trim()+"</ID_ARCHIVO>";
        codigo += "     <PAQUETE_ARCHIVO>"+archivo.getPackage_().trim()+"</PAQUETE_ARCHIVO>";
        codigo += "     <CODIGO_ARCHIVO>*!+\"@@@\"###$$$"+archivo.getCode()+"$$$###\"@@@\"+!*</CODIGO_ARCHIVO>";
        codigo += "</ARCHIVO>";
        return codigo;
    }

    private String construirPaquete(Package paquete){
        String codigo = "<PAQUETE>";
        codigo += "     <NOMBRE_PAQUETE>"+paquete.getName().trim()+"</NOMBRE_PAQUETE>";
        codigo += "     <ID_PAQUETE>"+paquete.getId().trim()+"</ID_PAQUETE>";
        codigo += "     <PAQUETES_PAQUETE>";
        for (Package paqueteHijo:paquete.getPackages()){
            codigo += construirPaquete(paqueteHijo);
        }
        codigo += "     </PAQUETES_PAQUETE>";
        codigo += "     <ARCHIVOS_PAQUETE>";
        for (File archivo:paquete.getFiles()){
            codigo += construirArchivo(archivo);
        }
        codigo += "     </ARCHIVOS_PAQUETE>";
        codigo += "</PAQUETE>";
        return codigo;
    }


}
