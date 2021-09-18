package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import webdriver.DriverManager;

public class LoginPage {

    public static Select titleDropDown(){
        return new Select(DriverManager.driver.findElement(By.xpath("//select[@id='register.title']")));
    }

    public static WebElement firstNameField(){
        return DriverManager.driver.findElement(By.xpath("//input[@id='register.firstName']"));
    }

    public static WebElement lastNameField(){
        return DriverManager.driver.findElement(By.xpath("//input[@id='register.lastName']"));
    }

    public static WebElement emailAddressField(){
        return DriverManager.driver.findElement(By.xpath("//input[@id='register.email']"));
    }

    public static WebElement passwordField(){
        return DriverManager.driver.findElement(By.xpath("//input[@id='password']"));
    }

    public static WebElement confirmPasswordField(){
        return DriverManager.driver.findElement(By.xpath("//input[@id='register.checkPwd']"));
    }

    public static WebElement confirmCheckBox(){
        return DriverManager.driver.findElement(By.xpath("//input[@id='registerChkTermsConditions']"));
    }

    public static WebElement submitButton(){
        return DriverManager.driver.findElement(By.xpath("//button[@class='btn btn-default btn-block']"));
    }

    public static WebElement loginEmailField(){
        return DriverManager.driver.findElement(By.xpath("//input[@id='j_username']"));
    }

    public static WebElement loginPasswordField(){
        return DriverManager.driver.findElement(By.xpath("//input[@id='j_password']"));
    }

    public static WebElement loginButton(){
        return DriverManager.driver.findElement(By.xpath("//button[@class='btn btn-primary btn-block']"));
    }

}
