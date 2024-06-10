package com.qa.automation.tests;

import com.qa.automation.base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LoginPageTest extends BaseTest {


    @Test
    public void loginPageTitleTest(){

        String actualTitle= loginPage.getLoginPageTitle();
        Assert.assertEquals(actualTitle,"Account Login");

    }


}
