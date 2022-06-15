package pages.logIn;

import base.BaseMobilePage;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import io.qameta.allure.Step;

public class SignUpOrLogInPage extends BaseMobilePage {
    @iOSXCUITFindBy(iOSClassChain = "**/XCUIElementTypeTextField[`value == \"00 000 00 00\"`]")
    protected MobileElement inputPhoneNumberField;
    @iOSXCUITFindBy(iOSClassChain = "**/XCUIElementTypeOther[`label == \"Unique name\"`][2]")
    protected MobileElement inputUniqueNameField;
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeOther[@name=\"00 000 00 00\"]//following-sibling::XCUIElementTypeOther")
    protected MobileElement chooseRegionField;
    @iOSXCUITFindBy(iOSClassChain = "**/XCUIElementTypeOther[`label == \"create-account-button\"`][2]")
    protected MobileElement createAnAccountButton;
    @iOSXCUITFindBy(iOSClassChain = "**/XCUIElementTypeOther[`label == \"login-button\"`][2]")
    protected MobileElement logInButton;
    @iOSXCUITFindBy(iOSClassChain = "**/XCUIElementTypeStaticText[`label == \"Phone number\"`]")
    protected MobileElement phoneNumberField;
    @iOSXCUITFindBy(iOSClassChain = "**/XCUIElementTypeOther[`label == \"start-button\"`][2]")
    protected MobileElement startButton;

    public SignUpOrLogInPage(AppiumDriver<MobileElement> driver) {
        super(driver);
    }

    @Step("Click number phone field and set phone number")
    public SignUpOrLogInPage setPhoneNumber(String number) {
        element(inputPhoneNumberField).clickElement();
        element(inputPhoneNumberField).setValue(number);

        return this;
    }

    @Step("Set Unique name")
    public SignUpOrLogInPage setUniqueName(String name) {
        element(inputUniqueNameField).setValue(name);

        return this;
    }

    @Step("Click Create Account Button")
    public SmsCodePage clickCreateAccountButton() {
        element(createAnAccountButton).clickElement();

        return new SmsCodePage(driver);
    }

    @Step("Click LogIn Button")
    public SmsCodePage clickLogInButton() {
        element(logInButton).clickElement();

        return new SmsCodePage(driver);
    }

    @Step("Phone Number Field visibility check")
    public boolean phoneNumberFieldIsVisible() {
        return element(phoneNumberField).isDisplayed();
    }

    @Step("Click Start Button")
    public SignUpOrLogInPage clickStartButton() {
        element(startButton).clickElement();

        return this;
    }
}
