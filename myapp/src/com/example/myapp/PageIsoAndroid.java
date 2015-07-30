package com.example.myapp;

import org.apache.log4j.Logger;

import android.view.View;

import com.robotium.solo.Solo;

/**
 * Created by Aliaksandr_Novik2 on 23.07.15.
 */

public class PageIsoAndroid {

	private static final Logger LOGGER = Logger.getLogger(PageIsoAndroid.class);

	private Solo solo;

	private static final int TAP_COORDINATE_X = 141;

	private static final int TAP_COORDINATE_Y = 945;

	private int btnToDoList;

	private int txtHintTasksGoHere;

	private int edittext;

	private int btnAdd;

	private int imgPostponeTo;

	private int txtSeekBarReminder;

	private int btnDone;

	private int btnCal;

	private String defaultNameOfCurrentTask = "defaulttask";

	private String buttonOk = "OK";

	/*
	 * @FindBy(id = "com.timleg.egoTimerLight:id/btnToDoList") private
	 * WebElement buttonToDo;
	 * 
	 * @FindBy(id = "com.timleg.egoTimerLight:id/txtHintTasksGoHere") private
	 * WebElement fieldAddNewTask;
	 * 
	 * @FindBy(id = "com.timleg.egoTimerLight:id/edittext") private WebElement
	 * fieldEditText;
	 * 
	 * @FindBy(id = "com.timleg.egoTimerLight:id/btnAdd") private WebElement
	 * buttonAddTask;
	 * 
	 * @FindBy(name = defaultNameOfCurrentTask) private WebElement currentTask;
	 * 
	 * @FindBy(id = "com.timleg.egoTimerLight:id/imgPostponeTo") private
	 * WebElement buttonPostponeTo;
	 * 
	 * @FindBy(id = "com.timleg.egoTimerLight:id/txtSeekBarReminder") private
	 * WebElement fieldSeekReminder;
	 * 
	 * @FindBy(id = "com.timleg.egoTimerLight:id/btnDone") private WebElement
	 * buttonBack;
	 * 
	 * @FindBy(id = "com.timleg.egoTimerLight:id/btnCal") private WebElement
	 * buttonCalendar;
	 * 
	 * @FindBy(name = "OK") private WebElement buttonOK;
	 * 
	 * private By xpathTomorrowDay = By.name(VideoUtils.getTomorrowtDay());
	 * private WebElement buttonTomorrowDay;
	 * 
	 * @FindBy(xpath =
	 * " //android.widget.LinearLayout[1]/android.widget.ImageView[1]") private
	 * WebElement buttonCheckStatusTask;
	 */
	public PageIsoAndroid(Solo solo) {
		this.solo = solo;
	}

	public void clickOnButtonToDoList() {
		solo.waitForView(btnToDoList);
		View btnToDoListView = solo.getView(btnToDoList);
		solo.clickOnView(btnToDoListView);
		LOGGER.info("Click on button ToDoList");
	}

	/*
	 * public void clickOnButtonAddTaskToday() {
	 * LOGGER.info("Click on button addTaskToDay"); fieldAddNewTask.click(); }
	 * 
	 * public void setNameOfCurrentTask() { LOGGER.info("Set Name of task : " +
	 * defaultNameOfCurrentTask);
	 * fieldEditText.sendKeys(defaultNameOfCurrentTask);
	 * LOGGER.info("Click on button addtask "); buttonAddTask.click(); }
	 * 
	 * public void openSettingsOfTask() { LOGGER.info("Open settings of task : "
	 * + defaultNameOfCurrentTask); currentTask.click(); }
	 * 
	 * public void clickOnButtonPostPoneTo() {
	 * LOGGER.info("Click on button Postpone to"); buttonPostponeTo.click(); }
	 * 
	 * public void moveSliderInPostPone() { while
	 * (!fieldSeekReminder.getAttribute("name").contains("1 день")) {
	 * LOGGER.info(fieldSeekReminder.getAttribute("name"));
	 * VideoUtils.androidTapByCoordinates(driver, TAP_COORDINATE_X,
	 * TAP_COORDINATE_Y); } }
	 * 
	 * public void clickOnButtonOk() { LOGGER.info("Click on button Back");
	 * buttonOK.click(); }
	 * 
	 * public void clickOnButtonBack() { LOGGER.info("Click on button Back");
	 * buttonBack.click(); }
	 * 
	 * public void clickOnButtonCalendar() {
	 * LOGGER.info("Click on button Calendar"); buttonCalendar.click(); }
	 * 
	 * public void selectTomorrowDay() { LOGGER.info("Select tomorrow day ");
	 * buttonTomorrowDay = driver.findElement(xpathTomorrowDay);
	 * buttonTomorrowDay.click(); }
	 * 
	 * public void clickOnButtonCheckTask() {
	 * LOGGER.info("Click on button check task"); buttonCheckStatusTask.click();
	 * }
	 * 
	 * public boolean checkIsTaskExist() {
	 * LOGGER.info("Check is current task by name: " + defaultNameOfCurrentTask
	 * + " displaeyd"); return currentTask.isDisplayed(); }
	 */
}
