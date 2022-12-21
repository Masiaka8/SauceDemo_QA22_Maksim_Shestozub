package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

public class LoginTests extends BaseTest{

    @Test(retryAnalyzer = RetryAnalyzer.class, groups = {"Smoke"}, description = "Тест на проверку авторизации")
    public void positiveLoginTest() {
     loginPage.setUsername("standard_user");
     loginPage.setPassword("secret_sauce");
     loginPage.clickLoginButton();
     Assert.assertTrue(productsPage.isShoppingCartButtonPresent());
    }
}
