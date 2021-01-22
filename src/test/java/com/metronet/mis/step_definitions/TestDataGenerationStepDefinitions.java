package com.metronet.mis.step_definitions;

import com.github.javafaker.Faker;
import com.metronet.mis.pages.ves.*;
import com.metronet.mis.pojos.Address;
import com.metronet.mis.pojos.Subscriber;
import com.metronet.mis.utilities.BrowserUtils;
import com.metronet.mis.utilities.ConfigurationReader;
import com.metronet.mis.utilities.Driver;
import com.metronet.mis.utilities.TableManipulation;
import io.cucumber.java.en.Given;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

public class TestDataGenerationStepDefinitions
{
    //private static final Logger logger = Logger.getLogger(TestDataGenerationStepDefinitions.class);
    LoginPage loginPage = new LoginPage();
    SearchPage searchPage = new SearchPage();
    NewPage newPage = new NewPage();
    ServicesPage servicesPage = new ServicesPage();
    ReviewOrderPage reviewOrderPage = new ReviewOrderPage();
    OrderSummaryPage orderSummaryPage = new OrderSummaryPage();
    Faker faker = new Faker();
    SimpleDateFormat sdf = new SimpleDateFormat("MM/dd/yyyy");

    @Given("Script")
    public void VESSubGenerationWithServices() throws IOException
    {

        String firstName, lastName, emailAddress, phone, dob, address;
        List<Subscriber> subscriberList = new ArrayList<>();
        WebDriverWait wait = new WebDriverWait(Driver.getDriver(), 20);

        Driver.getDriver().get(ConfigurationReader.getProperty("url"));
        BrowserUtils.impWait(30);
        loginPage.login();
        BrowserUtils.impWait(30);
        searchPage.newPageButton.click();
        BrowserUtils.impWait(30);

        List<Address> listOfAddress = null;

        listOfAddress = TableManipulation.readAddressesFromExcelFile("src/test/resources/test-data/Open Addresses_Fishers.xlsx");

        for (int i = 1; i < 50; i++)
        {
            firstName = faker.name().firstName();
            lastName = faker.name().lastName();
            emailAddress = faker.internet().emailAddress();
            phone = faker.numerify("###-###-####");
            dob = sdf.format(faker.date().birthday());
            address = listOfAddress.get(i).getStreet() + ", " + listOfAddress.get(i).getCity();

            Subscriber subscriber = new Subscriber(firstName, lastName, emailAddress, phone, dob, address);
            newPage.fillForm(subscriber);
            BrowserUtils.impWait(30);
            servicesPage.chooseServices();
            BrowserUtils.impWait(30);
            reviewOrderPage.fillOutReviewOrderInputs("01/23/2021", 1, "01/23/2021", 4, "Automation");
            BrowserUtils.impWait(500);


            subscriberList.add(orderSummaryPage.getCustomerInformation(subscriber));

            BrowserUtils.impWait(30);
            wait.until(ExpectedConditions.invisibilityOf(orderSummaryPage.loadingOverlay));
            orderSummaryPage.navigateToNewLink.click();

            BrowserUtils.impWait(30);
        }
        TableManipulation.writeExcel(subscriberList, "src/test/resources/test-data/SubInfo.xlsx");

        Driver.getDriver().close();

    }
}
