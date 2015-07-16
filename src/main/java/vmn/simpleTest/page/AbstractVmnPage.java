package vmn.simpleTest.page;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;

public abstract class AbstractVmnPage extends Page {

	private static final Logger LOGGER = Logger.getLogger(AbstractVmnPage.class);

	public AbstractVmnPage(WebDriver driver) {
		super(driver);
		LOGGER.info("Abstract Page has been initialised");
	}

	public abstract void clickOnButtonVMNSamplApp();

	public String getPageType() {
		return "Abstract";
	}

	public void clickButtonConfigure() {
	}

	public void setConfigureSettings() {
	}

	public void setConfigureLoadVideo() {
	}

	public void clickOnButtonLoadVideo() {
	}

	public abstract boolean checkIsVideoLoading();

	public abstract void demoSetPalyerTime(int time);

}
