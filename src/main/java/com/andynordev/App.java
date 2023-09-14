package com.andynordev;

import com.andynordev.config.Configuration;
import com.andynordev.download.DownloadService;
import com.andynordev.scraper.ScrapingService;

import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;

public class App
{
    static String[] urlList;
    static String saveDirectory;
    public static void main( String[] args )
    {
        System.out.println(Configuration.getCurrentDir());
        String[] imageUrls = null;
        
        if(checkArgs(args)) {
            ScrapingService scrapingService = new ScrapingService();
            for (String url : args[0].split(" ")) {
                imageUrls = scrapingService.getImages(url);
            }
            if (imageUrls == null || imageUrls.length == 0) {
                System.out.println("No images to download... Exiting");
                return;
            }
            System.out.printf("Starting download of %s images", imageUrls.length);
            ThreadPoolExecutor tpe = (ThreadPoolExecutor) Executors.newCachedThreadPool();
            for (String imageUrl : imageUrls) {

                tpe.execute(new DownloadService(imageUrl,saveDirectory));
                //new Thread(new DownloadService(imageUrl, saveDirectory)).start();
            }
        }
    }

    private static boolean checkArgs(String[] args) {
        if (args.length != 2) {
            System.out.println("missing urls list or image directory");
            return false;
        } else {
            urlList = args[0].split(" ");
            saveDirectory = args[1] == null ? Configuration.getCurrentDir() : args[1];
            System.out.println("urls:");
            for (String x : urlList) {
                System.out.println(x);
            }
            System.out.println("save dir : " + "\""+saveDirectory+"\"");
            return true;
        }
    }
}
