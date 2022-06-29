package com.accesshq.model;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.text.NumberFormat;
import java.text.ParseException;
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

    public Double getRadius() throws ParseException {
        String text = planetElement.findElement(By.className("radius")).getText();
        return NumberFormat.getInstance().parse(text).doubleValue();
    }

    public Double getDistance() throws ParseException {
        String text = planetElement.findElement(By.className("distance")).getText();
        return NumberFormat.getInstance().parse(text).doubleValue();
    }

    public void clickExplore() {
        planetElement.findElement(By.tagName("button")).click();
    }
}
