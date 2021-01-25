package com.metronet.mis.pages.ves;

import com.metronet.mis.pages.BasePage;
import com.metronet.mis.pojos.Subscriber;
import com.metronet.mis.utilities.BrowserUtils;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;

public class NewPage extends BasePage
{


    @FindBy(linkText = "residential")
    public WebElement residentialCheckBox;

    @FindBy(linkText = "Student")
    public WebElement studentCheckBox;

    @FindBy(id = "firstName")
    public WebElement firstNameTextBox;

    @FindBy(id = "lastName")
    public WebElement lastNameTextBox;

    @FindBy(id = "dateOfBirth")
    public WebElement dobTextBox;

    @FindBy(id = "serviceAddress")
    public WebElement serviceAddressTextBox;

    @FindBy(xpath = "//span[text()='No active services found']")
    public WebElement noServicesFoundWarning;

    @FindBy(xpath = "//label[@for='occupiedTimeYes']")
    public WebElement moreThanOneYearCheckBox;

    @FindBy(id = "contactEmail")
    public WebElement contactEmailTextBox;

    @FindBy(id = "contactMobilePhone")
    public WebElement contactMobilePhoneTextBox;

    @FindBy(xpath = "//select[@data-id='contactedHow']")
    public WebElement contactedDropDown;

    @FindBy(xpath = "//button[@data-submit='createSubscriber']")
    public WebElement submitButton;

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

        serviceAddressTextBox.click();
        BrowserUtils.impWait(30);

        wait.until(ExpectedConditions.visibilityOf(noServicesFoundWarning));
        BrowserUtils.impWait(30);

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

        logger.info("Filled form with:\n"
                + "First Name: " + subscriber.getFirstName() + "\n"
                + "Last Name: " + subscriber.getLastName() + "\n"
                + "Date Of Birth: " + subscriber.getDateOfBirth() + "\n"
                + "Service Address: " + subscriber.getServiceAddress() + "\n"
                + "Contact Email: " + subscriber.getContactEmail() + "\n"
                + "Contact Phone Number: " + subscriber.getContactPhone()
        );
    }


}
