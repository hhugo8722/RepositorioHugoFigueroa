package com.quasar.services;

import com.quasar.entities.Mensaje;
import com.quasar.entities.Posicion;
import com.quasar.entities.DistanciaSatelite;
import com.quasar.entities.Nave;
import com.quasar.exceptions.ExceptionLocalizar;
import com.quasar.exceptions.MensajeException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.http.RequestEntity;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import com.quasar.controller.Response;
import java.util.ArrayList;

@Service
public class ServiceImpl implements Response {

    @Autowired
    GetLocationService localizacion;

    @Autowired
    GetMessageService mensajes;

    @Autowired
    private Environment environment;
    
    public void pos(DistanciaSatelite sat){
        
//
//        ArrayList<String> array = new ArrayList<String>();
//        array.add("");
        if(sat.getPosicion()[0] == null) {
            int numberSat = 3;
            double[][] pointsList = new double[numberSat][];
            String[] arreglo;
            
            for (int i = 0; i < sat.getSatellites().size(); i++) {
                arreglo = environment.getProperty("satelites." + i).split(",");
                pointsList[i] = Arrays.stream(arreglo)
                        .map(Double::valueOf)
                        .mapToDouble(Double::doubleValue)
                        .toArray();
            }
            sat.setPositions(pointsList);
        }
    }

    @Override
    public Nave getResponse(RequestEntity requestEntity) throws MensajeException, ExceptionLocalizar {

        DistanciaSatelite sat = (DistanciaSatelite)requestEntity.getBody();
        if(sat.getMensajes().size() < 2)
            throw new MensajeException("mensajes insuficientes");
        String men = mensajes.ObtenerMensaje(sat.getMensajes());

        pos(sat);
        if( (sat.getPosicion().length < 2) || (sat.getDistancia().length < 2) )
            throw new ExceptionLocalizar("distancias insuficientes");
        double [] localiza = localizacion.getLocation(sat.getPosicion(), sat.getDistancia());
        Posicion posicion = new Posicion(localiza);

        return new Mensaje(posicion, men);
    }

    

}
