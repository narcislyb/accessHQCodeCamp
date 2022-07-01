package com.accesshq.model;

import com.accesshq.strategies.MatchingStrategy;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

public class CartPage {
    private final WebDriver driver;

    public CartPage(WebDriver driver) {
        this.driver = driver;
    }

//    public String getItem() {
//        return driver
//    }
//    public void clickExplore() throws ParseException {
//        for (CartItem item : ()) {
//            if (strategy.match(planet)) {
//                planet.clickExplore();
//                waitForPopupMessage();
//                break;
//            }
//        }
//    }
//
//    public List<CartItem> getItems() {
//        ArrayList<CartItem> items = new ArrayList<>();
//        for (WebElement planet : driver.findElements(By.className("planet"))) {
//            planets.add(new Planet(planet));
//        }
//        return planets;
//    }

}
