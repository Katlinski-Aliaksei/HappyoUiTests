package tests;

import io.qameta.allure.Description;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import utils.ListenerTest;
import utils.RandomData;

@Listeners(ListenerTest.class)
public class RegistrationTests extends BaseTest {
    @Description("Full profile create from Main Page.")
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

    @Description(" Profile create from AddVideo page.")
    @Test(groups = {"registration"})
    public void registrationFromAddVideoScreenTest() {
        mainPage
                .openAddVideoPage();

        Assert.assertTrue(signUpOrLogInPage.phoneNumberFieldIsVisible());
    }

    @Description(" Profile create from Notify page.")
    @Test(groups = {"registration"})
    public void registrationFromNotifyPageTest() {
        mainPage
                .openNotifyPage();
        signUpOrLogInPage
                .clickStartButton();

        Assert.assertTrue(signUpOrLogInPage.phoneNumberFieldIsVisible());
    }

    @Description(" Profile create from Profile page.")
    @Test(groups = {"registration"})
    public void registrationFromProfilePageTest() {
        mainPage
                .openProfilePage();
        signUpOrLogInPage
                .clickStartButton();

        Assert.assertTrue(signUpOrLogInPage.phoneNumberFieldIsVisible());
    }

    @Description(" Profile create from find page. Interesting people.")
    @Test(groups = {"registration"})
    public void registrationFromFindPageTest() {
        mainPage
                .openFindPage()
                .chooseFirstPerson()
                .clickFollowButton();

        Assert.assertTrue(signUpOrLogInPage.phoneNumberFieldIsVisible());
    }
}
