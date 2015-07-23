package vmn.simpleTest.test;

import com.google.inject.Guice;
import com.google.inject.Inject;
import com.google.inject.Injector;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import vmn.simpleTest.constant.VmnConstant;
import vmn.simpleTest.driverType.DriverTypes;
import vmn.simpleTest.guice.DriverGuice;
import vmn.simpleTest.page.isoTimerPage.AbstractIsoPage;
import vmn.simpleTest.page.isoTimerPage.PageIsoAndroid;
import vmn.simpleTest.utils.PropertyUtils;

import java.io.IOException;

/**
 * Created by Aliaksandr_Novik2 on 23.07.15.
 */
public class TestIsoTimer {

    private AbstractIsoPage abstractPage;

    @Inject
    private WebDriver driver;

    @BeforeClass
    public void injectMembers() throws IOException {
        PropertyConfigurator.configure(VmnConstant.LOG4_CONFIG_PATH);
        Injector injector = Guice
                .createInjector(new DriverGuice(DriverTypes.getDriverType(PropertyUtils.getInstance().getProperties("DriverType"))));
        injector.injectMembers(this);
    }

    @Test
    public void testForPlayerLoad() {
        abstractPage = new PageIsoAndroid(driver);
        abstractPage.clickOnButtonToDoList();
        abstractPage.clickOnButtonAddTaskToday();
        abstractPage.setNameOfCurrentTask();
        abstractPage.openSettingsOfTask();
        abstractPage.clickOnButtonPostPoneTo();
    }
}
