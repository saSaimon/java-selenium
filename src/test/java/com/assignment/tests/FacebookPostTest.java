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

        loginPage.open();

        loginPage.login(
                Config.get("fb.email"),
                Config.get("fb.password")
        );

        postPage.openPostComposer();

        postPage.typePost(
                "Hello World! This is an automated Facebook post for WalletHub assignment."
        );

        postPage.clickNextIfPresent();

        postPage.submitPost();
    }
}