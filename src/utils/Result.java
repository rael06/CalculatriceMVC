package utils;

public class Result {
    private String log;
    private float operationResult;
    private boolean error;

    public Result(String log, float operationResult) {
        this.log = log;
        this.operationResult = operationResult;
        error = operationResult == 0f;
    }

    public String getLog() {
        return log;
    }

    public float getOperationResult() {
        return operationResult;
    }

    public boolean isError() {
        return error;
    }
}
