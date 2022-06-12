package utils;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.functions.AppiumFunction;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.time.Duration;

import static org.openqa.selenium.support.ui.ExpectedConditions.elementToBeClickable;

public class Waiters {
    protected static final Logger LOGGER = LoggerFactory.getLogger(Waiters.class);
    public static final long IMPLICITLY_WAIT = 15L;
    protected static final long EXPLICITLY_WAIT = 5L;

    private static Waiters instance;
    AppiumDriver<MobileElement> driver;

    public Waiters(AppiumDriver<MobileElement> driver) {
        this.driver = driver;
    }

    public MobileElement waitForClickable(MobileElement by) {
        return (MobileElement) waiter().until(elementToBeClickable(by));
    }

    private FluentWait<AppiumDriver<MobileElement>> waiter() {
        return new FluentWait<>(driver)
                .withTimeout(Duration.ofSeconds(IMPLICITLY_WAIT))
                .ignoring(ElementNotInteractableException.class)
                .ignoring(InvalidElementStateException.class)
                .ignoring(StaleElementReferenceException.class)
                .ignoring(NoSuchElementException.class);
    }

    public void waitForAlert() {
        waiter(EXPLICITLY_WAIT).until(ExpectedConditions.alertIsPresent());
    }

    public MobileElement getElementAfterWaitForVisibility(MobileElement mobileElement) {
        return (MobileElement) waiter(EXPLICITLY_WAIT).until(ExpectedConditions.visibilityOf(mobileElement));
    }

    public MobileElement waitForVisibility(By by) {
        return (MobileElement) waiter().until(ExpectedConditions.visibilityOfElementLocated(by));
    }

    public MobileElement waitForVisibility(MobileElement mobileElement) {
        return (MobileElement) waiter().until(ExpectedConditions.visibilityOf(mobileElement));
    }

    public MobileElement waitForElementClickable(MobileElement element) {
        return (MobileElement) waiter(EXPLICITLY_WAIT).until(elementToBeClickable(element));
    }

    public MobileElement waitForElementClickable(MobileElement element, Long duration) {
        return (MobileElement) waiter(duration).until(elementToBeClickable(element));
    }

    public void waitForChangeAttribute(By by, String attribute, String attributeValue) {
        waiter(EXPLICITLY_WAIT).until(ExpectedConditions.attributeContains(by, attribute, attributeValue));
    }

    public void waitForElementVisibleNot(By byElement) {
        waitUntilFunctionIsTrue(func -> !isElementExist(byElement));
    }


    public boolean isElementExist(By locator) {
        var allElements = driver.findElements(locator);
        return allElements != null && !allElements.isEmpty();
    }

    public boolean isElementExist(MobileElement element, Long duration) {
        new WebDriverWait(driver, duration).until(ExpectedConditions.visibilityOf(element));
        return element.isDisplayed();
    }

    public void waitUntilFunctionIsTrue(AppiumFunction<AppiumDriver<MobileElement>, Object> function) {
        waiter(EXPLICITLY_WAIT).until(function);
    }

    protected void waitUntilFunctionIsTrue(AppiumFunction<AppiumDriver<MobileElement>, Object> function, String errorMessage) {
        waiter(errorMessage).until(function);
    }

    private FluentWait<AppiumDriver<MobileElement>> waiter(Long duration) {
        return new FluentWait<>(driver)
                .withTimeout(Duration.ofSeconds(duration))
                .ignoring(ElementNotInteractableException.class)
                .ignoring(InvalidElementStateException.class)
                .ignoring(StaleElementReferenceException.class)
                .ignoring(NoSuchElementException.class);
    }

    private FluentWait<AppiumDriver<MobileElement>> waiter(String errorMessage) {
        return waiter(EXPLICITLY_WAIT)
                .withMessage(errorMessage + "\nWait timeout: " + EXPLICITLY_WAIT + " seconds.\n");
    }

    public void waitSomeSecond(Integer seconds) {
        int timeOnMills = seconds * 1000;
        try {
            Thread.sleep(timeOnMills);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public MobileElement presenceOfElementLocated(By by) {
        return (MobileElement) waiter().until(ExpectedConditions.presenceOfElementLocated(by));
    }
}

