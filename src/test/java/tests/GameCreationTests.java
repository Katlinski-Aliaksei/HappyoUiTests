package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import static consts.TestData.*;

public class GameCreationTests extends BaseTest {
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
