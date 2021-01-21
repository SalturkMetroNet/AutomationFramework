package com.metronet.mis.utilities;

import java.util.concurrent.TimeUnit;

public class BrowserUtils
{
	public static void waitFor(int seconds)
	{
		try
		{
			Thread.sleep(seconds * 1000);
		}
		catch (InterruptedException e)
		{
			e.printStackTrace();
		}
	}

	public static void impWait(int max)
	{
		Driver.getDriver().manage().timeouts().implicitlyWait(max, TimeUnit.SECONDS);
	}
}
