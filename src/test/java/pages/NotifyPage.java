package pages;

import base.BaseMobilePage;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import io.qameta.allure.Step;

public class NotifyPage extends BaseMobilePage {
    @iOSXCUITFindBy(iOSClassChain = "**/XCUIElementTypeOther[`label == \"GAMES ACTIVITY No active games yet Create games yourself and stay tuned here CREATE GAME\"`][13]")
    protected MobileElement notificationText;
    @iOSXCUITFindBy(iOSClassChain = "**/XCUIElementTypeOther[`label == \"GAMES ACTIVITY\"`]/XCUIElementTypeOther[2]")
    protected MobileElement notificationButton;

    public NotifyPage(AppiumDriver<MobileElement> driver) {
        super(driver);
    }

    @Step("Checking visibility Create Game Button")
    public boolean createGameButtonIsVisible() {
        return element(notificationText).isDisplayed();
    }

    @Step("Checking visibility notification button")
    public boolean notificationButtonIsVisible() {
        return element(notificationButton).isDisplayed();
    }
}
