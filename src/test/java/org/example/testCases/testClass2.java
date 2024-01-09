package org.example.testCases;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

public class testClass2 extends BaseTest{

    String firstName = "first_name";
    String lastName = "last_name";
    String postalCode = "122345";
    String orderConfirmExpectedText = "Thank you for your order!";
    String logoTitle = "Swag Labs";

    @Test
    public void loginTest() {
        driver.get(baseUrl);
        driver.findElement(By.id("user-name")).sendKeys(user);
        driver.findElement(By.id("password")).sendKeys(pass);
        driver.findElement(By.id("login-button")).click();
        boolean isMenuVisible = driver.findElement(By.id("react-burger-menu-btn")).isDisplayed();
        Assert.assertTrue(isMenuVisible);
    }

    @Test(priority = 1, description = "Verify user can order a product from product list.",dependsOnMethods = "loginTest")
    public void orderProduct(){
        driver.get(baseUrl);
        driver.findElement(By.id("user-name")).sendKeys(user);
        driver.findElement(By.id("password")).sendKeys(pass);
        driver.findElement(By.id("login-button")).click();
        driver.findElement(By.id("add-to-cart-sauce-labs-backpack")).click();
        driver.findElement(By.id("shopping_cart_container")).click();
        driver.findElement(By.id("checkout")).click();
        driver.findElement(By.id("first-name")).sendKeys(firstName);
        driver.findElement(By.id("last-name")).sendKeys(lastName);
        driver.findElement(By.id("postal-code")).sendKeys(postalCode);
        driver.findElement(By.id("continue")).click();
        driver.findElement(By.id("finish")).click();
        String confirmText = driver.findElement(By.className("complete-header")).getText();
        Assert.assertEquals(confirmText, orderConfirmExpectedText);
        driver.findElement(By.id("react-burger-menu-btn")).click();
        driver.findElement(By.id("logout_sidebar_link")).click();
        String logoText = driver.findElement(By.className("login_logo")).getText();
        Assert.assertEquals(logoText,logoTitle);
    }
}
