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
    @iOSXCUITFindBy(xpath = "(//XCUIElementTypeOther[@name=\"\uD83D\uDC4D testaccount testaccount\"])[3]")
    protected MobileElement reactionFromTestAccount;
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeOther[@name=\"Today\"]/following-sibling::XCUIElementTypeOther[1]")
    protected MobileElement lastReactionToday;
    //"testaccount reacted 👍 to your completion at AUTOTEST 8 minutes ago"
    @iOSXCUITFindBy(iOSClassChain = "**/XCUIElementTypeOther[`label == \"DECLINE\"`][1]/XCUIElementTypeOther[1]")
    protected MobileElement viewButton;
    @iOSXCUITFindBy(iOSClassChain = "**/XCUIElementTypeOther[`label == \"DECLINE\"`][2]")
    protected MobileElement declineButton;


    public NotifyPage(AppiumDriver<MobileElement> driver) {
        super(driver);
    }

    @Step("Click Notification Button on Notification Page Button")
    public NotifyPage clickNotificationButton() {
        element(notificationButton).clickElement();

        return this;
    }

    @Step("Checking visibility notification button")
    public boolean notificationButtonIsVisible() {
        return element(notificationButton).isDisplayed();
    }

    @Step("Click View Button")
    public NotifyPage clickViewButton() {
        element(viewButton).clickElement();

        return this;
    }

    @Step("View Button Visibility Check")
    public boolean viewButtonIsVisible() {
        element().refreshPage();
        waiters.waitSomeSecond(3);

        return element(viewButton).isDisplayed();
    }

    @Step("Decline Button Click")
    public NotifyPage clickDeclineButton() {
        element(declineButton).clickElement();

        return this;
    }
}
