package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

public class CheckoutTest extends BaseTest {

    @Test(groups = {"Smoke"}, description = "Test to payment verification")
    public void сheckoutOverwiewTest(){
        String testItemName = "Sauce Labs Backpack";
        loginPage.setUsername("standard_user");
        loginPage.setPassword("secret_sauce");
        loginPage.clickLoginButton();
        productsPage.clickAddToCartButton(testItemName);
        productsPage.clickShoppingCartButton();
        shoppingCartPage.clickCheckOutButton();
        checkoutOnePage.setFirstName("qweqwe");
        checkoutOnePage.setLastName("qweqwe");
        checkoutOnePage.setZipCode("345354");
        checkoutOnePage.clickContinueOverwiewButton();

        Assert.assertTrue(checkoutTwoPage.isFinishButtonPresent());
    }

    @Test(groups = {"Negative"}, description = "Negative test to verify personal payment information")
    public void negativeCheckoutYourInformationTest() {
        String testItemName = "Sauce Labs Backpack";
        String erorrMessage = "Error: Postal Code is required";
        loginPage.setUsername("standard_user");
        loginPage.setPassword("secret_sauce");
        loginPage.clickLoginButton();
        productsPage.clickAddToCartButton(testItemName);
        productsPage.clickShoppingCartButton();
        shoppingCartPage.clickCheckOutButton();
        checkoutOnePage.setFirstName("qweqwe");
        checkoutOnePage.setLastName("qweqwe");
        checkoutOnePage.setZipCode("");
        checkoutOnePage.clickContinueOverwiewButton();

        Assert.assertEquals(checkoutOnePage.getErrorMessageText(), erorrMessage);
    }

    @Test(groups = {"Negative"}, description = "Negative test to verify a purchase without a product")
    public void negativeCheckoutOverwiewTest(){
        loginPage.setUsername("standard_user");
        loginPage.setPassword("secret_sauce");
        loginPage.clickLoginButton();
        productsPage.clickShoppingCartButton();
        shoppingCartPage.clickCheckOutButton();

        Assert.assertTrue(shoppingCartPage.isCheckoutButtonPresent());
    }
}
