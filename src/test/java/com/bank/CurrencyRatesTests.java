package com.bank;

import com.bank.myfin.logic.DataProviders;
import com.bank.myfin.logic.steps.APISteps;
import com.bank.myfin.logic.steps.CurrencyRatesSteps;
import com.bank.utils.DateUtils;
import com.google.inject.Inject;
import io.qameta.allure.Description;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import static io.qameta.allure.Allure.step;


public class CurrencyRatesTests extends Base {

    @Inject
    APISteps apiSteps;

    @Inject
    CurrencyRatesSteps currencyRatesSteps;

    @Test(dataProvider = "currency-provider", dataProviderClass = DataProviders.class)
    @Description("Test currency rates values")
    public void testCourse(String currency) {
        currencyRatesSteps.openRatesPage();
        var currentRateOnPage = currencyRatesSteps.getRateForCurrency(currency);
        var tomorrowRateFromApi = apiSteps.getRates(currency, DateUtils.getFutureDate(1));

        step("Assert currency rates are correct", () -> {
            SoftAssert softAssert = new SoftAssert();
            softAssert.assertTrue(currentRateOnPage > 0.01);
            softAssert.assertEquals(tomorrowRateFromApi, currentRateOnPage);
            softAssert.assertAll();
        });
    }
}
