package vmn.simpleTest.page;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import vmn.simpleTest.utils.VideoUtils;

public class PageVmnIOSIpad extends AbstractVmnPage {

	private static final Logger LOGGER = Logger.getLogger(PageVmnIOSIpad.class);

	private static final double SIZE_STATUS_LOAD = 508;

	private static final int DEFAULT_HEIGHT_STATUS_BAR = 517;

	@FindBy(name = "Load  Video Player")
	private WebElement buttonVMNSampleApp;

	@FindBy(name = "Load Video")
	private WebElement buttonLoadVideo;

	@FindBy(xpath = "//UIAApplication[1]/UIAWindow[1]/UIAStaticText[7]")
	private WebElement endTimeStatus;

	@FindBy(xpath = "//UIAApplication[1]/UIAWindow[1]/UIAStaticText[5]")
	private WebElement startTimeStatus;

	private By xpathStartTimeStatus = By.xpath("//UIAApplication[1]/UIAWindow[1]/UIAStaticText[5]");

	public PageVmnIOSIpad(WebDriver driver) {
		super(driver);
	}

	@Override
	public void clickOnButtonVMNSamplApp() {
		LOGGER.info("click on button VmnSampleApp");
		buttonVMNSampleApp.click();
	}

	@Override
	public void clickOnButtonLoadVideo() {
		LOGGER.info("click on button load video");
		buttonLoadVideo.click();
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
		LOGGER.info("current status time is  " + VideoUtils.getLengthVideoInSec(startTimeStatus) + "error "
				+ Math.abs(time - VideoUtils.getLengthVideoInSec(startTimeStatus)) + " sec");
		VideoUtils.iosTapByCoordinates(driver, (int) (SIZE_STATUS_LOAD + time * getNumbersPixelsInSecond()), DEFAULT_HEIGHT_STATUS_BAR);

	}
}
