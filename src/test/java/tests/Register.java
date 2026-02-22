package tests;

import base.BaseClass;
import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.Story;
import org.testng.annotations.Test;
import pages.LogPage;
import pages.MyAccPage;

public class Register extends BaseClass {

    @Test(priority = 1, testName = "Register-01: Validate user is not able to create account with an existent email")
    @Severity(SeverityLevel.CRITICAL)
    @Description("Verify Register functionality using a username previously registered")
    @Story("Register Page")
    public void validateRegisterWithExistentUser() throws Exception {
        driver.get(reader.getURL());
        LogPage loginPage = new LogPage(driver);
        loginPage.clickMyAcc();
        loginPage.inputUsernameRegister(reader.getValidUser());
        loginPage.inputPasswordRegister(reader.getValidPsw());
        loginPage.clickRegisterBtn();
        loginPage.errorMessageInvalidCredential(reader.getErrorMsgExistentUser());
    }

    @Test(priority = 2, testName = "Register-02: Validate user is not able to create account with empty form")
    @Severity(SeverityLevel.NORMAL)
    @Description("Verify Register functionality when Register Form is empty")
    @Story("Register Page")
    public void validateRegisterEmptyForm() throws Exception {
        driver.get(reader.getURL());
        LogPage loginPage = new LogPage(driver);
        loginPage.clickMyAcc();
        loginPage.clickRegisterBtn();
        loginPage.errorMessageInvalidCredential(reader.getErrorMsgEmptyRegisterForm());
    }

    @Test(priority = 3, testName = "Register-10: Validate password field strength validation for very weak passwords")
    @Severity(SeverityLevel.MINOR)
    @Description("Verify Register functionality for password field when user enters a very weak password")
    @Story("Register Page")
    public void validateRegisterPasswordFieldVeryWeak() throws Exception {
        driver.get(reader.getURL());
        LogPage loginPage = new LogPage(driver);
        loginPage.clickMyAcc();
        loginPage.inputPasswordRegister(reader.getVeryWeakPsw());
        loginPage.errorMessagePswStrength(reader.getErrorMsgVeryWeakPsw());
        loginPage.registerButtonNotClickable();
    }
}
