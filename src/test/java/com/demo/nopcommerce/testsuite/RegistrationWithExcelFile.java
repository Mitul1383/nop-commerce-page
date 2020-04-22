package com.demo.nopcommerce.testsuite;

import com.demo.nopcommerce.excelutility.ExcelUtility;
import com.demo.nopcommerce.pages.HomePage;
import com.demo.nopcommerce.pages.RegisterPage;
import com.demo.nopcommerce.testbase.TestBase;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import static com.demo.nopcommerce.Utility.Utility.getRandomString;

/**
 * Created by Mitul
 */
public class RegistrationWithExcelFile extends TestBase {


    public static final String File_path = System.getProperty("user.dir") + "/src/test/java/com/demo/nopcommerce/resources/testdata/Checker.xlsx";

    HomePage homePage;
    RegisterPage registerPage;
    SoftAssert softAssert;
    String emailId = null;

    @BeforeClass(groups = {"sanity", "smoke", "regression"})
    public void setExcel() {
        try {
            ExcelUtility.setExcelFile(File_path, "Register");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @BeforeMethod(groups = {"sanity", "smoke", "regression"})
    public void setUp() {
        homePage = new HomePage();
        registerPage = new RegisterPage();
        softAssert = new SoftAssert();
        emailId = "clickndrun" + getRandomString(4) + "@gmail.com";
    }


    @DataProvider(name = "Registration")
    public Object[][] getData() {
        Object[][] data = ExcelUtility.getTestData("RegData");
        return data;
    }
    @Test(groups = {"sanity", "regression"}, priority = 0)
    public void verifyUserShouldNavigateToRegisterPage() {
        //below methods calling from pages package
        homePage.clickOnRegisterFeature();
        //compare expected with actual result
        softAssert.assertEquals("Your Personal Details", registerPage.getRegisterMessage());
        softAssert.assertAll();
    }

    @Test(groups = {"smoke", "regression"}, dataProvider = "Registration", priority = 0)
    public void verifyUserShouldRegisterWithValidData(String firstName, String lastName, String dayOfBirth, String birthMonth, String birthYear, String companyName, String enterPassword, String enterConfirmPassword) {
        homePage.clickOnRegisterFeature();
        registerPage.register(firstName, lastName, dayOfBirth, birthMonth, birthYear, companyName, enterPassword, enterConfirmPassword);
        registerPage.enterEmailId(emailId);
        registerPage.clickOnRegistrationButton();
        softAssert.assertEquals("Your registration completed", registerPage.registrationCompleteMessage());
        softAssert.assertAll();
    }


    @Test(groups = {"regression"}, dataProvider = "Registration", priority = 1)
    public void verifyUserShouldNotRegisterWithInvalidData(String firstName, String lastName, String dayOfBirth, String birthMonth, String birthYear, String companyName, String enterPassword, String enterConfirmPassword) {
        homePage.clickOnRegisterFeature();
        registerPage.register(firstName, lastName, dayOfBirth, birthMonth, birthYear, companyName, enterPassword, enterConfirmPassword);
        registerPage.enterEmailId(emailId);
        registerPage.clickOnRegistrationButton();
        softAssert.assertEquals("Your registration completed", registerPage.registrationCompleteMessage());
        softAssert.assertAll();
    }
}
