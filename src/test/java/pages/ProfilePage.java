package pages;

import base.BaseMobilePage;
import consts.TestData;
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
    @iOSXCUITFindBy(xpath = "(//XCUIElementTypeOther[@name=\"Play\"])[13]/parent::XCUIElementTypeOther" +
            "/parent::XCUIElementTypeOther/preceding-sibling::XCUIElementTypeOther[1]")
    protected MobileElement arrowSecondButton;
    @iOSXCUITFindBy(iOSClassChain = "**/XCUIElementTypeStaticText[`label == \"Invitations sent\"`]")
    protected MobileElement textNotification;
    @iOSXCUITFindBy(iOSClassChain = "**/XCUIElementTypeOther[`label == \"Save video\"`]")
    protected MobileElement saveVideoButton;
    @iOSXCUITFindBy(iOSClassChain = "**/XCUIElementTypeOther[`label == \"Report\"`]")
    protected MobileElement reportButton;
    @iOSXCUITFindBy(iOSClassChain = "**/XCUIElementTypeOther[`label == \"CANCEL\"`][1]/XCUIElementTypeOther[1]")
    protected MobileElement sendReportButton;
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
    @iOSXCUITFindBy(xpath = "(//XCUIElementTypeOther[@name=\"Play\"])[12]/parent::XCUIElementTypeOther" +
            "/parent::XCUIElementTypeOther/parent::XCUIElementTypeOther/parent::XCUIElementTypeOther" +
            "/following-sibling::XCUIElementTypeOther[1]")
    protected MobileElement backRandomVideoButton;
    @iOSXCUITFindBy(xpath = "(//XCUIElementTypeOther[@name=\"Play\"])[12]/parent::XCUIElementTypeOther" +
            "/parent::XCUIElementTypeOther/parent::XCUIElementTypeOther/parent::XCUIElementTypeOther" +
            "/following-sibling::XCUIElementTypeOther[2]")
    protected MobileElement settingsRandomActiveGameButton;
    @iOSXCUITFindBy(xpath = "(//XCUIElementTypeOther[@name=\"Play\"])[12]")
    protected MobileElement playRandomActiveGameButton;

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
    @iOSXCUITFindBy(iOSClassChain = "**/XCUIElementTypeOther[`label == \"Thank you The complaint has been sent\"`][3]")
    protected MobileElement messageAfterReportingForCreatedVideo;

    @iOSXCUITFindBy(xpath = "(//XCUIElementTypeOther[@name=\"Invite to game\"])[2]/XCUIElementTypeOther[1]")
    protected MobileElement searchIconButton;
    @iOSXCUITFindBy(xpath = "(//XCUIElementTypeOther[@name=\"Search...\"])[3]/XCUIElementTypeTextField")
    protected MobileElement searchField;
    @iOSXCUITFindBy(xpath = "(//XCUIElementTypeOther[@name=\"testaccount2 testaccount2\"])[4]")
    protected MobileElement testAccountIconButton;
    @iOSXCUITFindBy(xpath = "(//XCUIElementTypeOther[@name=\"Invitations sent\"])[1]")
    protected MobileElement messageAfterInvitation;
    @iOSXCUITFindBy(xpath = "(//XCUIElementTypeOther[@name=\"Create ō-chain Share link Invite to game\"])[1]")
    protected MobileElement closeSmallToolBarButton;


    public ProfilePage(AppiumDriver<MobileElement> driver) {
        super(driver);
    }

    @Step("click Search Button")
    public ProfilePage clickSearchButton() {
        element(searchIconButton).clickElement();

        return this;
    }

    @Step("Set account name to Search Field")
    public ProfilePage setSearchingName(String name) {
        element(searchField).clickElement();
        element(searchField).setValue(name);

        return this;
    }

    @Step("Choose TestAccount2")
    public ProfilePage chooseTestAccount() {
        element(testAccountIconButton).clickElement();

        return this;
    }

    @Step("Message after Invitation Visibility Check")
    public boolean messageAfterInvitationIsVisible() {
        return element(textNotification).isDisplayed();
    }

    @Step("Click close small toolbar button")
    public ProfilePage clickCloseSmallToolBarButton() {
        element(closeSmallToolBarButton).clickElement();

        return this;
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
            if (element(backButton).isDisplayed()) {
                element(backButton).clickElement();
            }
            if (element(backRandomVideoButton).isDisplayed()) {
                element(backRandomVideoButton).clickElement();
            }
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
        if (element(arrowButton).isDisplayed()) {
            element(arrowButton).clickElement();
        } else if (element(arrowSecondButton).isDisplayed()) {
            element(arrowSecondButton).clickElement();
        }

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

    @Step("Click Settings Random Active Game Button")
    public ProfilePage clickSettingsRandomActiveGameButton() {
        element(settingsRandomActiveGameButton).clickElement();

        return this;
    }

    @Step("Play Random Active Game Button Visibility Check")
    public boolean playRandomActiveGameButtonIsVisible() {
        return element(playRandomActiveGameButton).isDisplayed();
    }

    @Step("Click Report Button")
    public ProfilePage clickReportButton() {
        element(reportButton).clickElement();

        return this;
    }

    @Step("Send Report for Created Video")
    public ProfilePage sendReportForCreatedVideo() {
        element(sendReportButton).clickElement();

        return this;
    }

    @Step("Message After Reporting Created Video Visibility Check")
    public boolean messageAfterReportingForCreatedVideoIsVisible() {
        return element(messageAfterReportingForCreatedVideo).isDisplayed();
    }
}
