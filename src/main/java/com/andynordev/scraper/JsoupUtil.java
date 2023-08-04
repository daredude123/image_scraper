package com.andynordev.scraper;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

import java.io.IOException;

public class JsoupUtil {

    public Document getDocument(String url) {
        String cleanedUrl = checkParameter(url);
        try {
            return Jsoup.connect(cleanedUrl).get();
        } catch(
                IOException e) {
            return null;
        }
    }

    private static String checkParameter(String param) {
        if (param != null) {
            return param;
        }
        return "";
    }
}
