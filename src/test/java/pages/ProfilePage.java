package pages;

import base.BaseMobilePage;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import org.openqa.selenium.By;

public class ProfilePage extends BaseMobilePage {
    private final String containsNameSettingButton = "(//XCUIElementTypeOther[contains(@name,'replace')][1]/XCUIElementTypeOther[3])[1]";
    private final String replaceUserName = "//XCUIElementTypeOther[@name='replace']";

    @iOSXCUITFindBy(iOSClassChain = "**/XCUIElementTypeOther[`label == \"settings-icon\"`][2]")
    private MobileElement settingsProfileButton;
    @iOSXCUITFindBy(iOSClassChain = "**/XCUIElementTypeOther[`label == \"Logout\"`]")
    protected MobileElement logOutButton;
    @iOSXCUITFindBy(iOSClassChain = "**/XCUIElementTypeButton[`label == \"Yes\"`]")
    protected MobileElement yesButton;
    @iOSXCUITFindBy(xpath = "(//XCUIElementTypeOther[@name=\"Invite to game\"])[2]/XCUIElementTypeOther[2]")
    protected MobileElement confirmButton;
    @iOSXCUITFindBy(xpath = "(//XCUIElementTypeOther[@name=\"Invite to game\"])/XCUIElementTypeOther[2]")
    protected MobileElement confirmInSettingsButton;
    @iOSXCUITFindBy(iOSClassChain = "**/XCUIElementTypeOther[`label == \"Created\"`]")
    protected MobileElement createdButton;
    @iOSXCUITFindBy(iOSClassChain = "**/XCUIElementTypeOther[`label == \"Completed\"`]")
    protected MobileElement completedButton;
    @iOSXCUITFindBy(iOSClassChain = "**/XCUIElementTypeOther[`label == \"Delete game\"`]")
    protected MobileElement deleteGameButton;
    @iOSXCUITFindBy(iOSClassChain = "**/XCUIElementTypeOther[`label == \"Delete my completion\"`]")
    protected MobileElement deleteMyCompetitionButton;
    @iOSXCUITFindBy(xpath = "(//XCUIElementTypeOther[@name=\"Invite to game\"])[1]")
    protected MobileElement inviteToGameButton;
    @iOSXCUITFindBy(xpath = "(//XCUIElementTypeOther[@name=\"Invite to game\"])[5]")
    protected MobileElement inviteToGameInSettingsButton;
    @iOSXCUITFindBy(iOSClassChain = "**/XCUIElementTypeOther[`label == \"Share link\"`]")
    protected MobileElement shareLinkButton;
    @iOSXCUITFindBy(iOSClassChain = "**/XCUIElementTypeOther[`label == \"Create ō-chain\"`]")
    protected MobileElement createChainButton;
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeOther[@name=\"Done\"]/parent::XCUIElementTypeOther" +
            "/parent::XCUIElementTypeOther/preceding-sibling::XCUIElementTypeOther[1]")
    protected MobileElement arrowButton;
    @iOSXCUITFindBy(iOSClassChain = "**/XCUIElementTypeStaticText[`label == \"Invitations sent\"`]")
    protected MobileElement textNotification;

    //TODO refactoring locator
    @iOSXCUITFindBy(xpath = "(//XCUIElementTypeOther[@name=\"Created Completed\"])[1]" +
            "/following-sibling::XCUIElementTypeOther/descendant::XCUIElementTypeOther[5]")
    protected MobileElement video;
    @iOSXCUITFindBy(xpath = "(//XCUIElementTypeOther[@name=\"Vertical scroll bar, 1 page\"])[2]" +
            "/preceding-sibling::XCUIElementTypeOther[2]")
    protected MobileElement settingsCreatedVideoButton;
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeOther[@name=\"Done\"]/parent::XCUIElementTypeOther/parent::XCUIElementTypeOther" +
            "/following::XCUIElementTypeOther[2]")
    protected MobileElement settingsCompletedVideoButton;
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeOther[@name=\"Done\"]/parent::XCUIElementTypeOther/parent::XCUIElementTypeOther" +
            "/following::XCUIElementTypeOther[1]")
    protected MobileElement backButton;


    public ProfilePage(AppiumDriver<MobileElement> driver) {
        super(driver);
    }

    public ProfilePage openProfileSettings() {
        waiters.waitSomeSecond(3);
        element(settingsProfileButton).clickElement();

        return this;
    }

    public ProfilePage clickLogOutButton() {
        waiters.waitSomeSecond(2);
        element(logOutButton).clickElement();

        return this;
    }

    public ProfilePage clickYesButton() {
        element(yesButton).clickElement();

        return this;
    }

    public boolean profileTestAccountIsVisible() {
        return element(settingsProfileButton).isDisplayed();
    }

    public ProfilePage clickCreatedButton() {
        element(createdButton).clickElement();

        return this;
    }

    public ProfilePage clickCompletedButton() {
        element(completedButton).clickElement();

        return this;
    }

    public ProfilePage clickConfirmButton() {
        element(confirmButton).clickElement();

        return this;
    }

    public ProfilePage clickConfirmInSettingsButton() {
        element(confirmInSettingsButton).clickElement();

        return this;
    }

    public ProfilePage clickDeleteGameButton() {
        element(deleteGameButton).clickElement();

        return this;
    }

    public ProfilePage clickDeleteCompetitionButton() {
        element(deleteMyCompetitionButton).clickElement();

        return this;
    }

    public ProfilePage clickVideo() {
        element(video).clickElement();

        return this;
    }

    public ProfilePage clickSettingsCreatedVideoButton() {
        element(settingsCreatedVideoButton).clickElement();

        return this;
    }

    public ProfilePage clickSettingsCompletedVideoButton() {
        element(settingsCompletedVideoButton).clickElement();

        return this;
    }

    public ProfilePage clickBackButton() {
        try {
            element(backButton).clickElement();
        } catch (Exception e) {
            LOGGER.info("Element isn't visible");
        }

        return this;
    }

    public boolean testVideoIsVisible() {
        element().refreshPage();
        waiters.waitSomeSecond(3);

        return element(video).isDisplayed();
    }

    public ProfilePage clickArrowButton() {
        element(arrowButton).clickElement();

        return this;
    }

    public ProfilePage clickInviteToGameButton() {
        element(inviteToGameButton).clickElement();

        return this;
    }

    public ProfilePage clickInviteToGameInSettingsButton() {
        element(inviteToGameInSettingsButton).clickElement();

        return this;
    }

    public ProfilePage selectUserToInviteToGame(String name) {
        String value = replaceUserName.replace("replace", name);
        element(By.xpath(value)).clickElement();
        System.out.println(value);

        return this;
    }

    public boolean notificationIsVisible() {
        return element(textNotification).isDisplayed();
    }
}
