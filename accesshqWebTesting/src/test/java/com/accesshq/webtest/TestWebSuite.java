package com.accesshq.webtest;

import com.accesshq.Planet.PlanetPage;
import com.accesshq.model.Form;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


public class TestWebSuite {

    private WebDriver driver;

    @BeforeEach
    public void setup() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://d18u5zoaatmpxx.cloudfront.net/");
    }

    @Test
    public void Test_Web() {
        driver.findElement(By.id("forename")).sendKeys("Yibo");
        driver.findElement(By.id("submit")).click();
    }

    @Test
    public void Test_SubmitButton() {
        var driver = new ChromeDriver();
        driver.get("https://d18u5zoaatmpxx.cloudfront.net/");
        driver.findElement(By.id("forename")).sendKeys("Yibo");
        driver.findElement(By.id("submit")).click();

        var popupElement = driver.findElement(By.className("popup-message"));
        new WebDriverWait(driver,1).until(ExpectedConditions.visibilityOf(popupElement));

        Assertions.assertEquals("Hello Yibo", popupElement.getText());
    }

    @Test
    public void Verify_Forms() {
        driver.findElement(By.cssSelector("[aria-label=forms]")).click();

        var form = new Form(driver);
        form.setName("test");
        form.setEmail("roy.liugm@gmail.com");
        form.setState("QLD");
        form.clickAgree();
        form.clickSubmit();

        Assertions.assertEquals("Thanks for your feedback test", form.getPopupText());
    }

    @Test
    public void Verify_Planets() {
        driver.findElement(By.cssSelector("[aria-label=planets]")).click();

        var planetPage = new PlanetPage(driver);
        planetPage.clickExplore("Earth");

        Assertions.assertEquals("Exploring Earth",
                planetPage.getPopupText());
    }

    @Test
    public void Verify_FindByRadius() {
        driver.findElement(By.cssSelector("[aria-label=planets]")).click();

        var planetPage = new PlanetPage(driver);
        planetPage.getByRadius("58,232 km");

        Assertions.assertEquals("Exploring Saturn",
                planetPage.getPopupText());
    }

    @AfterEach
    public void teardown() {
        driver.quit();
    }
}
