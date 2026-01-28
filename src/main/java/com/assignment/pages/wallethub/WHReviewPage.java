package com.assignment.pages.wallethub;

import com.assignment.core.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;

public class WHReviewPage extends BasePage {

    private final By policyDropdown = By.cssSelector("select[name='policy'], select#policy");
    private final By writeReview = By.xpath("//a[contains(.,'Write a review')]");
    private final By reviewText = By.cssSelector("textarea");
    private final By submitBtn = By.cssSelector("button[type='submit']");
    private final By confirmation = By.xpath("//*[contains(.,'reviewed') or contains(.,'Thank')]");

    public WHReviewPage(WebDriver driver) { super(driver); }

    public void selectPolicyHealthInsurance() {
        var dropdown = waits.visible(policyDropdown);
        new Select(dropdown).selectByVisibleText("Health Insurance");
    }

    public void clickWriteReview() {
        waits.clickable(writeReview).click();
    }

    public void typeReview(String text200Plus) {
        waits.visible(reviewText).sendKeys(text200Plus);
    }

    public void submit() {
        waits.clickable(submitBtn).click();
        waits.visible(confirmation);
    }
}