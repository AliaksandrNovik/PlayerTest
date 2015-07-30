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

    @FindBy(name = "Wishlist")
    private WebElement buttonWishList;

    @FindBy(xpath = "//android.view.View[1]/android.view.View[2]/android.widget.EditText[1]")
    private WebElement firstName;

    @FindBy(xpath = "//android.view.View[1]/android.view.View[4]/android.widget.EditText[1]")
    private WebElement lastName;

    @FindBy(name = "Submit")
    private WebElement submitBtn;

    @FindBy(xpath = "//android.view.View[3]/android.view.View[2]/android.widget.EditText[1]")
    private WebElement emailField;

    @FindBy(name = "There was a problem with your submission. Heading")
    private WebElement submitError;

    public PageBayStroreAndroid(WebDriver driver) {
        super(driver);
    }

    @Override
    public void clicnOnButtonWishList() {
        LOGGER.info("Click on button wishList");
        waitForElement(buttonWishList);
        buttonWishList.click();
    }


    @Override
    public void setFirstName(String name) {
        LOGGER.info("Set first name : " + name);
        waitForElement(firstName);
        firstName.sendKeys(name);
    }

    @Override
    public void setLastName(String nameLast) {
        LOGGER.info("Set second name : " + nameLast);
        lastName.sendKeys(nameLast);
    }

    @Override
    public void setEmail(String email) {
        LOGGER.info("Set email : " + email);
        waitForElement(emailField);
        emailField.sendKeys(email);
    }

    @Override
    public void clickOnButtonSubmit() {
        LOGGER.info("Click on submit button : ");
        submitBtn.click();
        submitBtn.click();
    }

    @Override
    public boolean checkIsError() {
        waitForElement(submitError);
        return submitError.isDisplayed();
    }

    @Override
    public void closeMobileKeyBoard() {
        LOGGER.info("Close keyBoard");
        driver.navigate().back();
    }
}
