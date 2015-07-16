package vmn.simpleTest.page;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import vmn.simpleTest.utils.VideoUtils;

import java.util.HashMap;

public class PageVmnIOS extends AbstractVmnPage {

	private static final Logger LOGGER = Logger.getLogger(PageVmnIOS.class);

	private static final double SIZE_STATUS_LOAD = 124.22;

	private static final int DEFAULT_HEIGHT_STATUS_BAR = 355;

	@FindBy(name = "Load  Video Player")
	private WebElement buttonVMNSampleApp;

	@FindBy(name = "Load Vid")
	private WebElement buttonLoadVideo;

	@FindBy(xpath = "//UIAApplication[1]/UIAWindow[2]/UIAStaticText[7]")
	private WebElement endTimeStatus;

	private By xpathStartTimeStatus = By.xpath("//UIAApplication[1]/UIAWindow[2]/UIAStaticText[5]");

	@FindBy(xpath = "//UIAApplication[1]/UIAWindow[2]/UIAStaticText[5]")
	private WebElement startTimeStatus;

	public PageVmnIOS(WebDriver driver) {
		super(driver);
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
		LOGGER.info("click on button VmnSampleApp");
		buttonVMNSampleApp.click();

	}

	@Override
	public void clickOnButtonLoadVideo() {
		swipeDown();
		LOGGER.info("click on button load video");
		buttonLoadVideo.click();

	}

	@Override
	public String getPageType() {
		return "IphoneVmn";
	}

	@Override
	public boolean checkIsVideoLoading() {
		return VideoUtils.checkIsVideoLoading(driver, xpathStartTimeStatus, startTimeStatus);
	}

	public double getNumbersPixelsInSecond() {
		LOGGER.info("pixels in one seconds = " + SIZE_STATUS_LOAD / VideoUtils.getLengthVideoInSec(endTimeStatus));
		return SIZE_STATUS_LOAD / VideoUtils.getLengthVideoInSec(endTimeStatus);
	}

	@Override
	public void demoSetPalyerTime(int time) {
		VideoUtils.iosTapByCoordinates(driver, (int) (SIZE_STATUS_LOAD + time * getNumbersPixelsInSecond()), DEFAULT_HEIGHT_STATUS_BAR);
		LOGGER.info("current status time is  " + VideoUtils.getLengthVideoInSec(startTimeStatus) + "error "
				+ Math.abs(time - VideoUtils.getLengthVideoInSec(startTimeStatus)) + " sec");
	}
}
