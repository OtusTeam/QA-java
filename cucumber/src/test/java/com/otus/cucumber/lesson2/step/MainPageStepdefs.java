package com.otus.cucumber.lesson2.step;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import com.otus.cucumber.lesson2.service.MainPageService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;

public class MainPageStepdefs {
    private static final Logger logger = LogManager.getLogger(MainPageStepdefs.class);

    @Autowired
    private  MainPageService mainPageService;


    @Given("I am on main page")
    public void iAmOnMainPage() {
        mainPageService.openPage();
    }

    private String postTitle;

    @When("I open {int} post")
    public void iOpenPost(int index) {
        postTitle = mainPageService.openPost(index - 1);
    }

    @Then("I am on post page")
    public void iAmOnPostPage() {
        mainPageService.verify(postTitle);
    }

    @And("each post has hub label {string}")
    public void eachPostHasHubLabel(String arg0) {
    }

    @When("I search {string}")
    public void iSearch(String searchTerm) {
//        driver.findElement(By.cssSelector("#search-form-btn")).click();
//        driver.findElement(By.cssSelector("#search-form-field")).sendKeys(searchTerm, Keys.ENTER);
    }

    @Then("I am on result page with {string}")
    public void iAmOnResultPageWith(String searchTerm) {
//        assertThat(driver.getTitle(), containsString(searchTerm));
//        assertThat(driver.getCurrentUrl(), startsWith("https://habr.com/ru/search/?q=" + searchTerm));
    }

}
