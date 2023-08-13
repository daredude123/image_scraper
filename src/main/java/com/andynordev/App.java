package com.andynordev;

import com.andynordev.config.Configuration;
import com.andynordev.download.DownloadService;
import com.andynordev.scraper.ScrapingService;

import java.io.File;
import java.net.URISyntaxException;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        try {
            Configuration.outputDir=  new File(App.class.getProtectionDomain().getCodeSource().getLocation()
                    .toURI()).getPath();
        } catch (URISyntaxException e) {
            System.out.println("Could not get current dir... exiting");
        }

        String[] imageUrls = null;
        if(checkArgs(args)) {
            ScrapingService scrapingService = new ScrapingService();
            for (String url : args) {
                imageUrls = scrapingService.getImages(url);
            }
            if (imageUrls == null || imageUrls.length == 0) {
                System.out.println("No images to download... Exiting");
                return;
            }
            System.out.printf("Starting download of %s images", imageUrls.length);
            for (String imageUrl : imageUrls) {
                new Thread(new DownloadService(imageUrl)).start();
            }
        }
    }

    private static boolean checkArgs(String[] args) {
        return args.length != 0;
    }
}
