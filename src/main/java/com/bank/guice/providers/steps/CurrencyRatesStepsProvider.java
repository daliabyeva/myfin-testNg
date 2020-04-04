package com.bank.guice.providers.steps;

import com.bank.myfin.forms.CurrencyRatesPage;
import com.bank.myfin.logic.steps.CurrencyRatesSteps;
import com.google.inject.Inject;
import com.google.inject.Provider;
import lombok.AllArgsConstructor;

@AllArgsConstructor(onConstructor_ = @Inject)
public class CurrencyRatesStepsProvider implements Provider<CurrencyRatesSteps> {
    CurrencyRatesPage currencyRatesPage;

    @Override
    public CurrencyRatesSteps get() {
        return new CurrencyRatesSteps(currencyRatesPage);
    }
}
