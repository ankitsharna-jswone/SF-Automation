package Utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

import java.util.HashMap;
import java.util.Map;

//import static Utils.Functionalities.driver;


public class BrowsserSetup {
    private static final ThreadLocal<WebDriver> driverThreadLocal = new ThreadLocal<>();

    public static WebDriver getDriver() {
        return driverThreadLocal.get();
    }

        public static void setDriver(String option) {
            if (option.equalsIgnoreCase("chrome")) {
                setChromeDriver();
            } else if (option.equalsIgnoreCase("firefox")) {
                setFirefoxDriver();
            } else if (option.equalsIgnoreCase("headless")) {
                setHeadlessDriver();
            } else {
                throw new IllegalArgumentException("Invalid browser or option: " + option);
            }
        }

    private static void setFirefoxDriver() {
        // Firefox-specific options
        FirefoxOptions firefoxOptions = new FirefoxOptions();
        driverThreadLocal.set(new FirefoxDriver(firefoxOptions));
    }

    private static void setHeadlessDriver() {
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.addArguments("--headless");
        chromeOptions.addArguments("--disable-gpu");
        chromeOptions.addArguments("--window-size=1920x1080");
        driverThreadLocal.set(new ChromeDriver(chromeOptions));


    }

    private static void setChromeDriver() {
        // Chrome-specific options
        Map<String, Object> prefs = new HashMap<>();
        prefs.put("profile.default_content_setting_values.notifications", 2);
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.setExperimentalOption("prefs", prefs);

        driverThreadLocal.set(new ChromeDriver(chromeOptions));
    }

    public static void quitDriver() {
        WebDriver driver = getDriver();
        if (driver != null) {
            driver.quit();
            driverThreadLocal.remove();
        }
    }


}



