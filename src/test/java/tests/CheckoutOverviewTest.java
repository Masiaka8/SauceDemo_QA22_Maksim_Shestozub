package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

public class CheckoutOverviewTest extends BaseTest {

    @Test
    public void CheckoutOverwiewTest(){
        String testItemName = "Sauce Labs Backpack";
        String expectedItemPrice = "$29.99";
        String expectedItemDescription = "carry.allTheThings() with the sleek, streamlined Sly Pack that melds uncompromising style with unequaled laptop and tablet protection.";
        loginPage.setUsername("standard_user");
        loginPage.setPassword("secret_sauce");
        loginPage.clickLoginButton();
        productsPage.clickAddToCartButton(testItemName);
        productsPage.clickShoppingCartButton();
        shoppingCartPage.clickContinueShoppingButton();
        checkoutPage.setFirstName("qweqwe");
        checkoutPage.setLastName("qweqwe");
        checkoutPage.setZipCode("345354");
        checkoutPage.clickContinueOverwiewButton();

        Assert.assertTrue(checkoutOverview.isFinishButtonPresent());
    }
}
