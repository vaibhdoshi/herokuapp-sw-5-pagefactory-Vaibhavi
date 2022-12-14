package com.herokuapp.testsuite;

import com.herokuapp.customlisteners.CustomListeners;
import com.herokuapp.pages.LoginPage;
import com.herokuapp.testbase.BaseTest;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

@Listeners(CustomListeners.class)
public class LoginPageTest extends BaseTest {

    LoginPage loginpage;

    @BeforeMethod(alwaysRun = true)
    public void inIt() {
        loginpage = new LoginPage();

    }

    @Test(groups = {"sanity","Regression"})
    public void userShouldLoginSuccessfullyWithValidCredentials() {
        loginpage.enterUserName("tomsmith");
        loginpage.enterPassword("SuperSecretPassword!");
        loginpage.clickOnLoginButton();
        loginpage.getSecureTextMessage();
        String expectedMessage = "Secure Area";
        String actualMessage = loginpage.getSecureTextMessage();
        Assert.assertEquals(actualMessage, expectedMessage, "correct text");
    }

    @Test(groups ={"smoke","Regression"})
    public void verifyTheUsernameErrorMessage() {
        loginpage.enterUserName("tomsmith1");
        loginpage.enterPassword("SuperSecretPassword!");
        loginpage.clickOnLoginButton();
        String expectedMessage = "Your username is invalid!\n" + "×";
        String actualMessage = loginpage.getUserErrorMessage();
        Assert.assertEquals(actualMessage, expectedMessage, "correct text");
    }

    @Test(groups = "Regression")
    public void verifyThePasswordErrorMessage() {
        loginpage.enterUserName("tomsmith");
        loginpage.enterPassword("SuperSecretPassword");
        loginpage.clickOnLoginButton();
        String expectedMessage = "Your password is invalid!\n" + "×";
        String actualMessage = loginpage.getPasswordErrorMessage();
        Assert.assertEquals(actualMessage, expectedMessage, "correct text");

    }
}

