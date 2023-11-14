import { Injectable } from '@angular/core';
import { File } from 'src/app/models/ide/file.model';
import { Package } from 'src/app/models/ide/package.model';
import { Project } from 'src/app/models/ide/project.model.';

@Injectable({
  providedIn: 'root'
})
export class PackageManagerService {

    public newFile(id: string, project: Project, code: string){
      let names: Array<string> = id.split('.');
      let fileName: string = names.pop()!;
      let packageName: string = names.join('.');
      if(names.length == 0){
        project.principalPackage.files.push(new File(fileName, id, project.principalPackage.name, code));
      } else {
        let package_ = this.createPackage(packageName, project);
        package_.files.push(new File(fileName, id, package_.name, code));
      }
    }

    public saveFileChanges(name: string, project: Project, code: string){
      let file = this.findFile(name, project);
    }

    public findFile(id: string, project: Project): File | null {
      let names: Array<string> = id.split('.');
      let fileName: string = names.pop()!;
      let packageName: string = names.join('.');
      let package_: Package;
      
      if(packageName == ""){
        package_ = project.principalPackage;
      } else {
        package_ = this.findPackage(packageName, project)!;
      }

      if(package_ == null){
        return null;
      } else{
        for (const i in package_.files) {
          if(package_.files[i].name == fileName){
            return package_.files[i];
          }
        }
        return null;
      }

    }

    public findPackage(id: string, project: Project): Package | null {
      let names: Array<string> = id.split('.');
      let package_: Package = project.principalPackage;
      while(names.length){
        let tempPackage = this.findPackageInList(names.shift()!, package_.packages);
        if(tempPackage == null){
          names.unshift();
          break;
        } else {
          package_ = tempPackage;
        }
      }
      if(names.length){
        return null;
      } else {
        return package_;
      }
    }


    public createPackage(id: string, project: Project): Package{
      let names: Array<string> = id.split('.');
      let package_: Package = project.principalPackage;
      let name: string;
      let accumulatedName: Array<string> = new Array();
      while(names.length){
        name = names.shift()!;
        let tempPackage = this.findPackageInList(name, package_.packages);
        if(tempPackage == null){
          names.unshift(name);
          break;
        } else {
          accumulatedName.push(name);
          package_ = tempPackage;
        }
      }
      
      if(names.length){
        let newPackage: Package;
        while(names.length){
          accumulatedName.join('.');
          let shiftName = names.shift();
          accumulatedName.push(shiftName!);
          newPackage = new Package(shiftName!, accumulatedName.join('.'));
          package_.packages.push(newPackage);
          package_ = newPackage;
        }
      }
      return package_;
    }

    private findPackageInList(name: string, packages: Array<Package>): Package | null {
      for (const packageItem of packages) {
        if (packageItem.name === name) {
          return packageItem;
        }
      }
      return null;
    }
}
