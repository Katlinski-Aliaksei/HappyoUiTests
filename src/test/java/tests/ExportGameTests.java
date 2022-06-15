package tests;

import io.qameta.allure.Description;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import utils.ListenerTest;

import static consts.TestData.testAccountPhoneNumber;

@Listeners(ListenerTest.class)
public class ExportGameTests extends BaseTest {
    @Test
    public void shareCompletedGameTest() {
        steps
                .logIn(testAccountPhoneNumber);
        steps
                .shotTenSecondVideo();
        mainPage
                .openProfilePage()
                .clickCompletedButton()
                .clickVideo()
                .clickArrowButton()
                .clickShareLinkButton();

        Assert.assertTrue(profilePage.previewVideoLinkIsVisible());

        profilePage
                .chooseMessageTool();

        Assert.assertTrue(profilePage.textMessageContainsVideoLink()
                .contains("https://dev.happyo.app/share/game"));

        profilePage
                .clickCancelButton()
                .clickCloseToolWindow();

        steps.removeCompletedVideo();
    }

    @Description("Share Link Created Game Test")
    @Test
    public void shareCreatedGameTest() {
        steps
                .logIn(testAccountPhoneNumber);
        mainPage
                .openProfilePage()
                .clickCreatedButton()
                .clickVideo()
                .clickArrowButton()
                .clickShareLinkButton();

        Assert.assertTrue(profilePage.previewVideoLinkIsVisible());

        profilePage
                .chooseMessageTool();

        Assert.assertTrue(profilePage.textMessageContainsVideoLink()
                .contains("AUTOTEST https://dev.happyo.app/share/game"));

        profilePage
                .clickCancelButton()
                .clickCloseToolWindow();
    }

    @Description("Save Created Game To Files Test")
    @Test
    public void saveCreatedGameToFilesTest() {
        steps
                .logIn(testAccountPhoneNumber);
        mainPage
                .openProfilePage()
                .clickCreatedButton()
                .clickVideo()
                .clickSettingsCreatedVideoButton()
                .clickSaveVideoButton()
                .clickSaveToFilesButton()
                .clickConfirmSaveButton();

        Assert.assertTrue(profilePage.arrowButtonIsVisible());
    }

    @Description("Share Link Random Video Test")
    @Test
    public void shareLinkRandomVideoTest() {
        steps
                .logIn(testAccountPhoneNumber);
        mainPage
                .clickArrowButtonOnRandomVideo()
                .clickShareLinkButton();

        Assert.assertTrue(profilePage.previewVideoLinkIsVisible());

        profilePage
                .chooseMessageTool();

        Assert.assertTrue(profilePage.textMessageContainsVideoLink()
                .contains("https://dev.happyo.app/share/game"));

        profilePage
                .clickCancelButton()
                .clickCloseToolWindow();
    }
}