package vmn.simpleTest.page;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import vmn.simpleTest.constant.VmnConstant;
import vmn.simpleTest.utils.WaitUtils;

public class PageVmnAndroid extends AbstractVmnPage {

	private static final Logger LOGGER = Logger.getLogger(PageVmnAndroid.class);

	@FindBy(xpath = "//*[@id='vmn_sample_app_button']")
	private WebElement buttonVMNSampleApp;

	@FindBy(xpath = "//*[@id='configure_btn']")
	private WebElement buttonConfigure;

	@FindBy(xpath = "//*[@id='load_video_btn']")
	private WebElement buttonLoadVideo;

	private By xpathStartTimeStatus = By.xpath("//*[@id='current_time']");
	@FindBy(xpath = "//*[@id='current_time']")
	private WebElement startTimeStatus;

	public PageVmnAndroid(WebDriver driver) {
		super(driver);
		//remove this
		this.driver = driver;
	}

	
	@Override
	public boolean checkIsVideoLoading() {

		LOGGER.info("wait of loading video for " + VmnConstant.IMPLICITY_WAIT + " seconds");
		try {
			WaitUtils.waitUntilElementExists(driver, xpathStartTimeStatus);
			//TODO:
			//create method for checking on element exist or use 'findElements' method and check on size
			LOGGER.info("current duration is : " + startTimeStatus.getAttribute("text"));
			return true;
		} catch (RuntimeException re) {
			LOGGER.error("Video does not run " + re.getLocalizedMessage());
			return false;
		}

	}

	//TODO:
	//remove this method because it is not used nowhere and it was moved to VideoUtils
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
		buttonConfigure.click();
		LOGGER.info("click on button ConfigureVideo");
	}

	@Override
	public void clickOnButtonLoadVideo() {
		buttonLoadVideo.click();
		LOGGER.info("click on button LoadVideo");
	}

	@Override
	public void clickOnButtonVMNSamplApp() {
		buttonVMNSampleApp.click();
		LOGGER.info("click on button VmnSampleApp");
	}

}
