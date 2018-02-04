package com.udacity.gradle.builditbigger.backend;

import com.google.api.server.spi.config.Api;
import com.google.api.server.spi.config.ApiMethod;
import com.google.api.server.spi.config.ApiNamespace;

/** An endpoint class we are exposing */
@Api(
        name = "jokeApi",
        version = "v1",
        namespace = @ApiNamespace(
                ownerDomain = "com.udacity.gradle.builditbigger.backend",
                ownerName = "com.udacity.gradle.builditbigger.backend",
                packagePath = ""))

public class JokeEndpoint {

    @ApiMethod(name = "putJoke")
    public JokeTellerBean putJoke() {
        JokeTellerBean jokeTellerBean = new JokeTellerBean();
        return jokeTellerBean;
    }

}
