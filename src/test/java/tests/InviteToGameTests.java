package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import static consts.TestData.*;

public class InviteToGameTests extends BaseTest {
    @Test
    public void sendInviteToAGameFromProfilePageUsedArrowButtonTest() {
        steps
                .logIn(testAccountPhoneNumber);
        mainPage
                .openProfilePage()
                .clickCreatedButton()
                .clickVideo()
                .clickArrowButton()
                .clickInviteToGameButton()
                .selectUserToInviteToGame(novicows)
                .clickConfirmButton();

        Assert.assertTrue(profilePage.notificationIsVisible());
    }

    @Test
    public void sendInviteToAGameFromProfilePageUsedSettingsButtonTest() {
        steps
                .logIn(testAccountPhoneNumber);
        mainPage
                .openProfilePage()
                .clickCreatedButton()
                .clickVideo()
                .clickSettingsCreatedVideoButton()
                .clickInviteToGameInSettingsButton()
                .selectUserToInviteToGame(netyliov)
                .clickConfirmInSettingsButton();

        Assert.assertTrue(profilePage.notificationIsVisible());
    }
}
