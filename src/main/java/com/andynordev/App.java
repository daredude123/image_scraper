package com.andynordev;

import com.andynordev.config.Configuration;
import com.andynordev.download.DownloadService;
import com.andynordev.scraper.ScrapingService;

import java.io.File;
import java.util.*;

public class App
{
    static String[] urlList;
    static String saveDirectory;
    private static HashMap<String, String> urlDirMap;

    public static void main( String[] args )
    {
        System.out.println(Configuration.getCurrentDir());
        List<String> imageUrls = new ArrayList<>();
        
        if(checkArgs(args)) {
            ScrapingService scrapingService = new ScrapingService();
            for (Map.Entry<String, String> urlDirMapEntry : urlDirMap.entrySet()) {
                imageUrls = scrapingService.getImages(urlDirMapEntry.getKey());
                if (imageUrls == null || imageUrls.size() == 0) {
                    System.out.println("No images to download... Exiting");
                    return;
                }
                for (int i = 0; i < imageUrls.size(); i++) {
                    String imageUrl = imageUrls.get(i);
                    String imageName = i+"_image";
                    new Thread(new DownloadService(imageUrl, entry.getKey(), imageName)).start();
                }
            }
            System.out.printf("Starting download of %s images", imageUrls.size());
        }
    }

    public static boolean checkArgs(String[] args) {
        System.out.println("ARGS : "+ Arrays.toString(args));
        
        if (args.length != 2) {
            System.out.println("missing urls list or image directory");
            return false;
        } else {
            urlList = args[0].split(" ");
            System.out.println(args[1]);
            saveDirectory = args[1] == null ? Configuration.getCurrentDir() : args[1];
            System.out.println("save DIR "+ saveDirectory);
            urlDirMap = new HashMap<>();
            for (String x : urlList) {
                String dir = saveDirectory+File.separator+x;
                System.out.println("MAP dir " + dir);
                new File(dir).mkdirs();
                urlDirMap.put(x,dir);
            }
            System.out.println("save dir : " + "\""+saveDirectory+"\"");
            return true;
        }
    }
}
