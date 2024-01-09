package org.example.testCases;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;


public class testClass1 extends BaseTest{

    @Test
    public void loginTest() {
        driver.get(baseUrl);
        driver.findElement(By.id("user-name")).sendKeys(user);
        driver.findElement(By.id("password")).sendKeys(pass);
        driver.findElement(By.id("login-button")).click();
        boolean isMenuVisible = driver.findElement(By.id("react-burger-menu-btn")).isDisplayed();
        Assert.assertTrue(isMenuVisible);
    }

    @Test(priority = 1, description = "Verify user can Remove a product from cart.",dependsOnMethods = "loginTest")
    public void removeProduct(){
        driver.get(baseUrl);
        driver.findElement(By.id("user-name")).sendKeys(user);
        driver.findElement(By.id("password")).sendKeys(pass);
        driver.findElement(By.id("login-button")).click();
        driver.findElement(By.id("item_4_title_link")).click();
        driver.findElement(By.id("add-to-cart-sauce-labs-backpack")).click();
        String countText =  driver.findElement(By.className("shopping_cart_link")).getText();
        int count = Integer.parseInt(countText);
        Assert.assertTrue(count > 0);
        driver.findElement(By.id("remove-sauce-labs-backpack")).click();
        String text =  driver.findElement(By.className("shopping_cart_link")).getText();
        Assert.assertEquals("", text);
    }
}
