package com.demo.nopcommerce.pages;

import com.demo.nopcommerce.Utility.Utility;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Reporter;


/**
 * Created by Mitul
 */
public class LoginPage extends Utility {

    private static final Logger log = LogManager.getLogger(LoginPage.class.getName());


    @FindBy(id = "Email")
    WebElement _emailField;
    @FindBy(id = "Password")
    WebElement _passwordField;
    @FindBy(xpath = "//input[@class='button-1 login-button']")
    WebElement _clickOnLogin;
    @FindBy(xpath = "//h1[contains(text(),'Welcome, Please Sign In!')]")
    WebElement _welcomeMessage;
    @FindBy(xpath = "//h2[contains(text(),'Welcome to our store')]")
    WebElement _welcomeToOurStore;

    public void enterEmailId(String email) {
        Reporter.log("Enter email " + email + "On Email Field " + _emailField.toString() + "<br>");
        sendTextToElement(_emailField, email);
        log.info("Enter email " + email + "On Email Field " + _emailField.toString());
    }

    public void enterPassword(String password) {
        Reporter.log("Enter password " + password + "On Password Field " + _passwordField.toString() + "<br>");
        sendTextToElement(_passwordField, password);
        log.info("Enter password " + password + "On Password Field " + _passwordField.toString());
    }

    public void clickOnLoginButton() {
        Reporter.log("Clicking on login button " + _clickOnLogin.toString() + "<br>");
        clickOnElement(_clickOnLogin);
        log.info("Clicking on login button " + _clickOnLogin.toString());
    }

    public String getWelcomeMessage() {
        Reporter.log("Getting welcome " + _welcomeMessage.toString() + "<br>");
        log.info("Getting welcome " + _welcomeMessage.toString());
        return getTextFromElement(_welcomeMessage);

    }

    public String welcomeToStore() {
        Reporter.log("Getting welcome to store message " + _welcomeToOurStore.toString() + "<br>");
        log.info("Getting welcome to store message " + _welcomeToOurStore.toString());
        return getTextFromElement(_welcomeToOurStore);
    }

    //  public void waitForVisibilityToSeeElement() {
    // waitUntilVisibilityOfElementLocated((By) _emailField, 10);

    public void logToApp(String username, String password){
        enterEmailId(username);
        enterPassword(password);
        clickOnLoginButton();
    }

}



