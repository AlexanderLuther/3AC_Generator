import { AfterViewInit, Component, ElementRef, OnInit, ViewChild } from '@angular/core';
import { Router } from '@angular/router';
import * as ace from "ace-builds";
import * as $ from 'jquery';
import 'jstree';
import { File } from 'src/app/models/ide/file.model';
import { Project } from 'src/app/models/ide/project.model.';
import { PackageManagerService } from 'src/app/services/ide/package-manager.service';
import { ProjectService } from 'src/app/services/ide/project.service';

@Component({
  selector: 'app-ide',
  templateUrl: './ide.component.html',
  styleUrls: ['./ide.component.css']
})
export class IdeComponent implements OnInit, AfterViewInit{

  public currentFile?: File;
  public principalCode?: string;
  public threeAddressCode?: string;
  public textConsole?: string;

  //Modals
  public idFile?: string;
  public idPackage?: string;
  public projectName?: string;
  public textInfo?: string;

  //Files Tress
  public ideProject?: Project

  //Editor
  @ViewChild('editor') private editor?: ElementRef<HTMLElement>;
  private line: Number = 0;
  private column: Number = 0;
  
  constructor(
    private projectService: ProjectService, 
    private packageManagerService: PackageManagerService,
    private router: Router){
      if(localStorage.getItem('project') != null && localStorage.getItem('project') != "null"){
        projectService.getProject(localStorage.getItem('project')!).subscribe(data =>{
          this.ideProject = data;
        });
        localStorage.setItem('project', null!);
      }
  }

  ngOnInit(): void {
    $(function () {
      ($('#jstree')as any).jstree();
      $('#jstree').on("changed.jstree", function (e, data) {
        console.log(data.selected);
      });
    });
    this.expand();
  }

  ngAfterViewInit(): void {
    ace.config.set("fontSize", "20px");
    ace.config.set("basePath", "/https://unpkg.com/ace-builds@1.4.12/src-noconflict");
    const aceEditor = ace.edit(this.editor!.nativeElement);
    aceEditor.session.selection.on('changeCursor', () => {
      this.line = aceEditor.getCursorPosition().row + 1;
      this.column = aceEditor.getCursorPosition().column;
      aceEditor.setTheme("ace/theme/monokai");
      aceEditor.session.setMode("ace/mode/java");
      aceEditor.session.setUseSoftTabs(false);
    });
  }

  expand():void{
    $('.expand').click(function() {
      $('ul', $(this).parent()).eq(0).toggle();
    });
  }


  public compile(){}
  public generate3ac(){}

  public getLine(){
    return this.line
  }
  public getColumn(){
    return this.column
  }
  
  public getTextConsole(){
    return this.textConsole
  }
  
  public createFile(){
    if(this.isValidId(this.idFile!)){
      console.log(this.idFile);
      this.packageManagerService.newFile(this.idFile!, this.ideProject!, ""); 
    }
    this.idFile = "";
  }

  public createPackage(){
    if(this.isValidId(this.idPackage!)){
      this.packageManagerService.createPackage(this.idPackage!, this.ideProject!);
    }
    this.idPackage = "";
  }

  public saveProject(){
    this.saveChanges();
    if(this.ideProject != null){
      this.projectService.saveProject(this.ideProject).subscribe(data =>{
        this.textInfo = data.description;
        document.getElementById('openModalInfo')!.click();
      });
    }
  }

  public autoSaveProject(){
    this.saveChanges();
    if(this.ideProject != null){
      this.projectService.saveProject(this.ideProject).subscribe(data =>{});
    }
  }

  public createProject(){
    this.ideProject = new Project(this.projectName!);
    this.projectName = "";
  }
  
  public closeProject(){
    if(this.ideProject != null){
      this.autoSaveProject();
      this.ideProject = null!;
    }
  }

  public updateCodeEditor(id: string): void{
    this.saveChanges();
    let tempFile: File = this.packageManagerService.findFile(id, this.ideProject!)!;
    if(tempFile != null){
      const aceEditor = ace.edit(this.editor!.nativeElement);
      aceEditor.session.setValue(tempFile.code);
      this.currentFile = tempFile;
    }
  }

  public showProjects(){
    this.router.navigate(['projects']);
  }
  
  public saveChanges(): void{
    if(this.currentFile != null){
      const aceEditor = ace.edit(this.editor!.nativeElement);
      this.currentFile.code = aceEditor.session.getValue();
    }
  }


  private isValidId( id: string ): boolean {
    return /^([a-zA-Z0-9_]+([.][a-zA-Z0-9_]+)*)$/.test(id);
  }

}
