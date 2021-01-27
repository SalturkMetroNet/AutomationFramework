package com.metronet.mis.pages.ves;

import com.metronet.mis.pages.BasePage;
import com.metronet.mis.pojos.Subscriber;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.io.IOException;
import java.util.List;

public class OrderSummaryPage extends BasePage
{
    private final static Logger logger = Logger.getLogger(OrderSummaryPage.class);
    @FindBy(xpath = "//div[@class='indent'][2]/div")
    public List<WebElement> customerInformation;

    @FindBy(xpath = "//div[@class='indent'][3]/div[2]")
    public WebElement customerNewPhone;

    @FindBy(xpath = "//a[contains(@href,'/ves/newSubscriber')]")
    public WebElement navigateToNewLink;

    @FindBy(id = "overlay")
    public WebElement loadingOverlay;

    public Subscriber getCustomerInformation(Subscriber subscriber) throws IOException
    {
        subscriber.setServiceAddress(customerInformation.get(2).getText().substring(customerInformation.get(2).getText().indexOf(":")+1));
        subscriber.setSubId(customerInformation.get(0).getText().substring(customerInformation.get(0).getText().indexOf(":")+1));

        System.out.println("Subscriber Information:\n"
                + "Account Number: " + customerInformation.get(0).getText() + "\n"
                + "Name: " + customerInformation.get(1).getText() + "\n"
                + "Service Address: " + customerInformation.get(2).getText() + "\n"
                + "Contact Phone: " + customerInformation.get(3).getText() + "\n"
                + "Contact Email: " + customerInformation.get(4).getText() + "\n");

        logger.info("Subscriber Information:\n"
                + "Account Number: " + customerInformation.get(0).getText() + "\n"
                + "Name: " + customerInformation.get(1).getText() + "\n"
                + "Service Address: " + customerInformation.get(2).getText() + "\n"
                + "Contact Phone: " + customerInformation.get(3).getText() + "\n"
                + "Contact Email: " + customerInformation.get(4).getText() + "\n"
        );

        return subscriber;
    }
}
