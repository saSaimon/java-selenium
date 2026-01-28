package com.assignment.pages.wallethub;

import com.assignment.core.BasePage;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedCondition;

import java.util.List;

public class WHProfilePage extends BasePage {

    // The stars area may change; keep locators isolated here.
    private final By reviewStars = By.cssSelector("review-star svg, .review-star svg, .rv-star svg");

    public WHProfilePage(WebDriver driver) { super(driver); }

    public void openProfile(String profileUrl) {
        driver.get(profileUrl);
    }

    public void hoverAndClickFourthStar() {
        List<WebElement> stars = driver.findElements(reviewStars);
        if (stars.size() < 5) {
            throw new RuntimeException("Star rating not found or less than 5 stars. Locator needs update.");
        }

        WebElement fourth = stars.get(3);
        Actions actions = new Actions(driver);
        actions.moveToElement(fourth).perform();

        // Verify hover effect (stars highlight) before click.
        waits.untilTrue((ExpectedCondition<Boolean>) d -> {
            String cls = fourth.getAttribute("class");
            String fill = fourth.getCssValue("fill");
            return (cls != null && (cls.contains("hover") || cls.contains("active") || cls.contains("filled")))
                    || (fill != null && !fill.isBlank());
        });

        fourth.click();
    }
}