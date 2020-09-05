package com.babbel.auto.entities.env;

/**
 * This class is used to parse envInfo.yaml file to
 * an Object.
 */
public class EnvInfo {

    String id;
    Mobile mobile;
    Web web;

    public void loadInitParam() {
        mobile.loadCredentials();
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Mobile getMobile() {
        return mobile;
    }

    public void setMobile(Mobile mobile) {
        this.mobile = mobile;
    }

    public Web getWeb() {
        return web;
    }

    public void setWeb(Web web) {
        this.web = web;
    }
}
