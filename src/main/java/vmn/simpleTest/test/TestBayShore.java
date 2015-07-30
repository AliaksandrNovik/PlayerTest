package vmn.simpleTest.test;

import com.google.inject.Guice;
import com.google.inject.Inject;
import com.google.inject.Injector;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import vmn.simpleTest.constant.VmnConstant;
import vmn.simpleTest.driverType.DriverTypes;
import vmn.simpleTest.guice.DriverGuice;
import vmn.simpleTest.page.bayShorePage.AbstractBayShorePage;
import vmn.simpleTest.page.bayShorePage.PageBayStroreAndroid;
import vmn.simpleTest.utils.PropertyUtils;

import java.io.IOException;

/**
 * Created by Aliaksandr_Novik2 on 23.07.15.
 */

public class TestBayShore {

    private static final String NAME = "NAME";
    private static final String LAST_NAME = "LAST_NAME";
    private static final String EMAIL = "example@example.com";
    private AbstractBayShorePage abstractPage;
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
        abstractPage = new PageBayStroreAndroid(driver);
        abstractPage.clicnOnButtonWishList();
        abstractPage.setFirstName(NAME);
        abstractPage.setLastName(LAST_NAME);
        abstractPage.closeMobileKeyBoard();
        abstractPage.setEmail(EMAIL);
        abstractPage.closeMobileKeyBoard();
        abstractPage.clickOnButtonSubmit();
        Assert.assertTrue(abstractPage.checkIsError());
    }
}
