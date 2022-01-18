package com.quasar.entities;

import java.util.List;

public class Satelite extends Nave {

    private List<String> mensaje;
    private double distancia;

    private String nombre;

    public List<String> getMensaje() {
        return mensaje;
    }

    public void setMensaje(List<String> mensaje) {
        this.mensaje = mensaje;
    }

    public double getDistancia() {
        return distancia;
    }

    public void setDistancia(double distancia) {
        this.distancia = distancia;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

}
