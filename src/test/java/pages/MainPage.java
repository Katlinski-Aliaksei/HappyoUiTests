package pages;

import base.BaseMobilePage;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import pages.logIn.SignUpOrLogInPage;

public class MainPage extends BaseMobilePage {
    @iOSXCUITFindBy(xpath = "(//XCUIElementTypeOther[@name=\"Play\"])[2]")
    protected MobileElement playButton;
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

    public MainPage(AppiumDriver<MobileElement> driver) {
        super(driver);
    }

    public SignUpOrLogInPage clickPlayButton() {
        element(playButton).clickElement();

        return new SignUpOrLogInPage(driver);
    }

    public boolean playButtonIsVisible() {
        waiters.waitSomeSecond(5);

        return element(playButton).isDisplayed();
    }

    public ProfilePage openProfilePage() {
        element(profilePageButton).clickElement();

        return new ProfilePage(driver);
    }

    public MainPage openMainPage(){
        element(mainPageButton).clickElement();

        return this;
    }

    public FindPage openFindPage(){
        element(findPageButton).clickElement();

        return new FindPage(driver);
    }

    public AddVideoPage openAddVideoPage(){
        element(addVideoPageButton).clickElement();

        return new AddVideoPage(driver);
    }

    public NotifyPage openNotifyPage(){
        element(notifyPageButton).clickElement();

        return new NotifyPage(driver);
    }
}
