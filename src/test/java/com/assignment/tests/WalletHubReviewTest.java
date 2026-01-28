package com.assignment.tests;

import com.assignment.config.Config;
import com.assignment.core.RandomText;
import com.assignment.pages.wallethub.WHLoginPage;
import com.assignment.pages.wallethub.WHProfilePage;
import com.assignment.pages.wallethub.WHReviewPage;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class WalletHubReviewTest extends BaseTest {

    @Test
    void shouldSubmitReviewAndSeeItInFeed() {
        String baseUrl = Config.get("baseUrlWalletHub");
        String profileUrl = Config.get("wallethubProfileUrl");

        var login = new WHLoginPage(driver);
        login.open(baseUrl);
        login.login(Config.get("wh.email"), Config.get("wh.password"));

        var profile = new WHProfilePage(driver);
        profile.openProfile(profileUrl);
        profile.hoverAndClickFourthStar();

        var review = new WHReviewPage(driver);
        review.selectPolicyHealthInsurance();
        review.clickWriteReview();
        review.typeReview(RandomText.generate(220));
        review.submit();

        // Simple assertion: after submit, you’re typically on a confirmation page.
        assertTrue(driver.getPageSource().toLowerCase().contains("review"));
    }
}