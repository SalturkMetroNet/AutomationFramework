package com.metronet.mis.pages;

import com.metronet.mis.utilities.Driver;
import org.apache.log4j.Logger;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

public abstract class BasePage
{
    protected final static Logger logger = Logger.getLogger(BasePage.class);
    protected WebDriverWait wait = new WebDriverWait(Driver.getDriver(), 60);

    public BasePage()
    {
        PageFactory.initElements(Driver.getDriver(), this);
    }

}
