package com.metronet.mis.pages.ves;

import com.metronet.mis.pages.BasePage;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class SearchPage extends BasePage
{
    private final static Logger logger = Logger.getLogger(LoginPage.class);

    @FindBy(linkText = "New")
    public WebElement newPageButton;
}
