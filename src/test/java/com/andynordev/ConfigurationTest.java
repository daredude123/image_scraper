package com.andynordev;

import com.andynordev.config.Configuration;
import org.junit.Assert;
import org.junit.Test;

import java.net.URISyntaxException;

public class ConfigurationTest {

    @Test
    public void getCurrentDirTest() {
        try {
            String dir = Configuration.getCurrentDir();
            System.out.println(dir);
            Assert.assertNotNull(dir);
        } catch (URISyntaxException e) {
            throw new RuntimeException(e);
        }
    }
}
