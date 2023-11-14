import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { IdeComponent } from './components/ide/ide.component';
import { ProjectListComponent } from './components/project-list/project-list.component';

const routes: Routes = [
  { path : 'ide', component: IdeComponent },
  { path : 'projects', component: ProjectListComponent },
  { path : '', redirectTo: '/ide', pathMatch: 'full'}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
