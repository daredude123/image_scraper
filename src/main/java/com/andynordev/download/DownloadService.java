package com.andynordev.download;

import java.io.BufferedInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.URL;

public class DownloadService {

    public String downloadFile(String url) {
        String[] nameSplit = url.split("/");
        String fileName = nameSplit[nameSplit.length-1];
        try (BufferedInputStream in = new BufferedInputStream(new URL(url).openStream());
             FileOutputStream fileOutputStream = new FileOutputStream(fileName)) {

            byte[] dataBuffer = new byte[1024];
            int bytesRead;
            while ((bytesRead = in.read(dataBuffer, 0, 1024)) != -1) {
                fileOutputStream.write(dataBuffer, 0, bytesRead);
            }
            return "";
        } catch (IOException e) {
            System.out.println("could not download image.");
        }
        return "";
    }
}
