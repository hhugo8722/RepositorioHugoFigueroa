package com.quasar.services;

import com.quasar.exceptions.MensajeException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Service
public class GetMessageService {

    public List<String> ObtenerMensa(List<List<String>> lista){

        List<String> listWords = new ArrayList<String>();
        for( List<String> msg : lista){
            listWords = Stream.concat(listWords.stream(), msg.stream())
                    .distinct()
                    .collect(Collectors.toList());
        }
        listWords.remove("");
        return listWords;
    }


    public String Mensaje(List<List<String>> lista){

        String men = "";
        for(List<String> m : lista){

            if(m.size()>0 && !m.get(0).equals("")){
                men = (m.size() == 1) ? m.get(0) : m.get(0) + " ";
                lista.stream().forEach( s -> s.remove(0));
                return  men + Mensaje(lista);
            }
        }
 
        return "";
    }

    public String ObtenerMensaje(List<List<String>> lista) throws MensajeException {

        List<String> mensajes = ObtenerMensa(lista);
        if(!validateMessagesSize(lista, mensajes.size()))
            throw new MensajeException("Tamaño del mensaje incorrecto");
        
        String mensaje = Mensaje(lista);
        if(!validateMessagePhrases(mensajes,mensaje))
            throw new MensajeException("No se puede conocer el mensaje");

        return mensaje;
    }

    public boolean validateMessagesSize(List<List<String>> mensaje, int size){
        for(List<String> m : mensaje){
            if(m.size() < size){
                return false;
            }
        }
        return true;
    }

    public boolean validateMessagePhrases(List<String> mens, String mensaje){
        List<String> msg = Arrays.stream(mensaje.split(" ")).collect(Collectors.toList());
        Collections.sort(mens);
        Collections.sort(msg);
        return Arrays.equals(mens.toArray(), msg.toArray());
    }

}
