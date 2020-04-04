package com.bank.myfin.forms;

import com.codeborne.selenide.SelenideElement;
import lombok.Getter;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Configuration.baseUrl;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class CurrencyRatesPage {
    private static final String PAGE_URL = "/torgi-na-bvfb";

    private String ratesTableLoc = "//table[contains(@class, 'rates-table-nbrb')]";
    private String ratesCourseValueLoc = ratesTableLoc + "//td[contains(.,'%s')]/following-sibling::td//div[@class='curr_block']";
    @Getter
    private SelenideElement ratesTable = $(By.xpath(ratesTableLoc));
    @Getter
    private SelenideElement rateCourseValue;

    public CurrencyRatesPage openPage() {
        open(baseUrl + PAGE_URL);
        return this;
    }

    public String getRateValueForCurrency(String currency) {
        rateCourseValue = $(By.xpath(String.format(ratesCourseValueLoc, currency)));
        return rateCourseValue.getText();
    }

}
