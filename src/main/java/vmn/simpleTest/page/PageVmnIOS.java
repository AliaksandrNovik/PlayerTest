package vmn.simpleTest.page;

import java.util.HashMap;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import vmn.simpleTest.constant.VmnConstant;
import vmn.simpleTest.utils.Sleeper;

public class PageVmnIOS extends AbstractVmnPage {
	private static final Logger LOGGER = Logger.getLogger(PageVmnIOS.class);

	private final double SIZE_STATUS_LOAD = 124.22;

	private final int DEFAULT_HEIGHT_STATUS_BAR = 355;

	private WebDriver driver;

	private By xpathButtonVmnSample = By.xpath("//UIAApplication[1]/UIAWindow[2]/UIAButton[2]");
	private WebElement buttonVMNSampleApp;

	private By xpathButtonLoadVideo = By.xpath("//UIAApplication[1]/UIAWindow[2]/UIAScrollView[1]/UIAButton[10]");
	private WebElement buttonLoadVideo;

	private By xpathEndTimeStatus = By.xpath("//UIAApplication[1]/UIAWindow[2]/UIAStaticText[7]");
	private WebElement endTimeStatus;

	private By xpathStartTimeStatus = By.xpath("//UIAApplication[1]/UIAWindow[2]/UIAStaticText[5]");
	private WebElement startTimeStatus;

	public PageVmnIOS(WebDriver driver) {
		super(driver);
		this.driver = driver;
	}

	public void swipeDown() {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		HashMap<String, String> scrollMap = new HashMap<String, String>();
		scrollMap.put("direction", "down");
		js.executeScript("mobile: scroll", scrollMap);
		LOGGER.info("scrolling down");
	}

	@Override
	public void clickOnButtonVMNSamplApp() {
		buttonVMNSampleApp = driver.findElement(xpathButtonVmnSample);
		buttonVMNSampleApp.click();
		LOGGER.info("click on button VmnSampleApp");
	}

	@Override
	public void clickOnButtonLoadVideo() {
		swipeDown();
		buttonLoadVideo = driver.findElement(xpathButtonLoadVideo);
		buttonLoadVideo.click();
		LOGGER.info("click on button load video");
	}

	@Override
	public String getPageType() {
		return "IphoneVmn";
	}

	@Override
	public boolean checkIsVideoLoading() {
		LOGGER.info("wait of loading video for " + VmnConstant.IMPLICITY_WAIT + " seconds");
		try {
			Sleeper.getInstance().sleep(VmnConstant.IMPLICITY_WAIT_MILLSEC);
			startTimeStatus = driver.findElement(xpathStartTimeStatus);
			LOGGER.info("current duration is : " + startTimeStatus.getAttribute("value"));
		} catch (RuntimeException re) {
			LOGGER.error("Video does not run " + re.getLocalizedMessage());
		}

		if (getLengthVideoInSec(startTimeStatus) > 0) {
			return true;
		} else
			return false;
	}

	public double getLengthVideoInSec(WebElement currentStatus) {
		String currentDuration = currentStatus.getAttribute("value");
		String[] lengthVideoArray = currentDuration.split(":");
		double hour = Integer.parseInt(lengthVideoArray[0]);
		double minutes = Integer.parseInt(lengthVideoArray[1]);
		double seconds = Integer.parseInt(lengthVideoArray[2]);
		double allDurationVideoInSeconds = (hour * 3600) + (minutes * 60) + seconds;
		LOGGER.info("Duration = " + allDurationVideoInSeconds + " sec");
		return allDurationVideoInSeconds;
	}

	public void IosTapByCoordinates(int x, int y) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("target.tap({x:" + x + ", y:" + y + "});");
	}

	public double getNumbersPixelsInSecond() {
		LOGGER.info("pixels in one seconds = " + SIZE_STATUS_LOAD / getLengthVideoInSec(endTimeStatus));
		return SIZE_STATUS_LOAD / getLengthVideoInSec(endTimeStatus);
	}

	@Override
	public void demoSetPalyerTime(int time) {
		endTimeStatus = driver.findElement(xpathEndTimeStatus);
		startTimeStatus = driver.findElement(xpathStartTimeStatus);
		IosTapByCoordinates((int) (SIZE_STATUS_LOAD + time * getNumbersPixelsInSecond()), DEFAULT_HEIGHT_STATUS_BAR);
		LOGGER.info("current status time is  " + getLengthVideoInSec(startTimeStatus) + "error "
				+ Math.abs(time - getLengthVideoInSec(startTimeStatus)) + " sec");
	}
}
