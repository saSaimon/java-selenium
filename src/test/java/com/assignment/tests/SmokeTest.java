package com.assignment.tests;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;

public class SmokeTest extends BaseTest {

    @Test
    void googleSearchAndOpenFirstResult() throws InterruptedException {
        // 1) Open Google
        driver.get("https://www.google.com");

        // 2) Search for Selenium
        WebElement searchBox = driver.findElement(By.name("q"));
        searchBox.sendKeys("Selenium automation testing");
        searchBox.sendKeys(Keys.ENTER);

        // 3) Wait for results to show
        Thread.sleep(2000); // short wait for results to load

        // 4) Click the first result link
        WebElement firstResult = driver.findElement(By.cssSelector("h3"));
        firstResult.click();

        // 5) Pause so we can see the page
        Thread.sleep(3000);

        // 6) (Optional) Print current page title to console
        System.out.println("Opened page title: " + driver.getTitle());
    }
}