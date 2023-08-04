package com.andynordev;

import com.andynordev.scraper.JsoupUtil;
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
    public void getDocumentTest() {
        Document doc = jsoupUtil.getDocument("https://wikipedia.com/wiki/james_bond");
        Assert.assertNotNull(doc);
        Assert.assertNotEquals("",doc.body().text());
    }
}
