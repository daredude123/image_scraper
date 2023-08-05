package com.andynordev;

import com.andynordev.scraper.JsoupUtil;
import com.andynordev.scraper.ScrapingService;
import org.jsoup.nodes.Document;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class JsoupUtilTest {

    JsoupUtil jsoupUtil;

    @Before
    public void before() {
        jsoupUtil = new JsoupUtil();
    }

    @Test
    public void get_document_test() {
        Document doc = jsoupUtil.getDocument("https://wikipedia.com/wiki/james_bond");
        System.out.println("not null");
        Assert.assertNotNull(doc);
        System.out.println("not empty");
        Assert.assertNotEquals("",doc.body().text());
    }

}
