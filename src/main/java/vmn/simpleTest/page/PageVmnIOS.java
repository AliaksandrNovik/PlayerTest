package vmn.simpleTest.page;

import java.util.HashMap;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import vmn.simpleTest.constant.VmnConstant;
import vmn.simpleTest.utils.WaitUtils;

public class PageVmnIOS extends AbstractVmnPage {

	private static final Logger LOGGER = Logger.getLogger(PageVmnIOS.class);

	//TODO:
	//Constants should be static
	private final double SIZE_STATUS_LOAD = 124.22;

	private final int DEFAULT_HEIGHT_STATUS_BAR = 355;

	//TODO:
	//try to use xpath locators which have name, id, class attributes, because if you will use only full path for locators 
	//you can faced with issue when for example developers will add additional element.    
	@FindBy(xpath = "//UIAApplication[1]/UIAWindow[2]/UIAButton[2]")
	private WebElement buttonVMNSampleApp;

	@FindBy(xpath = "//UIAApplication[1]/UIAWindow[2]/UIAScrollView[1]/UIAButton[10]")
	private WebElement buttonLoadVideo;

	@FindBy(xpath = "//UIAApplication[1]/UIAWindow[2]/UIAStaticText[7]")
	private WebElement endTimeStatus;

	private By xpathStartTimeStatus = By.xpath("//UIAApplication[1]/UIAWindow[2]/UIAStaticText[5]");

	@FindBy(xpath = "//UIAApplication[1]/UIAWindow[2]/UIAStaticText[5]")
	private WebElement startTimeStatus;

	public PageVmnIOS(WebDriver driver) {
		super(driver);
		//TODO:
		//remove this
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
		buttonVMNSampleApp.click();
		LOGGER.info("click on button VmnSampleApp");
	}

	@Override
	public void clickOnButtonLoadVideo() {
		swipeDown();
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
			WaitUtils.waitUntilElementExistsAndGetsValue(driver, xpathStartTimeStatus, VmnConstant.DEFAULT_PLAYER_WAIT_TIME_SEC);
			LOGGER.info("current duration is : " + startTimeStatus.getAttribute("value"));
			return true;
		} catch (RuntimeException re) {
			LOGGER.error("Video does not run " + re.getLocalizedMessage());
			return false;
		}

	}

	//TODO:
	//This method is a copy of method from VideoUtils class. You should remove one.
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

	//TODO:
	//Name of method should start with lowercase symbol.
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
		IosTapByCoordinates((int) (SIZE_STATUS_LOAD + time * getNumbersPixelsInSecond()), DEFAULT_HEIGHT_STATUS_BAR);
		LOGGER.info("current status time is  " + getLengthVideoInSec(startTimeStatus) + "error "
				+ Math.abs(time - getLengthVideoInSec(startTimeStatus)) + " sec");
	}
}
