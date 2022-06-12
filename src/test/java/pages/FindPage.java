package pages;

import base.BaseMobilePage;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import pages.logIn.SignUpOrLogInPage;

public class FindPage extends BaseMobilePage {
    @iOSXCUITFindBy(iOSClassChain = "**/XCUIElementTypeOther[`label == \"ALL\"`]")
    protected MobileElement allActiveGamesButton;
    @iOSXCUITFindBy(iOSClassChain = "**/XCUIElementTypeOther[`label == \"EDIT\"`]")
    protected MobileElement editYourProfileButton;
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name=\"Featured creators\"]" +
            "//following-sibling::XCUIElementTypeOther[1]")
    protected MobileElement firstPersonFromList;
    @iOSXCUITFindBy(iOSClassChain = "**/XCUIElementTypeOther[`label == \"FOLLOW\"`][2]")
    protected MobileElement followInsideProfileButton;
    @iOSXCUITFindBy(iOSClassChain = "**/XCUIElementTypeOther[`label == \"UNFOLLOW\"`][2]")
    protected MobileElement unfollowInsideProfileButton;
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeOther[@name=\"Active games ALL\"]" +
            "/following-sibling::XCUIElementTypeOther[1]/descendant::XCUIElementTypeOther[2]")
    protected MobileElement firstActiveGameVideo;


    public FindPage(AppiumDriver<MobileElement> driver) {
        super(driver);
    }

    public FindPage chooseFirstPerson() {
        element(firstPersonFromList).clickElement();

        return this;
    }

    public SignUpOrLogInPage clickFollowButton() {
        element(followInsideProfileButton).clickElement();

        return new SignUpOrLogInPage(driver);
    }

    public FindPage clickUnfollowButton() {
        element(unfollowInsideProfileButton).clickElement();

        return this;
    }

    public boolean unfollowButtonIsDisplayed() {
        return element(unfollowInsideProfileButton).isDisplayed();
    }

    public MainPage choseFirstActiveGame() {
        element(firstActiveGameVideo).clickElement();

        return new MainPage(driver);
    }
}
