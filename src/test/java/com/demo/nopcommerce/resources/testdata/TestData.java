package com.demo.nopcommerce.resources.testdata;

import org.testng.annotations.DataProvider;

/**
 * Created by Mitul
 */
public class TestData {
    @DataProvider(name = "Login Data")
    public Object[][] getDate() {
        return new Object[][]{
                {"MittulPattel@gmail.com", "1234"}
        };
    }

    @DataProvider(name = "Invalid Data")
    public Object[][] getData() {
        return new Object[][]{
                {"MittulPattel@gmail.com", "12345"}
        };
    }

    @DataProvider(name = "Registration Data")
    public Object[][] Registration() {
        return new Object[][]{
                {"clickndRun", "run", "4", "july", "1983", "Jec limited", "clickndrun123@", "clickndrun123@"}

        };
    }

    @DataProvider(name = "invalid Registration Data")
    public Object[][] InvalidRegistration() {
        return new Object[][]{
                {"clickndRun", "run", "4", "july", "1983", "jec limited", "clickndrun123@", "clickndrun123@"}
        };

    }

}



