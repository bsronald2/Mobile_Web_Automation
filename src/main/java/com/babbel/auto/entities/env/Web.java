package com.babbel.auto.entities.env;

import java.util.List;

public class Web {

    String url;
    int timeOut;
    int waitTimeOut;
    List<Remote> remotes;

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public int getTimeout() {
        return timeOut;
    }

    public void setTimeout(int timeout) {
        this.timeOut = timeout;
    }

    public List<Remote> getRemotes() {
        return remotes;
    }

    public void setRemotes(List<Remote> remotes) {
        this.remotes = remotes;
    }

    public int getTimeOut() {
        return timeOut;
    }

    public void setTimeOut(int timeOut) {
        this.timeOut = timeOut;
    }

    public int getWaitTimeOut() {
        return waitTimeOut;
    }

    public void setWaitTimeOut(int waitTimeOut) {
        this.waitTimeOut = waitTimeOut;
    }
}
