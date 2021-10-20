package me.matveev.page;

import com.codeborne.selenide.SelenideElement;
import lombok.Data;
import me.matveev.page.element.SearchResult;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

@Data
public class GoogleResultPage {
    private final SelenideElement searchInput = $("input[name='q'][type='text']");

    public Collection<SearchResult> getResults() {
        List<SearchResult> resultList = new ArrayList<>();
        for (SelenideElement result : $$("div#rso div.g")) {
            resultList.add(new SearchResult(result));
        }
        return resultList;
    }
}
