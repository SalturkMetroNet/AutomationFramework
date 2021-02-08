package com.metronet.mis.pages.ves;

import com.metronet.mis.pojos.Subscriber;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

/**
 * This is the OrderSummaryPage where we review our newly created subscriber and the services that are assigned to them.
 * @see VESBasePage
 * @see WebElement
 * @author salturk
 */

public class OrderSummaryPageVES extends VESBasePage
{
    /**
     * Customer Information text
     */
    @FindBy(xpath = "//div[@class='indent'][2]/div")
    public List<WebElement> customerInformation;

    /**
     * Customer New Phone text
     */
    @FindBy(xpath = "//div[@class='indent'][3]/div[2]")
    public WebElement customerNewPhone;

    /**
     * New title
     */
    @FindBy(xpath = "//a[contains(@href,'/ves/newSubscriber')]")
    public WebElement navigateToNewLink;

    /**
     * Loading overlay
     */
    @FindBy(id = "overlay")
    public WebElement loadingOverlay;

    /**
     * getCustomerInformation(subscriber) updates the subscriber with newly created information like Subscriber ID.
     * the method accepts a Subscriber object
     * and updates it's content with new info created through VES system
     * then returns the object for reassignment.
     * @param subscriber Subscriber object to be updated
     * @return Subscriber object to assign it again.
     *
     * @see Subscriber
     * @author salturk
     */
    public Subscriber getCustomerInformation(Subscriber subscriber)
    {
        subscriber.setServiceAddress(customerInformation.get(2).getText().substring(customerInformation.get(2).getText().indexOf(":")+1));
        subscriber.setSubId(customerInformation.get(0).getText().substring(customerInformation.get(0).getText().indexOf(":")+1));

        logger.info(subscriber.toString());

        return subscriber;
    }
}
