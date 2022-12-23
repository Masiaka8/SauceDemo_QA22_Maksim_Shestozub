package tests;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class LoginTests extends BaseTest{

    @Test(retryAnalyzer = RetryAnalyzer.class, groups = {"Smoke"}, description = "Тест на проверку авторизации")
    public void positiveLoginTest() {
     loginPage.setUsername("standard_user");
     loginPage.setPassword("secret_sauce");
     loginPage.clickLoginButton();
     Assert.assertTrue(productsPage.isShoppingCartButtonPresent());
    }

    @Test(dataProvider = "negativeLoginTestData", groups = {"Negative"}, description = "Негативный тест на проверку авторизации")
    public void negativeLoginTest(String username, String password, String errorMessage) {
        loginPage.setUsername(username);
        loginPage.setPassword(password);
        loginPage.clickLoginButton();
        Assert.assertEquals(loginPage.getErrorMessageText(), errorMessage);
    }
    @DataProvider()
    public Object[][] negativeLoginTestData() {
        return new Object[][]{
                {"standard_user", "", "Epic sadface: Password is required"},
                {"", "secret_sauce", "Epic sadface: Username is required"},
                {"qwe", "secret_sauce", "Epic sadface: Username and password do not match any user in this service"},
        };
    }
}
