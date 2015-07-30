package vmn.simpleTest.factory.capability;

import org.apache.log4j.Logger;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import vmn.simpleTest.constant.capability.AndroidCapability;

/**
 * Created by Aliaksandr_Novik2 on 27.07.15.
 */
public class AndroidCapabilityFactoryWeb {

    private static final Logger LOGGER = Logger.getLogger(AndroidCapabilityFactoryWeb.class);

    private static AndroidCapabilityFactoryWeb instance;

    private DesiredCapabilities caps;

    public AndroidCapabilityFactoryWeb(DesiredCapabilities caps) {
        LOGGER.info("Creating Android Web capability factory ...");
        this.caps = caps;
    }

    public static AndroidCapabilityFactoryWeb getInstance(DesiredCapabilities caps) {
        if (instance == null) {
            instance = new AndroidCapabilityFactoryWeb(caps);
        }
        return instance;
    }

    public DesiredCapabilities getAndroidCapability() {
        caps.setCapability(CapabilityType.VERSION, 4.4);
        caps.setCapability("browserName", "Browser");
        caps.setCapability("platformName", AndroidCapability.PLATFORM_NAME);
        caps.setCapability("udid", AndroidCapability.UDID);
        caps.setCapability("deviceName", "Android");
        caps.setCapability("newCommandTimeOut", 200);
        return caps;
    }
}
