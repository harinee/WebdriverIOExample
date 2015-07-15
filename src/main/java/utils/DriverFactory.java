package utils;

/**
 * Created by harineem on 14-07-2015.
 */

import com.thoughtworks.gauge.AfterSuite;
import com.thoughtworks.gauge.BeforeScenario;
import com.thoughtworks.gauge.BeforeSpec;
import com.thoughtworks.gauge.BeforeSuite;
import com.thoughtworks.gauge.datastore.DataStoreFactory;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

public class DriverFactory {
    private static final String IE = "internetexplorer";

    private static WebDriver driver;

    public static WebDriver getDriver() {
        return driver;
    }

    @BeforeSuite
    public void Setup() {
        String browser = System.getenv("browser.name");
//        if (browser.toLowerCase().equals(IE)) {
            DesiredCapabilities capabilities = new DesiredCapabilities();
            capabilities.setCapability(InternetExplorerDriver.INTRODUCE_FLAKINESS_BY_IGNORING_SECURITY_DOMAINS, true);
            driver = new InternetExplorerDriver(capabilities);
//        } else {
//            driver = new FirefoxDriver();
//        }
        driver.navigate().to("http://www.poetryfoundation.org/");
        driver.manage().window().maximize();
    }

    @AfterSuite
    public void TearDown() {
        driver.close();
    }
}
