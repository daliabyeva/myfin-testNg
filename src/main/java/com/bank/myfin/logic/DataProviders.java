package com.bank.myfin.logic;

import org.testng.annotations.DataProvider;

public class DataProviders {
    @DataProvider(name = "currency-provider")
    public static Object[][] currencyProvider()
    {
        return new Object[][] { { "USD" }, { "EUR" }, { "rub" } };
    }
}
