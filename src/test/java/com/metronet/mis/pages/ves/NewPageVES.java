package com.metronet.mis.pages.ves;

import com.metronet.mis.pojos.Subscriber;
import com.metronet.mis.utilities.ui.BrowserUtils;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;

/**
 * This is the NewPage class contains information on the page where we create a new subscriber
 *
 * @author salturk
 * @see VESBasePage
 * @see WebElement
 */
public class NewPageVES extends VESBasePage
{
    /**
     * Residential checkbox
     */
    @FindBy(linkText = "residential")
    public WebElement residentialCheckBox;

    /**
     * Student Checkbox
     */
    @FindBy(linkText = "Student")
    public WebElement studentCheckBox;

    /**
     * First Name textfield
     */
    @FindBy(id = "firstName")
    public WebElement firstNameTextBox;

    /**
     * Last Name textfield
     */
    @FindBy(id = "lastName")
    public WebElement lastNameTextBox;

    /**
     * Date of Birth textfield
     */
    @FindBy(id = "dateOfBirth")
    public WebElement dobTextBox;

    /**
     * Service Address textfield
     */
    @FindBy(id = "serviceAddress")
    public WebElement serviceAddressTextBox;

    /**
     * No Services Found message
     */
    @FindBy(xpath = "//span[text()='No active services found']")
    public WebElement noServicesFoundWarning;

    /**
     * Service Address already has active services message
     */
    @FindBy(xpath = "//span[text()='Service address already has active services.  An issue will be sent to the store front to resolve.']")
    public WebElement serviceAlreadyInUseWarning;

    /**
     * More Than One Year checkbox
     */
    @FindBy(xpath = "//label[@for='occupiedTimeYes']")
    public WebElement moreThanOneYearCheckBox;

    /**
     * Contact Email textfield
     */
    @FindBy(id = "contactEmail")
    public WebElement contactEmailTextBox;

    /**
     * Contact Mobile Phone Number textfield
     */
    @FindBy(id = "contactMobilePhone")
    public WebElement contactMobilePhoneTextBox;

    /**
     * Contacted dropdown
     */
    @FindBy(xpath = "//select[@data-id='contactedHow']")
    public WebElement contactedDropDown;

    /**
     * Submit button
     */
    @FindBy(xpath = "//button[@data-submit='createSubscriber']")
    public WebElement submitButton;

    /**
     * fillform(subscriber) method is used to fill the form at the new page.
     * the method interacts with the Web Elements and puts wait between them to assure synchronization
     *
     * @param subscriber Subscriber object - Get information stored in object
     * @author salturk
     * @see Subscriber
     * @see BrowserUtils
     */
    public void fillForm(Subscriber subscriber)
    {
        firstNameTextBox.sendKeys(subscriber.getFirstName());
        BrowserUtils.impWait(30);

        lastNameTextBox.sendKeys(subscriber.getLastName());
        BrowserUtils.impWait(30);

        dobTextBox.sendKeys(subscriber.getDateOfBirth());
        BrowserUtils.impWait(30);

        serviceAddressTextBox.sendKeys(subscriber.getServiceAddress());
        BrowserUtils.impWait(30);

        BrowserUtils.impWait(30);
        wait.until(ExpectedConditions.or(ExpectedConditions.visibilityOf(noServicesFoundWarning), ExpectedConditions.visibilityOf(serviceAlreadyInUseWarning)));

        moreThanOneYearCheckBox.click();
        BrowserUtils.impWait(30);

        contactEmailTextBox.sendKeys(subscriber.getContactEmail());
        BrowserUtils.impWait(30);

        contactMobilePhoneTextBox.sendKeys(subscriber.getContactPhone());
        BrowserUtils.impWait(30);

        Select select = new Select(contactedDropDown);
        select.selectByIndex(0);
        BrowserUtils.impWait(30);

        submitButton.click();
        BrowserUtils.impWait(30);
    }
}
