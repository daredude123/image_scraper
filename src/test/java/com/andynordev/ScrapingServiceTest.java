package com.andynordev;

import com.andynordev.scraper.ScrapingService;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class ScrapingServiceTest {

    ScrapingService scrapingService;

    @Before
    public void setup() {
        scrapingService = new ScrapingService();
    }

    @Test
    public void get_document_images() {
        String[] images = scrapingService.getImages("https://wikipedia.com/wiki/james_bond");
        for (String x : images) {
            System.out.println(x);
            Assert.assertNotNull(x);
        }
        Assert.assertNotEquals(0,images.length);
    }

    @Test
    public void test_empty_url() {
        String[] images = scrapingService.getImages("");
        Assert.assertNull(images);
    }
}
