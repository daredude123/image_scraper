package com.andynordev;

import com.andynordev.download.DownloadService;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class DownloadServiceTest {
    DownloadService downloadService;
    String testImageUrl = "https://wiki.image/test/image.jpg";
    String testOutput = "test/";
    String testName = "navnpåfil";
    @Before
    public void setup() {
        downloadService = new DownloadService(testImageUrl, testOutput, testName);
    }

}
