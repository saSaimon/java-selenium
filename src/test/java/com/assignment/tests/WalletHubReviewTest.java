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

        // 1. Login to wallethub
        WHLoginPage login = new WHLoginPage(driver);
        login.open(baseUrl);
        login.login(Config.get("wh.email"), Config.get("wh.password"));

        // 2. Open profile, and go to review page
        WHProfilePage profile = new WHProfilePage(driver);

        profile.openProfile(profileUrl);
        profile.clickReviewButton();


        // 3. select policy + write review + submit

        WHReviewPage review = new WHReviewPage(driver);
        review.clickFourthStar();
        //I have tried a lot way to select 4th star, but it always selects 3rd, maybe I am missing something, but I have
        //tried my best
        review.selectHealthInsurance();
        review.typeReview(RandomText.generate(220));
        review.submit();
        review.finalSubmit();
        //After successful review the website failed to keep its token, and also my profile is not fully registered as I
        //couldn't set my phone number. So I am keeping the project till here.
    }
}