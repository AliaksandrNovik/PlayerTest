package vmn.simpleTest.factory;

import java.net.MalformedURLException;
import java.net.URL;

import org.apache.log4j.Logger;
import org.openqa.selenium.remote.DesiredCapabilities;

import vmn.simpleTest.constant.VmnConstant;
import vmn.simpleTest.driverType.DriverTypes;
import vmn.simpleTest.factory.browser.ChromeDriverFactory;
import vmn.simpleTest.factory.browser.FirefoxDriverFactory;
import vmn.simpleTest.factory.remote.RemoteDriverFactory;
import vmn.simpleTest.factory.remote.WebDriverFactory;

public class LocalFactory {

	private static URL remoteAddress;

	private static final Logger LOGGER = Logger.getLogger(LocalFactory.class);

	private static LocalFactory instance = new LocalFactory();

	public static LocalFactory getInstance() {
		return instance;
	}

	public static WebDriverFactory createRemoteFactory(DriverTypes typeDriver) {

		try {
			remoteAddress = new URL(VmnConstant.REMOTE_APPIUM_URL);
		} catch (MalformedURLException e) {
			e.printStackTrace();
		}

		DesiredCapabilities caps = new DesiredCapabilities();
		switch (typeDriver) {

		case ANDROID_PHONE:
			LOGGER.info("Creating Android_Phone factory");
			caps.setCapability("deviceName", "Android");
			caps.setCapability("platformName", "Android");
			caps.setCapability("browserName", "Chrome");
			return new RemoteDriverFactory(remoteAddress, caps);

		case CHROME:
			LOGGER.info("Creating Chrome driver Factory");
			return new ChromeDriverFactory(VmnConstant.PATH_TO_CHROME);

		case FIREFOX:
			LOGGER.info("Creating Firefox driver factory");
			return new FirefoxDriverFactory();

		case IPHONE:
			LOGGER.info("Creating IOS Driver");
			caps.setCapability("platformVersion", 8.3);
			caps.setCapability("app", VmnConstant.PATH_TO_IOS_APP);
			caps.setCapability("platformName", "iOS");
			caps.setCapability("deviceName", "iPhone Simulator");
			return new RemoteDriverFactory(remoteAddress, caps);

		case IPAD:
			LOGGER.info("Creating IOS Driver Ipad");
			caps.setCapability("platformVersion", 8.3);
			caps.setCapability("app", VmnConstant.PATH_TO_IOS_APP);
			caps.setCapability("platformName", "iOS");
			caps.setCapability("deviceName", "iPad 2");
			return new RemoteDriverFactory(remoteAddress, caps);

		default:
			LOGGER.info("Default driver Firefox has been created");
			return new FirefoxDriverFactory();
		}

	}
}
