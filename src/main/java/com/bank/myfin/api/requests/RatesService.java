package com.bank.myfin.api.requests;


import com.bank.myfin.api.constants.Endpoints;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

import static com.bank.myfin.api.constants.Params.ONDATE;
import static com.bank.myfin.api.constants.Params.PARAMMODE;
import static io.restassured.RestAssured.given;

public class RatesService {

    public Response getRate(String currency, String date) {
        return given()
                .contentType(ContentType.URLENC)
                .queryParams(
                        PARAMMODE, 2,
                        ONDATE, date
                )
                .when()
                .get(String.format(Endpoints.RATES, currency));
    }

}
