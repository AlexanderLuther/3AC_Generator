import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { EditorComponent } from './components/editor/editor.component';
import { ProyectosComponent } from './components/project/proyectos.component';

const routes: Routes = [
  {path:'editor', component:EditorComponent},
  {path:'proyectos',component:ProyectosComponent},
  {path:'', redirectTo: 'editor', pathMatch:'full'}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
