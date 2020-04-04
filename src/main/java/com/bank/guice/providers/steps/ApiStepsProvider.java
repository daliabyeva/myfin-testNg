package com.bank.guice.providers.steps;

import com.bank.myfin.api.requests.RatesService;
import com.bank.myfin.logic.steps.APISteps;
import com.google.inject.Inject;
import com.google.inject.Provider;
import lombok.AllArgsConstructor;

@AllArgsConstructor(onConstructor_ = @Inject)
public class ApiStepsProvider implements Provider<APISteps> {
    RatesService ratesService;

    @Override
    public APISteps get() {
        return new APISteps(ratesService);
    }

}