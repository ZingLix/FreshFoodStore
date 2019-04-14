package xyz.zinglix.freshfoodstore.util;

public class Request {
    Integer operation;
    String message;

    public Request(Integer operation) {
        this.operation = operation;
    }

    public Request() {
    }

    public Integer getOperation() {

        return operation;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public void setOperation(Integer operation) {
        this.operation = operation;
    }
}
