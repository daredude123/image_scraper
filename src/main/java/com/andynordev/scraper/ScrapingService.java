package com.andynordev.scraper;

import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

import java.util.ArrayList;
import java.util.List;

public class ScrapingService {

    JsoupUtil jsoupUtil;
    static String[] imageAttrs = {"abs:src", "abs:data-src", "abs:data-srcset", "abs:abs:srcset"};

    public ScrapingService() {
        this.jsoupUtil = new JsoupUtil();
    }

    public List<String> getImages(String url) {
        Document doc = jsoupUtil.getDocument(url);
        if (doc == null) {
            return null;
        }

        Elements images = doc.getElementsByTag("img");
        ArrayList<String> imageList = new ArrayList<>();
        for (int i = 0; i< images.size();i++) {
            for (String attr : imageAttrs) {
                String absSrc = images.get(i).attr(attr);
                if (!absSrc.isEmpty()) {
                    imageList.add(absSrc);
                }
            }
        }
        return imageList;
    }

}
