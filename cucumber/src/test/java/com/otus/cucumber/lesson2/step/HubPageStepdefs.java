package com.otus.cucumber.lesson2.step;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.When;
import com.otus.cucumber.lesson2.service.Driver;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class HubPageStepdefs {
    private static final Logger logger = LogManager.getLogger(HubPageStepdefs.class);

    private WebDriver driver;

    public HubPageStepdefs() {
        driver = Driver.getDriver();
    }



    @Given("I am on hub page")
    public void iAmOnHubPage() {
        driver.get("https://habr.com/ru/hubs/");
    }

    By locator = By.cssSelector("#hubs .list-snippet__title-link");

    @When("I search hub {string}")
    public void iSearchHub(String hubName) {


        WebElement input = driver.findElement(By.cssSelector("#hubs_suggest"));
        input.sendKeys(hubName, Keys.ENTER);

        //   new WebDriverWait(driver, 10).until(ExpectedConditions.textToBe(locator, hubName));
    }

    @And("choose found hub")
    public void chooseFoundHub() {
    }
}
