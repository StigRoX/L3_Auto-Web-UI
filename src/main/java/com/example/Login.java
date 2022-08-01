package com.example;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
//import java.util.function.Function;

/**
 * Hello world!
 *
 */
public class Login
{
    public static void main( String[] args )
    {
        System.setProperty(
                "webdriver.chrome.driver", "src/main/resources/chromedriver"
        );
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.cifrus.ru/");
        WebElement authButton = driver.findElement(By.xpath("//*[contains(text(), 'Личный')]"));
        authButton.click();
        driver.findElement(By.xpath("//*[contains(text(), 'Авторизация')]")).click();
        driver.findElement(By.name("email")).sendKeys("vexeae@mailto.plus");
        driver.findElement(By.name("password")).sendKeys("8520go");
        driver.findElement(By.xpath("//a[contains(text(), 'Войти')]")).click();
        String url = driver.getCurrentUrl();
        System.out.println(url);
        if(url.equals("https://www.cifrus.ru/account/profile")) {
            System.out.println("Авторизация завершена успешно");
        }

    }
}
