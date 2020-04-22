package com.demo.nopcommerce.testsuite;

import com.demo.nopcommerce.pages.HomePage;
import com.demo.nopcommerce.pages.RegisterPage;
import com.demo.nopcommerce.testbase.TestBase;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import static com.demo.nopcommerce.Utility.Utility.getRandomString;

/**
 * Created by Mitul
 */
public class RegistrationTest extends TestBase {

    String emailId = null;
    HomePage homePage;
    RegisterPage registerPage;
    SoftAssert softAssert;

    @BeforeMethod(groups = {"sanity", "smoke", "regression"})
    public void setUp() {
        homePage = new HomePage();
        registerPage = new RegisterPage();
        softAssert = new SoftAssert();
    }


    @BeforeClass(groups = {"smoke", "sanity", "regression"})
    public void setUpEmail() {
        emailId = "dhanno" + getRandomString(2) + "@gmail.com";
    }

    @Test(groups = {"sanity", "regression"}, priority = 0)
    public void verifyUserShouldNavigateToRegisterPage() {
        //below methods calling from pages package
        homePage.clickOnRegisterFeature();
        //compare expected with actual result
        softAssert.assertEquals("Your Personal Details", registerPage.getRegisterMessage());
        softAssert.assertAll();
    }

    @Test(groups = {"smoke", "regression"}, priority = 1)
    public void verifyUserShouldRegisterSuccessfullyWithValidCredentials() {
        //below all methods calling from pages package
        homePage.clickOnRegisterFeature();
        registerPage.clickOnRadioButton();
        registerPage.enterFirstName("clickndRun");
        registerPage.enterLastName("run");
        registerPage.selectDayOfBirth("4");
        registerPage.selectDateOfBirthMonth("july");
        registerPage.selectDateOfBirthYear("1983");
        registerPage.enterEmailId(emailId);
        registerPage.enterCompanyName("jec limited");
        registerPage.selectCheckBoxOfNewsLetter();
        registerPage.enterPassword("clickndrun123@");
        registerPage.enterConfirmPassword("clickndrun123@");
        registerPage.clickOnRegistrationButton();
        //compare expected with actual result
        softAssert.assertEquals("Your registration completed", registerPage.registrationCompleteMessage());
        softAssert.assertAll();


    }

    @Test(groups = {"regression"}, priority = 2)
    public void verifyUserShouldNotRegisterSuccessfullyWithInvalidValidCredentials() {
        //below all methods calling from pages package
        homePage.clickOnRegisterFeature();
        registerPage.clickOnRadioButton();
        registerPage.enterFirstName("clickndRun");
        registerPage.enterLastName("run");
        registerPage.selectDayOfBirth("4");
        registerPage.selectDateOfBirthMonth("july");
        registerPage.selectDateOfBirthYear("1983");
        registerPage.enterEmailId(emailId);
        registerPage.enterCompanyName("jec limited");
        registerPage.selectCheckBoxOfNewsLetter();
        registerPage.enterPassword("clickndrun123@");
        registerPage.enterConfirmPassword("clickndrun123@");
        registerPage.clickOnRegistrationButton();
        //compare expected with actual result
        softAssert.assertEquals("Your registration", registerPage.registrationCompleteMessage());
        softAssert.assertAll();

    }
}
