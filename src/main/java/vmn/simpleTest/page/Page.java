package vmn.simpleTest.page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public abstract class Page {

	protected WebDriver driver;

	public Page(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);

	}

	public WebElement waitForElement(By locator, long timeOutInSeconds, long sleepInMillis) {
		WebDriverWait wait = new WebDriverWait(driver, timeOutInSeconds, sleepInMillis);
		return wait.until(ExpectedConditions.presenceOfElementLocated(locator));
	}

	//TODO:
	//Remove this method because it is incorrect. If you want to check element on presents you should use
	//ExpectedConditions or just check using 'findElements()' method from WebDriver.
	public void waitForElementPresent(long timeOutInSeconds, long sleepInMillis) {
		WebDriverWait wait = new WebDriverWait(driver, timeOutInSeconds, sleepInMillis);
		try {
			wait.wait(timeOutInSeconds);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

}
