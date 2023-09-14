package com.andynordev.scraper;

import com.andynordev.config.Configuration;
import com.andynordev.download.DownloadService;
import com.andynordev.enums.PictureExt;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

public class ScrapingService {

    JsoupUtil jsoupUtil;
    DownloadService downloadService;

    public ScrapingService() {
        this.jsoupUtil = new JsoupUtil();
    }

    public String[] getImages(String url) {
        Document doc = jsoupUtil.getDocument(url);
        if (doc == null) {
            return null;
        }

        Elements images = doc.getElementsByTag("img");
        String[] arr = new String[images.size()];
        for (int i = 0; i< arr.length;i++) {
            String absSrc = images.get(i).attr("abs:src").isEmpty() ? images.get(i).attr("abs:data-src") : images.get(i).attr("abs:src");
            arr[i] = absSrc;
        }
        return arr;
    }

}
