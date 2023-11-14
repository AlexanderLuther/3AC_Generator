import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { IdeComponent } from './components/ide/ide.component';
import { HttpClientModule } from '@angular/common/http';
import { FormsModule } from '@angular/forms';
import { ProjectListComponent } from './components/project-list/project-list.component';
import { ProjectService } from './services/ide/project.service';
import { PackageManagerService } from './services/ide/package-manager.service';

@NgModule({
  declarations: [
    AppComponent,
    IdeComponent,
    ProjectListComponent,
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    HttpClientModule,
    FormsModule
  ],
  providers: [ProjectService, PackageManagerService],
  bootstrap: [AppComponent]
})
export class AppModule { }
