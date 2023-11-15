import { Injectable } from '@angular/core';
import { File } from 'src/app/models/ide/file.model';
import { Package } from 'src/app/models/ide/package.model';
import { Project } from 'src/app/models/ide/project.model.';

@Injectable({
  providedIn: 'root'
})
export class FilesManagerService {

  constructor() { }

  public getAllFiles(project: Project):Array<File>{
    let files:Array<File> = new Array();
    this.getFilesPackages(project.principalPackage, files);
    return files;
  }
  
  private getFilesPackages(package_: Package, files: Array<File>){
    for(let i=0;i<package_.files.length;i++){
        files.push(package_.files[i]);
    }
    for(let i=0;i<package_.packages.length;i++){
        this.getFilesPackages(package_.packages[i], files);
    }
}

}
