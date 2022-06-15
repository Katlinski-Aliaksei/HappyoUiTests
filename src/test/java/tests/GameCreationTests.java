package tests;

import io.qameta.allure.Description;
import org.testng.Assert;
import org.testng.annotations.Test;

import static consts.TestData.*;

public class GameCreationTests extends BaseTest {
    @Description("Game creation from other video on Add Video screen")
    @Test(priority = 3)
    public void creationGameFromAddVideoPage() {
        steps
                .logIn(testAccountPhoneNumber);
        mainPage
                .openAddVideoPage()
                .shotVideo()
                .clickNextButton()
                .setTitleVideo(titleVideo)
                .clickPublishButton();

        Assert.assertTrue(mainPage.playButtonIsVisible());
    }

    @Description("Game creation from other video on feed screen")
    @Test(priority = 1)
    public void creationGameFromMainPage() {
        steps
                .logIn(testAccountPhoneNumber);
        mainPage
                .clickPlayButton();
        addVideoPage
                .shotTenSecVideo()
                .clickPublishTenSecVideoButton()
                .enterMail(mailText);
        mainPage
                .openProfilePage()
                .clickCompletedButton();

        Assert.assertTrue(profilePage.testVideoIsVisible());

        steps.removeCompletedVideo();
    }

    @Description("Game creation from find screen.")
    @Test(priority = 2)
    public void creationGameFromFindPage() {
        steps
                .logIn(testAccountPhoneNumber);
        mainPage
                .openFindPage()
                .choseFirstActiveGame();

        addVideoPage
                .clickPlayAddVideoButton()
                .shotTenSecVideo()
                .clickPublishTenSecVideoButton()
                .enterMail(mailText)
                .clickBackButton();
        mainPage
                .openProfilePage()
                .clickCompletedButton();

        Assert.assertTrue(profilePage.testVideoIsVisible());

        steps.removeCompletedVideo();
    }
}
