package pages;

import io.qameta.allure.Allure;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import utils.Screenshot;
import utils.Waits;

public class MyAccPage {
    private final WebDriver driver;
    private final Screenshot sc;
    private final Waits wait;
    //Locators
    private final By msgWelcome = By.xpath("//p[contains(text(),'Hello')]");
    //Constructor
    public MyAccPage(WebDriver driver) {
        this.driver = driver;
        sc = new Screenshot();
        wait = new Waits(driver);
    }
    //Steps
    @Step
    public void checkWelcomeMsg(String user) throws Exception {
        try {
            wait.waitPresenceOfElementLocated(msgWelcome);
            Allure.step("Validate welcome message");
            Assert.assertTrue(driver.findElement(msgWelcome).getText().contains(user.substring(0,user.indexOf("@"))));
            sc.screenshot("Welcome Message after LogIn",driver);
        }catch(Exception e) {
            sc.screenshot("Error on step, assertion error",driver);
            Assert.fail("Step failed: error in assertion on element " + msgWelcome);
        }
    }
}
