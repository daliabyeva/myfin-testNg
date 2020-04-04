package com.bank.myfin.logic.steps;

import com.bank.myfin.forms.CurrencyRatesPage;
import com.codeborne.selenide.Condition;
import io.qameta.allure.Step;

public class CurrencyRatesSteps {

    private final CurrencyRatesPage currencyRatesPage;

    public CurrencyRatesSteps(CurrencyRatesPage currencyRatesPage) {
        this.currencyRatesPage = currencyRatesPage;
    }

    @Step("Open Rates page")
    public void openRatesPage() {
        currencyRatesPage.openPage();
    }

    @Step("Open currency rate value from page for {0}")
    public Double getRateForCurrency(String currency) {
        currencyRatesPage.getRatesTable().shouldBe(Condition.visible);
        return Double.valueOf(currencyRatesPage.getRateValueForCurrency(currency));
    }

}
