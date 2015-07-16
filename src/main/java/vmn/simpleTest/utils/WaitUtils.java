package vmn.simpleTest.utils;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.FluentWait;
import vmn.simpleTest.constant.VmnConstant;

import java.util.concurrent.TimeUnit;

public class WaitUtils {

	public static boolean equalsDoubleValue(double firstValue, double secondValue) {
		return Math.abs(firstValue - secondValue) < VmnConstant.DOUBLE_ERROR;
	}

	public static void waitUntilElementExists(WebDriver driver,  By by) {
		new FluentWait<WebDriver>(driver).withTimeout(VmnConstant.IMPLICITY_WAIT, TimeUnit.SECONDS)
				.pollingEvery(VmnConstant.POLLING_INTERVAL_MILLSEC, TimeUnit.MILLISECONDS)
				.until(new ExpectedCondition<Boolean>() {
					public Boolean apply(WebDriver wd) {
						return driver.findElements(by).get(0).isDisplayed();
					}
				});
	}

	public static void waitUntilElementExistsAndGetsValue(WebDriver driver, By xpath, double value) {
		new FluentWait<WebDriver>(driver).withTimeout(VmnConstant.IMPLICITY_WAIT, TimeUnit.SECONDS)
				.pollingEvery(VmnConstant.POLLING_INTERVAL_MILLSEC, TimeUnit.MILLISECONDS)
				.until(new ExpectedCondition<Boolean>() {
					public Boolean apply(WebDriver wd) {
						if (driver.findElements(xpath).size() > 0) {
							return equalsDoubleValue(value, VideoUtils.getLengthVideoInSec(driver.findElements(xpath).get(0)));
						}else{
							return false;
						}
					}
				});
	}
}
