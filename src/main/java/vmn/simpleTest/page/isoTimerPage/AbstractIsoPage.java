package vmn.simpleTest.page.isoTimerPage;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import vmn.simpleTest.page.Page;

/**
 * Created by Aliaksandr_Novik2 on 23.07.15.
 */
public abstract class AbstractIsoPage extends Page {

    private static final Logger LOGGER = Logger.getLogger(AbstractIsoPage.class);

    public AbstractIsoPage(WebDriver driver) {
        super(driver);
        LOGGER.info("Abstract Iso Page has been initialised");
    }

    public abstract void clickOnButtonToDoList();

    public abstract void clickOnButtonAddTaskToday();

    public abstract void setNameOfCurrentTask();

    public abstract void openSettingsOfTask();

    public abstract void clickOnButtonPostPoneTo();

    public abstract void moveSliderInPostPone();

    public abstract void clickOnButtonOk();

    public abstract void clickOnButtonBack();

    public abstract void clickOnButtonCalendar();

    public abstract void selectTomorrowDay();

    public abstract void clickOnButtonCheckTask();

    public abstract boolean checkIsTaskExist();

}
