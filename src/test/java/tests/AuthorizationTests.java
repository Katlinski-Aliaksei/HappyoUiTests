package tests;

import io.qameta.allure.Description;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import utils.ListenerTest;

import static consts.TestData.testAccountPhoneNumber;

@Listeners(ListenerTest.class)
public class AuthorizationTests extends BaseTest {
    @Description("Authorization from main screen")
    @Test(groups = {"logIn"})
    public void authorizationFromMainPageTest() {
        mainPage
                .clickPlayButton()
                .setPhoneNumber(testAccountPhoneNumber)
                .clickLogInButton()
                .setSmsCode();

        Assert.assertTrue(mainPage.playButtonIsVisible());
    }

    @Description("Authorization from find screen")
    @Test(groups = {"logIn"})
    public void authorizationFromFindPageTest() {
        mainPage
                .openFindPage()
                .chooseFirstPerson()
                .clickFollowButton()
                .setPhoneNumber(testAccountPhoneNumber)
                .clickLogInButton()
                .setSmsCode();
        findPage
                .chooseFirstPerson()
                .clickFollowButton();

        Assert.assertTrue(findPage.unfollowButtonIsDisplayed());

        findPage.clickUnfollowButton();
    }

    @Description("Authorization from add video screen")
    @Test(groups = {"logIn"})
    public void authorizationFromAddVideoPageTest() {
        mainPage
                .openAddVideoPage();
        signUpOrLogInPage
                .setPhoneNumber(testAccountPhoneNumber)
                .clickLogInButton()
                .setSmsCode();

        Assert.assertTrue(mainPage.playButtonIsVisible());
    }

    @Description("Authorization from notify screen")
    @Test(groups = {"logIn"})
    public void authorizationFromNotifyPageTest() {
        mainPage
                .openNotifyPage();
        signUpOrLogInPage
                .clickStartButton()
                .setPhoneNumber(testAccountPhoneNumber)
                .clickLogInButton()
                .setSmsCode();

        Assert.assertTrue(notifyPage.notificationButtonIsVisible());
    }

    @Description("Authorization from profile screen")
    @Test(groups = {"logIn"})
    public void authorizationFromProfilePageTest() {
        mainPage
                .openProfilePage();
        signUpOrLogInPage
                .clickStartButton()
                .setPhoneNumber(testAccountPhoneNumber)
                .clickLogInButton()
                .setSmsCode();

        Assert.assertTrue(profilePage.profileTestAccountIsVisible());
    }
}
