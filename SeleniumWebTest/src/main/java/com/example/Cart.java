package com.example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Cart {
    public static void main( String[] args )
    {
        System.setProperty(
                "webdriver.chrome.driver", "src/main/resources/chromedriver"
        );
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.cifrus.ru/");
        WebElement product = driver.findElement(By.className("product-thumb"));
        String name = product.findElement(By.className("caption")).findElement(By.className("name")).getText();
        System.out.println("Найден продукт: " + name);
        product.findElement(By.xpath("//button[contains(text(), 'В корзину')]")).click();
        driver.get("https://www.cifrus.ru/basket.php");
        WebElement cartProduct = driver
                .findElement(By.className("simplecheckout-cart"))
                .findElement(By.tagName("tbody"))
                .findElement(By.tagName("tr"));
        String cartProductName = cartProduct.findElement(By.className("name")).getText();
        if (name.equals(cartProductName)) {
            System.out.println("Продукт был добавлен в корзину");
        }

    }
}
