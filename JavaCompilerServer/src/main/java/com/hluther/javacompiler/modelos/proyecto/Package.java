package com.hluther.javacompiler.modelos.proyecto;

import java.util.LinkedList;
import java.util.List;

public class Package {

    private String name;
    private String id;
    private List<File> files;
    private List<Package> packages;

    public Package() {
        files = new LinkedList<>();
        packages = new LinkedList<>();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public List<File> getFiles() {
        return files;
    }

    public void setFiles(LinkedList<File> files) {
        this.files = files;
    }

    public List<Package> getPackages() {
        return packages;
    }

    public void setPackages(LinkedList<Package> packages) {
        this.packages = packages;
    }

    public void agregarPaquete(Package paquete){
        this.packages.add(paquete);
    }

    public void agregarArchivo(File archivo){
        this.files.add(archivo);
    }
}
