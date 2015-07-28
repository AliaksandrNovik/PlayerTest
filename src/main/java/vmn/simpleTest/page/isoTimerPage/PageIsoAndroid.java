package vmn.simpleTest.page.isoTimerPage;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import vmn.simpleTest.utils.VideoUtils;


/**
 * Created by Aliaksandr_Novik2 on 23.07.15.
 */

public class PageIsoAndroid extends AbstractIsoPage {

    private static final Logger LOGGER = Logger.getLogger(PageIsoAndroid.class);

    private static final String defaultNameOfCurrentTask = "defaulttask";

    private static final int TAP_COORDINATE_X = 141;

    private static final int TAP_COORDINATE_Y = 945;

    @FindBy(id = "com.timleg.egoTimerLight:id/btnToDoList")
    private WebElement buttonToDo;

    @FindBy(id = "com.timleg.egoTimerLight:id/txtHintTasksGoHere")
    private WebElement fieldAddNewTask;

    @FindBy(id = "com.timleg.egoTimerLight:id/edittext")
    private WebElement fieldEditText;

    @FindBy(id = "com.timleg.egoTimerLight:id/btnAdd")
    private WebElement buttonAddTask;

    @FindBy(name = defaultNameOfCurrentTask)
    private WebElement currentTask;

    @FindBy(id = "com.timleg.egoTimerLight:id/imgPostponeTo")
    private WebElement buttonPostponeTo;

    @FindBy(id = "com.timleg.egoTimerLight:id/txtSeekBarReminder")
    private WebElement fieldSeekReminder;

    @FindBy(id = "com.timleg.egoTimerLight:id/btnDone")
    private WebElement buttonBack;

    @FindBy(id = "com.timleg.egoTimerLight:id/btnCal")
    private WebElement buttonCalendar;

    @FindBy(name = "OK")
    private WebElement buttonOK;

    private By xpathTomorrowDay = By.name(VideoUtils.getTomorrowtDay());
    private WebElement buttonTomorrowDay;

    @FindBy(xpath = " //android.widget.LinearLayout[1]/android.widget.ImageView[1]")
    private WebElement buttonCheckStatusTask;

    public PageIsoAndroid(WebDriver driver) {
        super(driver);
    }

    @Override
    public void clickOnButtonToDoList() {
        waitForElement(buttonToDo);
        buttonToDo.click();
        LOGGER.info("Click on button ToDoList");
    }

    @Override
    public void clickOnButtonAddTaskToday() {
        LOGGER.info("Click on button addTaskToDay");
        fieldAddNewTask.click();
    }

    @Override
    public void setNameOfCurrentTask() {
        LOGGER.info("Set Name of task : " + defaultNameOfCurrentTask);
        fieldEditText.sendKeys(defaultNameOfCurrentTask);
        LOGGER.info("Click on button addtask ");
        buttonAddTask.click();
    }

    @Override
    public void openSettingsOfTask() {
        LOGGER.info("Open settings of task : " + defaultNameOfCurrentTask);
        currentTask.click();
    }

    @Override
    public void clickOnButtonPostPoneTo() {
        LOGGER.info("Click on button Postpone to");
        buttonPostponeTo.click();
    }

    @Override
    public void moveSliderInPostPone() {
        while (!fieldSeekReminder.getAttribute("name").contains("1 день")
                ) {
            LOGGER.info(fieldSeekReminder.getAttribute("name"));
            VideoUtils.androidTapByCoordinates(driver, TAP_COORDINATE_X, TAP_COORDINATE_Y);
        }
    }

    @Override
    public void clickOnButtonOk() {
        LOGGER.info("Click on button Back");
        buttonOK.click();
    }

    @Override
    public void clickOnButtonBack() {
        LOGGER.info("Click on button Back");
        buttonBack.click();
    }

    @Override
    public void clickOnButtonCalendar() {
        LOGGER.info("Click on button Calendar");
        buttonCalendar.click();
    }

    @Override
    public void selectTomorrowDay() {
        LOGGER.info("Select tomorrow day ");
        buttonTomorrowDay = driver.findElement(xpathTomorrowDay);
        buttonTomorrowDay.click();
    }

    @Override
    public void clickOnButtonCheckTask() {
        LOGGER.info("Click on button check task");
        buttonCheckStatusTask.click();
    }

    @Override
    public boolean checkIsTaskExist() {
        LOGGER.info("Check is current task by name: " + defaultNameOfCurrentTask + " displaeyd");
        return currentTask.isDisplayed();
    }


}
