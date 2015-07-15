package vmn.simpleTest.page;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;

public abstract class AbstractVmnPage extends Page {

	private static final Logger LOGGER = Logger.getLogger(AbstractVmnPage.class);

	public AbstractVmnPage(WebDriver driver) {
		super(driver);
		LOGGER.info("Abstract Page has been initialised");
	}

	//TODO:
	//Why this method is empty? May be there is reason to mark this method as abstract and realize on implementations?
	public void clickOnButtonVMNSamplApp() {
	}

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

	//TODO:
	//Why this method is empty? May be there is reason to mark this method as abstract and realize on implementations?
	public void demoSetPalyerTime(int time) {
	}

}
