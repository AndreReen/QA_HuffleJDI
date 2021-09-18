package steps;

import io.cucumber.java.en.Given;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import pages.MainPage;
import webdriver.DriverManager;
import webdriver.WebDriverHelper;

import java.lang.reflect.Method;

import static hooks.Hook.helper;

public class CommonSteps {

    @Given("I open site")
    public static void test1() {
        DriverManager.driver.get("https://apparel-uk.local:9002/ucstorefront/en/");
    }

    @Given("I click on {string} on {string}")
    public static void click() {
        helper.click(MainPage.signInButton());
    }

    @Given("I click on {string} on {string} WIP")
    public static void clickReflect(String element, String page) {
        WebElement elementToClick = null;
        try {
            Class<?> c = Class.forName("pages." + page);
            Method method = c.getDeclaredMethod(element);
            elementToClick = (WebElement) method.invoke(null);
            elementToClick.click();
        } catch (ReflectiveOperationException e) {
            e.printStackTrace();
        }
    }
}
