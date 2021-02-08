package com.metronet.mis.pages.ves;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class SearchPageVES extends VESBasePage
{
    /**
     * New Title
     */
    @FindBy(linkText = "New")
    public WebElement newPageButton;
}
