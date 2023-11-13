package com.rex.compiladormultilenguajeservidor.utilidades;

import java.io.*;

public class Archivo {

    public static String recuperarArchivo(File archivo){
        String texto = "";
        try {
            FileReader fileReader;
            fileReader = new FileReader(archivo);
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            String textoTemporal = "";

            while((textoTemporal = bufferedReader.readLine()) != null){
                texto += textoTemporal+"\n";
            }

            return texto;
        } catch (IOException ex) {
            return null;
        }
    }

    public static void escribirArchivo(File archivo, String texto) throws IOException{
        if(!archivo.exists()){
            archivo.createNewFile();
        }
        FileWriter fileWriter = new FileWriter(archivo);
        try (BufferedWriter bufferedWriter = new BufferedWriter(fileWriter)) {
            bufferedWriter.write(texto);
        }
    }

}
