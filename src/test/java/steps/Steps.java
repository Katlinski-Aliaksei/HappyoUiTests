package steps;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.qameta.allure.Step;
import pages.AddVideoPage;
import pages.MainPage;
import pages.ProfilePage;
import pages.logIn.SignUpOrLogInPage;

import static consts.TestData.mailText;
import static consts.TestData.testAccountPhoneNumber;

public class Steps {
    AppiumDriver<MobileElement> driver;
    private MainPage mainPage;
    private SignUpOrLogInPage signUpOrLogInPage;
    private ProfilePage profilePage;
    private AddVideoPage addVideoPage;

    public Steps(AppiumDriver<MobileElement> driver) {
        this.driver = driver;
        mainPage = new MainPage(driver);
        signUpOrLogInPage = new SignUpOrLogInPage(driver);
        profilePage = new ProfilePage(driver);
        addVideoPage = new AddVideoPage(driver);
    }

    @Step
    public void logIn(String number) {
        mainPage
                .clickPlayButton()
                .setPhoneNumber(number)
                .clickLogInButton()
                .setSmsCode();
        addVideoPage
                .enterMail(mailText);
    }

    @Step
    public void logOut() {
        try {
            mainPage
                    .openProfilePage()
                    .openProfileSettings()
                    .clickLogOutButton()
                    .clickYesButton();
        } catch (Exception e) {
            return;
        }
    }

    @Step
    public void removeCompletedVideo() {
        profilePage
                .clickVideo()
                .clickSettingsCompletedVideoButton()
                .clickDeleteCompetitionButton()
                .clickBackButton();
    }
}
