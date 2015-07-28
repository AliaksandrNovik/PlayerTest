package vmn.simpleTest.page.worldTimePage;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import vmn.simpleTest.page.Page;

/**
 * Created by Aliaksandr_Novik2 on 27.07.15.
 */
public abstract class AbstractWorldTimePage extends Page {

    private static final Logger LOGGER = Logger.getLogger(AbstractWorldTimePage.class);

    public AbstractWorldTimePage(WebDriver driver) {
        super(driver);
    }

    public abstract void openPage(String urlPage);

    public abstract void searchTown(String townName);

    public abstract void clickOnButtonSearchTown();

    public abstract boolean checkIsCurrentTimeCorrect();
}
