package com.accesshq.Planet;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.ArrayList;
import java.util.List;

public class PlanetPage {

    private final WebDriver driver;

    public PlanetPage(WebDriver driver) {
        this.driver = driver;
    }

    public WebElement getPopupMessage() {
        return driver.findElement(By.className("popup-message"));
    }

    public String getPopupText() {
        return getPopupMessage().getText();
    }

    public void clickExplore(String planetName) {
        for (Planet planet : getPlanets()) {
            if (planet.getName().equalsIgnoreCase(planetName)) {
                planet.clickExplore();
                waitForPopupMessage();
                break;
            }
        }
    }

    public void getByRadius(String radius) {
        for (Planet planet : getPlanets()) {
            if (planet.getRadius().equalsIgnoreCase(radius)) {
                planet.clickExplore();
                waitForPopupMessage();
                break;
            }
        }
    }

    public List<Planet> getPlanets() {
        ArrayList<Planet> planets = new ArrayList<>();
        for (WebElement planet : driver.findElements(By.className("planet"))) {
            planets.add(new Planet(planet));
        }
        return planets;
    }

    public void waitForPopupMessage() {
        var popupElement = driver.findElement(By.className("popup-message"));
        new WebDriverWait(driver,15).until(ExpectedConditions.visibilityOf(popupElement));
    }
}
