package com.quasar.entities;

public class Mensaje extends Nave {

    private String mensaje;

    //Constructor con mensajee-----posicion
    public Mensaje(Posicion posicion, String mensaje) {
        this.setPosicion(posicion);
        this.mensaje = mensaje;
    }

    public String getMensaje() {
        return mensaje;
    }

    public void setMensaje(String mensaje) {
        this.mensaje = mensaje;
    }

}
