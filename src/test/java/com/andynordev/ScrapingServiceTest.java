package com.andynordev;

import com.andynordev.scraper.ScrapingService;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.List;

public class ScrapingServiceTest {

    ScrapingService scrapingService;

    @Before
    public void setup() {
        scrapingService = new ScrapingService();
    }

    @Test
    public void get_document_images() {
        List<String> images = scrapingService.getImages("https://wikipedia.com/wiki/james_bond");
        for (String x : images) {
            System.out.println(x);
            Assert.assertNotNull(x);
        }
        Assert.assertNotEquals(0,images.size());
    }

    @Test
    public void test_empty_url() {
        List<String> images = scrapingService.getImages("");
        Assert.assertNull(images);
    }
}
