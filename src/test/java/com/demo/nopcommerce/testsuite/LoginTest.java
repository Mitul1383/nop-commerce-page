package com.demo.nopcommerce.testsuite;

import com.demo.nopcommerce.pages.HomePage;
import com.demo.nopcommerce.pages.LoginPage;
import com.demo.nopcommerce.testbase.TestBase;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

/**
 * Created by Mitul
 */
public class LoginTest extends TestBase {
    HomePage homePage;
    LoginPage loginPage;
    SoftAssert softAssert;

    @BeforeMethod
    public void setUp(){
        homePage = new HomePage();
        loginPage = new LoginPage();
        softAssert = new SoftAssert();
    }

    //object created
    @Test(groups = {"sanity","regression"}, priority = 0)
    public void verifyUserShouldNavigateToLoginFeature() {
        //below methods calling from pages package
        homePage.clickOnLoginFeature();
        //compare expected with actual result
        softAssert.assertEquals("Welcome, Please Sign In!",loginPage.getWelcomeMessage());
        softAssert.assertAll();

    }

    @Test(groups = {"smoke","regression"}, priority = 1)
    public void verifyUserShouldLoginWithValidCredentialsSuccessfully() {
        //below methods calling from pages package
        homePage.clickOnLoginFeature();
      //  loginPage.waitForVisibilityToSeeElement();
        loginPage.enterEmailId("MittulPattel@gmail.com");
        loginPage.enterPassword("123456");
        loginPage.clickOnLoginButton();
        //compare expected with actual result
        softAssert.assertEquals("Welcome to our store",loginPage.welcomeToStore());
        softAssert.assertAll();

    }

    @Test(groups = {"regression"}, priority = 2)
    public void verifyUserShouldNotLoginWithInvalidCredentialsSuccessfully() {
        //below methods calling from pages package
        homePage.clickOnLoginFeature();
        //loginPage.waitForVisibilityToSeeElement();
        loginPage.enterEmailId("MittulPattel@gmail.com");
        loginPage.enterPassword("123456");
        loginPage.clickOnLoginButton();
        //compare expected with actual result

        softAssert.assertEquals("Welcome",loginPage.welcomeToStore());
        softAssert.assertAll();
    }

}
