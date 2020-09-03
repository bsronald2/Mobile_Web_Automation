package com.babbel.auto;

import com.babbel.auto.entities.env.EnvInfo;
import com.babbel.auto.utils.Constants;
import com.babbel.auto.utils.EnvInfoHandler;

public abstract class AbstractDriverManager {

    protected EnvInfo envInfo;

    public AbstractDriverManager(){
        this.envInfo = new EnvInfoHandler(Constants.ENV_INFO_PATH).getEnvInfo();
        this.envInfo.loadInitParam();
    }
}
