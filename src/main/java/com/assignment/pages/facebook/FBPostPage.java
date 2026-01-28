package com.assignment.pages.facebook;

import com.assignment.core.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;

public class FBPostPage extends BasePage {

    private final By postBox =
            By.xpath("//div[@class='xi81zsa x1lkfr7t xkjl1po x1mzt3pk xh8yej3 x13faqbe']//span[@class='x1lliihq x6ikm8r x10wlt62 x1n2onr6']");


    private final By textBox =
            By.cssSelector("[role=\"textbox\"]");

    private final By nextButton =
            By.cssSelector("[aria-label=\"Next\"]");

    private final By postButton =
            By.cssSelector("[aria-label=\"Post\"]");

    public FBPostPage(WebDriver driver) {
        super(driver);
    }

    public void openPostComposer() {
        waits.clickable(postBox).click();
    }

    public void clickPost() {
        waits.visible(textBox).click();
    }

    public void typePost(String text) {
        waits.visible(textBox).sendKeys(text);
    }

    public void clickNextIfPresent() {
        try {
            waits.clickable(nextButton).click();
        } catch (Exception ignored) {
            // Next button may not appear for all accounts
        }
    }

    public void submitPost() {
        waits.clickable(postButton).click();
    }
}