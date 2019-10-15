package com.baizhi.HighCharts.entity;

public class status {
    private int statusCode;
    private int statusNums;

    public status(int statusCode, int statusNums) {
        this.statusCode = statusCode;
        this.statusNums = statusNums;
    }

    public status() {
    }

    public int getStatusCode() {
        return statusCode;
    }

    public void setStatusCode(int statusCode) {
        this.statusCode = statusCode;
    }

    public int getStatusNums() {
        return statusNums;
    }

    public void setStatusNums(int statusNums) {
        this.statusNums = statusNums;
    }

    @Override
    public String toString() {
        return "status{" +
                "statusCode=" + statusCode +
                ", statusNums=" + statusNums +
                '}';
    }
}
