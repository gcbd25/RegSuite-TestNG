package utils;

import io.qameta.allure.Allure;
import io.qameta.allure.Attachment;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

public class Screenshot {
    @Attachment(value = "Screenshot", type = "image/png")
    public void screenshot (String name, WebDriver driver) throws Exception {
        Allure.addAttachment(name, FileUtils.openInputStream(((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE)));
    }
}


