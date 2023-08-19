package com.andynordev.scraper;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URISyntaxException;
import java.net.URL;
import java.sql.SQLOutput;

public class JsoupUtil {

    public Document getDocument(String url) {
        try {
            String cleanedUrl = checkParameter(url);
            return Jsoup.connect(cleanedUrl).get();
        } catch(Exception e) {
            System.out.println("returning null");
            return null;
        }
    }

    //hei på deg!
    private static String checkParameter(String param) throws URISyntaxException {
        if (param != null) {
            return param;
        }
        try {
            URL url = new URL(param);
            url.toURI();
        } catch (MalformedURLException e) {
            System.out.println("Failed Url validation");
        } catch (URISyntaxException e) {
            System.out.println("Invalid syntax on url");
            throw e;
        }
        return "NA";
    }
}
