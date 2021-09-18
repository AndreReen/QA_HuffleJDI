package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import webdriver.DriverManager;

public class MainPage {
    public static WebElement signInButton(){
        return DriverManager.driver.findElement(By.xpath("//a[@href='/ucstorefront/en/login']"));
    }
}
