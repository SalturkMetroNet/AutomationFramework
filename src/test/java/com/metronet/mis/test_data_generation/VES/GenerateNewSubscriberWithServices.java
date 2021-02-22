package com.metronet.mis.test_data_generation.VES;

import com.github.javafaker.Faker;
import com.metronet.mis.pages.ves.*;
import com.metronet.mis.pojos.Address;
import com.metronet.mis.pojos.Parameter;
import com.metronet.mis.pojos.Subscriber;
import com.metronet.mis.utilities.common.ConfigurationReader;
import com.metronet.mis.utilities.common.TableManipulation;
import com.metronet.mis.utilities.db.DBUtilities;
import com.metronet.mis.utilities.ui.BrowserUtils;
import com.metronet.mis.utilities.ui.Driver;
import org.apache.log4j.Logger;
import org.junit.Test;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.IOException;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

public class GenerateNewSubscriberWithServices
{
    private static final Logger logger = Logger.getLogger(GenerateNewSubscriberWithServices.class);

    LoginPageVES loginPage = new LoginPageVES();
    SearchPageVES searchPage = new SearchPageVES();
    NewPageVES newPage = new NewPageVES();
    ServicesPageVES servicesPage = new ServicesPageVES();
    ReviewOrderPageVES reviewOrderPage = new ReviewOrderPageVES();
    OrderSummaryPageVES orderSummaryPage = new OrderSummaryPageVES();

    WebDriverWait wait = new WebDriverWait(Driver.getDriver(), 20);
    Faker faker = new Faker();
    SimpleDateFormat sdf = new SimpleDateFormat("MM/dd/yyyy");
    DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("MM/dd/yyyy");
    LocalDate localDate = LocalDate.now().plusDays(1);

    Parameter parameter = TableManipulation.getParameters(ConfigurationReader.getProperty("parameterforves"));

    String firstName;
    String lastName;
    String emailAddress;
    String phone;
    String dob;
    String address;
    String installDate;

    int batchLimit = Integer.parseInt(ConfigurationReader.getProperty("batchlimit"));

    @Test
    public void script()
    {
        try
        {
            VESSubGenerationWithServices();
        }
        catch (Exception e)
        {
            BrowserUtils.takeAScreenshotAndSave("GenerateSubsWithServices");
            e.printStackTrace();
        }
    }

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
        logger.info("On the new page");
        BrowserUtils.impWait(30);

        List<Address> listOfAddress = null;//TableManipulation.readAddressesFromExcelFile(ConfigurationReader.getProperty("openaddressesfranklin"));
        try
        {
            listOfAddress = DBUtilities.getData();
        }
        catch (SQLException throwables)
        {
            throwables.printStackTrace();
        }
        logger.info("Read Street Data From Table");

        for (int i = 1; i < batchLimit; i++)
        {
            firstName = faker.name().firstName();
            lastName = faker.name().lastName();
            emailAddress = faker.internet().emailAddress();
            phone = faker.numerify("###-###-####");
            dob = sdf.format(faker.date().birthday());
            if (listOfAddress != null)
            {
                address = listOfAddress.get(i).getStreet().trim() + ", " + listOfAddress.get(i).getCity().trim();
            }
            installDate = dateTimeFormatter.format(localDate);
            //sdf.format(LocalDate.from(date.toInstant()).plusDays(1));

            Subscriber subscriber = new Subscriber(firstName, lastName, emailAddress, phone, dob, address);
            newPage.fillForm(subscriber);
            BrowserUtils.impWait(30);
            logger.info("Filled new page form");

            servicesPage.chooseServicesWithParameters(parameter);
            //servicesPage.chooseServices();
            BrowserUtils.impWait(30);
            logger.info("Services chosen");

            reviewOrderPage.fillOutReviewOrderInputs(installDate, 1, installDate, 4, "Automation");
/*
            if (reviewOrderPage.errorAlert.isDisplayed())
            {
                logger.info("Character creation failed. See transaction logs");
                searchPage.newPageButton.click();
                BrowserUtils.impWait(30);
                continue;

            }
*/
            BrowserUtils.impWait(500);
            logger.info("review order page info filled \n\n");

            subscriber = orderSummaryPage.getCustomerInformation(subscriber);
            TableManipulation.writeSubToExcel(subscriber);
            logger.info("Subscriber info written to excel file");

            wait.until(ExpectedConditions.invisibilityOf(orderSummaryPage.loadingOverlay));
            orderSummaryPage.navigateToNewLink.click();

            BrowserUtils.impWait(30);
        }

        Driver.getDriver().close();
    }
}
