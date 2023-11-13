import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import { HttpClientModule } from '@angular/common/http';

import { AppComponent } from './app.component';
import { FormsModule } from '@angular/forms';
import { AppRoutingModule } from './app-routing.module';
import { EditorComponent } from './components/editor/editor.component';
import { ProyectosComponent } from './components/project/proyectos.component';
import { ProjectService } from './services/project/project.service';
import { ModalModule } from './components/modal/modulo/modal/modal.module';

@NgModule({
  declarations: [
    AppComponent,
    EditorComponent,
    ProyectosComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    FormsModule,
    HttpClientModule,
    ModalModule
  ],
  providers: [ProjectService],
  bootstrap: [AppComponent]
})
export class AppModule { }
