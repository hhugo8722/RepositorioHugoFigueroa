package com.quasar.entities;

public class Posicion {

    private double y;

    private double x;

    public Posicion(double[] vector) {
        this.x = vector[0];
        this.y = vector[1];
    }

    public double getY() {
        return y;
    }

    public double getX() {
        return x;
    }

    public void setY(double y) {
        this.y = y;
    }

    public void setX(double x) {
        this.x = x;
    }

    @Override
    public String toString() {
        return x + "," + y;
    }

}
