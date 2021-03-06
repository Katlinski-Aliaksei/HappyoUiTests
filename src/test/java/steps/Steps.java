package steps;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.qameta.allure.Step;
import pages.AddVideoPage;
import pages.MainPage;
import pages.ProfilePage;

import static consts.TestData.*;

public class Steps {
    AppiumDriver<MobileElement> driver;
    private final MainPage mainPage;
    private final ProfilePage profilePage;
    private final AddVideoPage addVideoPage;

    public Steps(AppiumDriver<MobileElement> driver) {
        this.driver = driver;
        mainPage = new MainPage(driver);
        profilePage = new ProfilePage(driver);
        addVideoPage = new AddVideoPage(driver);
    }

    @Step("LogIn Step")
    public Steps logIn(String number) {
        mainPage
                .openMainPage()
                .clickPlayButton()
                .setPhoneNumber(number)
                .clickLogInButton()
                .setSmsCode();
        addVideoPage
                .enterMail(mailText);

        return this;
    }

    @Step("LogOut Step")
    public void logOut() {
        try {
            profilePage
                    .clickBackButton();
            mainPage
                    .openProfilePage()
                    .openProfileSettings()
                    .clickLogOutButton()
                    .clickYesButton();
        } catch (Exception e) {
            return;
        }
    }

    @Step("Remove Completed Video After Checking")
    public void removeCompletedVideo() {
        profilePage
                .clickVideo()
                .clickSettingsCompletedVideoButton()
                .clickDeleteCompetitionButton()
                .clickBackButton();
    }

    @Step("Shot Ten Second Video")
    public void shotTenSecondVideo() {
        mainPage
                .clickPlayButton();
        addVideoPage
                .shotTenSecVideo()
                .clickPublishTenSecVideoButton()
                .enterMail(mailText);
    }

    @Step("Shot Video From AddVideo Page")
    public void shotVideoFromAddVideoPage() {
        mainPage
                .openAddVideoPage()
                .shotVideo()
                .clickNextButton()
                .setTitleVideo(titleVideo)
                .clickPublishButton();
    }
}
