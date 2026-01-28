package com.assignment.pages.facebook;

import com.assignment.core.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class FBLoginPage extends BasePage {

    // Locators (as provided by you)
    private final By emailField = By.xpath("//input[@id='email']");
    private final By passwordField = By.xpath("//input[@id='pass']");
    private final By loginButton = By.xpath("//button[@type=\"submit\"]");

    public FBLoginPage(WebDriver driver) {
        super(driver);
    }

    public void open() {
        driver.get("https://www.facebook.com/");
    }

    public void login(String email, String password) {
        waits.visible(emailField).sendKeys(email);
        waits.visible(passwordField).sendKeys(password);
        waits.clickable(loginButton).click();
        // Pause for manual CAPTCHA
        try {
            System.out.println("⏸ Please complete CAPTCHA / verification manually...");
            Thread.sleep(30000); // 30 seconds
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
}