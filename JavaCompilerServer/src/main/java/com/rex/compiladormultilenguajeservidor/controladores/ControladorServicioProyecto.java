package com.rex.compiladormultilenguajeservidor.controladores;

import com.rex.compiladormultilenguajeservidor.modelos.Confirmacion;
import com.rex.compiladormultilenguajeservidor.modelos.proyecto.Proyecto;
import com.rex.compiladormultilenguajeservidor.utilidades.Archivo;
import com.rex.compiladormultilenguajeservidor.utilidades.RecuperadorProyecto;
import com.rex.compiladormultilenguajeservidor.utilidades.proyecto.ConstructorXML;
import com.rex.compiladormultilenguajeservidor.utilidades.proyecto.ManejadorLista;
import org.springframework.web.bind.annotation.*;

import java.io.File;
import java.util.LinkedList;
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
    public Confirmacion responder(){
        return new Confirmacion("Se ha recibido el proyecto",true);
    }

    @PostMapping(PATH_SERVICIO_PROYECTO+"/save")
    public Confirmacion procesarCuadrupla(@RequestBody Proyecto proyecto){
        System.out.println("proyecto "+proyecto.getNombre()+" recibido");
        try {
            Archivo.escribirArchivo(new File(PATH_DATA_PROYECTO+proyecto.getNombre()+".xml"),constructorXML.construirXML(proyecto));
            manejadorLista.registrarProyecto(proyecto.getNombre());
            return new Confirmacion("El proyecto "+proyecto.getNombre()+" ha sido guardado.",true);
        }catch (Exception e){
            e.printStackTrace();
            if(proyecto==null | proyecto.getNombre()==null){
                return new Confirmacion("No hay proyecto en curso para guardar.", false);
            }else {
                return new Confirmacion("Error al intentar guardar el proyecto " + proyecto.getNombre() + " .", false);
            }
        }
    }

    @PostMapping(PATH_SERVICIO_PROYECTO+"/project")
    public Proyecto recuperarProyecto(@RequestBody String nombreProyecto){
        return recuperadorProyecto.recuperar(nombreProyecto);
    }

    @GetMapping(PATH_SERVICIO_PROYECTO+"/project")
    public List<String> recuperarProyectos(){
        return manejadorLista.recuperarListaProyectos();
    }

}
