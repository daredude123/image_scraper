package com.andynordev;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        if(checkArgs(args)) {

        }
        System.out.println("Needs a url for scraping");
    }

    private static boolean checkArgs(String[] args) {
        return args.length != 0;
    }
}
