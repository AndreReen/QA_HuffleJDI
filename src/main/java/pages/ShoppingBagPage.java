package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import webdriver.DriverManager;

public class ShoppingBagPage {
    public static WebElement checkOutButton(){
        return DriverManager.driver.findElement(By.xpath("//button[@class='btn btn-primary btn-block btn--continue-checkout js-continue-checkout-button']"));
    }
}
