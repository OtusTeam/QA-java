package com.otus.cucumber.lesson1.step;

import com.otus.cucumber.lesson1.model.Tech;
import cucumber.api.java.en.*;
import io.cucumber.datatable.DataTable;

import java.util.List;

public class ConsoleStepdefs {

    @Given("I write init message")
    public void iWriteInitMessage() {
        System.out.println("Init message");
    }

    @Then("I write the second message")
    public void iWriteTheSecondMessage() {
        System.out.println(2);
    }

    @When("I write A")
    public void iWriteA() {
        System.out.println("A");
    }

    @And("I write B")
    public void iWriteB() {
        System.out.println("B");
    }

    @But("I write C")
    public void iWriteC() {
        System.out.println("C");
    }

    @And("I write D")
    public void iWriteD() {
        System.out.println("D");
    }

    @Given("I write to console {string}")
    public void iWriteToConsole(String text) {
        System.out.println(text);
    }

    @Given("I want to write {word} {int} times")
    public void iWantToWriteTimes(String text, int counter) {
        for (int i = 1; i <= counter; i++) {
            System.out.println(text + i);
        }
    }

    @Given("also I can write float {float} numbers and {string}")
    public void alsoICanWriteFloatNumbersAnd(float arg0, String arg2) {
        System.out.println(arg0);
        System.out.println(arg2);
    }

    @Given("Log {string} - {int}")
    public void logId(String login, int id) {
        System.out.println(id + " - " + login);
    }

    @Given("I can")
    public void iCan(DataTable texhStack) {
        List<Tech> techs = texhStack.asList(Tech.class);
        techs.forEach(tech -> System.out.println("I can " + tech));
    }

}