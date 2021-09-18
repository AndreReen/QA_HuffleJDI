package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import webdriver.DriverManager;

public class StoreItemPage {

    public static WebElement addToBagButton(){
        return DriverManager.driver.findElement(By.xpath("//button[@id='addToCartButton']"));
    }

    public static WebElement checkOutButton(){
        return DriverManager.driver.findElement(By.xpath("//a[@class='btn btn-primary btn-block add-to-cart-button']"));
    }

}
