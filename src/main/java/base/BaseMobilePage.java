package base;

import elements.MobileUIElements;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.By;
import org.openqa.selenium.support.PageFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import utils.Waiters;


public class BaseMobilePage {
    protected static final Logger LOGGER = LoggerFactory.getLogger(BaseMobilePage.class);

    protected AppiumDriver<MobileElement> driver;
    public Waiters waiters;

    public BaseMobilePage(AppiumDriver<MobileElement> driver) {
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
        this.driver = driver;

        waiters = new Waiters(driver);
    }

    public MobileUIElements element(MobileElement mobileElement) {
        return new MobileUIElements(driver, waiters, mobileElement);
    }

    public MobileUIElements element() {
        return new MobileUIElements(driver, waiters);
    }

    public MobileUIElements element(By by) {
        return new MobileUIElements(driver, waiters, by);
    }
}