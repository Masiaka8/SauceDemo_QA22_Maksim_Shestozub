package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

public class CheckoutOverviewTest extends BaseTest {

    @Test(groups = "Smoke", description = "Тест на проверку оплаты товра")
    public void CheckoutOverwiewTest(){
        String testItemName = "Sauce Labs Backpack";
        String expectedItemPrice = "$29.99";
        String expectedItemDescription = "carry.allTheThings() with the sleek, streamlined Sly Pack that melds uncompromising style with unequaled laptop and tablet protection.";
        loginPage.setUsername("standard_user");
        loginPage.setPassword("secret_sauce");
        loginPage.clickLoginButton();
        productsPage.clickAddToCartButton(testItemName);
        productsPage.clickShoppingCartButton();
        shoppingCartPage.clickCheckOutButton();
        checkoutPage.setFirstName("qweqwe");
        checkoutPage.setLastName("qweqwe");
        checkoutPage.setZipCode("345354");
        checkoutPage.clickContinueOverwiewButton();

        Assert.assertTrue(checkoutOverview.isFinishButtonPresent());
    }
}
