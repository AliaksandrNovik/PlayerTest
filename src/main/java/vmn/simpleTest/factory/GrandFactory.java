package vmn.simpleTest.factory;

import vmn.simpleTest.driverType.DriverTypes;
import vmn.simpleTest.factory.remote.WebDriverFactory;

public class GrandFactory {
	private static ThreadLocal<WebDriverFactory> webDriverFactory = new ThreadLocal<WebDriverFactory>();

	public static WebDriverFactory getInstance(DriverTypes driverType) {

		if (webDriverFactory.get() == null) {
			webDriverFactory.set(LocalFactory.createRemoteFactory(driverType));
		}
		return webDriverFactory.get();
	}
}
