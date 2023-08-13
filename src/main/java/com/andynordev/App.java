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

        if(checkArgs(args)) {
            ScrapingService scrapingService = new ScrapingService();
            String[] urls = scrapingService.

        }
        System.out.println("empty parameter. url cannot be empty");
    }

    private static boolean checkArgs(String[] args) {
        return args.length != 0;
    }
}
