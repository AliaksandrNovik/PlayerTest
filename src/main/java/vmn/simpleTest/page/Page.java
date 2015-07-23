package vmn.simpleTest.page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import vmn.simpleTest.constant.VmnConstant;

public abstract class Page {

    protected WebDriver driver;

    public Page(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);

    }

    public WebElement waitForElement(By locator, long timeOutInSeconds, long sleepInMillis) {
        WebDriverWait wait = new WebDriverWait(driver, timeOutInSeconds, sleepInMillis);
        return wait.until(ExpectedConditions.presenceOfElementLocated(locator));
    }

    public void waitForElement(WebElement waitButton){
        new WebDriverWait(driver, VmnConstant.IMPLICITY_WAIT).until(ExpectedConditions
                .visibilityOf(waitButton));
    }

}
