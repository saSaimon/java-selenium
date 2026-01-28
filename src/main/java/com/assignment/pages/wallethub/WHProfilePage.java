package com.assignment.pages.wallethub;

import com.assignment.core.BasePage;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedCondition;

import java.util.List;

public class WHProfilePage extends BasePage {

    private final By writeReviewButton = By.xpath("//button[@class='btn blue-brds mob']");

    public WHProfilePage(WebDriver driver) { super(driver); }

    public void openProfile(String profileUrl) {
        driver.get(profileUrl);
    }

    public void clickReviewButton(){
        waits.clickable(writeReviewButton).click();
    }

}