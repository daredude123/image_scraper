package com.andynordev.download;

import com.andynordev.config.Configuration;

import java.io.BufferedInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Paths;

public class DownloadService implements Runnable {
    
    String imageUrl;
    String outputDirectory;

    public DownloadService(String imageUrl, String outputDirectory) {
        this.imageUrl = imageUrl;
        this.outputDirectory = outputDirectory;
    }

    public void run() {
        System.out.println("Downloading file : " + imageUrl);
        String fileName = downloadFile(imageUrl);
    }

    public String downloadFile(String url) {
        String[] nameSplit = url.split("/");
        String fileName = nameSplit[nameSplit.length-1];
        try {
            Files.createDirectories(Paths.get(outputDirectory));
        } catch (IOException e) {
            System.out.println("Could not create directory");
            e.printStackTrace();
        }
        try (BufferedInputStream in = new BufferedInputStream(new URL(url).openStream());
             FileOutputStream fileOutputStream = new FileOutputStream(outputDirectory+"/"+fileName)) {

            byte[] dataBuffer = new byte[1024];
            int bytesRead;
            while ((bytesRead = in.read(dataBuffer, 0, 1024)) != -1) {
                fileOutputStream.write(dataBuffer, 0, bytesRead);
            }
            return fileName;
        } catch (IOException e) {
            System.out.println("could not download image.");
            e.printStackTrace();
        }
        return fileName;
    }
}
