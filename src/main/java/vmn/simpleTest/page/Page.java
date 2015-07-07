package vmn.simpleTest.page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public abstract class Page {

	protected WebDriver driver;

	public Page(WebDriver driver) {
		this.driver = driver;

	}

	public WebElement waitForElement(By locator, long timeOutInSeconds, long sleepInMillis) {
		WebDriverWait wait = new WebDriverWait(driver, timeOutInSeconds, sleepInMillis);
		return wait.until(ExpectedConditions.presenceOfElementLocated(locator));
	}
}
