package pages.logIn;

import base.BaseMobilePage;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import pages.MainPage;

public class SmsCodePage extends BaseMobilePage {
    @iOSXCUITFindBy(iOSClassChain = "**/XCUIElementTypeWindow[2]")
    protected MobileElement inputSmsCodeField;
    private final String containsValue = "//XCUIElementTypeKey[contains(@name,'replace')]";

    public SmsCodePage(AppiumDriver<MobileElement> driver) {
        super(driver);
    }

    @Step("Set SMS Code")
    public MainPage setSmsCode() {
        for (int i = 1; i <= 6; i++) {
            String value = containsValue.replace("replace", String.valueOf(i));
            element(By.xpath(value)).clickElement();
        }
        return new MainPage(driver);
    }
}
