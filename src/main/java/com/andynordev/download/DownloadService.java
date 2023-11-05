package com.andynordev.download;

import com.andynordev.config.Configuration;

import java.io.BufferedInputStream;
import java.io.FileOutputStream;
import java.net.URL;

public class DownloadService implements Runnable {
    
    String imageUrl;
    String outputDirectory;
    String fileName;
    String imageName;

    public DownloadService(String imageUrl, String outputDirectory, String imageName) {
        this.imageUrl = imageUrl;
        this.outputDirectory = outputDirectory;
        this.imageName = imageName;
    }

    public void run() {
        System.out.println("Downloading file : " + imageUrl);
        try {
            this.fileName = downloadFile(imageUrl);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public String downloadFile(String url) {
        System.out.println("downloading " +url);
        String fileExt = !url.substring(url.lastIndexOf(".")).isEmpty() ? url.substring(url.lastIndexOf(".")) : "";

        Configuration.createDir(outputDirectory);
        String fullPath = this.outputDirectory+"/"+this.imageName+fileExt;
        System.out.println("saving as : " + fullPath);
        System.out.println("image name " + this.imageName);
        System.out.println("image url " + this.imageUrl);
        try (BufferedInputStream in = new BufferedInputStream(new URL(url).openStream());
             FileOutputStream fileOutputStream = new FileOutputStream(fullPath)) {

            byte[] dataBuffer = new byte[1024];
            int bytesRead;
            while ((bytesRead = in.read(dataBuffer, 0, 1024)) != -1) {
                fileOutputStream.write(dataBuffer, 0, bytesRead);
            }
            System.out.println("finished " +url);
            return fileName;
        } catch (Exception e) {
            System.out.println("could not download image.");
            e.printStackTrace();
        }
        System.out.println("finished " +url);
        return fileName;
    }
}
