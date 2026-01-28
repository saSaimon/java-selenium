package com.assignment.pages.wallethub;

import com.assignment.core.BasePage;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class WHReviewPage extends BasePage {

    private final WebDriverWait wait;

    private final By stars = By.xpath("//div[@class='flex-box-rv']//div[@class='rating-box-wrapper']//*[name()='svg']");

    private final By policyDropdown = By.xpath("//span[normalize-space()='Select...']");

    private final By healthInsuranceOption = By.xpath("//li[@role='option' and normalize-space()='Health Insurance']");

    private final By reviewTextArea = By.cssSelector("textarea[placeholder*='Write your review']");

    private final By submitButton = By.xpath("//button[normalize-space()='Submit']");

    private final By successMessage =
            By.xpath("//*[contains(normalize-space(),'Your review has been posted') or contains(normalize-space(),'Awesome!')]");

    private final By finalSubmitButton = By.cssSelector("class=\"btn blue mob\"");

    public WHReviewPage(WebDriver driver) {
        super(driver);
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(15));
    }

    By fourthStarSvg = By.xpath("//div[@class='flex-box-rv']//div[@class='rating-box-wrapper']//*[name()='svg'][4]");

    public void clickFourthStar() {
        WebElement svg = wait.until(ExpectedConditions.visibilityOfElementLocated(fourthStarSvg));
        scrollIntoView(svg);

        WebElement clickable = svg.findElement(By.xpath("./ancestor::*[@role='radio' or @tabindex='0' or self::div][1]"));

        try {
            clickable.click();
        } catch (Exception e) {
            ((JavascriptExecutor) driver).executeScript("arguments[0].click();", clickable);
        }
    }

//    public void clickFourthStar() {
//
//        By ratingRadios = By.xpath("//div[contains(@class,'rating-box-wrapper')]//*[@role='radio']");
//
//        java.util.List<WebElement> radios = wait.until(
//                ExpectedConditions.numberOfElementsToBeMoreThan(ratingRadios, 3)
//        );
//
//        WebElement fourth = radios.get(3); // 4th star
//        scrollIntoView(fourth);
//
//        // Wait until it is actually interactable (not covered)
//        wait.until(ExpectedConditions.elementToBeClickable(fourth));
//
//        try {
//            // Hover INSIDE the element (small offset helps a lot on rating widgets)
//            new org.openqa.selenium.interactions.Actions(driver)
//                    .moveToElement(fourth, 2, 2)
//                    .pause(java.time.Duration.ofMillis(300))
//                    .click()
//                    .perform();
//        } catch (Exception e) {
//            // Fallback: dispatch real mouse events (mouseover/mousemove/click)
//            ((JavascriptExecutor) driver).executeScript(
//                    "const el = arguments[0];" +
//                            "['mouseover','mousemove','mousedown','mouseup','click'].forEach(type => " +
//                            "  el.dispatchEvent(new MouseEvent(type, {bubbles:true, cancelable:true, view:window}))" +
//                            ");",
//                    fourth
//            );
//        }
//    }

    public void selectHealthInsurance() {
        WebElement dropdown = wait.until(ExpectedConditions.elementToBeClickable(policyDropdown));
        dropdown.click();

        WebElement option = wait.until(ExpectedConditions.elementToBeClickable(healthInsuranceOption));
        option.click();
    }

    public void typeReview(String text) {
        WebElement area = wait.until(ExpectedConditions.visibilityOfElementLocated(reviewTextArea));
        area.clear();
        area.sendKeys(text);
    }

    public void submit() {
        WebElement btn = wait.until(ExpectedConditions.elementToBeClickable(submitButton));
        btn.click();
    }

    public void finalSubmit() {
        WebElement btn = wait.until(ExpectedConditions.elementToBeClickable(submitButton));
        btn.click();
    }

    public boolean isSuccessShown() {
        try {
            wait.until(ExpectedConditions.visibilityOfElementLocated(successMessage));
            return true;
        } catch (TimeoutException e) {
            return false;
        }
    }

    private void scrollIntoView(WebElement el) {
        ((JavascriptExecutor) driver).executeScript(
                "arguments[0].scrollIntoView({block:'center'});", el
        );
    }

    private void jsDispatchClick(WebElement el) {
        ((JavascriptExecutor) driver).executeScript(
                "arguments[0].dispatchEvent(new MouseEvent('click', {bubbles:true, cancelable:true, view:window}));",
                el
        );
    }
}