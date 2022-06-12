package tests;

import core.AppiumDriverConfig;
import core.AppiumServer;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import pages.*;
import pages.logIn.SignUpOrLogInPage;
import steps.Steps;

public class BaseTest {
    protected MainPage mainPage;
    protected ProfilePage profilePage;
    protected Steps steps;
    protected SignUpOrLogInPage signUpOrLogInPage;
    protected FindPage findPage;
    protected NotifyPage notifyPage;
    protected AddVideoPage addVideoPage;

    @BeforeSuite(alwaysRun = true)
    public void BeforeSuite() {
        AppiumServer.Start();
    }

    @BeforeMethod(alwaysRun = true)
    public void BeforeMethod() {
        mainPage = new MainPage(AppiumDriverConfig.getDriver());
        profilePage = new ProfilePage(AppiumDriverConfig.getDriver());
        steps = new Steps(AppiumDriverConfig.getDriver());
        signUpOrLogInPage = new SignUpOrLogInPage(AppiumDriverConfig.getDriver());
        findPage = new FindPage(AppiumDriverConfig.getDriver());
        notifyPage = new NotifyPage(AppiumDriverConfig.getDriver());
        addVideoPage = new AddVideoPage(AppiumDriverConfig.getDriver());
    }

    @AfterMethod(alwaysRun = true)
    public void logOut() {
        profilePage.clickBackButton();
        steps.logOut();
        AppiumDriverConfig.closeApp();
    }

    @AfterSuite
    public void AfterSuite() {
        AppiumServer.Stop();
    }
}
