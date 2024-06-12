package com.qa.automation.base;

import com.qa.automation.factory.DriverFactory;
import com.qa.automation.pages.LoginPage;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import java.util.Properties;

public class BaseTest {

    DriverFactory df;
    WebDriver driver;
    protected Properties prop;
    protected LoginPage loginPage;

    @BeforeTest
    public void setup () {
        df= new DriverFactory();
        prop = df.initProp();
        driver= df.initDriver (prop);
        loginPage= new LoginPage(driver);
    }

    @AfterTest
    public void tearDown(){
        driver.quit();
    }
}
