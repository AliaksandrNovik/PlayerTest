package vmn.simpleTest.page;

import java.util.HashMap;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

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

	private By xpathPlayButton = By.xpath("//UIAApplication[1]/UIAWindow[2]/UIAButton[5]");
	private WebElement playButton;

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
		playButton = driver.findElement(xpathPlayButton);
		LOGGER.info("wait of loading video for 30 seconds");
		try {
			waitForElement(xpathPlayButton, 5, 10);
			playButton.click();
			LOGGER.info("click on play button ");
		} catch (RuntimeException re) {
			LOGGER.error("Video does not run " + re.getLocalizedMessage());
			return false;
		}
		return true;
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
