package com.accesshq.Planet;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.ArrayList;
import java.util.List;

public class Planet {

    private final WebElement planetElement;

    public Planet(WebElement planetElement) {
        this.planetElement = planetElement;
    }

    public String getName() {
        return planetElement.findElement(By.className("name")).getText();
    }

    public String getRadius() {
        return planetElement.findElement(By.className("radius")).getText();
    }

    public void clickExplore() {
        planetElement.findElement(By.tagName("button")).click();
    }
}
