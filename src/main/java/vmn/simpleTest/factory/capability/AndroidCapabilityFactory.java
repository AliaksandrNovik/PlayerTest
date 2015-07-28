package vmn.simpleTest.factory.capability;

import org.apache.log4j.Logger;
import org.openqa.selenium.remote.DesiredCapabilities;
import vmn.simpleTest.constant.capability.AndroidCapability;

import java.io.File;

/**
 * Created by Aliaksandr_Novik2 on 24.07.15.
 */
public class AndroidCapabilityFactory {

    private static final Logger LOGGER = Logger.getLogger(AndroidCapabilityFactory.class);

    private static AndroidCapabilityFactory instance;

    private DesiredCapabilities caps;

    private File appFileNameAndroid;

    public AndroidCapabilityFactory(DesiredCapabilities caps, File appFileNameAndroid) {
        LOGGER.info("Creating Android capability factory ...");
        this.caps = caps;
        this.appFileNameAndroid = appFileNameAndroid;
    }

    public static AndroidCapabilityFactory getInstance(DesiredCapabilities caps, File appFileNameAndroid) {
        if (instance == null) {
            instance = new AndroidCapabilityFactory(caps, appFileNameAndroid);
        }
        return instance;
    }

    public DesiredCapabilities getAndroidCapability() {
        caps.setCapability("deviceName", "Android");
        caps.setCapability("platformName", AndroidCapability.PLATFORM_NAME);
        //caps.setCapability("udid", AndroidCapability.UDID);
        caps.setCapability("app", appFileNameAndroid.getAbsolutePath());
        caps.setCapability("appWaitActivity", "com.biznessapps.activities.HomeScreenActivity");
        return caps;
    }

}
