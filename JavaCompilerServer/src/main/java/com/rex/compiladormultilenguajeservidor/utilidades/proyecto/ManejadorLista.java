package com.rex.compiladormultilenguajeservidor.utilidades.proyecto;

import com.rex.compiladormultilenguajeservidor.controladores.ControladorServicioProyecto;

import java.io.*;
import java.util.LinkedList;

public class ManejadorLista {

    public static final String nombreArchivoLista = ControladorServicioProyecto.PATH_DATA_PROYECTO+"list_data.dat";

    public void registrarProyecto(String nombreProyecto){
        File archivo = new File(nombreArchivoLista);
        if(archivo.exists()){
            LinkedList<String> lista = recuperarListaProyectos();
            if(!contieneProyecto(nombreProyecto,lista)){
                lista.add(nombreProyecto);
                escribirListaProyectos(lista);
            }
        }else{
            LinkedList<String> lista = new LinkedList<>();
            lista.add(nombreProyecto);
            escribirListaProyectos(lista);
        }
    }

    private boolean contieneProyecto(String nombreProyecto,LinkedList<String> lista){
        for(String nombre:lista){
            if(nombre.equals(nombreProyecto)){
                return true;
            }
        }
        return false;
    }

    private void escribirListaProyectos(LinkedList<String> lista){
        try(
                FileOutputStream fileOutputStream = new FileOutputStream(nombreArchivoLista);
                ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);
        ){
            objectOutputStream.writeObject(lista);
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public LinkedList<String> recuperarListaProyectos(){
        try (
            FileInputStream fileInputStream = new FileInputStream(nombreArchivoLista);
            ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);
        ){
            return (LinkedList<String>)objectInputStream.readObject();
        } catch (Exception e) {
            return new LinkedList<>();
        }
    }

}
