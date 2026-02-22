package pages;

import io.qameta.allure.Allure;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import utils.Screenshot;
import utils.Waits;

public class LogPage {
    private final WebDriver driver;
    private final Screenshot sc;
    private final Waits wait;
    //Locators
    private final By usernameFieldLogIn = By.id("username");
    private final By passwordFieldLogIn = By.id("password");
    private final By loginButton = By.name("login");
    private final By myAccNav = By.xpath("//a[normalize-space()='My Account']");
    private final By errorLogIn = By.cssSelector("ul[class='woocommerce-error'] li");
    private final By usernameFieldRegister = By.id("reg_email");
    private final By passwordFieldRegister = By.id("reg_password");
    private final By registerButton = By.name("register");
    private final By errorStrengthPsw = By.xpath("//div[@class='woocommerce-password-strength short']");
    //Constructors
    public LogPage(WebDriver driver) {
        this.driver = driver;
        sc = new Screenshot();
        wait = new Waits(driver);
    }

    @Step
    public void clickMyAcc() throws Exception {
        try {
            wait.waitPresenceOfElementLocated(myAccNav);
            Allure.step("Click 'My account' on Nav Bar");
            driver.findElement(myAccNav).click();
        }catch(Exception e) {
            sc.screenshot("Error on step, not able to click My Acc",driver);
            Assert.fail("Step failed: unable to locate element" + myAccNav);
        }
    }

    @Step
    public void inputUsernameLogIn(String user) throws Exception {
        try {
            wait.waitPresenceOfElementLocated(usernameFieldLogIn);
            driver.findElement(usernameFieldLogIn).sendKeys(user);
            Allure.step("Add " + user + " on Username field");
            sc.screenshot("Add User",driver);
        }catch(Exception e) {
            sc.screenshot("Error on step, not able to locate field",driver);
            Assert.fail("Step failed: unable to locate element" + usernameFieldLogIn);
        }
    }

    @Step
    public void inputPasswordLogIn(String psw) throws Exception {
        try {
            wait.waitPresenceOfElementLocated(passwordFieldLogIn);
            driver.findElement(passwordFieldLogIn).sendKeys(psw);
            Allure.step("Add " + psw + " on Password field");
            sc.screenshot("Add Password",driver);
        }catch(Exception e) {
            sc.screenshot("Error on step, not able to locate field",driver);
            Assert.fail("Step failed: unable to locate element" + passwordFieldLogIn);
        }
    }

    @Step
    public void clickLogInBtn() throws Exception{
        try {
            wait.waitElementToBeClickable(loginButton);
            driver.findElement(loginButton).click();
            Allure.step("Click LogIn Button");
            sc.screenshot("Click LogIn Button",driver);
        }catch(Exception e) {
            sc.screenshot("Error on step, not able to locate element",driver);
            Assert.fail("Step failed: unable to locate element" + loginButton);

        }

    }

    @Step
    public void errorMessageInvalidCredential(String errorMsg) throws Exception{
        try {
            wait.waitPresenceOfElementLocated(errorLogIn);
            Allure.step("Validate error message");
            Assert.assertTrue(driver.findElement(errorLogIn).getText().contains(errorMsg));
            sc.screenshot("Error message after login",driver);
        }catch(Exception e) {
            sc.screenshot("Error on step, assertion error",driver);
            Assert.fail("Step failed: error in assertion on element " + errorLogIn);

        }

    }

    @Step
    public void inputUsernameRegister(String user) throws Exception {
        try {
            wait.waitPresenceOfElementLocated(usernameFieldRegister);
            driver.findElement(usernameFieldRegister).sendKeys(user);
            Allure.step("Add " + user + " on Username field");
            sc.screenshot("Add User",driver);
        }catch(Exception e) {
            sc.screenshot("Error on step, not able to locate field",driver);
            Assert.fail("Step failed: unable to locate element" + usernameFieldRegister);
        }
    }

    @Step
    public void inputPasswordRegister(String psw) throws Exception {
        try {
            wait.waitPresenceOfElementLocated(passwordFieldRegister);
            driver.findElement(passwordFieldRegister).sendKeys(psw);
            Allure.step("Add " + psw + " on Password field");
            sc.screenshot("Add Password",driver);
        }catch(Exception e) {
            sc.screenshot("Error on step, not able to locate field",driver);
            Assert.fail("Step failed: unable to locate element" + passwordFieldRegister);
        }
    }

    @Step
    public void clickRegisterBtn() throws Exception{
        try {
            wait.waitElementToBeClickable(registerButton);
            driver.findElement(registerButton).click();
            Allure.step("Click Register Button");
            sc.screenshot("Click Register Button",driver);
        }catch(Exception e) {
            sc.screenshot("Error on step, not able to locate element",driver);
            Assert.fail("Step failed: unable to locate element" + registerButton);

        }
    }

    @Step
    public void errorMessagePswStrength(String errorMsg) throws Exception{
        try {
            //driver.findElement(registerButton).sendKeys(Keys.ENTER);
            wait.waitPresenceOfElementLocated(errorStrengthPsw);
            Allure.step("Validate error message");
            Assert.assertTrue(driver.findElement(errorStrengthPsw).getText().contains(errorMsg));
            sc.screenshot("Error message on password field",driver);
        }catch(Exception e) {
            sc.screenshot("Error on step, assertion error",driver);
            Assert.fail("Step failed: error in assertion on element " + errorLogIn);
        }
    }

    @Step
    public void registerButtonNotClickable() throws Exception{
        try {
            if(driver.findElement(registerButton).isEnabled()){
                Assert.fail();
            }else {
                Allure.step("Button not clickable");
            }
        }catch(Exception e) {
            sc.screenshot("Error on step, assertion error",driver);
            Assert.fail("Step failed: error in assertion on element " + errorLogIn);
        }
    }



}
