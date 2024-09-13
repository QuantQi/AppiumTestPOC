package org.example;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.remote.MobileCapabilityType;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.net.URI;
import java.net.URL;

import static org.junit.Assert.assertEquals;

public class AppiumTest {

    private AndroidDriver<AndroidElement> driver;

    @Before
    public void setUp() throws Exception {
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability(MobileCapabilityType.PLATFORM_NAME, "Android");
        capabilities.setCapability("automationName", "UiAutomator2");
        capabilities.setCapability(MobileCapabilityType.DEVICE_NAME, "emulator-5554");
        capabilities.setCapability(MobileCapabilityType.APP, "app-debug.apk"); 

        @SuppressWarnings("deprecation")
        URL serverUrl = new URL(new URI("http://localhost:4723/wd/hub").toString());
        driver = new AndroidDriver<>(serverUrl, capabilities);

        System.out.println(driver.getPageSource());
    }

    @Test
    public void testTextFieldContentDescription() {
        // Find the TextField by its resource ID
        AndroidElement textField = driver.findElementById("com.example.myapplication7:id/textField");

        // Get the content description attribute
        String contentDescription = textField.getAttribute("contentDescription");

        // Verify the content description
        assertEquals("Expected content description", contentDescription);
    }

    @After
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}