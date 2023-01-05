package tests;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.Arrays;
import java.util.List;

public class ProductsTest extends BaseTest {

    @Test(groups = {"Regressive"}, description = "Test to check the display of products on the main page",
            dataProvider = "productsTestData")
    public void productsTest(String testItemName, String expectedItemPrice, String expectedItemDescription) {
        loginPage.setUsername("standard_user");
        loginPage.setPassword("secret_sauce");
        loginPage.clickLoginButton();

        Assert.assertEquals(productsPage.getItemPrice(testItemName), expectedItemPrice);
        Assert.assertEquals(productsPage.getItemDescrtption(testItemName), expectedItemDescription);
    }

    @DataProvider()
    public Object[][] productsTestData() {
        return new Object[][]{
                {"Sauce Labs Backpack", "$29.99",
                        "carry.allTheThings() with the sleek, streamlined Sly Pack that melds uncompromising style with unequaled laptop and tablet protection."},
                {"Sauce Labs Bike Light", "$9.99",
                        "A red light isn't the desired state in testing but it sure helps when riding your bike at night. Water-resistant with 3 lighting modes, 1 AAA battery included."},
                {"Sauce Labs Bolt T-Shirt", "$15.99",
                        "Get your testing superhero on with the Sauce Labs bolt T-shirt. From American Apparel, 100% ringspun combed cotton, heather gray with red bolt."},
                {"Sauce Labs Fleece Jacket", "$49.99",
                        "It's not every day that you come across a midweight quarter-zip fleece jacket capable of handling everything from a relaxing day outdoors to a busy day at the office."},
                {"Sauce Labs Onesie", "$7.99",
                        "Rib snap infant onesie for the junior automation engineer in development. Reinforced 3-snap bottom closure, two-needle hemmed sleeved and bottom won't unravel."},
                {"Test.allTheThings() T-Shirt (Red)", "$15.99",
                        "This classic Sauce Labs t-shirt is perfect to wear when cozying up to your keyboard to automate a few tests. Super-soft and comfy ringspun combed cotton."},
        };
    }

    @Test(groups = {"Regressive"}, description = "Test to check the sorting of products on the main page",
            dataProvider = "productsSortingTestData")
    public void sortingTest(String optionName, List<String> expectedItemList) {
        loginPage.setUsername("standard_user");
        loginPage.setPassword("secret_sauce");
        loginPage.clickLoginButton();
        productsPage.clickDropdownButton();
        productsPage.selectSortingOrderOption(optionName);
        Assert.assertEquals(productsPage.getSortingListItemName(), expectedItemList);
    }

    @DataProvider()
    public Object[][] productsSortingTestData() {
        return new Object[][]{
                {"Name (A to Z)", Arrays.asList("Sauce Labs Backpack", "Sauce Labs Bike Light", "Sauce Labs Bolt T-Shirt",
                        "Sauce Labs Fleece Jacket", "Sauce Labs Onesie", "Test.allTheThings() T-Shirt (Red)")},
                {"Name (Z to A)", Arrays.asList("Test.allTheThings() T-Shirt (Red)", "Sauce Labs Onesie", "Sauce Labs Fleece Jacket",
                        "Sauce Labs Bolt T-Shirt", "Sauce Labs Bike Light", "Sauce Labs Backpack")},
                {"Price (low to high)", Arrays.asList("Sauce Labs Onesie", "Sauce Labs Bike Light", "Sauce Labs Bolt T-Shirt",
                        "Test.allTheThings() T-Shirt (Red)", "Sauce Labs Backpack", "Sauce Labs Fleece Jacket")},
                {"Price (high to low)", Arrays.asList("Sauce Labs Fleece Jacket", "Sauce Labs Backpack", "Sauce Labs Bolt T-Shirt",
                        "Test.allTheThings() T-Shirt (Red)", "Sauce Labs Bike Light", "Sauce Labs Onesie")},
        };
    }
}
