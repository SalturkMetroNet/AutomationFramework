package com.metronet.mis.pages.ves;

import com.metronet.mis.utilities.ui.Driver;
import org.apache.log4j.Logger;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * This is the BasePage file which is the super of all other page classes I have created. It used to contain certain codes which is inherited
 * to other classes
 *
 * @author salturk
 */

public abstract class VESBasePage
{
    protected final static Logger logger = Logger.getLogger(VESBasePage.class);
    protected WebDriverWait wait = new WebDriverWait(Driver.getDriver(), 60);

    public VESBasePage()
    {
        PageFactory.initElements(Driver.getDriver(), this);
    }
}
