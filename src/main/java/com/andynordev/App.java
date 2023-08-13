package com.andynordev;

import com.andynordev.download.DownloadService;
import com.andynordev.scraper.ScrapingService;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
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
                
            }
        }
    }

    private static boolean checkArgs(String[] args) {
        return args.length != 0;
    }
}
