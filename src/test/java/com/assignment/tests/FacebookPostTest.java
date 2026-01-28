package com.assignment.tests;

import com.assignment.config.Config;
import com.assignment.pages.facebook.FBLoginPage;
import com.assignment.pages.facebook.FBPostPage;
import org.junit.jupiter.api.Test;

public class FacebookPostTest extends BaseTest {

    @Test
    void shouldLoginAndCreatePostOnFacebook() {

        FBLoginPage loginPage = new FBLoginPage(driver);
        FBPostPage postPage = new FBPostPage(driver);

        // Step 1: Open Facebook
        loginPage.open();

        // Step 2: Login
        loginPage.login(
                Config.get("fb.email"),
                Config.get("fb.password")
        );

        // Step 3: Open post composer
        postPage.openPostComposer();

//        postPage.clickPost();

        // Step 4: Write post
        postPage.typePost(
                "Hello World! This is an automated Facebook post for WalletHub assignment."
        );

        // Step 5: Click next (if shown)
        postPage.clickNextIfPresent();

        // Step 6: Post
        postPage.submitPost();
    }
}