package com.metronet.mis.pages.ves;

import com.metronet.mis.pages.BasePage;
import com.metronet.mis.pojos.Parameter;
import com.metronet.mis.utilities.ui.BrowserUtils;
import com.metronet.mis.utilities.common.Customs;
import com.metronet.mis.utilities.ui.Driver;
import org.apache.log4j.Logger;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ServicesPage extends BasePage
{
    private final static Logger logger = Logger.getLogger(ServicesPage.class);

    @FindBy(xpath = "//button[@type='reset']")
    public WebElement resetAllServicesButton;

    @FindBy(xpath = "//button[text()='Cancel All']")
    public WebElement cancelAllServicesButton;

    @FindBy(xpath = "(//button[.='Submit'])[4]")
    public WebElement submitServicesButton;


    @FindBy(xpath = "//span[@class='leaderLabel']")
    public WebElement biptvCheckBox;

    @FindBy(xpath = "(//span[@class='leaderLabel'])[2]")
    public WebElement siptvCheckBox;

    @FindBy(xpath = "(//span[@class='leaderLabel'])[3]")
    public WebElement piptvCheckBox;


    @FindBy(xpath = "//span[@data-platform='mediaroom']")
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

    @FindBy(xpath = "(//span[text()='4.31'])[1]")
    public WebElement sportstierCheckBox;

    @FindBy(xpath = "(//span[text()='7.18'])[1]")
    public WebElement starzCheckBox;

    @FindBy(xpath = "(//span[text()='8.47'])[1]")
    public WebElement cinemaxCheckBox;

    @FindBy(xpath = "(//span[text()='8.50'])[1]")
    public WebElement showtimeCheckBox;

    @FindBy(xpath = "(//span[text()='15.00'])[3]")
    public WebElement hboCheckBox;

    @FindBy(xpath = "//a[@title='Internet']")
    public WebElement internetTitle;

    @FindBy(xpath = "//span[text()='19.95']")
    public WebElement internet2mCheckBox;

    @FindBy(xpath = "//span[text()='49.95']")
    public WebElement internet100mCheckBox;

    @FindBy(xpath = "//span[text()='59.95']")
    public WebElement internet200mCheckBox;

    @FindBy(xpath = "//span[text()='69.95']")
    public WebElement internet500mCheckBox;

    @FindBy(xpath = "//span[text()='89.95']")
    public WebElement internet1gbCheckBox;

    @FindBy(xpath = "//span[text()='Purchased Router']")
    public WebElement purchasedRouterCheckBox;

    @FindBy(xpath = "//span[text()='Unreturned Router']")
    public WebElement unreturnedRouterCheckBox;

    @FindBy(xpath = "//span[text()='Tech Home Protect']")
    public WebElement techHomeProtectCheckBox;

    @FindBy(xpath = "//span[text()='Mobile Protect Add-On']")
    public WebElement thp_MobileProtectAddonCheckBox;

    @FindBy(xpath = "//span[text()='Desktop Protect Add-On']")
    public WebElement thp_DesktopProtectAddonCheckBox;

    @FindBy(xpath = "//span[text()='Tech Home Support']")
    public WebElement techHomeSupportCheckBox;

    @FindBy(xpath = "(//span[text()='Mobile Protect Add-On'])[3]")
    public WebElement ths_MobileProtectAddonCheckBox;

    @FindBy(xpath = "(//span[text()='Desktop Protect Add-On'])[3]")
    public WebElement ths_DesktopProtectAddonCheckBox;

    @FindBy(xpath = "//div[contains(@class, 'askExtender panel form')]//table//button[2]")
    public WebElement wholeHomePopUpNoButton;

    @FindBy(xpath = "//span[@title='Add WholeHome Wifi']")
    public WebElement addWholehomeWifiLink;

    @FindBy(xpath = "//span[text()='Speed Boost']")
    public WebElement speedBoostCheckBox;

    @FindBy(linkText = "Phone")
    public WebElement phoneTitle;

    @FindBy(xpath = "//span[text()='Fiber Phone 1000']")
    public WebElement fiberPhoneCheckBox;

    @FindBy(xpath = "(//div[contains(@class,'askBatteryBackup panel')]//button)[2]")
    public WebElement batteryBackupPopUpNoButton;

    @FindBy(xpath = "//div[contains(@class,'askBatteryBackup panel')]//button[1]") //(//button[.='Yes'])[4]
    public WebElement batteryBackupPopUpYesButton;

    @FindBy(id = "ratePlans")
    public WebElement ratePlanPopUpDropdown;

    @FindBy(xpath = "(//button[contains(@class,'submit button')])[2]")
    public WebElement ratePlanPopUpApplyButton;

    @FindBy(xpath = "//select[@data-id='lineType-activeAddrNew1']")
    public WebElement lineTypeDropdown;

    @FindBy(id = "overlay")
    public WebElement loadingOverlay;

    @FindBy(xpath = "//span[text()='10.00']")
    public WebElement sipAddressCheckBox;

    public void chooseServices()
    {
        wait.until(ExpectedConditions.invisibilityOf(loadingOverlay));
        resetAllServicesButton.click();
        wait.until(ExpectedConditions.invisibilityOf(loadingOverlay));
        resetAllServicesButton.click();
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
        BrowserUtils.wait(1);
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

    public void chooseServicesWithParameters(Parameter parameter)
    {
        wait.until(ExpectedConditions.invisibilityOf(loadingOverlay));
        resetAllServicesButton.click();
        logger.info(parameter.toString());
        if (parameter.getTv().equals("1"))
        {
            BrowserUtils.impWait(30);

            if (parameter.getIptv().equals("r"))
            {
                parameter.setIptv(Customs.randomZeroOne());
            }

            switch (parameter.getIptv())
            {
                case "1":
                    biptvCheckBox.click();
                    break;
                case "2":
                    siptvCheckBox.click();
                    break;
                case "3":
                    piptvCheckBox.click();
                    break;
                default:
                    logger.error("IPTV -> wrong type");
            }

            if (parameter.getStb().equals("r"))
            {
                parameter.setStb(Customs.randomZeroOne());
            }

            switch (parameter.getStb())
            {
                case "1":
                    addStbLink.click();
                    Select select = new Select(stbMenuRatePlanDropdown);
                    select.selectByIndex(0);
                    stbMenuRateSubmitButton.click();

                    if (parameter.getStb_pc().equals("r"))
                    {
                        parameter.setStb_pc(Customs.randomZeroOne());
                    }
                    if (parameter.getStb_rc().equals("r"))
                    {
                        parameter.setStb_rc(Customs.randomZeroOne());
                    }
                    if (parameter.getStb_return().equals("r"))
                    {
                        parameter.setStb_return(Customs.randomZeroOne());
                    }

                    if (parameter.getStb_pc().equals("1"))
                    {
                        stbPCCheckBox.click();
                    }
                    if (parameter.getStb_rc().equals("1"))
                    {
                        stbRCCheckBox.click();
                    }
                    if (parameter.getStb_return().equals("1"))
                    {
                        stbUCheckBox.click();
                    }
                    parameter.setDvr("0");
                    break;
                case "0":
                    parameter.setDvr("1");
                    dvrCheckBox.click();

                    if (parameter.getDvr_pc().equals("r"))
                    {
                        parameter.setDvr_pc(Customs.randomZeroOne());
                    }

                    if (parameter.getDvr_rc().equals("r"))
                    {
                        parameter.setDvr_rc(Customs.randomZeroOne());
                    }

                    if (parameter.getDvr_return().equals("r"))
                    {
                        parameter.setDvr_return(Customs.randomZeroOne());
                    }

                    if (parameter.getDvr_pc().equals("1"))
                    {
                        dvrPCCheckBox.click();
                    }
                    if (parameter.getDvr_rc().equals("1"))
                    {
                        dvrRCCheckBox.click();
                    }
                    if (parameter.getDvr_return().equals("1"))
                    {
                        dvrUCheckBox.click();
                    }
                    break;
            }

            if (parameter.getHdelite().equals("r"))
            {
                parameter.setHdelite(Customs.randomZeroOne());
            }
            if (parameter.getSportstier().equals("r"))
            {
                parameter.setSportstier(Customs.randomZeroOne());
            }
            if (parameter.getStarz().equals("r"))
            {
                parameter.setStarz(Customs.randomZeroOne());
            }
            if (parameter.getCinemax().equals("r"))
            {
                parameter.setCinemax(Customs.randomZeroOne());
            }
            if (parameter.getShowtime().equals("r"))
            {
                parameter.setShowtime(Customs.randomZeroOne());
            }
            if (parameter.getHbo().equals("r"))
            {
                parameter.setHbo(Customs.randomZeroOne());
            }

            if (parameter.getHdelite().equals("1") && parameter.getIptv().equals("3"))
            {
                hdeliteCheckBox.click();
            }
            if (parameter.getSportstier().equals("1") && parameter.getIptv().equals("3"))
            {
                sportstierCheckBox.click();
            }
            if (parameter.getStarz().equals("1"))
            {
                starzCheckBox.click();
            }
            if (parameter.getCinemax().equals("1"))
            {
                cinemaxCheckBox.click();
            }
            if (parameter.getShowtime().equals("1"))
            {
                showtimeCheckBox.click();
            }
            if (parameter.getHbo().equals("1"))
            {
                hboCheckBox.click();
            }
        }
        wait.until(ExpectedConditions.invisibilityOf(loadingOverlay));
        internetTitle.click();

        if (parameter.getSpeed().equals("r"))
        {
            parameter.setSpeed(Customs.getRandomInternetSpeedValue());
        }

        switch (parameter.getSpeed())
        {
            case "2M":
                internet2mCheckBox.click();
                break;
            case "100M":
                internet100mCheckBox.click();
                break;
            case "200M":
                internet200mCheckBox.click();
                break;
            case "500M":
                internet500mCheckBox.click();
                break;
            case "1GB":
                internet1gbCheckBox.click();
                break;
            default:
                logger.error("Internet -> Speed parameter error" + parameter.getSpeed());
        }


        WebDriverWait wait = new WebDriverWait(Driver.getDriver(), 5);
        try
        {
            wait.until(ExpectedConditions.visibilityOf(wholeHomePopUpNoButton));
            wholeHomePopUpNoButton.click();
        }
        catch (TimeoutException e)
        {
            logger.info("No wholehome wifi pop up");
        }

        if (parameter.getProuter().equals("r"))
        {
            parameter.setProuter(Customs.randomZeroOne());
        }

        if (parameter.getUrouter().equals("r"))
        {
            parameter.setUrouter(Customs.randomZeroOne());
        }

        if (parameter.getSipaddress().equals("r"))
        {
            parameter.setSipaddress(Customs.randomZeroOne());
        }

        if (parameter.getProuter().equals("1"))
        {
            purchasedRouterCheckBox.click();
        }

        if (parameter.getUrouter().equals("1"))
        {
            unreturnedRouterCheckBox.click();
        }

        if (parameter.getSipaddress().equals("1"))
        {
            sipAddressCheckBox.click();
        }

        if (parameter.getThp().equals("r"))
        {
            parameter.setThp(Customs.randomZeroOne());
        }

        switch (parameter.getThp())
        {
            case "1":
                techHomeProtectCheckBox.click();
                if (parameter.getThp_mob().equals("r"))
                {
                    parameter.setThp_mob(Customs.randomZeroOne());
                }
                if (parameter.getThp_desk().equals("r"))
                {
                    parameter.setThp_desk(Customs.randomZeroOne());
                }

                if (parameter.getThp_mob().equals("1"))
                {
                    thp_MobileProtectAddonCheckBox.click();
                }
                if (parameter.getThp_desk().equals("1"))
                {
                    thp_DesktopProtectAddonCheckBox.click();
                }
                parameter.setThs("0");
                break;

            case "0":
                if (parameter.getThs().equals("r"))
                {
                    parameter.setThs(Customs.randomZeroOne());
                }

                if (parameter.getThs().equals("1"))
                {
                    techHomeSupportCheckBox.click();

                    if (parameter.getThs_mob().equals("r"))
                    {
                        parameter.setThs_mob(Customs.randomZeroOne());
                    }
                    if (parameter.getThs_desk().equals("r"))
                    {
                        parameter.setThs_desk(Customs.randomZeroOne());
                    }

                    if (parameter.getThs_mob().equals("1"))
                    {
                        ths_MobileProtectAddonCheckBox.click();
                    }
                    if (parameter.getThs_desk().equals("1"))
                    {
                        ths_DesktopProtectAddonCheckBox.click();
                    }
                }
        }


        if (parameter.getWholeHome().equals("r"))
        {
            parameter.setWholeHome(Customs.randomZeroOne());
        }

        if (parameter.getWholeHome().equals("1"))
        {
            addWholehomeWifiLink.click();
        }

        if (parameter.getPhone().equals("r"))
        {
            parameter.setPhone(Customs.randomZeroOne());
        }

        if (parameter.getPhone().equals("1"))
        {
            phoneTitle.click();
            fiberPhoneCheckBox.click();

            if (parameter.getBatteryBackup().equals("r"))
            {
                parameter.setBatteryBackup(Customs.randomZeroOne());
            }

            wait.until(ExpectedConditions.visibilityOf(batteryBackupPopUpNoButton));

            switch (parameter.getBatteryBackup())
            {
                case "1":
                    batteryBackupPopUpYesButton.click();
                    break;
                case "0":
                    batteryBackupPopUpNoButton.click();
                    break;
            }

            Select select = new Select(lineTypeDropdown);
            select.selectByIndex(1);
        }
        wait.until(ExpectedConditions.visibilityOf(submitServicesButton));
        wait.until(ExpectedConditions.invisibilityOf(loadingOverlay));

        //BrowserUtils.takeAScreenshotAndSave("Test Data Generation");
        submitServicesButton.click();
        logger.info(parameter.toString());
    }
}
