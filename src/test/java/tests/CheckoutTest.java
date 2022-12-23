package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

public class CheckoutTest extends BaseTest {

    @Test(groups = {"Smoke"}, description = "Тест на проверку оплаты товра")
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

    @Test(groups = {"Negative"}, description = "Негативный тест на проверку личной информации оплаты")
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

    @Test(groups = {"Negative"}, description = "Негативный тест на проверку покупки без товара")
    public void negativeCheckoutOverwiewTest(){
        loginPage.setUsername("standard_user");
        loginPage.setPassword("secret_sauce");
        loginPage.clickLoginButton();
        productsPage.clickShoppingCartButton();
        shoppingCartPage.clickCheckOutButton();

        Assert.assertTrue(shoppingCartPage.isCheckoutButtonPresent());
    }
}
