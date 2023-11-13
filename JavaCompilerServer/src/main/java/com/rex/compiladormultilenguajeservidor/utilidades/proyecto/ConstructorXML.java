package com.rex.compiladormultilenguajeservidor.utilidades.proyecto;

import com.rex.compiladormultilenguajeservidor.modelos.proyecto.Archivo;
import com.rex.compiladormultilenguajeservidor.modelos.proyecto.Paquete;
import com.rex.compiladormultilenguajeservidor.modelos.proyecto.Proyecto;

public class ConstructorXML {

    public String construirXML(Proyecto proyecto){
        String codigo = "<PROYECTO_W>";
        codigo += "     <NOMBRE_PROYECTO>"+proyecto.getNombre().trim()+"</NOMBRE_PROYECTO>";
        codigo += "     <PAQUETE_PRINCIPAL>";
        codigo += "     <PAQUETES_PAQUETE>";
        for (Paquete paqueteHijo:proyecto.getPaquetePrincipal().getPaquetes()){
            codigo += construirPaquete(paqueteHijo);
        }
        codigo += "     </PAQUETES_PAQUETE>";
        codigo += "     <ARCHIVOS_PAQUETE>";
        for (Archivo archivo:proyecto.getPaquetePrincipal().getArchivos()){
            codigo += construirArchivo(archivo);
        }
        codigo += "     </ARCHIVOS_PAQUETE>";
        codigo += "     </PAQUETE_PRINCIPAL>";
        codigo += "</PROYECTO_W>";
        return codigo;
    }

    private String construirArchivo(Archivo archivo){
        String codigo = "<ARCHIVO>";
        codigo += "     <NOMBRE_ARCHIVO>"+archivo.getNombre().trim()+"</NOMBRE_ARCHIVO>";
        codigo += "     <ID_ARCHIVO>"+archivo.getId().trim()+"</ID_ARCHIVO>";
        codigo += "     <PAQUETE_ARCHIVO>"+archivo.getPaquete().trim()+"</PAQUETE_ARCHIVO>";
        codigo += "     <CODIGO_ARCHIVO>*!+\"@@@\"###$$$"+archivo.getCodigo()+"$$$###\"@@@\"+!*</CODIGO_ARCHIVO>";
        codigo += "</ARCHIVO>";
        return codigo;
    }

    private String construirPaquete(Paquete paquete){
        String codigo = "<PAQUETE>";
        codigo += "     <NOMBRE_PAQUETE>"+paquete.getNombre().trim()+"</NOMBRE_PAQUETE>";
        codigo += "     <ID_PAQUETE>"+paquete.getId().trim()+"</ID_PAQUETE>";
        codigo += "     <PAQUETES_PAQUETE>";
        for (Paquete paqueteHijo:paquete.getPaquetes()){
            codigo += construirPaquete(paqueteHijo);
        }
        codigo += "     </PAQUETES_PAQUETE>";
        codigo += "     <ARCHIVOS_PAQUETE>";
        for (Archivo archivo:paquete.getArchivos()){
            codigo += construirArchivo(archivo);
        }
        codigo += "     </ARCHIVOS_PAQUETE>";
        codigo += "</PAQUETE>";
        return codigo;
    }


}
