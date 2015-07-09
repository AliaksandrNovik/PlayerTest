package vmn.simpleTest.factory.browser;

import org.openqa.selenium.remote.DesiredCapabilities;

import vmn.simpleTest.factory.remote.WebDriverFactory;

public abstract class DesktopDriverFactory extends WebDriverFactory {

	protected DesiredCapabilities capabilities;

	public DesktopDriverFactory(DesiredCapabilities capabilities) {
		this.capabilities = capabilities;
	}

	public DesktopDriverFactory() {
		super();
	}

}
