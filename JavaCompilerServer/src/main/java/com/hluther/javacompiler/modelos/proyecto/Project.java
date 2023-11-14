package com.hluther.javacompiler.modelos.proyecto;

public class Project {


    private String name;
    private Package principalPackage;

    public Project() {
        principalPackage = new Package();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Package getPrincipalPackage() {
        return principalPackage;
    }

    public void setPrincipalPackage(Package principalPackage) {
        this.principalPackage = principalPackage;
    }
}
