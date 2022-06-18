package tests;

import io.qameta.allure.Description;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import utils.ListenerTest;

import static consts.TestData.*;

@Listeners(ListenerTest.class)
public class InviteToGameTests extends BaseTest {
    @Description("Send invite to a game from tab \"Created\"")
    @Test(priority = 1)
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

        Assert.assertTrue(profilePage.messageAfterInvitationIsVisible());
    }

    @Description("Send invite to a game from \"Created\" tab with other route.")
    @Test(priority = 2)
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

        Assert.assertTrue(profilePage.messageAfterInvitationIsVisible());
    }

    @Description("Accept Invite to a Game From Other User")
    @Test(priority = 4)
    public void acceptInviteToGameFromOtherUserTest() {
        steps
                .logIn(testAccountPhoneNumber)
                .shotVideoFromAddVideoPage();

        mainPage
                .openProfilePage()
                .clickCreatedButton()
                .clickVideo()
                .clickArrowButton()
                .clickInviteToGameButton()
                .clickSearchButton()
                .setSearchingName(testAccountSecondName)
                .chooseTestAccount()
                .clickConfirmButton();

        Assert.assertTrue(profilePage.messageAfterInvitationIsVisible());

        profilePage
                .clickCloseSmallToolBarButton()
                .clickBackButton();
        steps.logOut();

        steps.logIn(testAccountSecondPhoneNumber);

        mainPage
                .openNotifyPage()
                .clickNotificationButton()
                .clickViewButton();

        mainPage
                .clickPlayButton();
        steps
                .shotTenSecondVideo();
        profilePage
                .clickBackButton();

        Assert.assertFalse(notifyPage.viewButtonIsVisible());
    }

    @Description("Decline Invite To Game Test")
    @Test(priority = 3)
    public void declineInviteToGameTest() {
        steps
                .logIn(testAccountPhoneNumber)
                .shotVideoFromAddVideoPage();

        mainPage
                .openProfilePage()
                .clickCreatedButton()
                .clickVideo()
                .clickArrowButton()
                .clickInviteToGameButton()
                .clickSearchButton()
                .setSearchingName(testAccountSecondName)
                .chooseTestAccount()
                .clickConfirmButton()
                .clickCloseSmallToolBarButton()
                .clickBackButton();
        steps.logOut();
        steps.logIn(testAccountSecondPhoneNumber);

        mainPage
                .openNotifyPage()
                .clickNotificationButton();

        Assert.assertTrue(notifyPage.viewButtonIsVisible());

        notifyPage.clickDeclineButton();

        Assert.assertFalse(notifyPage.viewButtonIsVisible());
    }
}
