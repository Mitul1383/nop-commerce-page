package com.demo.nopcommerce.testsuite;

import com.demo.nopcommerce.excelutility.ExcelUtility;
import com.demo.nopcommerce.pages.HomePage;
import com.demo.nopcommerce.pages.LoginPage;
import com.demo.nopcommerce.testbase.TestBase;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

/**
 * Created by Mitul
 */
public class LoginTestWithExcelFile extends TestBase {

    public static final String File_path = System.getProperty("user.dir") + "/src/test/java/com/demo/nopcommerce/resources/testdata/JustTest.xlsx";

    HomePage homePage;
    LoginPage loginPage;
    SoftAssert softAssert;

    @BeforeMethod
    public void setUp(){
        homePage = new HomePage();
         loginPage = new LoginPage();
         softAssert = new SoftAssert();
    }


    @BeforeClass
    public void setExcel() {
        try {
            ExcelUtility.setExcelFile(File_path, "Valid Login Test");
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    @DataProvider(name = "Login Test")
    public Object[][] getData() {
        Object[][] data = ExcelUtility.getTestData("Login");
        return data;
    }

    @Test(groups = {"sanity"}, dataProvider = "Login Test", priority = 1)
    public void verifyUserShouldLoginSuccessfully(String username, String password) {
        homePage.clickOnLoginFeature();
        loginPage.logToApp(username, password);
        softAssert.assertEquals("Welcome to our store", loginPage.welcomeToStore());
        softAssert.assertAll();
    }


}
