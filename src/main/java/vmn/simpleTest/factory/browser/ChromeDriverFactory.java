package vmn.simpleTest.factory.browser;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;


public class ChromeDriverFactory extends DesktopDriverFactory {

	private static final Logger LOGGER = Logger.getLogger(ChromeDriverFactory.class);

	private static final String CHROME_SYS_PROP_NAME = "webdriver.chrome.driver";

	public ChromeDriverFactory(String pathToChrome) {

		LOGGER.info("Create ChromeDriverFactory " );
		System.setProperty(CHROME_SYS_PROP_NAME, pathToChrome);
	}

	@Override
	public WebDriver createWebDriver() {
		if (null != capabilities) {
			return new ChromeDriver(capabilities);
		}
		return new ChromeDriver();
	}

}
