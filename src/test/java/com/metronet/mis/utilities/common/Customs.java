package com.metronet.mis.utilities.common;

public class Customs
{
    public static String randomZeroOne()
    {
        double temp = Math.random();
        if (temp < 0.5)
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
