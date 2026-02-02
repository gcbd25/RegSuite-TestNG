package utils;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;

import java.time.Duration;

public class Waits {
    private final WebDriver driver;


    public Waits(WebDriver driver) {
        this.driver = driver;

    }
    /*
    Author: Gerardo Bravo
    Function: Implemented to wait for the visibility of an specific element
     */
    public void waitVisibilityOfElementLocated (By element) {
        Wait<WebDriver> wait = new FluentWait<WebDriver>(driver).withTimeout(Duration.ofSeconds(30L)).pollingEvery(Duration.ofSeconds(5L)).ignoring(NoSuchElementException.class);
        wait.until(ExpectedConditions.visibilityOfElementLocated(element));
    }
    /*
    Author: Gerardo Bravo
    Function: Implemented to wait for an element to be clickable
     */
    public void waitElementToBeClickable (By element) {
        Wait<WebDriver> wait = new FluentWait<WebDriver>(driver).withTimeout(Duration.ofSeconds(30L)).pollingEvery(Duration.ofSeconds(5L)).ignoring(NoSuchElementException.class);
        wait.until(ExpectedConditions.elementToBeClickable(element));
    }
    /*
    Author: Gerardo Bravo
    Function: Implemented to wait for an element to be located
     */
    public void waitPresenceOfElementLocated (By element) {
        Wait<WebDriver> wait = new FluentWait<WebDriver>(driver).withTimeout(Duration.ofSeconds(30L)).pollingEvery(Duration.ofSeconds(5L)).ignoring(NoSuchElementException.class);
        wait.until(ExpectedConditions.presenceOfElementLocated(element));
    }
}
