package com.metronet.mis.pages;

import com.metronet.mis.utilities.ConfigurationReader;
import org.apache.log4j.Logger;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends BasePage
{
	private final static Logger logger = Logger.getLogger(LoginPage.class);

	@FindBy(id = "username")
	public WebElement username;

	@FindBy(id = "password")
	public WebElement password;

	@FindBy(tagName = "button")
	public WebElement submitButton;

	public void login()
	{
		String usernameString = ConfigurationReader.getProperty("username");
		String passwordString = ConfigurationReader.getProperty("password");
		username.sendKeys(usernameString);
		password.sendKeys(passwordString, Keys.ENTER);
		logger.info("Login with " + usernameString + " username and " + passwordString + " password");
	}


}
