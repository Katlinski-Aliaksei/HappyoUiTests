package pages;

import base.BaseMobilePage;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import io.qameta.allure.Step;
import org.openqa.selenium.TimeoutException;

public class AddVideoPage extends BaseMobilePage {
    @iOSXCUITFindBy(iOSClassChain = "**/XCUIElementTypeOther[`label == \"CREATE GAME\"`][14]/XCUIElementTypeOther[2]")
    protected MobileElement closeButton;
    @iOSXCUITFindBy(xpath = "(//XCUIElementTypeOther[@name=\"Vertical scroll bar, 1 page\"])[1]" +
            "/preceding-sibling::XCUIElementTypeOther[3]")
    protected MobileElement backButton;
    @iOSXCUITFindBy(iOSClassChain = "**/XCUIElementTypeOther[`label == \"CREATE GAME\"`][13]/XCUIElementTypeOther[2]" +
            "/XCUIElementTypeOther/XCUIElementTypeOther[2]")
    protected MobileElement shotVideoButton;
    @iOSXCUITFindBy(iOSClassChain = "**/XCUIElementTypeOther[`label == \"FILM 10 SEC VIDEO\"`][8]/XCUIElementTypeOther[2]" +
            "/XCUIElementTypeOther/XCUIElementTypeOther[2]")
    protected MobileElement shotTenSecondVideoButton;
    @iOSXCUITFindBy(iOSClassChain = "**/XCUIElementTypeOther[`label == \"EDIT VIDEO\"`][8]/XCUIElementTypeOther[3]" +
            "/XCUIElementTypeOther")
    protected MobileElement nextButton;
    @iOSXCUITFindBy(iOSClassChain = "**/XCUIElementTypeOther[`label == \"0/48 TITLE\"`][2]")
    protected MobileElement titleField;
    @iOSXCUITFindBy(iOSClassChain = "**/XCUIElementTypeOther[`label == " +
            "\"9/48 Search... Horizontal scroll bar, 1 page Vertical scroll bar, 1 page Vertical scroll bar, 1 page " +
            "Horizontal scroll bar, 1 page\"`][8]/XCUIElementTypeOther[2]/XCUIElementTypeOther")
    protected MobileElement nextButtonAfterTitle;
    @iOSXCUITFindBy(iOSClassChain = "**/XCUIElementTypeTextField[`value == \"Enter your mail\"`]")
    protected MobileElement inputMailField;
    @iOSXCUITFindBy(xpath = "(//XCUIElementTypeOther[@name=\"We’re doing our best to deliver the best user experience. Please, leave your email and we’ll reach you to gather your feedback.\"])[3]/XCUIElementTypeOther[3]")
    protected MobileElement sendMailButton;
    @iOSXCUITFindBy(iOSClassChain = "**/XCUIElementTypeOther[`label == \"CREATE GAME\"`][14]/XCUIElementTypeOther[2]")
    protected MobileElement closeCreateVideoButton;
    @iOSXCUITFindBy(iOSClassChain = "**/XCUIElementTypeOther[`label == \"FILM 10 SEC VIDEO\"`][9]/XCUIElementTypeOther[2]")
    protected MobileElement closeTenSecondVideoButton;

    //TODO refactoring PUBLISH locator
    @iOSXCUITFindBy(xpath = "(//XCUIElementTypeOther[@name=\"publish-button\"])[2]")
    protected MobileElement publishButton;
    @iOSXCUITFindBy(iOSClassChain = "**/XCUIElementTypeOther[`label == \"EDIT VIDEO\"`][8]/XCUIElementTypeOther[3]/XCUIElementTypeOther")
    protected MobileElement publishTenSecVideoButton;
    @iOSXCUITFindBy(xpath = "(//XCUIElementTypeOther[@name=\"Play\"])[12]")
    protected MobileElement playAddVideoButton;

    public AddVideoPage(AppiumDriver<MobileElement> driver) {
        super(driver);
    }

    @Step("Click Shot Video Button")
    public AddVideoPage shotVideo() {
        element(shotVideoButton).clickElement();

        return this;
    }

    @Step("Click Shit Ten Second Video Button")
    public AddVideoPage shotTenSecVideo() {
        element(shotTenSecondVideoButton).clickElement();

        return this;
    }

    @Step("Click Next Button")
    public AddVideoPage clickNextButton() {
        element(nextButton).clickElement();

        return this;
    }

    @Step("Setting Title Video")
    public AddVideoPage setTitleVideo(String title) {
        element(titleField).setValue(title);

        return this;
    }

    @Step("Click Publish Button")
    public AddVideoPage clickPublishButton() {
        element(publishButton).clickElement();

        return this;
    }

    @Step("Click Publish Button after recording Ten Second Video")
    public AddVideoPage clickPublishTenSecVideoButton() {
        element(publishTenSecVideoButton).clickElement();

        return this;
    }

    @Step("Enter FeedBack and Send")
    public AddVideoPage enterMail(String text) {
        waiters.waitSomeSecond(3);
        try {
            element(inputMailField).setValue(text);
            element(sendMailButton).clickElement();
        } catch (TimeoutException e) {
            System.out.println("Mail Field not visible");
        }
        return this;
    }

    @Step("Click Back Button")
    public AddVideoPage clickBackButton() {
        element(backButton).clickElement();

        return this;
    }

    @Step("Click Play Button on Add Video Page")
    public AddVideoPage clickPlayAddVideoButton() {
        element(playAddVideoButton).clickElement();

        return this;
    }

    @Step("Click Close Button on Screen for Shot Video")
    public AddVideoPage closeVideoScreen() {
        if (element(closeCreateVideoButton).isDisplayed()) {
            element(closeCreateVideoButton).clickElement();
        }
        if ((element(closeTenSecondVideoButton).isDisplayed())) {
            element(closeTenSecondVideoButton).clickElement();
        }
        return this;
    }
}
