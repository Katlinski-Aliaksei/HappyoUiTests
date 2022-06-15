package pages;

import base.BaseMobilePage;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import io.qameta.allure.Step;
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
    @iOSXCUITFindBy(iOSClassChain = "**/XCUIElementTypeOther[`label == \"Save video\"`]")
    protected MobileElement saveVideoButton;
    @iOSXCUITFindBy(iOSClassChain = "**/XCUIElementTypeButton[`label == \"Save to Files\"`]")
    protected MobileElement saveToFilesButton;
    @iOSXCUITFindBy(iOSClassChain = "**/XCUIElementTypeButton[`label == \"Сохранить\"`]")
    protected MobileElement confirmSaveButton;

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

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeNavigationBar[@name=\"UIActivityContentView\"]/XCUIElementTypeOther/child::XCUIElementTypeOther")
    protected MobileElement previewVideoLink;
    @iOSXCUITFindBy(iOSClassChain = "**/XCUIElementTypeButton[`label == \"Close\"`]")
    protected MobileElement closeToolWindow;
    @iOSXCUITFindBy(iOSClassChain = "**/XCUIElementTypeCell[`label == \"Messages\"`]")
    protected MobileElement messagesButton;
    @iOSXCUITFindBy(iOSClassChain = "**/XCUIElementTypeCell[`label == \"Telegram\"`]/XCUIElementTypeOther/XCUIElementTypeOther[2]")
    protected MobileElement telegramButton;
    @iOSXCUITFindBy(iOSClassChain = "**/XCUIElementTypeButton[`label == \"Save to Files\"`]")
    protected MobileElement saveToFileLinkButton;
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeTextField[@name=\"messageBodyField\"]")
    protected MobileElement messageBodyField;
    @iOSXCUITFindBy(iOSClassChain = "**/XCUIElementTypeButton[`label == \"Отменить\"`]")
    protected MobileElement cancelButton;


    public ProfilePage(AppiumDriver<MobileElement> driver) {
        super(driver);
    }

    @Step("Click Settings Profile Button")
    public ProfilePage openProfileSettings() {
        waiters.waitSomeSecond(3);
        element(settingsProfileButton).clickElement();

        return this;
    }

    @Step("Click LogOut Button")
    public ProfilePage clickLogOutButton() {
        waiters.waitSomeSecond(2);
        element(logOutButton).clickElement();

        return this;
    }

    @Step("Click Yes Button")
    public ProfilePage clickYesButton() {
        element(yesButton).clickElement();

        return this;
    }

    @Step("Settings Profile Button Visibility Check")
    public boolean profileTestAccountIsVisible() {
        return element(settingsProfileButton).isDisplayed();
    }

    @Step("Click Created Button")
    public ProfilePage clickCreatedButton() {
        element(createdButton).clickElement();

        return this;
    }

    @Step("Click Completed Button")
    public ProfilePage clickCompletedButton() {
        element(completedButton).clickElement();

        return this;
    }

    @Step("Click Confirm Button")
    public ProfilePage clickConfirmButton() {
        element(confirmButton).clickElement();

        return this;
    }

    @Step("Click Confirm Button")
    public ProfilePage clickConfirmInSettingsButton() {
        element(confirmInSettingsButton).clickElement();

        return this;
    }

    public ProfilePage clickDeleteGameButton() {
        element(deleteGameButton).clickElement();

        return this;
    }

    @Step("Click Delete Competition Button")
    public ProfilePage clickDeleteCompetitionButton() {
        element(deleteMyCompetitionButton).clickElement();

        return this;
    }

    @Step("Tap on Video")
    public ProfilePage clickVideo() {
        try {
            element(video).clickElement();
        } catch (Exception e) {
            System.out.println("Video isn't visible");
        }
        return this;
    }

    @Step("Click Settings Created Video Button")
    public ProfilePage clickSettingsCreatedVideoButton() {
        element(settingsCreatedVideoButton).clickElement();

        return this;
    }

    @Step("Click Settings Completed Video Button")
    public ProfilePage clickSettingsCompletedVideoButton() {
        element(settingsCompletedVideoButton).clickElement();

        return this;
    }

    @Step("Click Back Button")
    public ProfilePage clickBackButton() {
        try {
            element(backButton).clickElement();
        } catch (Exception e) {
            LOGGER.info("Element isn't visible");
        }

        return this;
    }

    @Step("New Test Video Visibility Check")
    public boolean testVideoIsVisible() {
        element().refreshPage();
        waiters.waitSomeSecond(3);

        return element(video).isDisplayed();
    }

    @Step("Click Arrow Button")
    public ProfilePage clickArrowButton() {
        element(arrowButton).clickElement();

        return this;
    }

    @Step("Arrow Button Visibility Check")
    public boolean arrowButtonIsVisible() {
        return element(arrowButton).isDisplayed();
    }

    @Step("Click Invite To A Game Button")
    public ProfilePage clickInviteToGameButton() {
        element(inviteToGameButton).clickElement();

        return this;
    }

    @Step("Click Invite To A Game Button in Settings")
    public ProfilePage clickInviteToGameInSettingsButton() {
        element(inviteToGameInSettingsButton).clickElement();

        return this;
    }

    @Step("Choose User from List To Invite To A Game")
    public ProfilePage selectUserToInviteToGame(String name) {
        String value = replaceUserName.replace("replace", name);
        element(By.xpath(value)).clickElement();
        System.out.println(value);

        return this;
    }

    @Step("Notification after Sending Invite To A Game Visibility Checking")
    public boolean notificationIsVisible() {
        return element(textNotification).isDisplayed();
    }

    @Step("Click Share Button")
    public ProfilePage clickShareLinkButton() {
        element(shareLinkButton).clickElement();

        return this;
    }

    @Step("Choose Messages Tool for Sharing Game")
    public ProfilePage chooseMessageTool() {
        element(messagesButton).clickElement();

        return this;
    }

    @Step("Preview Link Video Visibility Check")
    public boolean previewVideoLinkIsVisible() {
        return element(previewVideoLink).isDisplayed();
    }

    @Step("Text message contains Link Check")
    public String textMessageContainsVideoLink() {
        return element(messageBodyField).getText();
    }

    @Step("Click Close Tool Window Button")
    public ProfilePage clickCloseToolWindow() {
        element(closeToolWindow).clickElement();

        return this;
    }

    @Step("Click Cancel Button")
    public ProfilePage clickCancelButton() {
        element(cancelButton).clickElement();

        return this;
    }

    @Step("click Save Button")
    public ProfilePage clickSaveVideoButton() {
        element(saveVideoButton).clickElement();

        return this;
    }

    @Step("Click save To files Button")
    public ProfilePage clickSaveToFilesButton() {
        element(saveToFilesButton).clickElement();

        return this;
    }

    @Step("Click confirm Save Button")
    public ProfilePage clickConfirmSaveButton() {
        element(confirmSaveButton).clickElement();

        return this;
    }
}
