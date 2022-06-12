package elements;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.TouchAction;
import io.appium.java_client.touch.offset.PointOption;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.remote.RemoteWebElement;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.ITestListener;
import utils.Waiters;

import java.util.HashMap;

public class MobileUIElements extends MobileElement {
    private static final Logger LOGGER = LoggerFactory.getLogger(MobileUIElements.class);
    private final AppiumDriver<MobileElement> driver;
    private final Waiters waiters;
    private MobileElement mobileElement;
    private Dimension screenSize;


    public MobileUIElements(AppiumDriver<MobileElement> driver, Waiters waiters, MobileElement mobileElement) {
        this.driver = driver;
        this.waiters = waiters;

        this.mobileElement = mobileElement;
    }

    public MobileUIElements(AppiumDriver<MobileElement> driver, Waiters waiters) {
        this.driver = driver;
        this.waiters = waiters;
    }

    public MobileUIElements(AppiumDriver<MobileElement> driver, Waiters waiters, By by) {
        this.driver = driver;
        this.waiters = waiters;

        this.mobileElement = waiters.presenceOfElementLocated(by);
    }

    @Override
    public void setValue(String value) {
        try {
            mobileElement.clear();
            mobileElement.setValue(value);
            closeKeyboard();
        } catch (Exception e) {
            LOGGER.info("Can't set value: " + e);
        }
    }

    public void clickElement() {
        waiters.waitForClickable(mobileElement).click();
    }

    public boolean isDisplayed() {
        try {
            return waiters.waitForVisibility(mobileElement).isDisplayed();
        } catch (TimeoutException e) {
            return false;
        }
    }

    public String getText() {
        return waiters.waitForVisibility(mobileElement).getText();
    }

    public void closeKeyboard() {
        By findTitleStrategy = By.xpath("(//ion-title)[last()]/div");
        MobileElement clickPoint;

        if (waiters.isElementExist(findTitleStrategy)) {
            clickPoint = driver.findElement(findTitleStrategy);
            waiters.waitForElementClickable(clickPoint);
            clickPoint.click();
            clickPoint.click();
        } else {
            Dimension windowSize = driver.manage().window().getSize();
            double width = windowSize.getWidth();
            double height = windowSize.getHeight();

            int pointX = (int) (width / 2);
            int pointY = (int) (height * 0.1);

            new TouchAction<>(driver)
                    .longPress(PointOption.point(pointX, pointY))
                    .perform()
                    .release();
        }

        //TODO. Replace with waiting for the keyboard to close
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public MobileUIElements scrollPageOrSwipeElement(String elementID, String direction) {
        HashMap<String, String> scrollObject = new HashMap<>();
        scrollObject.put("element", elementID);
        scrollObject.put("direction", direction);
        driver.executeScript("mobile:scroll", scrollObject);

        return this;
    }

    public MobileUIElements scrollPage() {
        RemoteWebElement element = driver.findElement(By.className("XCUIElementTypeOther"));
        String elementID = element.getId();
        scrollPageOrSwipeElement(elementID, "down");

        return this;
    }

    public MobileUIElements refreshPage() {
        RemoteWebElement element = driver.findElement(By.className("XCUIElementTypeOther"));
        String elementID = element.getId();
        scrollPageOrSwipeElement(elementID, "up");

        return this;
    }

    public MobileUIElements swipeElement(String xpath, String direction) {
        MobileElement element = driver.findElement(By.xpath(xpath));
        String elementID = element.getId();
        scrollPageOrSwipeElement(elementID, direction);

        return this;
    }
}
