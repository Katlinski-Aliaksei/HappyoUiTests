package tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import utils.RandomData;

public class RegistrationTests extends BaseTest {
    @Test(groups = {"registration"})
    public void registrationFromMainScreenIosTest() {
        mainPage
                .clickPlayButton()
                .setPhoneNumber(RandomData.generateRandomPhoneNumber())
                .setUniqueName(RandomData.generateRandomName())
                .clickCreateAccountButton()
                .setSmsCode();

        Assert.assertTrue(mainPage.playButtonIsVisible());
    }

    @Test(groups = {"registration"})
    public void registrationFromAddVideoScreenTest() {
        mainPage
                .openAddVideoPage();

        Assert.assertTrue(signUpOrLogInPage.phoneNumberFieldIsVisible());
    }

    @Test(groups = {"registration"})
    public void registrationFromNotifyPageTest() {
        mainPage
                .openNotifyPage();
        signUpOrLogInPage
                .clickStartButton();

        Assert.assertTrue(signUpOrLogInPage.phoneNumberFieldIsVisible());
    }

    @Test(groups = {"registration"})
    public void registrationFromProfilePageTest() {
        mainPage
                .openProfilePage();
        signUpOrLogInPage
                .clickStartButton();

        Assert.assertTrue(signUpOrLogInPage.phoneNumberFieldIsVisible());
    }

    @Test(groups = {"registration"})
    public void registrationFromFindPageTest() {
        mainPage
                .openFindPage()
                .chooseFirstPerson()
                .clickFollowButton();

        Assert.assertTrue(signUpOrLogInPage.phoneNumberFieldIsVisible());
    }
}
