package com.otus.cucumber.lesson1.step;

import cucumber.api.Scenario;
import cucumber.api.java.AfterStep;
import cucumber.api.java.BeforeStep;
import cucumber.api.java.en.Then;
import org.springframework.beans.factory.annotation.Autowired;
import com.otus.cucumber.lesson1.page.TopicPage;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

public class TopicPageStepdefs {
    @Autowired
    private TopicPage page;


    @Then("topic title should be {string}")
    public void topicTitleShouldBe(String textToBe) {
        assertThat(page.getTopicTitle(), equalTo(textToBe));
    }

    @BeforeStep
    public void doSomethingBeforeStep(Scenario scenario) {
        System.out.println(scenario.getName());
    }

    @AfterStep
    public void doSomethingAfterStep(Scenario scenario) {
        System.out.println(scenario.getName() + " " + scenario.getId() + " " + scenario.getStatus().lowerCaseName());
    }
}
