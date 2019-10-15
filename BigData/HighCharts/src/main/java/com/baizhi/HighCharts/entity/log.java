package com.baizhi.HighCharts.entity;

public class log {
    private int pv;
    private int uv;
    private String showTime;

    public log(int pv, int uv, String showTime) {
        this.pv = pv;
        this.uv = uv;
        this.showTime = showTime;
    }

    public log() {
    }

    public int getPv() {
        return pv;
    }

    public void setPv(int pv) {
        this.pv = pv;
    }

    public int getUv() {
        return uv;
    }

    public void setUv(int uv) {
        this.uv = uv;
    }

    public String getShowTime() {
        return showTime;
    }

    public void setShowTime(String showTime) {
        this.showTime = showTime;
    }

    @Override
    public String toString() {
        return "log{" +
                "pv=" + pv +
                ", uv=" + uv +
                ", showTime='" + showTime + '\'' +
                '}';
    }
}
