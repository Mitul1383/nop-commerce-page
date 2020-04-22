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
public class DesktopPage extends Utility {

    private static final Logger log = LogManager.getLogger(DesktopPage.class.getName());

    @FindBy(xpath = "//ul[@class='top-menu notmobile']//a[contains(text(),'Desktops')]")
    WebElement _clickOnDesktopFeature;
    @FindBy(id = "products-orderby")
    WebElement _sortByPosition;
    @FindBy(xpath = "//option[contains(text(),'Name: A to Z')]")
    WebElement _aToZSorting;

    public void clickOnDesktopButton() {
        Reporter.log("Clicking on Desktop button " + _clickOnDesktopFeature.toString() + "<br>");

        clickOnElement(_clickOnDesktopFeature);
        log.info("Clicking on Desktop button " + _clickOnDesktopFeature.toString());
    }

    public void clickOnPosition() {
        Reporter.log("Clicking on position " + _sortByPosition.toString() + "<br>");
        clickOnElement(_sortByPosition);
        log.info("Clicking on position " + _sortByPosition.toString());
    }

    public void aTozSort() {
        Reporter.log("Clicking on A to Z " + _aToZSorting.toString() + "<br>");
        clickOnElement(_aToZSorting);
        log.info("Clicking on A to Z " + _aToZSorting.toString());
    }

}
