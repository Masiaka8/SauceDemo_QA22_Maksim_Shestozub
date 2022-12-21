package tests;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import pages.*;
import java.util.concurrent.TimeUnit;

@Listeners(TestListener.class)
public abstract class BaseTest {
    protected WebDriver driver;
    protected LoginPage loginPage;
    protected ProductsPage productsPage;
    protected ShoppingCartPage shoppingCartPage;
    protected ProductDetailsPage productsDetailPage;
    protected CheckoutPage checkoutPage;
    protected CheckoutOverview checkoutOverview;

    @BeforeClass(alwaysRun = true)
    public void setUp() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        loginPage = new LoginPage(driver);
        productsPage = new ProductsPage(driver);
        shoppingCartPage = new ShoppingCartPage(driver);
        productsDetailPage = new ProductDetailsPage(driver);
        checkoutPage = new CheckoutPage(driver);
        checkoutOverview = new CheckoutOverview(driver);
    }

    @BeforeMethod(alwaysRun = true)
    public void  navigate() {
        driver.get("https://www.saucedemo.com/");
    }

    @AfterClass(alwaysRun = true)
    public void  tearDown() {
        driver.quit();
    }
}
