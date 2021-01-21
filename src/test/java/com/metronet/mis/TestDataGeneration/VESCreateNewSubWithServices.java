package com.metronet.mis.TestDataGeneration;


import com.metronet.mis.pages.ves.*;
import com.metronet.mis.utilities.BrowserUtils;
import com.metronet.mis.utilities.ConfigurationReader;
import com.metronet.mis.utilities.Driver;
import org.junit.Test;

public class VESCreateNewSubWithServices
{
	LoginPage loginPage = new LoginPage();
	SearchPage searchPage = new SearchPage();
	NewPage newPage = new NewPage();
	ServicesPage servicesPage = new ServicesPage();
	ReviewOrderPage reviewOrderPage = new ReviewOrderPage();
	OrderSummaryPage orderSummaryPage = new OrderSummaryPage();

	@Test
	public void GenerateTestDataWithServices()
	{
		Driver.getDriver().get(ConfigurationReader.getProperty("url"));
		BrowserUtils.impWait(30);

		loginPage.login();
		BrowserUtils.impWait(30);

		searchPage.newPageButton.click();
		BrowserUtils.impWait(30);

		newPage.fillForm("Test", "Tester", "10/10/1990", "13855 WYANDOTTE PL", ConfigurationReader.getProperty("email"),"719-960-7419");
		BrowserUtils.impWait(30);

		servicesPage.chooseServices();
		BrowserUtils.impWait(30);

		reviewOrderPage.fillOutReviewOrderInputs("01/21/2021", 1, "01/20/2021", 4, "Automation");
		BrowserUtils.impWait(200);

		orderSummaryPage.getCustomerInformation();
		BrowserUtils.impWait(30);

		BrowserUtils.waitFor(5);
		orderSummaryPage.navigateToNewLink.click();
		BrowserUtils.impWait(30);
	}
}
