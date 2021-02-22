package com.metronet.mis.utilities.common;

import java.util.Random;

/**
 * Custom methods to help with random processes
 */
public class Customs
{
   static Random random = new Random();

    public static String randomZeroOne()
    {
        if (random.nextBoolean())
        {
            return "0";
        }
        else return "1";
    }

    public static String getRandomInternetSpeedValue()
    {
        int random =(int) (Math.random() * 100);
        if (random>=0 && random<20)
        {
            return "2M";
        }
        else if (random>=20 && random <40)
        {
            return "100M";
        }
        else if (random>=40 && random < 60)
        {
            return "200M";
        }
        else if (random>=60 && random < 80)
        {
            return "500M";
        }
        else return "1GB";
    }
}
