package com.assignment.core;

import org.openqa.selenium.WebDriver;

public abstract class BasePage {
    protected final WebDriver driver;
    protected final Waits waits;

    protected BasePage(WebDriver driver) {
        this.driver = driver;
        this.waits = new Waits(driver);
    }
}