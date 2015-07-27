package vmn.simpleTest.factory.capability;

import org.apache.log4j.Logger;
import org.openqa.selenium.remote.DesiredCapabilities;
import vmn.simpleTest.constant.capability.IosIPhoneCapability;

import java.io.File;

/**
 * Created by Aliaksandr_Novik2 on 24.07.15.
 */
public class IosCapabilityFactory {

    private static final Logger LOGGER = Logger.getLogger(IosCapabilityFactory.class);

    private static IosCapabilityFactory instance;

    private DesiredCapabilities caps;

    private File appFileNameIOS;

    private String deviceName;

    public IosCapabilityFactory(DesiredCapabilities caps, File appFileNameIOS, String deviceName) {
        LOGGER.info("Creating Ios capability factory ...");
        this.caps = caps;
        this.appFileNameIOS = appFileNameIOS;
        this.deviceName = deviceName;
    }

    public static IosCapabilityFactory getInstance(DesiredCapabilities caps, File appFileNameIOS, String deviceName) {
        if (instance == null) {
            instance = new IosCapabilityFactory(caps, appFileNameIOS, deviceName);
        }
        return instance;
    }

    public DesiredCapabilities getIosCapability() {
        caps.setCapability("platformVersion", IosIPhoneCapability.PLATFORM_VERSION);
        caps.setCapability("app", appFileNameIOS.getAbsolutePath());
        caps.setCapability("platformName", IosIPhoneCapability.PLATFORM_NAME);
        caps.setCapability("deviceName", deviceName);
        return caps;
    }

}
