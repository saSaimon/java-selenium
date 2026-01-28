package com.assignment.tests;

import com.assignment.config.Config;
import com.assignment.config.DriverFactory;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.WebDriver;

public abstract class BaseTest {

    protected WebDriver driver;

    @BeforeEach
    void setup() {
        driver = DriverFactory.createDriver();
    }

    @AfterEach
    void teardown() {
        boolean closeBrowser = Boolean.parseBoolean(Config.get("close.browser"));

        if (closeBrowser && driver != null) {
            driver.quit();
        } else {
            System.out.println("Browser kept open for debugging.");
        }
    }
}