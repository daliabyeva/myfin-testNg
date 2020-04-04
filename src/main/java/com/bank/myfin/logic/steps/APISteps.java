package com.bank.myfin.logic.steps;

import com.bank.myfin.api.requests.RatesService;
import io.qameta.allure.Step;

import static io.restassured.module.jsv.JsonSchemaValidator.matchesJsonSchemaInClasspath;
import static java.net.HttpURLConnection.HTTP_OK;

public class APISteps {

    private final RatesService ratesService;


    public APISteps(RatesService ratesService) {
        this.ratesService = ratesService;
    }

    @Step("Get currency rate value from API for {0} on date {1}")
    public Double getRates(String currency, String date) {
        var responseRatesOnDateAndCurrency = ratesService.getRate(currency, date);
        responseRatesOnDateAndCurrency.then().assertThat()
                .statusCode(HTTP_OK)
                .and()
                .body(matchesJsonSchemaInClasspath("schemas/rates.ondate.currency.response.schema.json"));

        return Double.valueOf(responseRatesOnDateAndCurrency.then()
                .assertThat()
                .statusCode(HTTP_OK)
                .and().assertThat()
                .extract()
                .body().jsonPath().getString("Cur_OfficialRate"));
    }

}
