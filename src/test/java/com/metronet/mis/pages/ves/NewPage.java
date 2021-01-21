package com.metronet.mis.pages.ves;

import com.metronet.mis.pages.BasePage;
import com.metronet.mis.utilities.Driver;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

public class NewPage extends BasePage
{
	private final static Logger logger = Logger.getLogger(LoginPage.class);
	private final Wait<WebDriver> webDriverWait = new WebDriverWait(Driver.getDriver(), 5, 1000).withMessage("Warning was not found");

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

	public void fillForm(String fName, String lName, String dateOfBirth, String serviceAddress, String contactEmail, String contactMobilePhone)
	{
		firstNameTextBox.sendKeys(fName);
		lastNameTextBox.sendKeys(lName);
		dobTextBox.sendKeys(dateOfBirth);
		serviceAddressTextBox.sendKeys(serviceAddress);
		webDriverWait.until(ExpectedConditions.visibilityOf(noServicesFoundWarning));
		moreThanOneYearCheckBox.click();
		contactEmailTextBox.sendKeys(contactEmail);
		contactMobilePhoneTextBox.sendKeys(contactMobilePhone);
		Select select = new Select(contactedDropDown);
		select.selectByIndex(0);
		submitButton.click();
		logger.info("Filled form with:\n"
				+ "First Name: " + fName + "\n"
				+ "Last Name: " + lName + "\n"
				+ "Date Of Birth: " + dateOfBirth + "\n"
				+ "Service Address: " + serviceAddress + "\n"
				+ "Contact Email: " + contactEmail + "\n"
				+ "Contact Phone Number: " + contactMobilePhone
		);
	}


}
