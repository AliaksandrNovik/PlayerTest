package vmn.simpleTest.page.bayShorePage;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import vmn.simpleTest.page.Page;

/**
 * Created by Aliaksandr_Novik2 on 27.07.15.
 */
public class AbstractBayShorePage extends Page {

    private static final Logger LOGGER = Logger.getLogger(AbstractBayShorePage.class);

    public AbstractBayShorePage(WebDriver driver) {
        super(driver);
        LOGGER.info("Abstract BayShore Page has been initialised");
    }

}
