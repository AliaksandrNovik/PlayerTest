package vmn.simpleTest.factory;

import org.apache.log4j.Logger;
import org.openqa.selenium.remote.DesiredCapabilities;
import vmn.simpleTest.constant.VmnConstant;
import vmn.simpleTest.constant.capability.AndroidCapability;
import vmn.simpleTest.constant.capability.IosIPhoneCapability;
import vmn.simpleTest.driverType.DriverTypes;
import vmn.simpleTest.factory.browser.FirefoxDriverFactory;
import vmn.simpleTest.factory.remote.RemoteDriverFactory;
import vmn.simpleTest.factory.remote.SelendroidFactory;
import vmn.simpleTest.factory.remote.WebDriverFactory;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;

public class LocalFactory {

	private static URL remoteAddress;

	private static final Logger LOGGER = Logger.getLogger(LocalFactory.class);

	private static LocalFactory instance = new LocalFactory();
	//TODO:
	//You should not use full path for project, you should use porject relative path,
	//because if I copy your framework and try to run I will faced with issue.
	private static File appDir = new File(VmnConstant.PATH_TO_APP_DIR);

	private static File appFileNameIOS = new File(appDir, VmnConstant.FILENAME_APP_IOS);

	private static File appFileNameAndroid = new File(appDir, VmnConstant.FILENAME_APP_ANDROID);

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
			caps.setCapability("deviceName", AndroidCapability.DEVICE_NAME);
			caps.setCapability("platformName", AndroidCapability.PLATFORM_NAME);
			caps.setCapability("automationName", AndroidCapability.AUTOMATION_NAME);
			caps.setCapability("udid", AndroidCapability.UDID);
			caps.setCapability("deviceName", "Selendroid");
			caps.setCapability("platformName", "Android");
			caps.setCapability("automationName", "Selendroid");
			caps.setCapability("udid", "71UBBLJ22KAQ");
			caps.setCapability("app", appFileNameAndroid.getAbsolutePath());
			return new SelendroidFactory(remoteAddress, caps);

		case IPHONE:
			LOGGER.info("Creating IOS Driver Iphone");
			caps.setCapability("platformVersion", IosIPhoneCapability.PLATFORM_VERSION);
			caps.setCapability("app", appFileNameIOS.getAbsolutePath());
			caps.setCapability("platformName", IosIPhoneCapability.PLATFORM_NAME);
			caps.setCapability("deviceName", IosIPhoneCapability.DEVICE_NAME);
			return new RemoteDriverFactory(remoteAddress, caps);

		case IPAD:
			LOGGER.info("Creating IOS Driver Ipad");
			caps.setCapability("platformVersion", IosIPhoneCapability.PLATFORM_VERSION);
			caps.setCapability("app", appFileNameIOS.getAbsolutePath());
			caps.setCapability("platformName", IosIPhoneCapability.PLATFORM_NAME);
			caps.setCapability("deviceName", IosIPhoneCapability.DEVICE_NAME_IPAD_2);
			return new RemoteDriverFactory(remoteAddress, caps);

		default:
			LOGGER.info("Default driver Firefox has been created");
			return new FirefoxDriverFactory();
		}
	}
}
