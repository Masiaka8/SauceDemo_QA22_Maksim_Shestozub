package tests;

import org.testng.Assert;
import org.testng.annotations.Test;


public class LogoutTest extends BaseTest {


    @Test(retryAnalyzer = RetryAnalyzer.class, groups = {"Smoke"}, description = "Тест на проверку выхода")
    public void logoutTest() {
        loginPage.setUsername("standard_user");
        loginPage.setPassword("secret_sauce");
        loginPage.clickLoginButton();
        productsPage.clickBurgerMenuButton();
        productsPage.clickLogoutButton();
        Assert.assertTrue(loginPage.isLoginButtonPresent());
    }
}