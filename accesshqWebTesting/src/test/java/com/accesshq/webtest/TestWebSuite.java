package com.accesshq.webtest;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;



public class TestWebSuite {

    private WebDriver drive;

    @BeforeEach
    public void setup() {
        drive = new ChromeDriver();
        drive.manage().window().maximize();
        drive.get("https://d18u5zoaatmpxx.cloudfront.net/");
    }
    @Test
    public void Test_Web() {
        drive.findElement(By.id("forename")).sendKeys("Yibo");
        drive.findElement(By.id("submit")).click();
    }

    @Test
    public void Test_SubmitButton() {
        var drive = new ChromeDriver();
        drive.get("https://d18u5zoaatmpxx.cloudfront.net/");
        drive.findElement(By.id("forename")).sendKeys("Yibo");
        drive.findElement(By.id("submit")).click();

        var popupElement = drive.findElement(By.className("popup-message"));
        new WebDriverWait(drive,1).until(ExpectedConditions.visibilityOf(popupElement));

        Assertions.assertEquals("Hello Yibo", popupElement.getText());
    }

    @AfterEach
    public void teardown() {
        drive.quit();
    }
}
