package com.metronet.mis.pages.ves;

import com.metronet.mis.utilities.common.ConfigurationReader;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

/**
 * This is the Login Page class file which contains all necessary information of login page to VES system.
 *
 * login() method to login to VES system
 * @see WebElement
 *
 * @author salturk
 */
public class LoginPageVES extends VESBasePage
{
    /**
     * Username text field
     */
    @FindBy(id = "username")
    public WebElement username;

    /**
     * Password text field
     */
    @FindBy(id = "password")
    public WebElement password;

    /**
     * Submit Button
     */
    @FindBy(tagName = "button")
    public WebElement submitButton;

    /**
     * login() method
     * Logs into VES system by interacting with the necessary WebElements and enter required information
     *
     * @see ConfigurationReader
     *
     * @author salturk
     */
    public void login()
    {
        String usernameString = ConfigurationReader.getProperty("username");
        String passwordString = ConfigurationReader.getProperty("password");
        username.sendKeys(usernameString);
        password.sendKeys(passwordString);
        submitButton.click();
        logger.info("Login with " + usernameString + " username and " + passwordString + " password");
    }
}
