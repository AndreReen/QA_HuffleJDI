package steps;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.apache.hc.core5.util.Asserts;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import webdriver.DriverManager;

import java.lang.reflect.Method;

import static hooks.Hook.helper;

public class CommonSteps {

    @Given("I open site")
    public static void test1() {
        DriverManager.driver.get("https://apparel-uk.local:9002/ucstorefront/en/");
    }

    @When("I click on {string} on {string}")
    public static void clickReflect(String element, String page) {
        WebElement elementToClick = null;
        try {
            Class<?> c = Class.forName("pages." + page);
            Method method = c.getDeclaredMethod(element);
            elementToClick = (WebElement) method.invoke(null);
            helper.click(elementToClick);
        } catch (ReflectiveOperationException e) {
            e.printStackTrace();
        }
    }

    @When("I type {string} in {string} on {string}")
    public static void set(String text, String element, String page) {
        WebElement elementToSendKeys = null;
        try {
            Class<?> c = Class.forName("pages." + page);
            Method method = c.getDeclaredMethod(element);
            elementToSendKeys = (WebElement) method.invoke(null);
            helper.sendKeys(elementToSendKeys, text);
        } catch (ReflectiveOperationException e) {
            e.printStackTrace();
        }
    }

    @When("I select value {string} from {string} on {string}")
    public static void select(String text, String element, String page) {
        Select elementToSelect = null;
        try {
            Class<?> c = Class.forName("pages." + page);
            Method method = c.getDeclaredMethod(element);
            elementToSelect = (Select) method.invoke(null);
            helper.selectFrom(elementToSelect, text);
        } catch (ReflectiveOperationException e) {
            e.printStackTrace();
        }
    }

    @Then("I am on the page with {string} title")
    public static void pageTitle(String expectedTitle){
        helper.waitForPageUpdate();
        Asserts.check(helper.getPageTitle().equals(expectedTitle) , "Hurray");

    }

    @Then("{string} message is displayed  on screen")
    public static void displayedMessage(String expectedMessage){
        DriverManager.driver.findElement(By.xpath("//*[text()[contains(.,'"+ expectedMessage+"')]]"));
    }

}
