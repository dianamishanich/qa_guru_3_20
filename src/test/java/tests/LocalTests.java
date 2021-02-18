package tests;

import com.codeborne.selenide.Configuration;
import drivers.LocalMobileDriver;
import io.appium.java_client.MobileBy;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.CollectionCondition.sizeGreaterThan;
import static com.codeborne.selenide.Selectors.byClassName;
import static com.codeborne.selenide.Selenide.*;
import static io.appium.java_client.MobileBy.AccessibilityId;

public class LocalTests {
    @BeforeAll
    public static void configureSelenide() {
        Configuration.browser = LocalMobileDriver.class.getName();
        Configuration.startMaximized = false;
        Configuration.browserSize = null;
        Configuration.timeout = 10000;
    }

    @Test
    void searchTest() {
        open();
//        Continue
//        org.wikipedia.alpha:id/fragment_onboarding_done_button
        back();
        $(AccessibilityId("Search Wikipedia")).click();
        $(MobileBy.id("org.wikipedia.alpha:id/search_src_text")).setValue("BrowserStack");
        $$(byClassName("android.widget.TextView")).shouldHave(sizeGreaterThan(0));

    }
}
