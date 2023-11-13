package com.rex.compiladormultilenguajeservidor.controladores;

import com.rex.compiladormultilenguajeservidor.modelos.Codigo3d;
import com.rex.compiladormultilenguajeservidor.modelos.Confirmacion;
import com.rex.compiladormultilenguajeservidor.modelos.instruccion.Instruccion;
import com.rex.compiladormultilenguajeservidor.modelos.instruccion.complemento.ResultadoInstruccion;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
public class ControladorServicioCodigo3D {

    private ResultadoInstruccion resultadoInstruccion;

    public ControladorServicioCodigo3D() {
    }

    @PostMapping(ControladorServicioProyecto.PATH_SERVICIO_PROYECTO+"/codigo3d")
    public Confirmacion test(@RequestBody List<Instruccion> instrucciones){
        System.out.println("RECIBIENDO INSTRUCCIONES");
        resultadoInstruccion = new ResultadoInstruccion("",1,1);
        for (Instruccion instruccion:instrucciones){
            instruccion.generarCodigo(resultadoInstruccion);
        }
        //System.out.println("CODIGO 3D:");
        //System.out.println(resultadoInstruccion.getCodigo3d().getCodigo());
        return new Confirmacion(resultadoInstruccion.getCodigo3d().getCodigo(), true);
    }

}
