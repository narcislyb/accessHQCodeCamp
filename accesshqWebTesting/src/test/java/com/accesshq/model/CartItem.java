package com.accesshq.model;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class CartItem {

    private final WebElement item;

    public CartItem(WebElement item) {
        this.item = item;
    }

    public String getName() {
        return item.findElement(By.className("Item")).getText();
    }

    public String getPrice() {
        return item.findElement(By.className("Price")).getText();
    }

    public String getSubtotal() {
        return item.findElement(By.className("Subtotal")).getText();
    }

    public void ChangeNumber(String number) {
        item.findElement(By.className("qty")).sendKeys(number); // need convert to int
    }
}
