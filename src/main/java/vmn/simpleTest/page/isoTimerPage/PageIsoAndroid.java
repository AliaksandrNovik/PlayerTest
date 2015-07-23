package vmn.simpleTest.page.isoTimerPage;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

/**
 * Created by Aliaksandr_Novik2 on 23.07.15.
 */

public class PageIsoAndroid extends AbstractIsoPage {

    private static final Logger LOGGER = Logger.getLogger(PageIsoAndroid.class);

    private static final String defaultNameOfCurrentTask = "defaulttask";

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


}
