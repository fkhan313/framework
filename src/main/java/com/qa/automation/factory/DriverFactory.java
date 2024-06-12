package com.qa.automation.factory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class DriverFactory {

    public WebDriver driver;
    public Properties prop;
    public OptionsManager optionsManager;
    //not going to work until prop class is created
    public static String highlight;

    public WebDriver initDriver(Properties prop) {
        optionsManager = new OptionsManager(prop);
        String browserName = prop.getProperty("browser").toLowerCase().trim();
        System.out.println("browser name is: " + browserName);

        if (browserName.equalsIgnoreCase("chrome")) {
            driver = new ChromeDriver(optionsManager.getChromeOptions());
            //create method for firefox options in OptionsManager class
        } else if (browserName.equalsIgnoreCase("firefox")) {
            driver = new FirefoxDriver();
            //create merthod for Edge options in OptionsManager class
        } else if (browserName.equalsIgnoreCase("edge")) {
            driver = new EdgeDriver();
        } else {
            System.out.println(" please pass the right browser " + browserName);
        }
        driver.manage().deleteAllCookies();
        driver.manage().window().maximize();
        driver.get(prop.getProperty("url"));
        return driver;
    }
    /**
     * reads properties file
     * @return
     */

    public Properties initProp() {
        prop = new Properties();
        try {
            FileInputStream ip = new FileInputStream(".src/main/resources/config/config.properties");
            prop.load(ip);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return prop;
    }

}
