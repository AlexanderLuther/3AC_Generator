export class File {

    public name:string;
    public package:string;
    public code:string;
    public id:string;

    constructor(name:string,id:string,packet:string,code:string){
        this.name = name;
        this.id = id;
        this.package = packet;
        this.code = code;
    }

}