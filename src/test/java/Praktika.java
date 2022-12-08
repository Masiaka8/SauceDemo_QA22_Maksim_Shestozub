import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;

public class Praktika {

    WebDriver driver;

    @AfterMethod(alwaysRun = true)
    public void closeDriver() {
        if (driver != null) {
            driver.quit();
        }
    }

    public void test() {
        WebDriverManager.chromedriver().setup();
        ChromeDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.saucedemo.com/");

        WebElement password = driver.findElement(By.id("password"));
        WebElement password1 = driver.findElement(By.name("password"));
        WebElement loginBox = driver.findElement(By.className("login-box"));

        //xpath по порядку как в задании.
        driver.get("https://www.saucedemo.com/cart.html");
        WebElement abc1 = driver.findElement(By.xpath("//button[@class='btn btn_secondary back btn_medium']"));
        driver.get("https://www.saucedemo.com/inventory.html");
        WebElement abc2 = driver.findElement(By.xpath("//div[text()='Sauce Labs Backpack']"));
        driver.get("https://www.saucedemo.com/cart.html");
        WebElement abc3 = driver.findElement(By.xpath("//button[contains(@class,'back btn_medium')]"));
        driver.get("https://www.saucedemo.com/inventory.html");
        WebElement abc4 = driver.findElement(By.xpath("//div[contains(text(),'Sauce Labs Backpack')]"));
        WebElement abc5 = driver.findElement(By.xpath("//a[@id='item_4_title_link']/ancestor::div[@class='inventory_item_label']"));
        WebElement abc6 = driver.findElement(By.xpath("//a[@id='item_4_title_link']/descendant::div[@class='inventory_item_name']"));
        WebElement abc7 = driver.findElement(By.xpath("//a[@id='item_4_title_link']/following::div"));
        WebElement abc8 = driver.findElement(By.xpath("//a[@id='item_4_title_link']/parent::div"));
        WebElement abc9 = driver.findElement(By.xpath("//a[@id='item_4_title_link']/preceding::span[@class='select_container']"));
        WebElement abc10 = driver.findElement(By.xpath("//img[@alt='Sauce Labs Backpack' and @class='inventory_item_img']"));

        //css по порядку как в задании.
        driver.get("https://www.saucedemo.com/cart.html");
        WebElement qwe1 = driver.findElement(By.cssSelector(".btn.btn_secondary.btn_small.cart_button"));
        driver.get("https://www.saucedemo.com/inventory.html");
        WebElement qwe2 = driver.findElement(By.cssSelector(".bm-item.menu-item[style*='display']"));
        WebElement qwe3 = driver.findElement(By.cssSelector(".bm-menu [style*='display']"));
        WebElement qwe4 = driver.findElement(By.cssSelector("#item_4_title_link"));
        WebElement qwe5 = driver.findElement(By.cssSelector("div"));
        WebElement qwe6 = driver.findElement(By.cssSelector("div.primary_header"));
        WebElement qwe7 = driver.findElement(By.cssSelector("img.footer_robot[src='/static/media/SwagBot_Footer_graphic.2e87acec.png']"));
        WebElement qwe8 = driver.findElement(By.cssSelector(" ~ не понял "));
        WebElement qwe9 = driver.findElement(By.cssSelector(" | не понял "));
        WebElement qwe10 = driver.findElement(By.cssSelector("img.footer_robot[src^='/']"));
        WebElement qwe11 = driver.findElement(By.cssSelector("img.footer_robot[src$='g']"));
        WebElement qwe12 = driver.findElement(By.cssSelector("img.footer_robot[src*='media']"));
        // там где я добавил img.footer_robot я как понял Idea и без него найдёт элемент, а в браузере только так находит.
    }
}