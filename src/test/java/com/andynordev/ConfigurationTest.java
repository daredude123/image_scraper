package com.andynordev;

import com.andynordev.config.Configuration;
import org.apache.commons.io.FileUtils;
import org.junit.Assert;
import org.junit.Test;

import java.io.File;
import java.io.IOException;

public class ConfigurationTest {

    String testDir = "/home/andreas/test";
    @Test
    public void getCurrentDirTest() {
        String dir = Configuration.getCurrentDir();
        System.out.println(dir);
        Assert.assertNotNull(dir);
    }

    @Test
    public void paramDirTest() {
        String dir = Configuration.createDir(testDir);
        System.out.println(dir);
        Assert.assertEquals(testDir, dir);
        cleanUp();
    }

    public void cleanUp() {
        try {
            FileUtils.deleteDirectory(new File(testDir));
        } catch (IOException e) {
            System.out.println("could not clean up...");
            throw new RuntimeException(e);
        }
    }
}
