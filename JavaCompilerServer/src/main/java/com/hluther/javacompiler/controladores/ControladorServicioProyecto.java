package com.hluther.javacompiler.controladores;

import com.hluther.javacompiler.modelos.Confirmation;
import com.hluther.javacompiler.modelos.proyecto.Project;
import com.hluther.javacompiler.utilidades.proyecto.Archivo;
import com.hluther.javacompiler.utilidades.proyecto.ConstructorXML;
import com.hluther.javacompiler.utilidades.proyecto.ManejadorLista;
import com.hluther.javacompiler.utilidades.proyecto.RecuperadorProyecto;
import org.springframework.web.bind.annotation.*;

import java.io.File;
import java.util.List;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
public class ControladorServicioProyecto {

    public static final String PATH_DATA_PROYECTO = "data/";
    public static final String PATH_SERVICIO_PROYECTO = "/api/compiler";
    private ConstructorXML constructorXML;
    private ManejadorLista manejadorLista;
    private RecuperadorProyecto recuperadorProyecto;

    public ControladorServicioProyecto() {
        constructorXML = new ConstructorXML();
        manejadorLista = new ManejadorLista();
        recuperadorProyecto = new RecuperadorProyecto();
    }

    @GetMapping(PATH_SERVICIO_PROYECTO+"/Responder")
    public Confirmation responder(){
        return new Confirmation("Se ha recibido el proyecto",true);
    }

    @PostMapping(PATH_SERVICIO_PROYECTO+"/project")
    public Confirmation procesarCuadrupla(@RequestBody Project proyecto){
        System.out.println("proyecto "+proyecto.getName()+" recibido");
        try {
            Archivo.escribirArchivo(new File(PATH_DATA_PROYECTO+proyecto.getName()+".xml"),constructorXML.construirXML(proyecto));
            manejadorLista.registrarProyecto(proyecto.getName());
            return new Confirmation("El proyecto "+proyecto.getName()+" ha sido guardado.",true);
        }catch (Exception e){
            e.printStackTrace();
            if(proyecto==null | proyecto.getName()==null){
                return new Confirmation("No hay proyecto en curso para guardar.", false);
            }else {
                return new Confirmation("Error al intentar guardar el proyecto " + proyecto.getName() + " .", false);
            }
        }
    }

    @GetMapping(PATH_SERVICIO_PROYECTO+"/project/{name}")
    public Project recuperarProyecto(@PathVariable String name){
        return recuperadorProyecto.recuperar(name);
    }

    @GetMapping(PATH_SERVICIO_PROYECTO+"/project")
    public List<String> recuperarProyectos(){
        return manejadorLista.recuperarListaProyectos();
    }

}
