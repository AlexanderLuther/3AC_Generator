import { File } from '../../core/models/project/file';
import { Package } from '../../core/models/project/package';
import { Project } from '../../core/models/project/project';

export class PackageManager{

    public nuevoArchivo(id:string,proyecto:Project,codigo:string){
        let nombres:Array<string> = id.split('.');
        let nombreArchivo = nombres.pop();
        let nombrePaquete = nombres.join('.');
        if(nombres.length==0){
            console.log(proyecto.principalPackage.name);
            proyecto.principalPackage.files.push(new File(nombreArchivo,id,proyecto.principalPackage.name,codigo));
        }else{
            let paquete = this.crearPaquete(nombrePaquete,proyecto);
            paquete.files.push(new File(nombreArchivo,id,paquete.name,codigo));
        }
    }

    public guardarCambiosArchivo(nombre:string,proyecto:Project,codigo:string){
        let archivo = this.buscarArchivo(nombre,proyecto);
    }

    public buscarArchivo(id:string,proyecto:Project){
        let nombres:Array<string> = id.split('.');
        let nombreArchivo = nombres.pop();
        let nombrePaquete = nombres.join('.');
        let paquete:Package
        if(nombrePaquete==""){
            paquete = proyecto.principalPackage;
        }else{
            paquete = this.buscarPaquete(nombrePaquete,proyecto);
        }
        if(paquete==null){
            return null;
        }else{
            for (const i in paquete.files) {
                if(paquete.files[i].name==nombreArchivo){
                    return paquete.files[i];
                }
            }
            return null;
        }
    }

    public buscarPaquete(id:string,proyecto:Project):Package{
        let nombres:Array<string> = id.split('.');
        let paquete:Package = proyecto.principalPackage; 
        while(nombres.length){
            let paqueteTemp = this.buscarPaqueteEnLista(nombres.shift(),paquete.packages);
            if(paqueteTemp==null){
                nombres.unshift('WJAJ');
                break;
            }else{
                paquete = paqueteTemp;
            }
        }

        if(nombres.length){
            return null;
        }else{
            return paquete;
        }
    }

    public crearPaquete(id:string,proyecto:Project):Package{
        let nombres:Array<string> = id.split('.');
        let paquete:Package = proyecto.principalPackage; 
        let nombre:string;
        let nombreAcumulado:Array<string> = new Array();

        while(nombres.length){
            nombre = nombres.shift();
            let paqueteTemp = this.buscarPaqueteEnLista(nombre,paquete.packages);
            if(paqueteTemp==null){
                nombres.unshift(nombre);
                break;
            }else{
                nombreAcumulado.push(nombre);
                paquete = paqueteTemp;
            }
        }

        if(nombres.length){
            let nuevoPaquete:Package;
            while(nombres.length){
                nombreAcumulado.join('.')
                let nombreshift:string = nombres.shift();
                nombreAcumulado.push(nombreshift);
                nuevoPaquete = new Package(nombreshift,nombreAcumulado.join('.'));
                paquete.packages.push(nuevoPaquete);
                paquete = nuevoPaquete;
            }
        }
        return paquete;
    }

    private buscarPaqueteEnLista(nombre:string,paquetes:Array<Package>):Package{
        for (const i in paquetes) {
            if(paquetes[i].name==nombre){
                return paquetes[i];
            }
        }
        return null;
    }

}