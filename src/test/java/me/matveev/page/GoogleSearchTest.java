package me.matveev.page;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class GoogleSearchTest {
    @Before
    public void openStartPage() {
        Configuration.browser = "firefox";
        Configuration.startMaximized = true;

        Selenide.open(GoogleSearchPage.getBASE_URL());
    }

    @Test
    public void test() {
        String searchText = "hello selenide";

        GoogleSearchPage searchPage = new GoogleSearchPage();
        searchPage.getSearchField()
                .shouldBe(Condition.enabled, Condition.visible, Condition.empty)
                .setValue(searchText);
        searchPage.getSearchButton()
                .shouldBe(Condition.enabled)
                .click();

        GoogleResultPage resultPage = new GoogleResultPage();
        resultPage.getSearchInput()
                .shouldBe(Condition.visible, Condition.enabled);
        int size = resultPage.getResults()
                .size();

        assertEquals(10, size);
    }

    @After
    public void closeDriver() {
        Selenide.closeWebDriver();
    }
}