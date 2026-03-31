package org.test;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class WebpageTest {

    private static WebDriver driver;

    @BeforeTest
    public void openBrowser() throws InterruptedException {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        Thread.sleep(2000); // wait for browser to open
        driver.get("https://chinnu1024.github.io/experiment3.1/");
    }

    @Test
    public void titleValidationTest() {
        String actualTitle = driver.getTitle();
        System.out.println("Page Title: " + actualTitle);

        // Match exact title from HTML (with quotes if they exist)
        String expectedTitle = "\"My Simple Webpage\"";
        Assert.assertEquals(actualTitle, expectedTitle, "Page title does not match expected.");

        // Safe contains check (avoids warning)
        Assert.assertTrue(actualTitle != null && actualTitle.contains("Simple"),
                "Title contains 'Simple'");
    }

    @AfterTest
    public void closeBrowser() throws InterruptedException {
        Thread.sleep(1000); // wait before closing
        driver.quit();
    }
}