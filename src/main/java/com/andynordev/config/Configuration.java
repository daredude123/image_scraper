package com.andynordev.config;

import com.andynordev.App;

import java.io.File;
import java.io.IOException;
import java.net.URISyntaxException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class Configuration {

    public static String getCurrentDir() {

        try {
            return new File(App.class.getProtectionDomain().getCodeSource().getLocation()
                    .toURI()).getPath();
        } catch (URISyntaxException e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * creates dir or return current directory
     * @param outputPathParam
     * @return
     */
    public static String createDir(String outputPathParam) {
        try {
            //todo something fucky
            return Files.createDirectories(Paths.get(outputPathParam)).toString();
        } catch (IOException e) {
            System.out.println("Could not create directory");
            e.printStackTrace();
            throw new RuntimeException(e);
        }
    }
}
