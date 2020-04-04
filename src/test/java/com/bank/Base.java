package com.bank;

import com.bank.guice.module.ModulesBindings;
import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.restassured.AllureRestAssured;
import io.qameta.allure.selenide.AllureSelenide;
import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.config.HttpClientConfig;
import io.restassured.config.RestAssuredConfig;
import io.restassured.filter.log.LogDetail;
import io.restassured.http.ContentType;
import lombok.NoArgsConstructor;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.impl.conn.PoolingHttpClientConnectionManager;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Guice;

import static java.net.HttpURLConnection.HTTP_OK;


@NoArgsConstructor
@Guice(modules = ModulesBindings.class)
public abstract class Base {
    private static final String API_PROTOCOL = "https";
    private static final String API_HOST = "www.nbrb.by";
    private static final String API_PORT = "443";

    @BeforeClass
    void setUp() {
        Configuration.baseUrl = "https://myfin.by/currency";
        Configuration.browser = "chrome";
        Configuration.startMaximized = true;

        SelenideLogger.addListener("AllureSelenide", new AllureSelenide().screenshots(true).savePageSource(false));

        RestAssuredConfig.config().httpClient(HttpClientConfig.httpClientConfig()
                .httpClientFactory(() -> {
                    var cm = new PoolingHttpClientConnectionManager();
                    cm.setMaxTotal(50);
                    cm.setDefaultMaxPerRoute(20);
                    return HttpClients.custom()
                            .setConnectionManager(cm)
                            .build();
                }).and().dontReuseHttpClientInstance());

        RestAssured.replaceFiltersWith(new AllureRestAssured());

        RestAssured.requestSpecification = new RequestSpecBuilder()
                .setBaseUri(API_PROTOCOL + "://" + API_HOST + ":" + API_PORT)
                .setAccept(ContentType.JSON)
                .log(LogDetail.ALL)
                .build();

        RestAssured.responseSpecification = new ResponseSpecBuilder()
                .expectStatusCode(HTTP_OK)
                .build();
    }

}
