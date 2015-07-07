package vmn.simpleTest.factory.remote;

import java.net.URL;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

public class RemoteDriverFactory extends WebDriverFactory {

	protected URL url;

	private static final Logger LOGGER = Logger.getLogger(RemoteDriverFactory.class);

	protected DesiredCapabilities capabilities;

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
