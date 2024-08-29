package org.example.entity;

public class ResponseFromServer {
    private Integer status = null;
    private String code = null;

    public ResponseFromServer(int status, String code) {
        this.status = (Integer) status;
        this.code = code;
    }

    public ResponseFromServer() {
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = Integer.valueOf(status);
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }
}
