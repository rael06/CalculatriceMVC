package view;

import utils.Result;
import utils.MyObserver;

public class Console implements MyObserver<Result> {
    private static Console instance;

    private Console() {
    }

    public static Console getInstance() {
        return instance = instance == null ? new Console() : instance;
    }

    @Override
    public void update(Result result) {
        System.out.println("opération : " + result.getLog());
        System.out.println("résultat : " + result.getOperationResult());
    }
}
