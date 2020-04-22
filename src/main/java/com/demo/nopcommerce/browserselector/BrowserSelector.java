package com.demo.nopcommerce.browserselector;

import com.demo.nopcommerce.basepage.BasePage;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.Reporter;

/**
 * Created by Mitul
 */
public class BrowserSelector extends BasePage {

    private static final Logger log = LogManager.getLogger(BrowserSelector.class.getName());

    String projectPath = System.getProperty("user.dir");
    public void selectBrowser(String browser) {
        if (browser.equalsIgnoreCase("chrome")) {
            System.setProperty("webdriver.chrome.driver", projectPath + "/drivers/chromedriver.exe");
            Reporter.log("Launching chrome browser");
            driver = new ChromeDriver();
            log.info("Launching chrome browser");
        }else if (browser.equalsIgnoreCase("firefox")){
            System.setProperty("webdriver.gecko.driver", projectPath + "/drivers/geckodriver.exe");
            Reporter.log("Launching firefox browser");
            driver = new FirefoxDriver();
            log.info("Launching firefox browser");
        }else if (browser.equalsIgnoreCase("ie")){
            System.setProperty("webdriver.ie.driver", projectPath + "/drivers/IEDriverServer.exe");
            Reporter.log("Launching IE browser");
            driver = new InternetExplorerDriver();
            log.info("Launching IE browser");
        }else{
            System.out.println("Browser is not available");
            Reporter.log("Browser is not available");
            log.info("Browser is not available");
        }
    }


}
