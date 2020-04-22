package com.demo.nopcommerce.testsuite;

import com.demo.nopcommerce.pages.ComputerPage;
import com.demo.nopcommerce.pages.DesktopPage;
import com.demo.nopcommerce.pages.HomePage;
import com.demo.nopcommerce.testbase.TestBase;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

/**
 * Created by Mitul
 */
public class ComputerTest extends TestBase {
    HomePage homePage;
    DesktopPage desktopPage;
    ComputerPage computerPage;
    SoftAssert softAssert;

    @BeforeMethod
    public void setUp() {
        homePage = new HomePage();
        desktopPage = new DesktopPage();
        computerPage = new ComputerPage();
        softAssert = new SoftAssert();

    }

    @Test(groups = {"sanity", "regression"}, priority = 0)
    public void verifyUserShouldNavigateToComputersPage() {
        //below methods calling from pages package
        homePage.clickOnComputerFeature();
        //compare expected with actual result
        softAssert.assertEquals("Computers", computerPage.getComputerTextMessage());
        softAssert.assertAll();

    }

    @Test(groups = {"smoke", "regression"}, priority = 1)
    public void verifyUserShouldAddProductToCartSuccessfully() {
        //below all methods calling from pages package
        homePage.clickOnComputerFeature();
        desktopPage.clickOnDesktopButton();
        desktopPage.clickOnPosition();
        desktopPage.aTozSort();
        computerPage.clickOnBuildComputer();
        computerPage.clickOnRadioButtonFeature();
        computerPage.clickOnAddToCartButton();
        //compare expected with actual result
        softAssert.assertEquals("The product has been added to your shopping cart", computerPage.getAddToCartMessage());
        softAssert.assertAll();

    }

    @Test(groups = {"regression"}, priority = 2)
    public void verifyUserShouldNotAddProductToCartSuccessfully() {
        //below all methods calling from pages package
        homePage.clickOnComputerFeature();
        desktopPage.clickOnDesktopButton();
        desktopPage.clickOnPosition();
        desktopPage.aTozSort();
        computerPage.clickOnBuildComputer();
        computerPage.clickOnRadioButtonFeature();
        computerPage.clickOnAddToCartButton();
        //compare expected with actual result
        softAssert.assertEquals("The product has been added to your shopping", computerPage.getAddToCartMessage());
        softAssert.assertAll();
    }


}

