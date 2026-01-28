package com.assignment.tests;

import com.assignment.config.DriverFactory;
import org.junit.jupiter.api.*;
import org.openqa.selenium.WebDriver;

public abstract class BaseTest {
    protected WebDriver driver;

    @BeforeEach
    void setup() {
        driver = DriverFactory.createDriver();
    }

    @AfterEach
    void teardown() {
        if (driver != null) driver.quit();
    }
}