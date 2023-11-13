import { Component, OnInit, ViewChild, AfterViewInit, ElementRef, ViewChildren, ViewContainerRef } from '@angular/core';
import { Router } from '@angular/router';
import * as ace from "ace-builds";
import * as $ from 'jquery'; import 'jstree';
import { Project } from 'src/app/core/models/project/project';
import { ProjectService } from 'src/app/services/project/project.service';
import { File } from 'src/app/core/models/project/file';
import { Package } from 'src/app/core/models/project/package';
import { PackageManager } from 'src/app/core/Global/GestionadorPaquete';
import { parser as Parser } from 'src/assets/gramm/main/gramm-main.js';
import { ErrorGramm } from 'src/app/core/models/ast/error/error-gramm';


@Component({
  selector: 'app-editor',
  templateUrl: './editor.component.html',
  styleUrls: ['./editor.component.css']
})
export class EditorComponent implements OnInit, AfterViewInit {

  private linea:Number = 0;
  private columna:Number = 0;
  @ViewChild('editor') private editor:ElementRef<HTMLElement>;
  private txtConsola:String = "";
  public idArchivo:string = "";
  public idPaquete:string = "";
  public nombreProyecto:string = "";
  public textoInfo:string = "";
  public gestionadorPaquete:PackageManager;
  public codigoPrincipal = "";
  public archivoActual:File;
  public proyecto:Project;
  public codigo3d = "";
  public cod3dDeshabilitado = true;
  public compilarDeshabilitado = true;
  public parser = Parser;

  constructor(private servicioProyecto:ProjectService, private router:Router) {
    this.gestionadorPaquete = new PackageManager();
    if(localStorage.getItem('proyecto')!=null && localStorage.getItem('proyecto')!="null"){
      servicioProyecto.getProject(localStorage.getItem('proyecto')).subscribe(data=>{
        this.proyecto = data;
        this.compilarDeshabilitado = false;
      });
      localStorage.setItem('proyecto',null);
    }
    this.parser = Parser;
  }

  ngOnInit(): void {
    $(function () {
      ($('#myTree') as any).jstree();
      $('#jstree').on("changed.jstree", function (e, data) {
        console.log(data.selected);
      });
    });
    this.expandir();
  }

  expandir():void{
    $('.expand').click(function() {
      $('ul', $(this).parent()).eq(0).toggle();
    });
  }

  ngAfterViewInit(){
    
    ace.config.set("fontSize", "25px");
    ace.config.set('basePath', 'https://unpkg.com/ace-builds@1.4.12/src-noconflict');

    const aceEditor = ace.edit(this.editor.nativeElement);
    aceEditor.session.selection.on('changeCursor',()=>{
      this.linea = aceEditor.getCursorPosition().row+1;
      this.columna = aceEditor.getCursorPosition().column;
    });

    aceEditor.setTheme('ace/theme/eclipse');
    aceEditor.session.setMode('ace/mode/java');
    aceEditor.session.setUseSoftTabs(false);

  }
  
  code : string =`
  public class s {
    int x = 5;
  
    public main() {

    }
  }
  
  
  
  `;

  public compilar(){
    let result: any;
    try {
      // Evalúa la expresión utilizando el parser
      // console.log(enterText);
      // console.log(ErrorType.LEXICAL);
      
      // const txtEnter = this.codeMirror.codeMirror.getValue();
     result = this.parser.parse(this.code);
     console.log('Salida: \n',result);

      if (result && result.listError.length>0) {
        //Existen errores
        for (let i = 0; i < result.listError.length; i++) {
          const element: ErrorGramm = result.listError[i] as ErrorGramm;
          //console.log(element.toString());
        }
      } else {
        console.log('Salida: \n\n',result);
       // let factory: Factory = new Factory(result, this.shareCodeEditorService);
        //factory.factory();
        // let handlerComprobation: HandlerComprobation = new HandlerComprobation();
        // let listroot = result.listRoot;
        // for (let i = 0; i < listroot.length; i++) {
        //   const element: Node = listroot[i] as Node;
        //   try {
        //     element.executeComprobationTypeNameAmbitUniqueness(handlerComprobation);

        //     handlerComprobation.paintError();
        //   } catch (error) {
        //     console.error(error);
            
        //   }
        // }
        // console.log(handlerComprobation.symbolTable);
        // this.shareCodeEditorService.setSymbolTable(handlerComprobation.symbolTable);
        // this.shareCodeEditorService.setListError(handlerComprobation.listError)
        // let environment: Environment = new Environment();
        // this.sectionService.sendData(5);
      }
      
      return 1;
    } catch (error) {
      // console.log(this.parser.yy.listErrors);
      // console.log(this.parser.yy);
      
      if (result && result.listError.length>0) {
        //Existen errores
        for (let i = 0; i < result.listError.length; i++) {
         // const element: ErrorGramm = result.listError[i] as ErrorGramm;
         // console.log(element.toString());
        }
      } else {
        const listError = this.parser.yy.listErrors;
        //this.shareCodeEditorService.setListError(listError)
      }

      return NaN;
    }

  }

  public generarCodigo3d(){

  }

  public getLinea(){
    return this.linea;
  }

  public getColumna(){
    return this.columna;
  }

  public getTxtConsola(){
    return this.txtConsola;
  }

  public crearArchivo():void{
    if(this.idValido(this.idArchivo)){
      this.gestionadorPaquete.nuevoArchivo(this.idArchivo,this.proyecto,"");
      this.idArchivo = "";
    }else{
      this.idArchivo = "";
    }
  }

  public crearPaquete():void{
    if(this.idValido(this.idPaquete)){
      this.gestionadorPaquete.crearPaquete(this.idPaquete,this.proyecto);
      this.idPaquete = "";
    }else{
      this.idPaquete = "";
    }
  }

  private idValido(id:string):boolean{
    return /^([a-zA-Z0-9_]+([.][a-zA-Z0-9_]+)*)$/.test(id);
  }

  public guardarProyecto():void{
    this.guardarCambios();
    if(this.proyecto!=null){
      this.servicioProyecto.sendProject(this.proyecto).subscribe(data=>{
        this.textoInfo = data.description;
        document.getElementById("abrirModalInfo").click();
      });
    }
  }

  public guardarProyectoSinAviso():void{
    this.guardarCambios();
    if(this.proyecto!=null){
      this.servicioProyecto.sendProject(this.proyecto).subscribe(data=>{});
    }
  }

  public crearProyecto():void{
    this.proyecto = new Project(this.nombreProyecto);
    this.nombreProyecto = "";
    this.compilarDeshabilitado = false;
  }

  public cerrarProyecto():void{
    if(this.proyecto!=null){
      this.guardarProyectoSinAviso();
      this.proyecto = null;
      this.compilarDeshabilitado = true;
    }
  }

  public actualizarCodigoEditor(id:string):void{
    this.guardarCambios();
    let archivo:File = this.gestionadorPaquete.buscarArchivo(id,this.proyecto);
    if(archivo!=null){
      const aceEditor = ace.edit(this.editor.nativeElement);
      aceEditor.session.setValue(archivo.code);
      this.archivoActual = archivo;
    }
  }

  public mostrarProyectos(){
    this.router.navigate(["proyectos"]);
  }

  public guardarCambios():void{
    if(this.archivoActual!= null){
      const aceEditor = ace.edit(this.editor.nativeElement);
      this.archivoActual.code = aceEditor.getValue();
    }
  }

}
