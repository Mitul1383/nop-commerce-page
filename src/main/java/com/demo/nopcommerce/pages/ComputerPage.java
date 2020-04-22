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
public class ComputerPage extends Utility {
    private static final Logger log = LogManager.getLogger(RegisterPage.class.getName());


    @FindBy(xpath = "//ul[@class='top-menu notmobile']//a[contains(text(),'Computers')]")
    WebElement _computerTextMessage;
    @FindBy(linkText = "Build your own computer")
    WebElement _buildYourComputer;
    @FindBy(xpath = "//input[@id='product_attribute_3_7']")
    WebElement _clickOnRadioButton;
    @FindBy(id = "add-to-cart-button-1")
    WebElement _addToCartButton;
    @FindBy(className = "content")
    WebElement _addToCartConfirmMessage;

    //below all methods for each elements and doing actions on that each elements
    public String getComputerTextMessage() {
        Reporter.log("Getting computer text message " + _computerTextMessage.toString() + "<br>");
        log.info("Getting computer text message " + _computerTextMessage.toString());
        return getTextFromElement(_computerTextMessage);
    }

    public void clickOnBuildComputer() {
        Reporter.log("Clicking on build computer " + _buildYourComputer.toString() + "<br>");
        clickOnElement(_buildYourComputer);
        log.info("Clicking on build computer " + _buildYourComputer.toString());
    }

    public void clickOnRadioButtonFeature() {
        Reporter.log("Clicking on radio button feature " + _clickOnRadioButton.toString());
        clickOnElement(_clickOnRadioButton);
        log.info("Clicking on radio button feature " + _clickOnRadioButton.toString());
    }

    public void clickOnAddToCartButton() {
        Reporter.log("Clicking On add cart button " + _addToCartButton.toString() + "<br>");
        clickOnElement(_addToCartButton);
        log.info("Clicking on add cart button " + _addToCartButton.toString());
    }

    public String getAddToCartMessage() {
        Reporter.log("Getting add to cart message " + _addToCartConfirmMessage.toString() + "<br>");
        log.info("Getting add to cart message " + _addToCartConfirmMessage.toString());
        return getTextFromElement(_addToCartConfirmMessage);
    }


}
