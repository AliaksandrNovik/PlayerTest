package vmn.simpleTest.page;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import vmn.simpleTest.constant.VmnConstant;
import vmn.simpleTest.utils.Sleeper;

public class PageVmnAndroid extends AbstractVmnPage {

	private static final Logger LOGGER = Logger.getLogger(PageVmnAndroid.class);

	private By xpathButtonVmnSample = By.xpath("//*[@id='vmn_sample_app_button']");
	private WebElement buttonVMNSampleApp;

	private By xpathButtonConfigureVideo = By.xpath("//*[@id='configure_btn']");
	private WebElement buttonConfigure;

	private By xpathButtonLoadVideo = By.xpath("//*[@id='load_video_btn']");
	private WebElement buttonLoadVideo;

	private By xpathStartTimeStatus = By.xpath("//*[@id='current_time']");
	private WebElement startTimeStatus;

	private WebDriver driver;

	public PageVmnAndroid(WebDriver driver) {
		super(driver);
		this.driver = driver;
	}

	@Override
	public boolean checkIsVideoLoading() {

		LOGGER.info("wait of loading video for " + VmnConstant.IMPLICITY_WAIT + " seconds");
		try {
			Sleeper.getInstance().sleep(VmnConstant.IMPLICITY_WAIT_MILLSEC);
			startTimeStatus = driver.findElement(xpathStartTimeStatus);
			LOGGER.info("current duration is : " + startTimeStatus.getAttribute("text"));
		} catch (RuntimeException re) {
			LOGGER.error("Video does not run " + re.getLocalizedMessage());
		}

		if (getLengthVideoInSec(startTimeStatus) > 0) {
			return true;
		} else
			return false;
	}

	public double getLengthVideoInSec(WebElement currentStatus) {
		String currentDuration = currentStatus.getAttribute("text");
		String[] lengthVideoArray = currentDuration.split(":");
		double minutes = Integer.parseInt(lengthVideoArray[0]);
		double seconds = Integer.parseInt(lengthVideoArray[1]);
		double allDurationVideoInSeconds = (minutes * 60) + seconds;
		LOGGER.info("Duration = " + allDurationVideoInSeconds + " sec");
		return allDurationVideoInSeconds;
	}

	@Override
	public void clickButtonConfigure() {
		buttonConfigure = driver.findElement(xpathButtonConfigureVideo);
		buttonConfigure.click();
		LOGGER.info("click on button ConfigureVideo");
	}

	@Override
	public void clickOnButtonLoadVideo() {
		buttonLoadVideo = driver.findElement(xpathButtonLoadVideo);
		buttonLoadVideo.click();
		LOGGER.info("click on button LoadVideo");
	}

	@Override
	public void clickOnButtonVMNSamplApp() {
		buttonVMNSampleApp = driver.findElement(xpathButtonVmnSample);
		buttonVMNSampleApp.click();
		LOGGER.info("click on button VmnSampleApp");
		Sleeper.getInstance().sleep(1000);
	}

}
