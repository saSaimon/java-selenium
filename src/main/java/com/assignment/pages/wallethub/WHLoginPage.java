package com.assignment.pages.wallethub;

import com.assignment.core.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class WHLoginPage extends BasePage {

    private final By email = By.cssSelector("[id=\"email-input\"]");
    private final By password = By.cssSelector("[id=\"pass-input\"]");
    private final By loginBtn = By.cssSelector("button[type='submit']");

    public WHLoginPage(WebDriver driver) { super(driver); }

    public void open(String baseUrl) {
        driver.get(baseUrl + "/join/login");
    }

    public void login(String user, String pass) {
        waits.visible(email).sendKeys(user);
        waits.visible(password).sendKeys(pass);
        waits.clickable(loginBtn).click();
    }
}