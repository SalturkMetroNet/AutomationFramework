package com.metronet.mis.pages.ves;

import com.metronet.mis.utilities.ui.BrowserUtils;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

/**
 * This is the ReviewOrderPage class which contains necessary information and method on the page where we review our order at VES
 * @see VESBasePage
 * @see WebElement
 * @author salturk
 */
public class ReviewOrderPageVES extends VESBasePage
{
    /**
     * Schedule Installation Date textfield
     */
    @FindBy(id = "scheduleActivity")
    public WebElement scheduleInstallationDateInput;

    /**
     * Schedule Installation Time textfield
     */
    @FindBy(id = "timeSlot")
    public WebElement scheduleInstallationTimeInput;

    /**
     * Service Start Date All input
     */
    @FindBy(id = "startDate") //xpath = "//label[text()='Set all start dates:']/following::input"
    public WebElement serviceStartDataAllInput;

    /**
     * Order Placed dropdown
     */
    @FindBy(id = "orderPlaced")
    public WebElement orderPlacedDropdown;

    /**
     * Order Notes textfield
     */
    @FindBy(id = "notes")
    public WebElement orderNotesTextBox;

    /**
     * Process Order button
     */
    @FindBy(xpath = "//button[text()[normalize-space()='Process Order']]")
    public WebElement processOrderButton;

    /**
     * Signature canvas
     */
    @FindBy(tagName = "canvas")
    public WebElement signatureCanvas;

    /**
     * Signature Submit button
     */
    @FindBy(xpath = "(//button[@class='button'])[2]")
    public WebElement signatureSubmitButton;

    /**
     * fillOutReviewOrderInputs(intallDate, installTime, allStartDate, orderPlacedIndex, orderNotes
     * @param installDate
     * @param installTimeIndex
     * @param allStartDate
     * @param orderPlacedIndex
     * @param orderNotes
     */
    public void fillOutReviewOrderInputs(String installDate, int installTimeIndex, String allStartDate, int orderPlacedIndex, String orderNotes)
    {
        Select installTime = new Select(scheduleInstallationTimeInput);
        Select orderPlaced = new Select(orderPlacedDropdown);

        scheduleInstallationDateInput.sendKeys(installDate);
        BrowserUtils.wait(1);
        installTime.selectByIndex(installTimeIndex);
        BrowserUtils.impWait(30);
        serviceStartDataAllInput.sendKeys(allStartDate + "" + Keys.ENTER);
        BrowserUtils.impWait(30);
        orderPlaced.selectByIndex(orderPlacedIndex);
        BrowserUtils.impWait(30);
        orderNotesTextBox.sendKeys(orderNotes);
        BrowserUtils.impWait(30);
        processOrderButton.click();
        BrowserUtils.impWait(30);
        signatureCanvas.click();
        BrowserUtils.impWait(30);
        signatureSubmitButton.click();
        BrowserUtils.impWait(200);

        logger.info("Filled form with:\n"
                + "Install Date: " + installDate + "\n"
                + "Install Time Choice: " + installTime.getFirstSelectedOption().getText() + "\n"
                + "Service Start Dates (All): " + allStartDate + "\n"
                + "Order Placed Choice: " + orderPlaced.getFirstSelectedOption().getText() + "\n"
                + "Order Notes: " + orderNotes + "\n"
        );
    }
}
