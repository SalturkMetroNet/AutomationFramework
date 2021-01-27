package com.metronet.mis.step_definitions;

import com.metronet.mis.pages.ves.LoginPage;
import com.metronet.mis.utilities.common.ConfigurationReader;
import com.metronet.mis.utilities.ui.Driver;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;

public class LoginPageStepDefinitions
{
    LoginPage loginPage = new LoginPage();

    @When("user is on login page")
    public void userIsOnLoginPage()
    {
        Driver.getDriver().get(ConfigurationReader.getProperty("url"));
    }

    @And("user enters username to username text box")
    public void userEntersUsernameToUsernameTextBox()
    {
        loginPage.username.sendKeys(ConfigurationReader.getProperty("username"));
    }

    @And("user enters password to password text box")
    public void userEntersPasswordToPasswordTextBox()
    {
        loginPage.password.sendKeys(ConfigurationReader.getProperty("password"));
    }

    @When("user clicks on submit button")
    public void userClicksOnSubmitButton()
    {
        loginPage.submitButton.click();
    }

    @Then("user should be able to see {string}")
    public void userShouldBeAbleToSee(String expectedResult)
    {
        String actualResult = Driver.getDriver().findElement(By.xpath("//li[@class='appName nowrap']")).getText();
        Assert.assertEquals(expectedResult, actualResult);
    }
}
