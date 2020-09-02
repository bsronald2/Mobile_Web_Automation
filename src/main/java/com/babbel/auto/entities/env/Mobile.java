package com.babbel.auto.entities.env;

import java.util.List;

public class Mobile {
    String url;
    User user;
    List<Capabilities> capabilities;


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
            if (capability.getDeviceName().toLowerCase().equals(os)) {
                return capability;
            }
        }
        throw new IllegalArgumentException(os + " capabilities were not found.");
    }
}
