package tests;

import io.qameta.allure.Description;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import utils.ListenerTest;

import static consts.TestData.testAccountPhoneNumber;
import static consts.TestData.titleVideo;

@Listeners(ListenerTest.class)
public class ComplaintsTests extends BaseTest {
    @Description("Create Video and Report Test")
    @Test
    public void createReportForCreatedVideoTest() {
        steps
                .logIn(testAccountPhoneNumber);
        mainPage
                .openAddVideoPage()
                .shotVideo()
                .clickNextButton()
                .setTitleVideo(titleVideo)
                .clickPublishButton();
        mainPage
                .openProfilePage()
                .clickCreatedButton()
                .clickVideo()
                .clickSettingsCreatedVideoButton()
                .clickReportButton()
                .sendReportForCreatedVideo();

        Assert.assertTrue(profilePage.messageAfterReportingForCreatedVideoIsVisible());
    }
}
