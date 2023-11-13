package com.rex.compiladormultilenguajeservidor.modelos.proyecto;

public class Proyecto {

    private String nombre;
    private Paquete paquetePrincipal;

    public Proyecto() {
        paquetePrincipal = new Paquete();
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Paquete getPaquetePrincipal() {
        return paquetePrincipal;
    }

    public void setPaquetePrincipal(Paquete paquetePrincipal) {
        this.paquetePrincipal = paquetePrincipal;
    }
}
