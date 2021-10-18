package me.matveev.page;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;

public class WikiPage {
    private final SelenideElement searchField = $(By.id("searchInput"));
    private final SelenideElement searchButton = $(By.id("searchButton"));
}
