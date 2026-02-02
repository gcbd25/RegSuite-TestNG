package base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.testng.annotations.*;
import pages.LogPage;
import utils.ConfigFileReader;

import java.io.File;


public class BaseClass {
    public ConfigFileReader reader = new ConfigFileReader();
    protected WebDriver driver;
    @BeforeMethod
    public void setUp() {
        //ConfigFileReader reader = new ConfigFileReader();
        switch (reader.getBrowser()) {
            case "Chrome": {
                ChromeOptions options = new ChromeOptions();
                options.addArguments("--start-maximized");
                driver = new ChromeDriver(options);
                break;
            }
            case "Edge": {
                System.setProperty("webdriver.edge.driver", "..//testNG-Practice//Drivers//edgedriver_win64//msedgedriver.exe");
                EdgeOptions options = new EdgeOptions();
                options.addArguments("--start-maximized");
                driver = new EdgeDriver(options);
                break;
            }
            case "Firefox": {
                FirefoxOptions options = new FirefoxOptions();
                options.addArguments("--start-maximized");
                driver = new FirefoxDriver(options);
                break;
            }
            default:
                driver.quit();
                break;
        }

    }

    @AfterMethod
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }



}
