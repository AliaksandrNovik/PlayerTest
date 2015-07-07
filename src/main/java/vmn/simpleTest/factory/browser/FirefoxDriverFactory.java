package vmn.simpleTest.factory.browser;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class FirefoxDriverFactory extends DesktopDriverFactory {
	private static final Logger LOGGER = Logger.getLogger(FirefoxDriverFactory.class);

	public FirefoxDriverFactory() {
		super();
	}

	@Override
	public WebDriver createWebDriver() {

		LOGGER.info("Starting Firefox Driver for " + System.getProperty("os.name") + "...");

		if (null != capabilities) {
			return new FirefoxDriver(capabilities);
		}
		return new FirefoxDriver();
	}

}
