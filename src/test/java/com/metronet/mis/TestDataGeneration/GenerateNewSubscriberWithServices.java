package com.metronet.mis.TestDataGeneration;

import com.github.javafaker.Faker;
import com.metronet.mis.pages.ves.*;
import com.metronet.mis.pojos.Address;
import com.metronet.mis.pojos.Subscriber;
import com.metronet.mis.utilities.BrowserUtils;
import com.metronet.mis.utilities.ConfigurationReader;
import com.metronet.mis.utilities.Driver;
import com.metronet.mis.utilities.TableManipulation;
import org.apache.log4j.Logger;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.junit.Test;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.FileOutputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
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
    String firstName, lastName, emailAddress, phone, dob, address;
    List<Subscriber> subscriberList = new ArrayList<>();
    int batchLimit = 6;

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

        List<Address> listOfAddress = TableManipulation.readAddressesFromExcelFile("src/test/resources/test-data/Open Addresses_Fishers.xlsx");
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

            servicesPage.chooseServices();
            BrowserUtils.impWait(30);

            reviewOrderPage.fillOutReviewOrderInputs("01/26/2021", 1, "01/26/2021", 4, "Automation");
            BrowserUtils.impWait(500);

            subscriberList.add(orderSummaryPage.getCustomerInformation(subscriber));

            wait.until(ExpectedConditions.invisibilityOf(orderSummaryPage.loadingOverlay));
            orderSummaryPage.navigateToNewLink.click();

            BrowserUtils.impWait(30);
        }

        FileOutputStream fileOutputStream = new FileOutputStream("src/test/resources/test-data/SubInfo.xlsx");
        Workbook workbook = new XSSFWorkbook();

        Sheet sheet = workbook.createSheet("Subs");

        Row row = sheet.createRow(0);
        Cell cell = row.createCell(0);
        cell.setCellValue("First Name");
        cell = row.createCell(1);
        cell.setCellValue("Last Name");
        cell = row.createCell(2);
        cell.setCellValue("Contact Email Address");
        cell = row.createCell(3);
        cell.setCellValue("Contact Phone Number");
        cell = row.createCell(4);
        cell.setCellValue("Date of Birth");
        cell = row.createCell(5);
        cell.setCellValue("Service Address");
        cell = row.createCell(6);
        cell.setCellValue("Subscriber ID");

        for (int i = 0; i < subscriberList.size(); i++)
        {
            row = sheet.createRow(i + 1);
            Subscriber subscriber = subscriberList.get(i);

            cell = row.createCell(0);
            cell.setCellValue(subscriber.getFirstName());
            cell = row.createCell(1);
            cell.setCellValue(subscriber.getLastName());
            cell = row.createCell(2);
            cell.setCellValue(subscriber.getContactEmail());
            cell = row.createCell(3);
            cell.setCellValue(subscriber.getContactPhone());
            cell = row.createCell(4);
            cell.setCellValue(subscriber.getDateOfBirth());
            cell = row.createCell(5);
            cell.setCellValue(subscriber.getServiceAddress());
            cell = row.createCell(6);
            cell.setCellValue(subscriber.getSubId());
        }

        workbook.write(fileOutputStream);
        workbook.close();
        fileOutputStream.close();

        Driver.getDriver().close();

    }
}
