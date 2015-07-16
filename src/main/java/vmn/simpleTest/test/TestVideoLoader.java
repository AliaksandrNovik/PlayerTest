package vmn.simpleTest.test;

import java.io.IOException;

import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import vmn.simpleTest.constant.VmnConstant;
import vmn.simpleTest.driverType.DriverTypes;
import vmn.simpleTest.guice.DriverGuice;
import vmn.simpleTest.page.AbstractVmnPage;
import vmn.simpleTest.page.PageVmnAndroid;
import vmn.simpleTest.utils.PropertyUtils;

import com.google.inject.Guice;
import com.google.inject.Inject;
import com.google.inject.Injector;

public class TestVideoLoader {

	private AbstractVmnPage abstractPage;

	@Inject
	private WebDriver driver;

	@BeforeClass
	public void injectMembers() throws IOException {
		PropertyConfigurator.configure(VmnConstant.LOG4_CONFIG_PATH);
		Injector injector = Guice.createInjector(new DriverGuice(DriverTypes.getDriverType(PropertyUtils.getInstance().getProperties(
				"DriverType"))));
		injector.injectMembers(this);
	}

	@Test
	public void testForPlayerLoad() {
		abstractPage = new PageVmnAndroid(driver);
		abstractPage.clickOnButtonVMNSamplApp();
		abstractPage.clickButtonConfigure();
		abstractPage.clickOnButtonLoadVideo();
		Assert.assertTrue(abstractPage.checkIsVideoLoading());
		abstractPage.demoSetPalyerTime(VmnConstant.DEFAULT_SET_PLAYER_TIME);
	}

}