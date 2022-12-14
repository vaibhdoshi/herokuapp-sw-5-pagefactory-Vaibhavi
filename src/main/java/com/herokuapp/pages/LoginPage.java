package com.herokuapp.pages;

import com.herokuapp.utility.Utility;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Reporter;

public class LoginPage extends Utility {
    public LoginPage() {
        PageFactory.initElements(driver, this);
    }

    @CacheLookup
    @FindBy(id = "username")
    WebElement usernameField;


    @CacheLookup
    @FindBy(id = "password")
    WebElement passwordField;

    @CacheLookup
    @FindBy(xpath = "//button[@type='submit']")
    WebElement loginButton;

    @CacheLookup
    @FindBy(xpath = "//h2[text()=' Secure Area']")
    WebElement secureText;

    @CacheLookup
    @FindBy(xpath = "//div[@id='flash']")
    WebElement userErrorMessage;

    @CacheLookup
    @FindBy(xpath = "//div[@id='flash'])[1]")
    WebElement passwordErrorMessage;


    //By userName = By.id("username");
    //By passwordField = By.id("password");
    //By loginButton = By.xpath("//button[@type='submit']");
    //By secureText = By.xpath("//h2[text()=' Secure Area']");
    //By userErrorMessage = By.xpath("//div[@id='flash']");

    //By passwordErrorMessage=By.xpath("//div[@id='flash'])[1]");

    public void enterUserName(String username) {
        Reporter.log("Enter username " + username + " to username field " + usernameField.toString());
        sendTextToElement(usernameField, username);

    }
    public void enterPassword(String password) {
        Reporter.log("Enter password" + password + "to password field " + passwordField.toString());
        sendTextToElement(passwordField, password);

    }
    public void clickOnLoginButton() {
        Reporter.log("Clicking on Login Button" + loginButton.toString());
        clickOnElement(loginButton);
    }

    public String getSecureTextMessage() {
        Reporter.log("Get secure text message" + secureText.toString());
        return getTextFromElement(secureText);

    }public String getUserErrorMessage() {
        Reporter.log("Get user error message" + userErrorMessage.toString());
        return getTextFromElement(userErrorMessage);
    }
    public String getPasswordErrorMessage() {
        Reporter.log("Get password error message" + passwordErrorMessage.toString());
        return getTextFromElement(passwordErrorMessage);
    }
}

