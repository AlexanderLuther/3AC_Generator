import { Injectable } from '@angular/core';
import { File } from 'src/app/models/ide/file.model';
import { Project } from 'src/app/models/ide/project.model.';
import { FilesManagerService } from './files-manager.service';
import { parser as Parser } from 'src/assets/grammar.js';


@Injectable({
  providedIn: 'root'
})
export class AnalysisManagerService {
  parser: any;

  constructor(private fileManager: FilesManagerService) {
   }

  public analyse(project: Project){
    let files: Array<File> = this.fileManager.getAllFiles(project);
    let code = "";
    for(let i=0;i<files.length;i++){
      code += "";
      code += files[i].code;
      code += "\n";
    }
    console.log(code);
    this.parser = Parser;
    this.parser.parse(code);
  }

  
}
