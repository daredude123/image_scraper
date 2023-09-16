package com.andynordev;

import com.andynordev.download.DownloadService;
import org.junit.Before;
import org.junit.Test;

public class DownloadServiceTest {
    DownloadService downloadService;
    String testImageUrl = "https://wiki.image/test/image.jpg";
    String testOutput = "test/";
    @Before
    public void setup() {
        downloadService = new DownloadService(testImageUrl, testOutput);
    }
    @Test
    public void checkFileExtensionTest() {
        DownloadService.allowedExtension("jpg");
    }
}
