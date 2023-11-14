import { Injectable } from '@angular/core';
import { HttpClient, HttpParams } from '@angular/common/http';
import { Project } from 'src/app/models/ide/project.model.';
import { Confirmation } from 'src/app/models/general/confirmation.model';

@Injectable({
  providedIn: 'root'
})
export class ProjectService {

  private URL_PROJECT : string = 'http://localhost:8080/api/compiler/project';

  constructor( private httpClient : HttpClient) { }

  public getProjects(){
    return this.httpClient.get<Array<string>>(this.URL_PROJECT);
  }

  public getProject(name : string){
    return this.httpClient.get<Project>(this.URL_PROJECT + `/${name}`);
  }

  public saveProject(project : Project){
    return this.httpClient.post<Confirmation>(this.URL_PROJECT, project);
  }

}
