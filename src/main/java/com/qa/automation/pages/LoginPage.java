package com.qa.automation.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage {

    private WebDriver driver;

    private By emailid = By.id("input-email");

    public LoginPage(WebDriver driver) {
        this.driver=driver;
    }

    public String getLoginPageTitle () {
        String title = driver.getTitle();
        System.out.println("Login page title is: " +title);
        return title;
    }



}
