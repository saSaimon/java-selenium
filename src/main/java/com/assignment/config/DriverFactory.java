package com.assignment.config;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.HashMap;
import java.util.Map;

public class DriverFactory {

    public static WebDriver createDriver() {
        String browser = Config.get("browser");
        boolean headless = Config.getBool("headless");

        switch (browser.toLowerCase()) {

            case "firefox" -> {
                WebDriverManager.firefoxdriver().setup();
                FirefoxOptions fo = new FirefoxOptions();
                if (headless) {
                    fo.addArguments("-headless");
                }
                return new FirefoxDriver(fo);
            }

            default -> {
                WebDriverManager.chromedriver().setup();
                ChromeOptions co = new ChromeOptions();

                // ✅ HANDLE BROWSER NOTIFICATION POPUP (ALLOW)
                Map<String, Object> prefs = new HashMap<>();
                prefs.put("profile.default_content_setting_values.notifications", 1); // 1 = Allow, 2 = Block
                co.setExperimentalOption("prefs", prefs);

                if (headless) {
                    co.addArguments("--headless=new");
                }

                co.addArguments("--start-maximized");

                return new ChromeDriver(co);
            }
        }
    }
}