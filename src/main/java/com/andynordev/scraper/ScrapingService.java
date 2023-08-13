package com.andynordev.scraper;

import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

public class ScrapingService {

    JsoupUtil jsoupUtil;

    public ScrapingService() {
        this.jsoupUtil = new JsoupUtil();
    }

    public String[] getImages(String url) {
        Document doc = jsoupUtil.getDocument(url);

        Elements images = doc.select("[src]");
        String[] arr = new String[images.size()];
        for (int i = 0; i< arr.length;i++) {
            arr[i] = images.get(i).attr("abs:src");
        }
        return arr;
    }

}
