package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import static consts.TestData.testAccountPhoneNumber;

public class AuthorizationTests extends BaseTest {
    @Test(groups = {"logIn"})
    public void authorizationFromMainPageTest() {
        mainPage
                .clickPlayButton()
                .setPhoneNumber(testAccountPhoneNumber)
                .clickLogInButton()
                .setSmsCode();

        Assert.assertTrue(mainPage.playButtonIsVisible());
    }

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
