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
    String fileName;

    public DownloadService(String imageUrl, String outputDirectory) {
        this.imageUrl = imageUrl;
        this.outputDirectory = outputDirectory;
    }

    public void run() {
        System.out.println("Downloading file : " + imageUrl);
        try {
            this.fileName = downloadFile(imageUrl);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public String downloadFile(String url) throws IOException {
        System.out.println("downloading " +url);
        String[] nameSplit = url.split("/");
        String fileName = nameSplit[nameSplit.length-1];
        outputDirectory = Configuration.createDir(outputDirectory);

        try (BufferedInputStream in = new BufferedInputStream(new URL(url).openStream());
             FileOutputStream fileOutputStream = new FileOutputStream(outputDirectory+"/"+fileName)) {

            byte[] dataBuffer = new byte[1024];
            int bytesRead;
            while ((bytesRead = in.read(dataBuffer, 0, 1024)) != -1) {
                fileOutputStream.write(dataBuffer, 0, bytesRead);
            }
            System.out.println("finished " +url);
            return fileName;
        } catch (IOException e) {
            System.out.println("could not download image.");
            e.printStackTrace();
        }
        System.out.println("finished " +url);
        return fileName;
    }
}
