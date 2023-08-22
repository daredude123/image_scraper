package com.andynordev.scraper;

import com.andynordev.enums.PictureExt;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

public class ScrapingService {

    JsoupUtil jsoupUtil;

    public ScrapingService() {
        this.jsoupUtil = new JsoupUtil();
    }

    public String[] getImages(String url) {
        Document doc = jsoupUtil.getDocument(url);
        if (doc == null) {
            return null;
        }

        Elements images = doc.select("[src]");
        String[] arr = new String[images.size()];
        for (int i = 0; i< arr.length;i++) {
            String absSrc = images.get(i).attr("abs:src");
            //Todo add check for file extensions. IMAGES ONLY!!!
        }
        return arr;
    }

}
