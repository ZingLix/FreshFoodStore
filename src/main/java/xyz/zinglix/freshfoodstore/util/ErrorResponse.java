package xyz.zinglix.freshfoodstore.util;

public class ErrorResponse{
    private String msg;

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public ErrorResponse(String msg) {
        this.msg = msg;
    }
}
