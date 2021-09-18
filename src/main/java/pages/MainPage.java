package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import webdriver.DriverManager;

public class MainPage {

    public static String MainPageTitle() {
        return "Apparel Site UK | Homepage";
    }

    public static WebElement signInButton() {
        return DriverManager.driver.findElement(By.xpath("//a[@href='/ucstorefront/en/login']"));
    }

    public static WebElement alertMesasge() {
        return DriverManager.driver.findElement(By.xpath("//div[@class='alert alert-info alert-dismissable getAccAlert']"));
    }
}
