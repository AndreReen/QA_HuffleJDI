package webdriver;

import java.util.NoSuchElementException;

import org.openqa.selenium.ElementClickInterceptedException;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WebDriverHelper {

    //    private static final String LOGGER_INFO = "{}, page URL: {}";
    private static final int TIMEOUT = 10;
    private final WebDriver driver;

    private static final String JS_AJAX_PROGRESS =
            "var userWindow = window;"
                    + "var docReady = window.document.readyState == 'complete';"
                    + "var isJqueryComplete = typeof(userWindow.jQuery) != 'function' || userWindow.jQuery.active == 0;"
                    + "var isPrototypeComplete = typeof(userWindow.Ajax) != 'function' "
                    + "|| userWindow.Ajax.activeRequestCount == 0;"
                    + "var isDojoComplete = typeof(userWindow.dojo) != 'function' "
                    + "|| userWindow.dojo.io.XMLHTTPTransport.inFlight.length == 0;"
                    + "var result = docReady && isJqueryComplete && isPrototypeComplete && isDojoComplete;"
                    + "return result;";

    public WebDriverHelper(WebDriver driver) {
        this.driver = driver;
        //        log.debug("Start driver");
    }

    public WebDriver getDriver() {
        return driver;
    }

    private static final ExpectedCondition<Object> isAJAXCompleted = webDriver -> {
        JavascriptExecutor js = (JavascriptExecutor) webDriver;
        return Boolean.parseBoolean(js.executeScript(JS_AJAX_PROGRESS).toString());
    };

    public void waitForPageUpdate() {
        new WebDriverWait(driver, TIMEOUT).until(isAJAXCompleted);
    }

    public boolean isElementVisible(WebElement element) {
        boolean visible = false;
        try {
            visible = element.isDisplayed();
        } catch (NoSuchElementException e) {
            //            log.info("Element not found");
        } finally {
            //            log.info(LOGGER_INFO, "Is element displayed", driver.getCurrentUrl());
            System.out.println("log");
        }
        return visible;
    }

    public void waitForElementToBeClickable(WebElement element) {
        try {
            new WebDriverWait(driver, TIMEOUT)
                    .until(ExpectedConditions.elementToBeClickable(element));
        } catch (NoSuchElementException e) {
            //            log.info("Timeout exception when wait for element clickable");
        } finally {
            //            log.info(LOGGER_INFO, "Wait for element to be clickable", driver.getCurrentUrl());
            System.out.println("log");
        }
    }

    public void waitForElementIsVisible(WebElement element) {
        try {
            new WebDriverWait(driver, TIMEOUT)
                    .until(ExpectedConditions.visibilityOf(element));
        } catch (org.openqa.selenium.NoSuchElementException e) {
            e.printStackTrace();
            //            log.info("Waiting element visible throw timeout");
        } finally {
            //            log.info(LOGGER_INFO, "Wait element visibility", driver.getCurrentUrl());
            System.out.println("log");
        }
    }

    public void click(WebElement element) {
        try {
            waitForElementToBeClickable(element);
            element.click();
        } catch (ElementClickInterceptedException e) {
            //            log.info("Clicking element throw ne exception");
        } finally {
            //            log.info(LOGGER_INFO, "Click", driver.getCurrentUrl());
            System.out.println("log");
        }
    }

    public void selectFrom(Select element, String text) {
        try {
            element.selectByValue(text);
        } catch (ElementClickInterceptedException e) {
            //            log.info("Clicking element throw ne exception");
        } finally {
            //            log.info(LOGGER_INFO, "Click", driver.getCurrentUrl());
            System.out.println("log");
        }
    }

    public void sendKeys(WebElement element, String text) {
        try {
            waitForElementIsVisible(element);
            element.clear();
            element.sendKeys(text);
        } finally {
            //            log.info(LOGGER_INFO, "Send keys to element", driver.getCurrentUrl());
            System.out.println("log");
        }
    }

    public String getText(WebElement element) {
        String text = "";
        try {
            waitForElementIsVisible(element);
            text = element.getText();
        } catch (NoSuchElementException e) {
            //            log.info("Unable to locate element");
        } finally {
            //            log.info(LOGGER_INFO, "Get text", driver.getCurrentUrl());
            System.out.println("log");
        }
        return text;
    }

    public String getPageTitle() {
        return driver.getTitle();
    }
}
