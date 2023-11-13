package com.rex.compiladormultilenguajeservidor.modelos;

public class Confirmacion {

    private String descripcion;
    private boolean estado;

    public Confirmacion(String descripcion, boolean estado) {
        this.descripcion = descripcion;
        this.estado = estado;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public boolean isEstado() {
        return estado;
    }

    public void setEstado(boolean estado) {
        this.estado = estado;
    }
}
