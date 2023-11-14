package com.hluther.javacompiler.modelos;

public class Confirmation {

    private String description;
    private boolean status;

    public Confirmation(String descripcion, boolean estado) {
        this.description = descripcion;
        this.status = estado;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }
}
