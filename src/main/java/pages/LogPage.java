package pages;

import io.qameta.allure.Allure;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import utils.Screenshot;
import utils.Waits;

public class LogPage {
    private final WebDriver driver;
    private final Screenshot sc;
    private final Waits wait;
    //Xpaths
    private final By usernameFieldLogIn = By.id("username");
    private final By passwordFieldLogIn = By.id("password");
    private final By loginButton = By.name("login");
    private final By myAccNav = By.xpath("//a[normalize-space()='My Account']");
    private final By errorLogIn = By.cssSelector("ul[class='woocommerce-error'] li");
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
}
