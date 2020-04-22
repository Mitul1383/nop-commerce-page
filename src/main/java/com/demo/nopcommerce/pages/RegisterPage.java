package com.demo.nopcommerce.pages;

import com.demo.nopcommerce.Utility.Utility;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Reporter;

/**
 * Created by Mitul
 */
public class RegisterPage extends Utility {


    private static final Logger log = LogManager.getLogger(RegisterPage.class.getName());

    @FindBy(xpath = "//strong[contains(text(),'Your Personal Details')]")
    WebElement _welcomeRegisterText;
    @FindBy(id = "gender-male")
    WebElement _clickOnRadio;
    @FindBy(id = "FirstName")
    WebElement _firstName;
    @FindBy(id = "LastName")
    WebElement _lastName;
    @FindBy(name = "DateOfBirthDay")
    WebElement _dayOfBirth;
    @FindBy(name = "DateOfBirthMonth")
    WebElement _dateOfBirthMonth;
    @FindBy(name = "DateOfBirthYear")
    WebElement _dateOfBirthYear;
    @FindBy(id = "Email")
    WebElement _email;
    @FindBy(id = "Company")
    WebElement _companyName;
    @FindBy(id = "Newsletter")
    WebElement _newsLetterCheckBox;
    @FindBy(id = "Password")
    WebElement _password;
    @FindBy(id = "ConfirmPassword")
    WebElement _confirmPassword;
    @FindBy(id = "register-button")
    WebElement _registerButton;
    @FindBy(className = "result")
    WebElement _confirmRegistrationMessage;


    public String getRegisterMessage() {
        Reporter.log("Getting Register message " + _welcomeRegisterText.toString() + "<br>");
        log.info("Getting Register message " + _welcomeRegisterText.toString());
        return getTextFromElement(_welcomeRegisterText);
    }

    public void clickOnRadioButton() {
        Reporter.log("Clicking on Radio Button " + _clickOnRadio.toString() + "<br>");
        clickOnElement(_clickOnRadio);
        log.info("Clicking on Radio Button " + _clickOnRadio.toString());
    }

    public void enterFirstName(String firstName) {
        Reporter.log("Enter First Name " + firstName + "First Name Field " + _firstName.toString() + "<br>");
        sendTextToElement(_firstName, firstName);
        log.info("Enter First Name " + firstName + "First Name Field " + _firstName.toString());
    }

    public void enterLastName(String lastName) {
        Reporter.log("Enter Last Name " + lastName + "Last Name Field " + _lastName.toString() + "<br>");
        sendTextToElement(_lastName, lastName);
        log.info("Enter Last Name " + lastName + "Last Name Field " + _lastName.toString());
    }

    public void selectDayOfBirth(String dayOfBirth) {
        Reporter.log("Selecting Date of Birth Day " + dayOfBirth + "Date Field " + _dayOfBirth.toString() + "<br>");
        selectByVisibleTextFromDropDown(_dayOfBirth, dayOfBirth);
        log.info("Selecting Date of Birth Day " + dayOfBirth + "Date Field " + _dayOfBirth.toString());
    }

    public void selectDateOfBirthMonth(String month) {
        Reporter.log("Selecting Date of Birth Month " + month + "Birth Month Field " + _dateOfBirthMonth.toString() + "<br>");
        sendTextToElement(_dateOfBirthMonth, month);
        log.info("Selecting Date of Birth Month " + month + "Birth Month Field " + _dateOfBirthMonth.toString());
    }

    public void selectDateOfBirthYear(String year) {
        Reporter.log("Selecting Date of Birth Year " + year + "Birth Year Field " + _dateOfBirthYear.toString() + "<br>");
        selectByVisibleTextFromDropDown(_dateOfBirthYear, year);
        log.info("Selecting Date of Birth Year " + year + "Birth Year Field " + _dateOfBirthYear.toString());
    }

    public void enterEmailId(String email1) {
        Reporter.log("Enter Email " + email1 + "Email Field " + _email.toString() + "<br>");
        sendTextToElement(_email, email1);
        log.info("Enter Email " + email1 + "Email Field " + _email.toString());
    }

    public void enterCompanyName(String companyName) {
        Reporter.log("Enter Company Name " + companyName + "Company Name Field " + _companyName.toString() + "<br>");
        sendTextToElement(_companyName, companyName);
        log.info("Enter Company Name " + companyName + "Company Name Field " + _companyName.toString());
    }

    public void selectCheckBoxOfNewsLetter() {
        Reporter.log("Clicking on check box button for NewsLetter " + _newsLetterCheckBox.toString() + "<br>");
        clickOnElement(_newsLetterCheckBox);
        log.info("Clicking on check box button for NewsLetter");
    }

    public void enterPassword(String password) {
        Reporter.log("Enter Password " + password + "On Password Field" + _password.toString() + "<br>");
        sendTextToElement(_password, password);
        log.info("Enter Password " + password + "On Password Field " + _password.toString());
    }

    public void enterConfirmPassword(String confirmPassword) {
        Reporter.log("Enter Confirm Password " + confirmPassword + "Confirm Password Field " + _confirmPassword.toString() + "<br>");
        sendTextToElement(_confirmPassword, confirmPassword);
        log.info("Enter Confirm Password " + confirmPassword + "Confirm Password Field " + _confirmPassword.toString());
    }

    public void clickOnRegistrationButton() {
        Reporter.log("Clicking On Registration Button " + _registerButton.toString() + "<br>");
        clickOnElement(_registerButton);
        log.info("Clicking On Registration Button " + _registerButton.toString());
    }

    public String registrationCompleteMessage() {
        Reporter.log("Getting Registration Complete Message " + _confirmRegistrationMessage.toString() + "<br>");
        log.info("Getting Registration Complete Message " + _confirmRegistrationMessage.toString());
        return getTextFromElement(_confirmRegistrationMessage);
    }

    public void register(String firstName, String lastName, String dayOfBirth, String birthMonth, String birthYear, String companyName, String enterPassword, String enterConfirmPassword) {
        clickOnRadioButton();
        enterFirstName(firstName);
        enterLastName(lastName);
        selectDayOfBirth(dayOfBirth);
        selectDateOfBirthMonth(birthMonth);
        selectDateOfBirthYear(birthYear);
        enterCompanyName(companyName);
        selectCheckBoxOfNewsLetter();
        enterPassword(enterPassword);
        enterConfirmPassword(enterConfirmPassword);
    }


}
