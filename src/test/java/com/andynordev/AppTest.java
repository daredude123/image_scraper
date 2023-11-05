package com.andynordev;

import java.util.Arrays;

import org.junit.Assert;
import org.junit.Test;

/**
 * Unit test for simple App.
 */
public class AppTest 
{

    String[] args = {"https://nrk.no https://ba.no", "/home/andreas/test"};
    String[] expectedUrlList = {"https://nrk.no", "https://ba.no"};
    String expectedSaveDir = "/home/andreas/test";

    @Test
    public void shouldAnswerWithTrue()
    {
        App.checkArgs(args);
        System.out.println("url list : "+Arrays.toString(App.urlList));
        System.out.println("save directory : "+App.saveDirectory);
        
        Assert.assertEquals(expectedSaveDir, App.saveDirectory);
        Assert.assertEquals(expectedUrlList, App.urlList);
    }
}
