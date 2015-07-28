package vmn.simpleTest.factory.capability;

import org.apache.log4j.Logger;
import org.openqa.selenium.remote.DesiredCapabilities;
import vmn.simpleTest.constant.capability.AndroidCapability;

import java.io.File;

/**
 * Created by Aliaksandr_Novik2 on 24.07.15.
 */
public class SelendroidCapabilityFactory {

    private static final Logger LOGGER = Logger.getLogger(SelendroidCapabilityFactory.class);

    private static SelendroidCapabilityFactory instance;

    private DesiredCapabilities caps;

    private File appFileNameAndroid;

    public SelendroidCapabilityFactory(DesiredCapabilities caps, File appFileNameAndroid) {
        LOGGER.info("Creating Selendroid capability factory ...");
        this.caps = caps;
        this.appFileNameAndroid = appFileNameAndroid;
    }

    public static SelendroidCapabilityFactory getInstance(DesiredCapabilities caps, File appFileNameAndroid) {
        if (instance == null) {
            instance = new SelendroidCapabilityFactory(caps, appFileNameAndroid);
        }
        return instance;
    }

    public DesiredCapabilities getSelendroidCapability() {
        caps.setCapability("deviceName", "Android");
        caps.setCapability("platformName", AndroidCapability.PLATFORM_NAME);
        caps.setCapability("automationName", AndroidCapability.AUTOMATION_NAME);
        caps.setCapability("udid", AndroidCapability.UDID);
        caps.setCapability("app", appFileNameAndroid.getAbsolutePath());
        caps.setCapability("appWaitActivity", "com.timleg.egoTimer.preMain");
        caps.setCapability("appPackage", "com.timleg.egoTimer");


        return caps;
    }
}
