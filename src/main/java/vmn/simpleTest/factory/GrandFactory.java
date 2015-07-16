package vmn.simpleTest.factory;

import vmn.simpleTest.driverType.DriverTypes;
import vmn.simpleTest.factory.remote.WebDriverFactory;

public class GrandFactory {

	private static WebDriverFactory webDriverFactory;

	public static WebDriverFactory getInstance(DriverTypes driverType) {
		if (webDriverFactory == null) {
			webDriverFactory = LocalFactory.createRemoteFactory(driverType);
		}
		return webDriverFactory;
	}
}
