package pages;

import base.BaseMobilePage;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import io.qameta.allure.Step;
import pages.logIn.SignUpOrLogInPage;

public class MainPage extends BaseMobilePage {
    @iOSXCUITFindBy(iOSClassChain = "**/XCUIElementTypeButton[`label == \"tab-feed tab-feed\"`]")
    protected MobileElement mainPageButton;
    @iOSXCUITFindBy(iOSClassChain = "**/XCUIElementTypeButton[`label == \"tab-explore tab-explore\"`]")
    protected MobileElement findPageButton;
    @iOSXCUITFindBy(iOSClassChain = "**/XCUIElementTypeButton[`label == \"tab-creategame tab-creategame\"`]")
    protected MobileElement addVideoPageButton;
    @iOSXCUITFindBy(iOSClassChain = "**/XCUIElementTypeButton[`label == \"tab-activity tab-activity\"`]")
    protected MobileElement notifyPageButton;
    @iOSXCUITFindBy(iOSClassChain = "**/XCUIElementTypeButton[`label == \"tab-profile tab-profile\"`]")
    protected MobileElement profilePageButton;

    @iOSXCUITFindBy(xpath = "(//XCUIElementTypeOther[@name=\"Play\"])[2]")
    protected MobileElement playButton;
    @iOSXCUITFindBy(xpath = "(//XCUIElementTypeOther[@name=\"Play\"])[1]/parent::XCUIElementTypeOther" +
            "/parent::XCUIElementTypeOther/preceding-sibling::XCUIElementTypeOther[1]")
    protected MobileElement arrowButton;

    public MainPage(AppiumDriver<MobileElement> driver) {
        super(driver);
    }

    @Step("Click Play Button")
    public SignUpOrLogInPage clickPlayButton() {
        element(playButton).clickElement();

        return new SignUpOrLogInPage(driver);
    }

    @Step("Play button visibility check")
    public boolean playButtonIsVisible() {
        waiters.waitSomeSecond(5);

        return element(playButton).isDisplayed();
    }

    @Step("Click Profile Page Button")
    public ProfilePage openProfilePage() {
        element(profilePageButton).clickElement();

        return new ProfilePage(driver);
    }

    @Step("Click Main Page Button")
    public MainPage openMainPage() {
        element(mainPageButton).clickElement();

        return this;
    }

    @Step("Click Find Page Button")
    public FindPage openFindPage() {
        element(findPageButton).clickElement();

        return new FindPage(driver);
    }

    @Step("Click Add Video Page Button")
    public AddVideoPage openAddVideoPage() {
        element(addVideoPageButton).clickElement();

        return new AddVideoPage(driver);
    }

    @Step("Click Play Button")
    public NotifyPage openNotifyPage() {
        element(notifyPageButton).clickElement();

        return new NotifyPage(driver);
    }

    @Step("Click Arrow Button on Random Video")
    public ProfilePage clickArrowButtonOnRandomVideo() {
        element(arrowButton).clickElement();

        return new ProfilePage(driver);
    }
}
