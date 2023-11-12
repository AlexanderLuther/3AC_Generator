import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent {
  title = 'Java Compiler';

  constructor(private router:Router){}
  
  MostrarEditor(){
    this.router.navigate(["editor",{ id: 'heroId', foo: 'foo' }]);
  }

  MostrarConsola(){
    this.router.navigate(["consola"]);
  }
  
}
