package tests;

import io.qameta.allure.Description;
import org.testng.Assert;
import org.testng.annotations.Test;

import static consts.TestData.*;

public class InviteToGameTests extends BaseTest {
    @Description("Send invite to a game from tab \"Created\"")
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

    @Description("Send invite to a game from \"Created\" tab with other route.")
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
