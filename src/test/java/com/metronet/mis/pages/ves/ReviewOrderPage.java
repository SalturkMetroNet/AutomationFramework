package com.metronet.mis.pages.ves;

import com.metronet.mis.pages.BasePage;
import com.metronet.mis.utilities.BrowserUtils;
import org.apache.log4j.Logger;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

public class ReviewOrderPage extends BasePage
{
	private final static Logger logger = Logger.getLogger(LoginPage.class);

	@FindBy (id = "scheduleActivity")
	public WebElement scheduleInstallationDateInput;

	@FindBy (id = "timeSlot")
	public WebElement scheduleInstallationTimeInput;

	@FindBy (id = "startDate") //xpath = "//label[text()='Set all start dates:']/following::input"
	public WebElement serviceStartDataAllInput;

	@FindBy (id = "orderPlaced")
	public WebElement orderPlacedDropdown;

	@FindBy (id = "notes")
	public WebElement orderNotesTextBox;

	@FindBy (xpath = "//button[text()[normalize-space()='Process Order']]")
	public WebElement processOrderButton;

	@FindBy (tagName = "canvas")
	public WebElement signatureCanvas;

	@FindBy (xpath = "(//button[@class='button'])[2]")
	public WebElement signatureSubmitButton;

	public void fillOutReviewOrderInputs(String installDate, int installTimeIndex, String allStartDate, int orderPlacedIndex, String orderNotes)
	{
		Select installTime = new Select(scheduleInstallationTimeInput);
		Select orderPlaced = new Select(orderPlacedDropdown);

		scheduleInstallationDateInput.sendKeys(installDate);
		BrowserUtils.impWait(30);
		installTime.selectByIndex(installTimeIndex);
		BrowserUtils.impWait(30);
		serviceStartDataAllInput.sendKeys(allStartDate+""+ Keys.ENTER);
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
