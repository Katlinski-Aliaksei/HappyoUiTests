package utils;

import core.AppiumDriverConfig;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.qameta.allure.Allure;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.ITestListener;
import org.testng.ITestResult;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class ListenerTest implements ITestListener {
    AppiumDriver<MobileElement> driver;

    protected void takeScreenshot() throws IOException {
        driver = AppiumDriverConfig.getDriver();
        SimpleDateFormat sdf = new SimpleDateFormat("dd.MM hh:mm:ss");
        Date date = new Date();
        String fileName = sdf.format(date);
        try {
            Allure.addAttachment(fileName, new ByteArrayInputStream(((TakesScreenshot) driver)
                    .getScreenshotAs(OutputType.BYTES)));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void onTestFailure(ITestResult result) {
        try {
            takeScreenshot();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
