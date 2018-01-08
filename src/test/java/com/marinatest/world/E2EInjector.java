package com.marinatest.world;

import com.google.inject.Guice;
import com.google.inject.Injector;
import com.google.inject.Stage;
import cucumber.api.guice.CucumberModules;
import cucumber.runtime.java.guice.InjectorSource;

public class E2EInjector implements InjectorSource {
    private static Injector theOne;

    @Override
    public Injector getInjector() {
        if (theOne == null) {
            theOne = Guice.createInjector(Stage.PRODUCTION, CucumberModules.SCENARIO, new E2EModule());
        }
        return theOne;
    }
}
