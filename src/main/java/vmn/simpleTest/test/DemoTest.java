package vmn.simpleTest.test;

import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.Test;
import vmn.simpleTest.constant.VmnConstant;
import vmn.simpleTest.constant.capability.AndroidCapability;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Set;

/**
 * Created by Aliaksandr_Novik2 on 30.07.15.
 */
public class DemoTest {

    private static URL remoteAddress;
    private static File appDir = new File(VmnConstant.PATH_TO_APP_DIR);
    private static File appFileNameAndroid = new File(appDir, VmnConstant.FILENAME_APP_ANDROID_BAYSHARE);
    private AndroidDriver driver;

    @Test
    public void run() {

        DesiredCapabilities caps = new DesiredCapabilities();

        caps.setCapability("deviceName", "Selendroid");
        caps.setCapability("platformName", AndroidCapability.PLATFORM_NAME);
        caps.setCapability("automationName", AndroidCapability.AUTOMATION_NAME);
        caps.setCapability("udid", AndroidCapability.UDID);
        caps.setCapability("app", appFileNameAndroid.getAbsolutePath());
        caps.setCapability("appWaitActivity", "com.biznessapps.activities.HomeScreenActivity");
        try {
            remoteAddress = new URL(VmnConstant.REMOTE_APPIUM_URL);
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
        driver = new AndroidDriver(remoteAddress, caps);
        try {
            Thread.sleep(4000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        WebElement elemnt = driver.findElement(By.name("Wishlist"));
        elemnt.click();
        Set<String> contextNames = driver.getContextHandles();
        try {
            Thread.sleep(4000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        for (String contextName : contextNames) {
            System.out.println(contextNames);
        }
        driver.context(contextNames.toArray()[1].toString());
        System.out.println(driver.getPageSource());
        for (String contextName : contextNames) {
            System.out.println(contextNames);
        }
        // driver.context(contextNames.toArray()[1]); // set context to WEBVIEW_1

    }
}
