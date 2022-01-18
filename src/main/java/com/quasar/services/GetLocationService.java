package com.quasar.services;

import com.lemmingapex.trilateration.NonLinearLeastSquaresSolver;
import com.lemmingapex.trilateration.TrilaterationFunction;
import org.apache.commons.math3.fitting.leastsquares.LevenbergMarquardtOptimizer;
import org.springframework.stereotype.Service;


@Service
public class GetLocationService {

    public double[] getLocation(double[][] posiciones, double [] distancias) {

        TrilaterationFunction trilaterationFunction = new TrilaterationFunction(posiciones, distancias);
        NonLinearLeastSquaresSolver obtenerDistancia = new NonLinearLeastSquaresSolver(trilaterationFunction, new LevenbergMarquardtOptimizer());

        return  obtenerDistancia.solve().getPoint().toArray();
    }

}
