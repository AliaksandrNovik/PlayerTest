package vmn.simpleTest.factory.remote;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.URL;

public class RemoteDriverFactory extends WebDriverFactory {

	protected URL url;

	protected DesiredCapabilities capabilities;

	private static final Logger LOGGER = Logger.getLogger(RemoteDriverFactory.class);

	public RemoteDriverFactory(URL url, DesiredCapabilities capabilities) {
		super();
		this.capabilities = capabilities;
		this.url = url;
	}

	@Override
	public WebDriver createWebDriver() {
		LOGGER.info("Starting Remote Driver... Host URL: " + url);
		return new RemoteWebDriver(url, capabilities);
	}

}
