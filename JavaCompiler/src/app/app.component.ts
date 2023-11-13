import { Component } from '@angular/core';
import { Router } from '@angular/router';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.scss']
})
export class AppComponent {
  title = 'Compiler3D';

  constructor(private router:Router){}
  
  MostrarEditor(){
    this.router.navigate(["editor",{ id: 'heroId', foo: 'foo' }]);
  }

  MostrarConsola(){
    this.router.navigate(["consola"]);
  }

}
