import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Confirmation } from 'src/app/core/models/project/confirmacion';
import { Project } from 'src/app/core/models/project/project';

@Injectable({
  providedIn: 'root'
})
export class ProjectService {

  private urlGuardarProyecto:string = "http://localhost:8080/api/compiler/save";
  private urlProyectos:string = "http://localhost:8080/api/compiler/project";
  private urlProyecto:string = "http://localhost:8080/api/compiler/project";

  constructor(private httpClient:HttpClient) { }

  public getProjects(){
    return this.httpClient.get<Array<Project>>(this.urlProyectos);
  }

  public getProject(name:string){
    return this.httpClient.post<Project>(this.urlProyecto,name);
  }

  public sendProject(project:Project){
    return this.httpClient.post<Confirmation>(this.urlGuardarProyecto,project);
  }

}
