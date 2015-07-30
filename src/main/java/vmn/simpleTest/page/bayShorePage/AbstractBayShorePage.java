package vmn.simpleTest.page.bayShorePage;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import vmn.simpleTest.page.Page;

/**
 * Created by Aliaksandr_Novik2 on 27.07.15.
 */
public abstract class AbstractBayShorePage extends Page {

    private static final Logger LOGGER = Logger.getLogger(AbstractBayShorePage.class);

    public AbstractBayShorePage(WebDriver driver) {
        super(driver);
        LOGGER.info("Abstract BayShore Page has been initialised");
    }

    public abstract void clicnOnButtonWishList();

    public abstract void setFirstName(String name);

    public abstract void setLastName(String nameLast);

    public abstract void setEmail(String email);

    public abstract void clickOnButtonSubmit();

    public abstract boolean checkIsError();

    public abstract void closeMobileKeyBoard();

}
