package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import webdriver.DriverManager;

public class CheckoutPage {

    public static Select countryRegionDropDown(){
        return new Select(DriverManager.driver.findElement(By.xpath("//select[@id='address.country']")));
    }

    public static Select titleDropDown(){
        return new Select(DriverManager.driver.findElement(By.xpath("//select[@id='address.title']")));
    }

    public static Select shippingMethondDropDown(){
        return new Select(DriverManager.driver.findElement(By.xpath("//select[@id='delivery_method']")));
    }

    public static Select cardTypeDropDown(){
        return new Select(DriverManager.driver.findElement(By.xpath("//select[@id='card_cardType']")));
    }

    public static Select expiryMonthDropDown(){
        return new Select(DriverManager.driver.findElement(By.xpath("//select[@id='ExpiryMonth']")));
    }

    public static Select expiryYearDropDown(){
        return new Select(DriverManager.driver.findElement(By.xpath("//select[@id='ExpiryYear']")));
    }

    public static WebElement firstNameField(){
        return DriverManager.driver.findElement(By.xpath("//input[@id='address.firstName']"));
    }

    public static WebElement lastNameField(){
        return DriverManager.driver.findElement(By.xpath("//input[@id='address.surname']"));
    }

    public static WebElement addressLine1Fiels(){
        return DriverManager.driver.findElement(By.xpath("//input[@id='address.line1']"));
    }

    public static WebElement cityField(){
        return DriverManager.driver.findElement(By.xpath("//input[@id='address.townCity']"));
    }

    public static WebElement postCodeField(){
        return DriverManager.driver.findElement(By.xpath("//input[@id='address.postcode']"));
    }

    public static WebElement cardCvvField(){
        return DriverManager.driver.findElement(By.xpath("//input[@id='card_cvNumber']"));
    }

    public static WebElement cardNumberField(){
        return DriverManager.driver.findElement(By.xpath("//input[@id='card_accountNumber']"));
    }

    public static WebElement nextButton(){
        return DriverManager.driver.findElement(By.cssSelector(".checkout-next"));
    }

    public static WebElement confirmCheckbox(){
        return DriverManager.driver.findElement(By.xpath("//input[@id='Terms1']"));
    }

    public static WebElement PlaceOrderButton(){
        return DriverManager.driver.findElement(By.xpath("//button[@id='placeOrder']"));
    }


}
