package com.andynordev;

import com.andynordev.config.Configuration;
import org.junit.Assert;
import org.junit.Test;

import java.net.URISyntaxException;

public class ConfigurationTest {
    @Test
    public void getCurrentDirTest() {
        String dir = Configuration.getCurrentDir();
        System.out.println(dir);
        Assert.assertNotNull(dir);
    }
}
