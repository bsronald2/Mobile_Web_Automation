package com.babbel.auto.entities.env;

import java.util.List;

public class Mobile {
    String url;
    User user;
    List<Capabilities> capabilities;
    int timeOut;
    int waitTimeOut;

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

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public List<Capabilities> getCapabilities() {
        return capabilities;
    }

    public void setCapabilities(List<Capabilities> capabilities) {
        this.capabilities = capabilities;
    }

    public void loadCredentials() {
        user.setPassword(System.getProperty("password"));
        user.setUserName(System.getProperty("userName"));
    }

    public Capabilities getCapabilities(String os) {
        for (Capabilities capability : this.capabilities) {
            if (capability.getPlatformName().toLowerCase().equals(os)) {
                return capability;
            }
        }
        throw new IllegalArgumentException(os + " capabilities were not found.");
    }
}
