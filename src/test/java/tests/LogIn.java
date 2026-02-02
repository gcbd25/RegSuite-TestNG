package tests;

import base.BaseClass;

import io.qameta.allure.*;
import org.testng.annotations.Test;
import pages.LogPage;
import pages.MyAccPage;

public class LogIn extends BaseClass {

    @Test(priority = 1, testName = "LogIn-01: Validate LogIn with valid credentials")
    @Severity(SeverityLevel.CRITICAL)
    @Description("Verify Log In functionality using valid username and password")
    @Story("LogIn Page")
    public void validateLogInValidCredentials() throws Exception {
        driver.get(reader.getURL());
        LogPage loginPage = new LogPage(driver);
        MyAccPage myAcc = new MyAccPage(driver);
        loginPage.clickMyAcc();
        loginPage.inputUsernameLogIn(reader.getValidUser());
        loginPage.inputPasswordLogIn(reader.getValidPsw());
        loginPage.clickLogInBtn();
        myAcc.checkWelcomeMsg(reader.getValidUser());
    }

    @Test(priority = 1, testName = "LogIn-02: Validate LogIn with valid username and invalid password")
    @Severity(SeverityLevel.CRITICAL)
    @Description("Verify Log In functionality using valid username and invalid password")
    @Story("LogIn Page")
    public void validateLogInInvalidPsw() throws Exception {
        driver.get(reader.getURL());
        LogPage loginPage = new LogPage(driver);
        loginPage.clickMyAcc();
        loginPage.inputUsernameLogIn(reader.getValidUser());
        loginPage.inputPasswordLogIn(reader.getInvalidPsw());
        loginPage.clickLogInBtn();
        loginPage.errorMessageInvalidCredential(reader.getErrorMsgInvalidPsw());
    }

    @Test(priority = 1, testName = "LogIn-03: Validate LogIn with invalid username and valid password")
    @Severity(SeverityLevel.CRITICAL)
    @Description("Verify Log In functionality using invalid username and valid password")
    @Story("LogIn Page")
    public void validateLogInInvalidUser() throws Exception {
        driver.get(reader.getURL());
        LogPage loginPage = new LogPage(driver);
        loginPage.clickMyAcc();
        loginPage.inputUsernameLogIn(reader.getInvalidUser());
        loginPage.inputPasswordLogIn(reader.getValidPsw());
        loginPage.clickLogInBtn();
        loginPage.errorMessageInvalidCredential(reader.getErrorMsgInvalidUser());
    }

    @Test(priority = 2, testName = "LogIn-04: Validate LogIn with valid username and empty password")
    @Severity(SeverityLevel.NORMAL)
    @Description("Verify Log In functionality using valid username and empty password")
    @Story("LogIn Page")
    public void validateLogInEmptyPsw() throws Exception {
        driver.get(reader.getURL());
        LogPage loginPage = new LogPage(driver);
        loginPage.clickMyAcc();
        loginPage.inputUsernameLogIn(reader.getValidUser());
        loginPage.clickLogInBtn();
        loginPage.errorMessageInvalidCredential(reader.getErrorMsgEmptyPsw());
    }

    @Test(priority = 2, testName = "LogIn-05: Validate LogIn empty form")
    @Severity(SeverityLevel.NORMAL)
    @Description("Verify Log In functionality with empty form")
    @Story("LogIn Page")
    public void validateLogInEmptyForm() throws Exception {
        driver.get(reader.getURL());
        LogPage loginPage = new LogPage(driver);
        loginPage.clickMyAcc();
        loginPage.clickLogInBtn();
        loginPage.errorMessageInvalidCredential(reader.getErrorMsgEmptyForm());
    }

}
