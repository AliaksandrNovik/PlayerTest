package vmn.simpleTest.page;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import vmn.simpleTest.constant.VmnConstant;
import vmn.simpleTest.utils.VideoUtils;
import vmn.simpleTest.utils.WaitUtils;

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

	private By xpathStartTimeStatus = By.xpath("//UIAApplication[1]/UIAWindow[1]/UIAStaticText[5]");
	@FindBy(xpath = "//UIAApplication[1]/UIAWindow[1]/UIAStaticText[5]")
	private WebElement startTimeStatus;

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
		LOGGER.info("wait of loading video for " + VmnConstant.IMPLICITY_WAIT + " seconds");
		try {
			WaitUtils.waitUntilElementExistsAndGetsValue(driver, xpathStartTimeStatus, VmnConstant.DEFAULT_PLAYER_WAIT_TIME_SEC);
			LOGGER.info("current duration is : " + startTimeStatus.getAttribute("value"));
		} catch (RuntimeException re) {
			LOGGER.error("Video does not run " + re.getLocalizedMessage());
		}
		return driver.findElements(xpathStartTimeStatus).size() > 0;
	}


	public void iosTapByCoordinates(int x, int y) {
		LOGGER.info("target.tap({x:" + x + ", y:" + y + "});");
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("target.tap({x:" + x + ", y:" + y + "});");
	}

	public double getNumbersPixelsInSecond() {
		LOGGER.info("pixels in one seconds = " + SIZE_STATUS_LOAD / VideoUtils.getLengthVideoInSec(endTimeStatus));
		return SIZE_STATUS_LOAD / VideoUtils.getLengthVideoInSec(endTimeStatus);
	}

	@Override
	public void demoSetPalyerTime(int time) {
		LOGGER.info("current status time is  " + VideoUtils.getLengthVideoInSec(startTimeStatus) + "error " + Math
				.abs(time - VideoUtils.getLengthVideoInSec(startTimeStatus)) + " sec");
		iosTapByCoordinates((int) (SIZE_STATUS_LOAD + time * getNumbersPixelsInSecond()), DEFAULT_HEIGHT_STATUS_BAR);

	}
}
