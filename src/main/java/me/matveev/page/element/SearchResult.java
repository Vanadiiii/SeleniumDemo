package me.matveev.page.element;

import com.codeborne.selenide.SelenideElement;
import lombok.Data;
import org.openqa.selenium.By;

@Data
public class SearchResult {
    private final String url;
    private final String header;
    private final String partialText;

    public SearchResult(SelenideElement container) {
        this.url = container.$$(By.tagName("cite"))
                .first()
                .text()
                .replaceAll("^(.+?) .+$", "$1");
        this.header = container.$("a h3").text();
        this.partialText = container.$$x("div/div/div").get(1).text();
    }
}
