package com.baizhi.Flume.redis;

public class log {
    private String ip;
    private String accesstime;
    private String method;
    private String resource;
    private int status;

    public log(String ip, String accesstime, String method, String resource, int status) {
        this.ip = ip;
        this.accesstime = accesstime;
        this.method = method;
        this.resource = resource;
        this.status = status;
    }

    public log() {
    }

    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }

    public String getAccesstime() {
        return accesstime;
    }

    public void setAccesstime(String accesstime) {
        this.accesstime = accesstime;
    }

    public String getMethod() {
        return method;
    }

    public void setMethod(String method) {
        this.method = method;
    }

    public String getResource() {
        return resource;
    }

    public void setResource(String resource) {
        this.resource = resource;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "log{" +
                "ip='" + ip + '\'' +
                ", accesstime='" + accesstime + '\'' +
                ", method='" + method + '\'' +
                ", resource='" + resource + '\'' +
                ", status=" + status +
                '}';
    }
}
