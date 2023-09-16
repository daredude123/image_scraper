package com.andynordev.download;

import com.andynordev.config.Configuration;

import java.io.BufferedInputStream;
import java.io.FileOutputStream;
import java.net.URL;

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
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public String downloadFile(String url) {
        System.out.println("downloading " +url);
        String[] nameSplit = url.split("/");
        String fileName = nameSplit[nameSplit.length-1];
        //String fileExt = !fileName.substring(fileName.lastIndexOf(".")).isEmpty() ? fileName.substring(fileName.lastIndexOf(".")) : "";
       /** if (!allowedExtension(fileExt)) {
            System.out.println("File not a valid form. filename: " +fileName);
            return "";
        }*/
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
        } catch (Exception e) {
            System.out.println("could not download image.");
            e.printStackTrace();
        }
        System.out.println("finished " +url);
        return fileName;
    }
}
