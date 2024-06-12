package com.qa.automation.factory;

import org.openqa.selenium.chrome.ChromeOptions;

import java.util.Properties;

public class OptionsManager {

    private Properties prop;
    private ChromeOptions co;

    public OptionsManager(Properties prop) {
        this.prop = prop;
    }

    public ChromeOptions getChromeOptions() {
        co = new ChromeOptions();
        if (Boolean.parseBoolean(prop.getProperty("headless").trim())) {
            co.addArguments("--headless");
        }
        //curly brace can be removed
        if (Boolean.parseBoolean(prop.getProperty("incognito").trim())) co.addArguments("--incognito");

        return co;
    }
}

