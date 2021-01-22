package com.metronet.mis.pages.ves;

import com.metronet.mis.pages.BasePage;
import com.metronet.mis.pojos.Subscriber;
import com.metronet.mis.utilities.TableManipulation;
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

    public void getCustomerInformation(Subscriber subscriber, boolean hasNewPhone, int iterator) throws IOException
    {
        subscriber.setServiceAddress(customerInformation.get(2).getText());
        subscriber.setSubId(customerInformation.get(0).getText());

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

        TableManipulation.writeExcel(subscriber, "src/test/resources/test-data/Open Addresses_Fishers.xlsx", false, iterator);




    }
}
