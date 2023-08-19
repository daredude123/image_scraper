package com.andynordev.config;

import com.andynordev.App;

import java.io.File;
import java.net.URISyntaxException;

public class Configuration {

    public static String getCurrentDir() {

        try {
            return new File(App.class.getProtectionDomain().getCodeSource().getLocation()
                    .toURI()).getPath();
        } catch (URISyntaxException e) {
            throw new RuntimeException(e);
        }
    }
}
