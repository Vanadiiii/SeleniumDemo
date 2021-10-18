package me.matveev.page;

import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class WikiPageTest {
    @BeforeClass
    public static void initWebDriver() {
        System.setProperty("selenide.browser", "firefox");
        System.setProperty("selenide.headless", "true");
    }


    @Test
    public void test() {
        String value = "Собака";

        open("https://ru.wikipedia.org");

        $(By.id("searchInput"))
                .setValue(value);
        $(By.id("searchButton"))
                .click();

        $("#firstHeading").shouldBe(visible)
                .shouldHave(text(value));
    }
}