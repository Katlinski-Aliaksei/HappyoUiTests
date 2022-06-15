package core;

import configs.PropertiesConfig;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.remote.MobileCapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;

public class AppiumDriverConfig {
    static AppiumDriver<MobileElement> driver;
    private static final Logger LOGGER = LoggerFactory.getLogger(AppiumDriverConfig.class);

    public static AppiumDriver<MobileElement> getDriver() {
        if (driver == null) {
            try {
                driver = startAppiumDriver();
                LOGGER.info("Driver is started");
            } catch (MalformedURLException e) {
                e.printStackTrace();
            }
        }
        return driver;
    }

    public static AppiumDriver<MobileElement> startAppiumDriver() throws MalformedURLException {
        LOGGER.info("Start AppiumDriver...");

        switch (PropertiesConfig.getProperty("platformName").toUpperCase()) {
            case "IOS":
                DesiredCapabilities iOSCapabilities = setCapabilities();
                driver = new IOSDriver<>(new URL("http://0.0.0.0:4723/wd/hub"), iOSCapabilities);
                break;
            default:
                LOGGER.info("Appium driver not initialize");
                break;
        }

        return driver;
    }

    private static DesiredCapabilities setCapabilities() {
        DesiredCapabilities cap = new DesiredCapabilities();

        cap.setCapability(MobileCapabilityType.DEVICE_NAME, PropertiesConfig.getProperty("iosDeviceName"));
        cap.setCapability(MobileCapabilityType.PLATFORM_NAME, PropertiesConfig.getProperty("platformName"));
        cap.setCapability(MobileCapabilityType.PLATFORM_VERSION, PropertiesConfig.getProperty("iosPlatformVersion"));
        cap.setCapability(MobileCapabilityType.NO_RESET, false);
        cap.setCapability(MobileCapabilityType.UDID, PropertiesConfig.getProperty("iosUdId"));
        cap.setCapability(MobileCapabilityType.AUTOMATION_NAME, PropertiesConfig.getProperty("iosAutomationName"));
        cap.setCapability("bundleId", PropertiesConfig.getProperty("iosBundleId"));
        cap.setCapability(MobileCapabilityType.CLEAR_SYSTEM_FILES, true);

        return cap;
    }

    public static void closeApp() {
        driver.launchApp();
       // driver.runAppInBackground(Duration.ofSeconds(-1));
    }
}
