package webdriver;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.util.concurrent.TimeUnit;

public class DriverManager {

    public static final WebDriver driver;
    private static final String HEADLESS = "HEADLESS_BROWSER";

    private DriverManager() {
    }

    public static WebDriver setupDriver() {
        if (driver == null) {
            WebDriverManager.chromedriver().setup();
            ChromeOptions chromeOptions = new ChromeOptions();
            chromeOptions.addArguments(
                "--no-sandbox",
                "--ignore-certificate-errors");
            if (Boolean.parseBoolean(System.getProperty(HEADLESS))) {
                chromeOptions.addArguments("--disable-gpu", "--window-size=1920x1080", "--headless");
            }
            driver = new ChromeDriver(chromeOptions);
            driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        }
        return driver;
    }
}
