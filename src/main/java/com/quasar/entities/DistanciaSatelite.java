package com.quasar.entities;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class DistanciaSatelite {

    private List<Satelite> satelites;

    public void setSatellites(List<Satelite> satelites) {
        this.satelites = satelites;
    }

    public List<Satelite> getSatellites() {
        return satelites;
    }

    public List<List<String>> getMensajes() {
        List<List<String>> mensajes = new ArrayList<List<String>>();
        for (Satelite s : satelites) {
            mensajes.add(s.getMensaje());
        }
        return mensajes;
    }

    public void setPositions(double[][] Lista) {
        Posicion posicion;
        for (int i = 0; i < Lista.length; i++) {
            posicion = new Posicion(Lista[i]);
            satelites.get(i).setPosicion(posicion);
        }
    }

    public double[] getDistancia() {

        double[] distancia = new double[satelites.size()];
        for (int i = 0; i < satelites.size(); i++) {
            distancia[i] = satelites.get(i).getDistancia();
        }
        return distancia;
    }

    public double[][] getPosicion() {
        double[][] positions = new double[satelites.size()][];
        String[] miArreglo;
        for (int i = 0; i < satelites.size(); i++) {
            if (satelites.get(i).getPosicion() != null) {
                miArreglo = satelites.get(i).getPosicion().toString().split(",");
                positions[i] = Arrays.stream(miArreglo)
                        .map(Double::valueOf)
                        .mapToDouble(Double::doubleValue)
                        .toArray();
            }
        }
        return positions;
    }

}
