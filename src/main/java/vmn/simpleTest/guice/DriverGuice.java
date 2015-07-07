package vmn.simpleTest.guice;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;

import vmn.simpleTest.constant.VmnConstant;
import vmn.simpleTest.driverManager.DriverManager;
import vmn.simpleTest.driverType.DriverTypes;
import vmn.simpleTest.factory.GrandFactory;
import vmn.simpleTest.factory.remote.WebDriverFactory;

import com.google.inject.AbstractModule;

public class DriverGuice extends AbstractModule {
	protected WebDriver driver;

	protected DriverManager driverManager;

	@Override
	protected void configure() {
		WebDriverFactory webDriverFactory = GrandFactory.getInstance(DriverTypes.IPHONE);
		driverManager = DriverManager.getInstance(webDriverFactory);
		driver = driverManager.getWebDriver();
		driver.manage().timeouts().pageLoadTimeout(VmnConstant.IMPLICITY_WAIT, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(VmnConstant.IMPLICITY_WAIT, TimeUnit.SECONDS);
		bind(WebDriver.class).toInstance(driver);

	}
}
