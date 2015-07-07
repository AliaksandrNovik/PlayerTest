package vmn.simpleTest.factory.remote;

import org.openqa.selenium.WebDriver;

public abstract class WebDriverFactory {

	public WebDriverFactory() {
	}
	
	public abstract WebDriver createWebDriver();

}
