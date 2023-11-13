import { File } from "./file";

export class Package {

    public name:string;
    public id:string;
    public files:Array<File>;
    public packages:Array<Package>;

    constructor(name:string,id:string){
        this.name = name;
        this.id = id;
        this.files = new Array();
        this.packages = new Array();
    }

}