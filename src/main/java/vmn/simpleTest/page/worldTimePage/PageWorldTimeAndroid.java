package vmn.simpleTest.page.worldTimePage;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.text.SimpleDateFormat;
import java.util.Calendar;

/**
 * Created by Aliaksandr_Novik2 on 27.07.15.
 */
public class PageWorldTimeAndroid extends AbstractWorldTimePage {
    private static final Logger LOGGER = Logger.getLogger(PageWorldTimeAndroid.class);

    @FindBy(id = "search")
    private WebElement fieldSearch;

    @FindBy(className = "btn-search")
    private WebElement buttonSearch;

    @FindBy(className = "timeResult")
    private WebElement timeFromPage;

    public PageWorldTimeAndroid(WebDriver driver) {
        super(driver);
    }

    @Override
    public void openPage(String urlPage) {
        LOGGER.info("Opening " + urlPage + " ...");
        driver.get(urlPage);
    }

    @Override
    public void searchTown(String townName) {
        LOGGER.info("Search town " + townName + "...");
        fieldSearch.sendKeys(townName);
    }

    @Override
    public void clickOnButtonSearchTown() {
        LOGGER.info("Click on button search town ");
        buttonSearch.click();
    }

    @Override
    public boolean checkIsCurrentTimeCorrect() {
        String timeStamp = new SimpleDateFormat("HH:mm").format(Calendar.getInstance().getTime());
        LOGGER.info("Current time :" + timeStamp + "\n" + "Time from page : " + timeFromPage.getText());
        return timeFromPage.getText().equals(timeStamp);
    }

}


