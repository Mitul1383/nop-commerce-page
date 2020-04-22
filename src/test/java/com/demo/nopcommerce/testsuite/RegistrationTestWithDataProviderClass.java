package com.demo.nopcommerce.testsuite;

import com.demo.nopcommerce.pages.HomePage;
import com.demo.nopcommerce.pages.LoginPage;
import com.demo.nopcommerce.pages.RegisterPage;
import com.demo.nopcommerce.resources.testdata.TestData;
import com.demo.nopcommerce.testbase.TestBase;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import static com.demo.nopcommerce.Utility.Utility.getRandomString;

/**
 * Created by Mitul
 */
public class RegistrationTestWithDataProviderClass extends TestBase {
    RegisterPage registerPage;
    HomePage homePage;
    SoftAssert softAssert = new SoftAssert();

    String emailId = null;

    @BeforeMethod(groups = {"sanity", "smoke", "regression"})
    public void setUp() {
        registerPage = new RegisterPage();
        homePage = new HomePage();
        emailId = "clickndrun" + getRandomString(4) + "@gmail.com";
    }

    @Test(groups = {"sanity", "regression"}, priority = 0)
    public void verifyUserShouldNavigateToRegisterPage() {
        //below methods calling from pages package
        homePage.clickOnRegisterFeature();
        //compare expected with actual result
        softAssert.assertEquals("Your Personal Details", registerPage.getRegisterMessage());
        softAssert.assertAll();
    }


    @Test(groups = {"smoke", "regression"}, dataProvider = "Registration Data", dataProviderClass = TestData.class, priority = 1)
    public void verifyUserShouldRegisterWithValidData(String firstName, String lastName, String dayOfBirth, String birthMonth, String birthYear, String companyName, String enterPassword, String enterConfirmPassword) {
        homePage.clickOnRegisterFeature();
        registerPage.register(firstName, lastName, dayOfBirth, birthMonth, birthYear, companyName, enterPassword, enterConfirmPassword);
        registerPage.enterEmailId(emailId);
        registerPage.clickOnRegistrationButton();
        softAssert.assertEquals("Your registration completed", registerPage.registrationCompleteMessage());
        softAssert.assertAll();
    }

    @Test(groups = {"regression"}, dataProvider = "invalid Registration Data", dataProviderClass = TestData.class, priority = 2)
    public void verifyUserShouldNotRegisterWithInvalidData(String firstName, String lastName, String dayOfBirth, String birthMonth, String birthYear, String companyName, String enterPassword, String enterConfirmPassword) {
        homePage.clickOnRegisterFeature();
        registerPage.register(firstName, lastName, dayOfBirth, birthMonth, birthYear, companyName, enterPassword, enterConfirmPassword);
        //registerPage.enterEmailId(emailId);
        registerPage.clickOnRegistrationButton();
        softAssert.assertEquals("Your registration", registerPage.registrationCompleteMessage());
        softAssert.assertAll();


    }

}
