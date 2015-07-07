package vmn.simpleTest.test;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import vmn.simpleTest.constant.VmnConstant;
import vmn.simpleTest.guice.DriverGuice;
import vmn.simpleTest.page.AbstractVmnPage;
import vmn.simpleTest.page.PageVmnIOS;

import com.google.inject.Guice;
import com.google.inject.Inject;
import com.google.inject.Injector;

public class TestVideoLoader {

	private AbstractVmnPage abstractPage;
	@Inject
	private WebDriver driver;

	@BeforeClass
	public void injectMembers() {
		Injector injector = Guice.createInjector(new DriverGuice());
		injector.injectMembers(this);
	}

	@Test
	public void testForButtonGames() {
		abstractPage = new PageVmnIOS(driver);
		abstractPage.clickOnButtonVMNSamplApp();
		abstractPage.clickOnButtonLoadVideo();
		Assert.assertTrue(abstractPage.checkIsVideoLoading());
		abstractPage.demoSetPalyerTime(VmnConstant.DEFAULT_SET_PLAYER_TIME);
	}

}
