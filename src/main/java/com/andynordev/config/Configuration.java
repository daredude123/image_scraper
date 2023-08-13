package com.andynordev.config;

import com.andynordev.App;

import java.io.File;
import java.net.URISyntaxException;

public class Configuration {

    public static String getCurrentDir() throws URISyntaxException {

        return new File(App.class.getProtectionDomain().getCodeSource().getLocation()
                .toURI()).getPath();
    }
}
