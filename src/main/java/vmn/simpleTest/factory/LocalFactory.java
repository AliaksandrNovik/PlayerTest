package vmn.simpleTest.factory;

import org.apache.log4j.Logger;
import org.openqa.selenium.remote.DesiredCapabilities;
import vmn.simpleTest.constant.VmnConstant;
import vmn.simpleTest.constant.capability.IosIPhoneCapability;
import vmn.simpleTest.driverType.DriverTypes;
import vmn.simpleTest.factory.browser.FirefoxDriverFactory;
import vmn.simpleTest.factory.capability.AndroidCapabilityFactory;
import vmn.simpleTest.factory.capability.IosCapabilityFactory;
import vmn.simpleTest.factory.capability.SelendroidCapabilityFactory;
import vmn.simpleTest.factory.remote.RemoteDriverFactory;
import vmn.simpleTest.factory.remote.SelendroidFactory;
import vmn.simpleTest.factory.remote.WebDriverFactory;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;

public class LocalFactory {

    private static final Logger LOGGER = Logger.getLogger(LocalFactory.class);

    private static URL remoteAddress;

    private static LocalFactory instance = new LocalFactory();

    private static File appDir = new File(VmnConstant.PATH_TO_APP_DIR);

    private static File appFileNameIOS = new File(appDir, VmnConstant.FILENAME_APP_IOS);

    private static File appFileNameAndroid = new File(appDir, VmnConstant.FILENAME_APP_ANDROID_ISO);

    public static LocalFactory getInstance() {
        return instance;
    }

    public static WebDriverFactory createRemoteFactory(DriverTypes typeDriver) {

        DesiredCapabilities caps = new DesiredCapabilities();

        try {
            remoteAddress = new URL(VmnConstant.REMOTE_APPIUM_URL);
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }

        switch (typeDriver) {
            case ANDROID_PHONE:
                LOGGER.info("Creating Android_Phone factory");
                return new RemoteDriverFactory(remoteAddress, AndroidCapabilityFactory.getInstance(caps, appFileNameAndroid)
                        .getAndroidCapability());

            case IPHONE:
                LOGGER.info("Creating IOS Driver Iphone");
                return new RemoteDriverFactory(remoteAddress, IosCapabilityFactory.getInstance(caps, appFileNameIOS,
                        IosIPhoneCapability.DEVICE_NAME).getIosCapability());

            case IPAD:
                LOGGER.info("Creating IOS Driver Ipad");
                return new RemoteDriverFactory(remoteAddress, IosCapabilityFactory.getInstance(caps, appFileNameIOS,
                        IosIPhoneCapability.DEVICE_NAME_IPAD_2).
                        getIosCapability());

            case ANDROID_PHONE_SELENDROID:
                LOGGER.info("Creating Selendroid Factory");
                return new SelendroidFactory(remoteAddress, SelendroidCapabilityFactory.getInstance(caps, appFileNameAndroid).
                        getSelendroidCapability());

            default:
                LOGGER.info("Default driver Firefox has been created");
                return new FirefoxDriverFactory();
        }
    }
}
