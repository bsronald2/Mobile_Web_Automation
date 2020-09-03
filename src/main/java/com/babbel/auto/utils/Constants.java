package com.babbel.auto.utils;

import java.nio.file.Path;
import java.nio.file.Paths;

public final class Constants {


    /**
     * This Constructor to default.
     */
    private Constants() {
    }

    // Absolute Paths
    public static Path dir = Paths.get("src");
    public static final String UTILS_PATH = dir.toAbsolutePath().toString();

    // Paths
    public static final String ENV_INFO_PATH = UTILS_PATH.concat("/main/resources/envInfo.yaml");
    public static final String CONFIG_PATH = UTILS_PATH.concat("/main/resources/config.properties");

    // Properties Keys
    public static final String BROWSER = "BROWSER";
    public static final String DRIVER = "DRIVER";
    public static final String SERVER = "SERVER";
    public static final String TAGS = "TAGS";


    // Browsers
    public static final String CHROME = "chrome";
    public static final String FIREFOX = "firefox";

    /*OS System*/
    public static final String WINDOWS_OS = "Windows";
    public static final String LINUX_OS = "Linux";
    public static final String ANDROID = "android";
    public static final String IOS = "ios";
}
