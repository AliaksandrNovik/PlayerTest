package vmn.simpleTest.factory.remote;

import io.selendroid.client.SelendroidDriver;

import java.net.URL;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

public class SelendroidFactory extends WebDriverFactory {

	protected URL url;

	private static final Logger LOGGER = Logger.getLogger(SelendroidFactory.class);

	protected DesiredCapabilities capabilities;

	public SelendroidFactory(URL url, DesiredCapabilities capabilities) {
		super();
		this.capabilities = capabilities;
		this.url = url;
	}

	@Override
	public WebDriver createWebDriver() {
		try {
			LOGGER.info("Create Selendroid Driver ... Host URL: " + url);
			return new SelendroidDriver(url, capabilities);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

}
