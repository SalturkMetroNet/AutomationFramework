package com.metronet.mis.pages.ves;

import com.metronet.mis.pages.BasePage;
import com.metronet.mis.utilities.BrowserUtils;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class ServicesPage extends BasePage
{
    private final static Logger logger = Logger.getLogger(ServicesPage.class);

    @FindBy(xpath = "(//button[.='Reset'])[3]")
    public WebElement resetAllServices;

    @FindBy(xpath = "//span[text()='21.23']")
    public WebElement biptvCheckBox;

    @FindBy(xpath = "//span[text()='86.12']")
    public WebElement siptvCheckBox;

    @FindBy(xpath = "//span[text()='97.71']")
    public WebElement piptvCheckBox;

    @FindBy(xpath = "//span[@title='Add Mediaroom STB']")
    public WebElement addStbLink;

    @FindBy(id = "ratePlans")
    public WebElement stbMenuRatePlanDropdown;

    @FindBy(xpath = "//button[text()='Apply']")
    public WebElement stbMenuRateSubmitButton;

    @FindBy(xpath = "//label[@class='indent']")
    public WebElement stbPCCheckBox;

    @FindBy(xpath = "(//label[@class='indent'])[2]")
    public WebElement stbRCCheckBox;

    @FindBy(xpath = "(//label[@class='indent'])[4]")
    public WebElement stbUCheckBox;

    @FindBy(xpath = "//span[text()='16.95']")
    public WebElement dvrCheckBox;

    @FindBy(xpath = "(//span[text()='5.00'])[2]")
    public WebElement dvrPCCheckBox;

    @FindBy(xpath = "(//span[.='Replacement Remote Control'])[3]")
    public WebElement dvrRCCheckBox;

    @FindBy(xpath = "//span[text()='Unreturned Digital Set Top Box with DVR & HD']")
    public WebElement dvrUCheckBox;

    @FindBy(xpath = "(//span[text()='1.22'])[1]")
    public WebElement hdeliteCheckBox;

    @FindBy(xpath = "//a[@title='Internet']")
    public WebElement internetTitle;

    @FindBy(xpath = "//span[text()='49.95']")
    public WebElement internet100mCheckBox;

    @FindBy(xpath = "//div[contains(@class, 'askExtender panel form')]//table//button[2]")
    public WebElement wholeHomePopUpNoButton;

    @FindBy(xpath = "(//button[.='Submit'])[4]")
    public WebElement submitServicesButton;

    @FindBy(id = "overlay")
    public WebElement loadingOverlay;

    public void chooseServices()
    {
        wait.until(ExpectedConditions.invisibilityOf(loadingOverlay));
        resetAllServices.click();
        wait.until(ExpectedConditions.invisibilityOf(loadingOverlay));
        resetAllServices.click();
        BrowserUtils.impWait(30);
        wait.until(ExpectedConditions.invisibilityOf(loadingOverlay));
        biptvCheckBox.click();
        BrowserUtils.impWait(30);
        wait.until(ExpectedConditions.invisibilityOf(loadingOverlay));
        dvrCheckBox.click();
        BrowserUtils.impWait(30);
        wait.until(ExpectedConditions.invisibilityOf(loadingOverlay));
        internetTitle.click();
        BrowserUtils.impWait(30);
        wait.until(ExpectedConditions.invisibilityOf(loadingOverlay));
        internet100mCheckBox.click();
        BrowserUtils.impWait(30);
        wait.until(ExpectedConditions.invisibilityOf(loadingOverlay));
        BrowserUtils.waitFor(1);
        try
        {
            wholeHomePopUpNoButton.click();
        }
        finally
        {
            logger.info("Pop up button");
        }
        wait.until(ExpectedConditions.invisibilityOf(loadingOverlay));
        BrowserUtils.impWait(30);
        submitServicesButton.click();
        wait.until(ExpectedConditions.invisibilityOf(loadingOverlay));
        BrowserUtils.impWait(30);
    }

}
