package hooks;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import webdriver.DriverManager;
import webdriver.WebDriverHelper;

public class Hook {

    public static WebDriverHelper helper;

    @Before
    public void setUp() {
        DriverManager.setupDriver();
        helper = new WebDriverHelper(DriverManager.driver);
    }

    @After
    public void tearDown() {
        DriverManager.driver.quit();
        DriverManager.driver = null;
    }
}
