package me.matveev.steps;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import io.cucumber.java.AfterAll;
import io.cucumber.java.BeforeAll;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import me.matveev.page.GoogleResultPage;
import me.matveev.page.GoogleSearchPage;

import static org.junit.Assert.assertEquals;

public class GoogleSteps {
    @BeforeAll
    public static void setBrowserConfig() {
        Configuration.browser = "firefox";
        Configuration.startMaximized = true;
    }

    @Given("^I open google search page$")
    public void openSearchPage() {
        Selenide.open(GoogleSearchPage.getBASE_URL());
    }

    @Given("^I write text \"(.+)\" to search input$")
    public void setTextToInput(String searchText) {
        GoogleSearchPage searchPage = new GoogleSearchPage();
        searchPage.getSearchField()
                .shouldBe(Condition.enabled, Condition.visible, Condition.empty)
                .setValue(searchText);
    }

    @And("I click button to search it")
    public void clickToSearch() {
        GoogleSearchPage searchPage = new GoogleSearchPage();
        searchPage.getSearchButton()
                .shouldBe(Condition.enabled)
                .click();
    }

    @Then("Result page has {int} results")
    public void checkResults(int expectedResultSize) {
        GoogleResultPage resultPage = new GoogleResultPage();
        resultPage.getSearchInput()
                .shouldBe(Condition.visible, Condition.enabled);
        int size = resultPage.getResults()
                .size();

        assertEquals(expectedResultSize, size);
    }

    @AfterAll
    public static void closeAll() {
        Selenide.closeWebDriver();
    }
}
