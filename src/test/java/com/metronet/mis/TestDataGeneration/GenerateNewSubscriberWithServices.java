package com.metronet.mis.TestDataGeneration;

import com.github.javafaker.Faker;
import com.metronet.mis.pages.ves.*;
import com.metronet.mis.pojos.Address;
import com.metronet.mis.pojos.Parameter;
import com.metronet.mis.pojos.Subscriber;
import com.metronet.mis.utilities.ui.BrowserUtils;
import com.metronet.mis.utilities.common.ConfigurationReader;
import com.metronet.mis.utilities.ui.Driver;
import com.metronet.mis.utilities.db.TableManipulation;
import org.apache.log4j.Logger;
import org.junit.Test;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.List;

public class GenerateNewSubscriberWithServices
{
    private static final Logger logger = Logger.getLogger(GenerateNewSubscriberWithServices.class);

    LoginPage loginPage = new LoginPage();
    SearchPage searchPage = new SearchPage();
    NewPage newPage = new NewPage();
    ServicesPage servicesPage = new ServicesPage();
    ReviewOrderPage reviewOrderPage = new ReviewOrderPage();
    OrderSummaryPage orderSummaryPage = new OrderSummaryPage();

    WebDriverWait wait = new WebDriverWait(Driver.getDriver(), 20);
    Faker faker = new Faker();
    SimpleDateFormat sdf = new SimpleDateFormat("MM/dd/yyyy");

    Parameter parameter = TableManipulation.getParameters(ConfigurationReader.getProperty("parameterforves"));

    String firstName;
    String lastName;
    String emailAddress;
    String phone;
    String dob;
    String address;

    int batchLimit = Integer.parseInt(ConfigurationReader.getProperty("batchlimit"));

    @Test
    public void VESSubGenerationWithServices() throws IOException
    {
        logger.info(": : : |Starting Subscriber Generation With Services Automation Script| : : :");

        Driver.getDriver().get(ConfigurationReader.getProperty("url"));
        BrowserUtils.impWait(30);
        logger.info("TEST ENV -> VES URL retrieved");

        loginPage.login();
        BrowserUtils.impWait(30);
        logger.info("Login to VES -> Successful");

        searchPage.newPageButton.click();
        BrowserUtils.impWait(30);

        List<Address> listOfAddress = TableManipulation.readAddressesFromExcelFile(ConfigurationReader.getProperty("openaddressesfishers"));
        logger.info("Read Street Data From Table");

        for (int i = 1; i < batchLimit; i++)
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

            servicesPage.chooseServicesWithParameters(parameter);
            //servicesPage.chooseServices();
            BrowserUtils.impWait(30);

            reviewOrderPage.fillOutReviewOrderInputs("01/26/2021", 1, "01/26/2021", 4, "Automation");
            BrowserUtils.impWait(500);

            subscriber = orderSummaryPage.getCustomerInformation(subscriber);
            TableManipulation.writeSubToExcel(subscriber, i);


            wait.until(ExpectedConditions.invisibilityOf(orderSummaryPage.loadingOverlay));
            orderSummaryPage.navigateToNewLink.click();

            BrowserUtils.impWait(30);
        }

        Driver.getDriver().close();
    }
}
