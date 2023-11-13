import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { Project } from 'src/app/core/models/project/project';
import { ProjectService } from 'src/app/services/project/project.service';

@Component({
  selector: 'app-proyectos',
  templateUrl: './proyectos.component.html',
  styleUrls: ['./proyectos.component.css']
})
export class ProyectosComponent implements OnInit {

  public proyectos:Array<Project>;

  constructor(private servicioProyecto:ProjectService, private router:Router) {
    this.actualizarProyectos();
  }

  ngOnInit(): void {
  }

  private actualizarProyectos():void{
    this.servicioProyecto.getProjects().subscribe( data => {
      this.proyectos = data;
    });
  }

  public abrirProyecto(nombre:string):void{
    localStorage.setItem('proyecto',nombre);
    this.router.navigate(["editor"]);
  }

}
