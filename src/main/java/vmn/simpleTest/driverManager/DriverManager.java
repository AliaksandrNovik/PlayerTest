package vmn.simpleTest.driverManager;

import org.openqa.selenium.WebDriver;
import vmn.simpleTest.factory.remote.WebDriverFactory;

public class DriverManager {

	private WebDriver driver;

	private static DriverManager instance;

	private DriverManager(WebDriverFactory factory) throws Exception {
		driver = factory.createWebDriver();
	}

	public static DriverManager getInstance(WebDriverFactory factory) throws Exception {
		if (instance == null) {
			instance = new DriverManager(factory);
		}
		return instance;
	}

	public WebDriver getWebDriver() {
		return driver;
	}

}
