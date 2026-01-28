package com.assignment.tests;

import org.junit.jupiter.api.Test;

public class SmokeTest extends BaseTest {

    @Test
    void shouldOpenBrowser() {
        driver.get("https://www.google.com");
    }
}