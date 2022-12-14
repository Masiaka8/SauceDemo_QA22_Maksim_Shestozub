package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

public class ProductsDetailsTest extends BaseTest{

    @Test
    public void productsDetailTest() {
        String testItemName = "Sauce Labs Backpack";
        String expectedItemPrice = "$29.99";
        String expectedItemDescription = "carry.allTheThings() with the sleek, streamlined Sly Pack that melds uncompromising style with unequaled laptop and tablet protection.";
        loginPage.setUsername("standard_user");
        loginPage.setPassword("secret_sauce");
        loginPage.clickLoginButton();
        productsPage.openItem(testItemName);

        Assert.assertEquals(productsDetailPage.getItemPrice(testItemName), expectedItemPrice);
        Assert.assertEquals(productsDetailPage.getItemDescription(testItemName), expectedItemDescription);

    }
}
