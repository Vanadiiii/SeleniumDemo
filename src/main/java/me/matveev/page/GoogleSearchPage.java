package me.matveev.page;

import com.codeborne.selenide.SelenideElement;
import lombok.Data;
import lombok.Getter;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;


@Data
public class GoogleSearchPage {
    @Getter
    private static final String BASE_URL = "https://www.google.com";

    private final SelenideElement searchField = $(By.name("q"));
    private final SelenideElement searchButton = $$(By.name("btnK")).first();
}
