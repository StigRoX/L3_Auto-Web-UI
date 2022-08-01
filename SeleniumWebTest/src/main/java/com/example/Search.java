package com.example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.ArrayList;

public class Search {
    public static void main( String[] args )
    {
        System.setProperty(
                "webdriver.chrome.driver", "src/main/resources/chromedriver"
        );
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.cifrus.ru/");
        driver.findElement(By.id("search_box")).sendKeys("iphone 13");
        driver.findElement(By.xpath("//button[@type='submit']")).click();

        WebElement el = driver.findElement(By.className("product-thumb")).findElement(By.className("caption")).findElement(By.className("name"));
        String text = el.getText();
        if(text.toLowerCase().contains("iphone 13")) {
            System.out.println("Найден продукт: " + text);
        }

    }
}
