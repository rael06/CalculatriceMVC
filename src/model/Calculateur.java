package model;

import utils.Constants;
import utils.MyObservable;
import utils.Result;

public class Calculateur extends MyObservable<Result> {
    private static Calculateur instance;

    private Calculateur() {
    }

    public static Calculateur getInstance() {
        return instance = instance == null ? new Calculateur() : instance;
    }

    public void process(String log, float nombre1, float nombre2, char operateur) {
        float operationResult = Constants.OPERATORS.get(operateur + "").process(nombre1, nombre2);
        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        notifyObservers(new Result(log, operationResult));
    }

    public void erreur(String log) {
        notifyObservers(new Result(log, 0f));
    }
}
