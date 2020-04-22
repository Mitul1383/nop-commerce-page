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
public class HomePage extends Utility {
    private static final Logger log = LogManager.getLogger(HomePage.class.getName());


    @FindBy(linkText = "Register")
    WebElement _registerFeature;
    @FindBy(linkText = "Log in")
    WebElement _loginFeature;
    @FindBy(xpath = "//ul[@class='top-menu notmobile']//a[contains(text(),'Computers')]")
    WebElement _computerFeature;

    public void clickOnRegisterFeature() {
        Reporter.log("Clicking on register button " + _registerFeature.toString() + "<br>");
        clickOnElement(_registerFeature);
        log.info("Clicking on register button " + _registerFeature.toString());
    }

    public void clickOnLoginFeature() {
        //Reporter.log("Clicking on login button " + _loginFeature.toString() + "<br>");
        clickOnElement(_loginFeature);
       // log.info("Clicking on login button " + _loginFeature.toString());
    }

    public void clickOnComputerFeature() {
        Reporter.log("Clicking on computer button " + _computerFeature.toString() + "<br>");
        mouseHoverToElement(_computerFeature);
        log.info("Clicking on computer button " + _computerFeature.toString());
    }


}
