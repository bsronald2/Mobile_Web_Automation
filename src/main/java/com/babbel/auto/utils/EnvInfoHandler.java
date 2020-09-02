package com.babbel.auto.utils;

import com.babbel.auto.entities.env.EnvInfo;

import java.io.FileNotFoundException;

public class EnvInfoHandler {

    private String path;
    private EnvInfo envInfo;

    /**
     *
     * @param path to load Yaml file
     */
    public EnvInfoHandler(String path) {
        this.path = path;
        loadYaml();
    }

    private void loadYaml() {
        try {
            this.envInfo = (EnvInfo) YamlReader.loadYamlFileAsObject(EnvInfo.class, this.path);
        } catch (FileNotFoundException ex) {
            ex.fillInStackTrace();
        }
    }

    public EnvInfo getEnvInfo() {
        return this.envInfo;
    }
}
