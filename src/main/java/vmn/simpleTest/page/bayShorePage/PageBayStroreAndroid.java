package vmn.simpleTest.page.bayShorePage;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

/**
 * Created by Aliaksandr_Novik2 on 27.07.15.
 */
public class PageBayStroreAndroid extends AbstractBayShorePage {

    private static final Logger LOGGER = Logger.getLogger(PageBayStroreAndroid.class);

    @FindBy(xpath = "com.timleg.egoTimerLight:id/btnToDoList")
    private WebElement buttonToDo;



    public PageBayStroreAndroid(WebDriver driver) {
        super(driver);
    }
}
