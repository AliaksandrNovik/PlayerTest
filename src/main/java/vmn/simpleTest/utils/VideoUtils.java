package vmn.simpleTest.utils;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import vmn.simpleTest.constant.VmnConstant;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;

public class VideoUtils {

    private static final Logger LOGGER = Logger.getLogger(VideoUtils.class);

    public static double getLengthVideoInSec(WebElement currentStatus) {
        String currentDuration = currentStatus.getAttribute("value");
        String[] lengthVideoArray = currentDuration.split(":");
        double hour = Integer.parseInt(lengthVideoArray[0]);
        double minutes = Integer.parseInt(lengthVideoArray[1]);
        double seconds = Integer.parseInt(lengthVideoArray[2]);
        double allDurationVideoInSeconds = (hour * 3600) + (minutes * 60) + seconds;
        LOGGER.info("Duration = " + allDurationVideoInSeconds + " sec");
        return allDurationVideoInSeconds;
    }

    public static void iosTapByCoordinates(WebDriver driver, int x, int y) {
        LOGGER.info("target.tap({x:" + x + ", y:" + y + "});");
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("target.tap({x:" + x + ", y:" + y + "});");
    }

    public static boolean checkIsVideoLoading(WebDriver driver, By xpathStartTimeStatus, WebElement startTimeStatus) {
        LOGGER.info("wait of loading video for " + VmnConstant.IMPLICITY_WAIT + " seconds");
        try {
            WaitUtils.waitUntilElementExistsAndGetsValue(driver, xpathStartTimeStatus, VmnConstant.DEFAULT_PLAYER_WAIT_TIME_SEC);
            LOGGER.info("current duration is : " + startTimeStatus.getAttribute("value"));
        } catch (RuntimeException re) {
            LOGGER.error("Video does not run " + re.getLocalizedMessage());
        }
        return driver.findElements(xpathStartTimeStatus).size() > 0;
    }

    public static void androidTapByCoordinates(WebDriver driver, int x, int y) {
        LOGGER.info("mobile: tap x: " + x + " y: " + y);
        JavascriptExecutor js = (JavascriptExecutor) driver;
        HashMap tapObject = new HashMap();
        tapObject.put("x", x);
        tapObject.put("y", y);
        js.executeScript("mobile: tap", tapObject);
    }
    public static String getTomorrowtDay() {
        DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        Date date = new Date();
        int nextDay = Integer.parseInt(dateFormat.format(date).split("/")[0]) + 1;
        LOGGER.info("Current date is " + dateFormat.format(date));
        LOGGER.info("return  " + Integer.toString(nextDay));
        return Integer.toString(nextDay);
    }

}
