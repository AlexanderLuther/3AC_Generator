//import { GestionadorPaquete } from "src/resources/utilidades/proyecto/GestionadorPaquete";
import { Package } from "./package";

export class Project{

    public name:string;
    public principalPackage:Package;
    

    constructor(name:string){
        this.name = name;
        this.principalPackage = new Package(this.name,this.name);
    }

}