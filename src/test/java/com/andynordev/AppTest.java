package com.andynordev;

import static org.junit.Assert.assertTrue;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;

/**
 * Unit test for simple App.
 */
public class AppTest 
{

    String[] args = {"https://nrk.no https://ba.no", "/home/andreas/test"};

    @Test
    public void shouldAnswerWithTrue()
    {
        App.checkArgs(args);
        System.out.println(Arrays.toString(App.urlList));
        System.out.println(App.saveDirectory);
        Assert.assertEquals("/home/andreas/test", App.saveDirectory);
        Assert.assertEquals("[https://nrk.no, https://ba.no]", Arrays.toString(App.urlList));
    }
}
