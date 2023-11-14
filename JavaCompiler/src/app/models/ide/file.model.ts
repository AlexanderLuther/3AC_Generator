export class File {

    public name : string;
    public package_ : string;
    public code : string;
    public id : string;
    
    constructor(name : string, id: string, package_ : string, code : string){
        this.name = name;
        this.package_ = package_;
        this.code = code;
        this.id = id;
    }

}