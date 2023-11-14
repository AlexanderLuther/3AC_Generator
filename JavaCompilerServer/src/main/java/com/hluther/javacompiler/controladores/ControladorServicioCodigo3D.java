package com.hluther.javacompiler.controladores;

import com.hluther.javacompiler.modelos.Confirmation;
import com.hluther.javacompiler.modelos.instruccion.Instruccion;
import com.hluther.javacompiler.modelos.instruccion.complemento.ResultadoInstruccion;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
public class ControladorServicioCodigo3D {

    private ResultadoInstruccion resultadoInstruccion;

    public ControladorServicioCodigo3D() {
    }

    @PostMapping(ControladorServicioProyecto.PATH_SERVICIO_PROYECTO+"/codigo3d")
    public Confirmation test(@RequestBody List<Instruccion> instrucciones){
        System.out.println("RECIBIENDO INSTRUCCIONES");
        resultadoInstruccion = new ResultadoInstruccion("",1,1);
        for (Instruccion instruccion:instrucciones){
            instruccion.generarCodigo(resultadoInstruccion);
        }
        //System.out.println("CODIGO 3D:");
        //System.out.println(resultadoInstruccion.getCodigo3d().getCodigo());
        return new Confirmation(resultadoInstruccion.getCodigo3d().getCodigo(), true);
    }

}
