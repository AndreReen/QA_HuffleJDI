package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import webdriver.DriverManager;

public class LoginPage {
    public static WebElement registerButton(){
        return DriverManager.driver.findElement(By.xpath("//button[@href='/ucstorefront/en/login']"));
    }
}
