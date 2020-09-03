package com.babbel.auto.mobile;


import java.nio.file.Paths;

public enum App {
    ANDROID("%s/app-debug.apk"),
    IOS("%s/app/");

    String appPath;
    App(String appPath) {
        this.appPath = String.format(appPath, Paths.get("app").toAbsolutePath().toString());;
    }

    public String getAppPath() {
        return this.appPath;
    }
}
