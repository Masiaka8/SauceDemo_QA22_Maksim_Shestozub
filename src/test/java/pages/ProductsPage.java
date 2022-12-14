package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;

public class ProductsPage extends BasePage{
    private  final static By SHOPPING_CART_BUTTON = By.cssSelector(".shopping_cart_link");
    private final static String ITEM_CONTAINER_LOCATOR = "//div[@class='inventory_item_name' and text()='%s']/ancestor::div[@class='inventory_item']";
    private final static By ADD_TO_CART_BUTTON = By.xpath("//button[text()='Add to cart']");
    private final static By ITEM_BUTTON = By.xpath("//div[@class='inventory_item_name']");
    private final static By ITEM_DESCRIPTION = By.xpath("//div[@class='inventory_item_desc']");
    private final static By ITEM_PRICE = By.xpath(".//div[@class='inventory_item_price']");

    public ProductsPage(WebDriver driver) {
        super(driver);
    }

    public Boolean isShoppingCartButtonPresent() {
        try {
            driver.findElement(SHOPPING_CART_BUTTON);
        } catch (NoSuchElementException ex) {
            return false;
        }
        return true;
    }

    public void clickShoppingCartButton() {
        driver.findElement(SHOPPING_CART_BUTTON).click();
    }

    public void clickAddToCartButton (String itemName) {
        driver.findElement(getItemContainerByName(itemName)).findElement(ADD_TO_CART_BUTTON).click();
    }

    public String getItemDescrtption (String itemName) {
        return driver.findElement(getItemContainerByName(itemName)).findElement(ITEM_DESCRIPTION).getText();
    }

    public String getItemPrice (String itemName) {
        return driver.findElement(getItemContainerByName(itemName)).findElement(ITEM_PRICE).getText();
    }

    public void openItem (String itemName) {
        driver.findElement(getItemContainerByName(itemName)).findElement(ITEM_BUTTON).click();
    }

    private By getItemContainerByName (String itemName) {
        return By.xpath(String.format(ITEM_CONTAINER_LOCATOR, itemName));
    }
}
