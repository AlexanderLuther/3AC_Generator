import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { Project } from 'src/app/models/ide/project.model.';
import { ProjectService } from 'src/app/services/ide/project.service';

@Component({
  selector: 'app-project-list',
  templateUrl: './project-list.component.html',
  styleUrls: ['./project-list.component.css']
})
export class ProjectListComponent implements OnInit{

  public projects: Array<string> = [];

  constructor(private projectService: ProjectService, private router: Router) { 
    this.getProyects();
  }

  ngOnInit(): void {}

  private getProyects(): void {
    this.projectService.getProjects().subscribe( data => {
      this.projects = data;
    });
  }

  public back(): void {
    this.router.navigate(['/ide']);
  }

  public openProject(name: string): void {
    localStorage.setItem('project', name);
    this.router.navigate(['ide']);
  }
}
