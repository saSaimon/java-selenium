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
                if (headless) fo.addArguments("-headless");

                fo.addPreference("dom.webnotifications.enabled", false);
                fo.addPreference("dom.push.enabled", false);

                return new FirefoxDriver(fo);
            }
            default -> {
                WebDriverManager.chromedriver().setup();
                ChromeOptions co = new ChromeOptions();

                if (headless) co.addArguments("--headless=new");
                co.addArguments("--start-maximized");

                Map<String, Object> prefs = new HashMap<>();
                prefs.put("profile.default_content_setting_values.notifications", 2);
                co.setExperimentalOption("prefs", prefs);

                co.addArguments("--disable-notifications");
                co.addArguments("--disable-popup-blocking");

                return new ChromeDriver(co);
            }
        }
    }
}