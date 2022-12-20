package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

public class ShoppingCartTest extends BaseTest{

    @Test(groups = {"Smoke"}, description = "Тест на проверку добавленного товара в корзину")
    public void shoppingCartTest() {
        String testItemName = "Sauce Labs Backpack";
        String expectedItemPrice = "$29.99";
        String expectedItemDescription = "carry.allTheThings() with the sleek, streamlined Sly Pack that melds uncompromising style with unequaled laptop and tablet protection.";
        loginPage.setUsername("standard_user");
        loginPage.setPassword("secret_sauce");
        loginPage.clickLoginButton();
        productsPage.clickAddToCartButton(testItemName);
        productsPage.clickShoppingCartButton();

        Assert.assertEquals(shoppingCartPage.getItemPrice(testItemName), expectedItemPrice);
        Assert.assertEquals(shoppingCartPage.getItemDescription(testItemName), expectedItemDescription);
    }
}
