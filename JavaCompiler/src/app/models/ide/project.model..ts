import { Package } from "./package.model";

export class Project{

    public name: string;
    public principalPackage: Package

    constructor(name: string) {
        this.name = name;
        this.principalPackage = new Package(name, name);
    }

}