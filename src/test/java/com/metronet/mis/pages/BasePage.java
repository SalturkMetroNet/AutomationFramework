package com.metronet.mis.pages;

import com.metronet.mis.utilities.Driver;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

public abstract class BasePage
{
	protected final static Logger logger = Logger.getLogger(BasePage.class);
	protected WebDriverWait wait = new WebDriverWait(Driver.getDriver(), 20);

	public BasePage()
	{
		PageFactory.initElements(Driver.getDriver(), this);
	}

	/**
	 * Method used for navigation. Module name will be specified in feature file:
	 * @param moduleName like New
	 */

	public void navigateTo(String moduleName)
	{
		//if moduleName = Activity Stream, then xpath like this:
		// //span[contains(text(),'Activity Stream') and @class='menu-item-link-fast']
		// and this xpath represents Activity Stream kink on the page
		String xpath = "//span[contains(text(),'"+moduleName+"') and @class='menu-item-link-text']";
		//wait for presence of element and click on it
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(xpath))).click();
		logger.info("Navigating to: "+moduleName);
	}
}
