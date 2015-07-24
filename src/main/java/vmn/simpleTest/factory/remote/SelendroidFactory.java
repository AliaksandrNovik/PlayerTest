package vmn.simpleTest.factory.remote;

import io.selendroid.client.SelendroidDriver;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.net.URL;

public class SelendroidFactory extends WebDriverFactory {

    private static final Logger LOGGER = Logger.getLogger(SelendroidFactory.class);
    protected URL url;
    protected DesiredCapabilities capabilities;

    public SelendroidFactory(URL url, DesiredCapabilities capabilities) {
        super();
        this.capabilities = capabilities;
        this.url = url;
    }

    @Override
    public WebDriver createWebDriver() {
        LOGGER.info("Create Selendroid Driver ... Host URL: " + url);
        try {
            return new SelendroidDriver(url, capabilities);
        } catch (Exception e) {
            throw new RuntimeException(e.getMessage());
        }

    }
}
