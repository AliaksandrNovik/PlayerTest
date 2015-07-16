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
	}

	
	@Override
	public boolean checkIsVideoLoading() {
		LOGGER.info("wait of loading video for " + VmnConstant.IMPLICITY_WAIT + " seconds");
		try {
			WaitUtils.waitUntilElementExists(driver, xpathStartTimeStatus);
			LOGGER.info("current duration is : " + startTimeStatus.getAttribute("text"));
		} catch (RuntimeException re) {
			LOGGER.error("Video does not run " + re.getLocalizedMessage());
		}
		return driver.findElements(xpathStartTimeStatus).size() > 0;

	}

	@Override
	public void clickButtonConfigure() {
		LOGGER.info("click on button ConfigureVideo");
		buttonConfigure.click();
	}

	@Override
	public void clickOnButtonLoadVideo() {
		LOGGER.info("click on button LoadVideo");
		buttonLoadVideo.click();
	}

	@Override
	public void clickOnButtonVMNSamplApp() {
		LOGGER.info("click on button VmnSampleApp");
		buttonVMNSampleApp.click();
	}

	@Override public void demoSetPalyerTime(int time) {
		LOGGER.info("set player time");
		throw new UnsupportedOperationException("Not supported yet for android application");
	}

}
