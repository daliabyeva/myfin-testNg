package com.bank.guice.module;

import com.bank.guice.providers.steps.ApiStepsProvider;
import com.bank.guice.providers.steps.CurrencyRatesStepsProvider;
import com.bank.myfin.api.requests.RatesService;
import com.bank.myfin.forms.CurrencyRatesPage;
import com.bank.myfin.logic.steps.APISteps;
import com.bank.myfin.logic.steps.CurrencyRatesSteps;
import com.google.inject.AbstractModule;
import com.google.inject.Inject;
import com.google.inject.Provides;

/**
 * This class represents declaration of correlation of entities and their providers.
 * App screens and forms, tests steps can be bound here
 * <p>
 * Google guice guide https://www.baeldung.com/guice
 */
public class ModulesBindings extends AbstractModule {

    @Override
    protected void configure() {
        bind(CurrencyRatesSteps.class).toProvider(CurrencyRatesStepsProvider.class);
        bind(APISteps.class).toProvider(ApiStepsProvider.class);
    }

    @Inject
    @Provides
    CurrencyRatesPage provideCurrencyRatesPage() {
        return new CurrencyRatesPage();
    }

    @Inject
    @Provides
    RatesService provideRatesService() {
        return new RatesService();
    }

}