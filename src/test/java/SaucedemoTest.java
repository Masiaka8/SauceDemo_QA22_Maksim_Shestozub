import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;


public class SaucedemoTest {

    WebDriver driver;

    @AfterMethod(alwaysRun = true)
    public void closeDriver() {
        if (driver != null) {
            driver.quit();
        }
    }

    @Test
    public void testAddRemoveElements() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.saucedemo.com/");

        WebElement firstNameInput = driver.findElement(By.name("user-name"));
        firstNameInput.sendKeys("standard_user");
        WebElement passwordInput = driver.findElement(By.name("password"));
        passwordInput.sendKeys("secret_sauce");
        WebElement loginButton = driver.findElement(By.cssSelector("[value=Login]"));
        loginButton.click();
        WebElement addToCart = driver.findElement(By.name("add-to-cart-sauce-labs-backpack"));
        addToCart.click();
        WebElement shoppingCartLink = driver.findElement(By.cssSelector("[class='shopping_cart_link']"));
        shoppingCartLink.click();
        WebElement priceItem = driver.findElement(By.className("inventory_item_price"));
        Assert.assertEquals(priceItem.getText(), "$29.99");
        WebElement nameItem = driver.findElement(By.className("inventory_item_name"));
        Assert.assertEquals(nameItem.getText(), "Sauce Labs Backpack");
    }
}
