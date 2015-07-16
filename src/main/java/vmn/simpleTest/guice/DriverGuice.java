package vmn.simpleTest.guice;

import com.google.inject.AbstractModule;
import org.openqa.selenium.WebDriver;
import vmn.simpleTest.constant.VmnConstant;
import vmn.simpleTest.driverManager.DriverManager;
import vmn.simpleTest.driverType.DriverTypes;
import vmn.simpleTest.factory.GrandFactory;
import vmn.simpleTest.factory.remote.WebDriverFactory;

import java.util.concurrent.TimeUnit;

public class DriverGuice extends AbstractModule {

	protected WebDriver driver;

	public DriverTypes type;

	public DriverGuice(DriverTypes type) {
		super();
		this.type = type;
	}

	protected DriverManager driverManager;

	@Override
	protected void configure() {
		try {
			WebDriverFactory webDriverFactory = GrandFactory.getInstance(type);
			driverManager = DriverManager.getInstance(webDriverFactory);
			driver = driverManager.getWebDriver();
			if (!type.getDriverType().equalsIgnoreCase(DriverTypes.ANDROID_PHONE.getDriverType())
					&& !type.getDriverType().equalsIgnoreCase(DriverTypes.ANDROID_TABLET.getDriverType())) {
				driver.manage().timeouts().pageLoadTimeout(VmnConstant.IMPLICITY_WAIT, TimeUnit.SECONDS);
				driver.manage().timeouts().implicitlyWait(VmnConstant.IMPLICITY_WAIT, TimeUnit.SECONDS);
			}
			bind(WebDriver.class).toInstance(driver);

		} catch (Exception e) {
			e.printStackTrace();
		}

	}
}
